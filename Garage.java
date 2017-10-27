/**
 * Programmer:  Patrick Kunst
 * Purpose:     To display adjustments for tire pressure for Mr. de la Vega's Garage
 */

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.text.DecimalFormat;

public class Garage extends Applet implements ActionListener, ItemListener
{
    //constructing components
    Label lblCheckbox = new Label("Check the Checkbox for the type of driving the car drives");
    CheckboxGroup drivingGroup = new CheckboxGroup();
        Checkbox normalBox = new Checkbox("Normal", false, drivingGroup);
        Checkbox haulingBox = new Checkbox("Hauling", false, drivingGroup);
        Checkbox ruggedBox = new Checkbox("Rugged Terrain", false, drivingGroup);
        Checkbox hiddenBox = new Checkbox("", true, drivingGroup);
    
    Label lblFrontLeft = new Label("What is the pressure of the front-left tire in PSI?");
        TextField txtFrontLeft = new TextField(5);
    Label lblFrontRight = new Label("What is the pressure of the front-right tire in PSI?");
        TextField txtFrontRight = new TextField(5);
    Label lblRearLeft = new Label("What is the pressure of the rear-left tire in PSI?");
        TextField txtRearLeft = new TextField(5);
    Label lblRearRight = new Label("What is the pressure of the rear-right tire in PSI?");
        TextField txtRearRight = new TextField(5);
        
    Button adjustButton = new Button("Calculate my adjustments");
        Label lblAdjust = new Label("Press the button to calculate the adjustments you need to make");
        
    Label frontLeftStat = new Label("");
    Label frontRightStat = new Label("");
    Label rearLeftStat = new Label("");
    Label rearRightStat = new Label("");
        
    double frontLeft, frontRight, rearLeft, rearRight;
        
    public void init()
    {
        setBackground(Color.red);
        add(lblFrontLeft);
        add(txtFrontLeft);
        add(lblFrontRight);
        add(txtFrontRight);
        add(lblRearLeft);
        add(txtRearLeft);
        add(lblRearRight);
        add(txtRearRight);
        add(lblCheckbox);
        add(normalBox);
            normalBox.addItemListener(this);
        add(haulingBox);
            haulingBox.addItemListener(this);
        add(ruggedBox);
            ruggedBox.addItemListener(this);
        add(adjustButton);
            adjustButton.addActionListener(this);
        add(lblAdjust);
        add(frontLeftStat);
        add(frontRightStat);
        add(rearLeftStat);
        add(rearRightStat);
    }
    
    public void itemStateChanged(ItemEvent choice)
    {
        try //makes sure the user entered a valid tire pressure
        {
            frontLeft = Double.parseDouble(txtFrontLeft.getText());
            frontRight = Double.parseDouble(txtFrontRight.getText());
            rearRight = Double.parseDouble(txtRearRight.getText());
            rearLeft = Double.parseDouble(txtRearLeft.getText());
            
            if(frontLeft < 0 || frontRight < 0 || rearRight < 0 || rearLeft < 0) throw new NumberFormatException();
        }
        catch(NumberFormatException q) //if the user doesn't enter a valid tire pressure, this happens
        {
            lblAdjust.setText("Make sure all of the tire pressures are greater than 0 and have no symbols other than a decimal point.");
            txtFrontLeft.setText("");
            txtFrontRight.setText("");
            txtRearLeft.setText("");
            txtRearRight.setText("");
            txtFrontLeft.requestFocus();
            hiddenBox.setState(true);
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        normalBoxTrue();
        haulingBoxTrue();
        ruggedBoxTrue();
    }
    
    public void normalBoxTrue() //this method activates if the user selects the normal driving box 
    {
        if(normalBox.getState() == true) //if the user chose normal driving
        {
            DecimalFormat twoDigits = new DecimalFormat("##.00");
            
            //the following are stats for the front-left tire
            if(frontLeft >= 33 && frontLeft <= 43) frontLeftStat.setText("The tire pressure on the front-left tire is fine");
            if(frontLeft < 33) frontLeftStat.setText("The tire pressure on the front-left tire should be between " + twoDigits.format(33 - frontLeft) + " PSI and " + twoDigits.format(43 - frontLeft) + " more PSI");
            if(frontLeft > 43) frontLeftStat.setText("The tire pressure on the front-left tire should be " + twoDigits.format(frontLeft - 43) + "PSI and " + twoDigits.format(frontLeft - 33) + " less PSI");
            
            //the following are stats for the front-right tire
            if(frontRight > 33 && frontRight < 43) frontRightStat.setText("The Tire Pressure on the front-right tire is fine");
            if(frontRight <= 33) frontRightStat.setText("The tire pressure on the front-right tire should be between " + twoDigits.format(33 - frontRight) + " PSI and " + twoDigits.format(43 - frontRight) + " more PSI");
            if(frontRight > 43) frontRightStat.setText("The tire pressure on the front-right tire should be " + twoDigits.format(frontRight - 43) + "PSI and " + twoDigits.format(frontRight - 33) + " less PSI");
            
            //the following are stats for the rear-left tire
            if(rearLeft >= 33  && rearLeft <= 43) rearLeftStat.setText("The tire pressure on the rear-left tire is fine");
            if(rearLeft < 33) rearLeftStat.setText("The tire pressure on the rear-left tire should be between " + twoDigits.format(33 - rearLeft) + " PSI and " + twoDigits.format(43 - rearLeft) + " more PSI");
            if(rearLeft > 43) rearLeftStat.setText("The tire pressure on the rear-left tire should be between " + twoDigits.format(rearLeft - 43) +  "PSI and " + twoDigits.format(rearLeft - 33) + " less PSI");
            
            //the following are stats for the rear-right tire
            if(rearRight >= 33 && rearRight <=43) rearRightStat.setText("The tire pressure on the rear-right tire is fine");
            if(rearRight < 33) rearRightStat.setText("The tire pressure on the rear-right tire should be between " + twoDigits.format(33 - rearRight) + " PSI and " + twoDigits.format(43 - rearRight) + " more PSI");
            if(rearRight > 43) rearRightStat.setText("The tire pressure on the rear-right tire should be between " + twoDigits.format(rearRight - 43) +  "PSI and " + twoDigits.format(rearRight - 33) + " more PSI");
        }
    }
    
    public void haulingBoxTrue() //this method selects if the user selects the hauling box
    {
        if(haulingBox.getState() == true)
        {
            DecimalFormat twoDigits = new DecimalFormat("##.00");
            //if the front left tire pressure is correct
            if(frontLeft >= 33 && frontLeft <= 43)
            {
                if(rearLeft >= (frontLeft * 1.08) && rearLeft <= (frontLeft * 1.12)) frontLeftStat.setText("Your tire pressure on the front-left and rear-left tires are fine.");
                if(rearLeft <= (frontLeft * 1.08)) frontLeftStat.setText("The tire pressure on the rear-left tire should be between " + twoDigits.format((frontLeft * 1.08) - rearLeft) + " PSI and " + 
                    twoDigits.format((frontLeft * 1.12) - rearLeft) + " PSI more");
                if(rearLeft >= (frontLeft * 1.12)) frontLeftStat.setText("The tire pressure on the rear-left tire should be betwee " + twoDigits.format(rearLeft - (frontLeft * 1.08)) + " PSI and " + 
                    twoDigits.format(rearLeft - (frontLeft * 1.12)) + " PSI less");
            }
            //if the front left tire pressure is wrong
            if(frontLeft < 33) frontLeftStat.setText("The tire pressure on the front-left tire should be " + twoDigits.format(33 - frontLeft) + " more PSI, then check again for the rear tires' stats");
            if(frontLeft > 43) frontLeftStat.setText("The tire pressure on the front-left tire should be " + twoDigits.format(frontLeft - 43) + " less PSI, then check again for the rear tires' stats");
            
            //if the front-right tire pressure is correct
            if(frontRight >= 33 && frontRight <= 43)
            {
                if(rearRight >= (frontRight * 1.08) && rearRight <= (frontLeft * 1.12)) frontRightStat.setText("Your tire pressure on the front-right and rear-right tires are fine.");
                if(rearRight <= (frontRight * 1.08)) frontRightStat.setText("The tire pressure on the rear-right tire should be between " + twoDigits.format((frontRight * 1.08) - rearRight) + " PSI and " + 
                    twoDigits.format((frontRight * 1.12) - rearRight) + " PSI more");
                if(rearRight >= (frontRight * 1.12)) frontRightStat.setText("The tire pressure on the rear-Right tire should be between " + twoDigits.format(rearRight - (frontRight * 1.08)) + " PSI and " + 
                    twoDigits.format(rearRight - (frontRight * 1.12)) + " PSI less");
            }
            //if the front left tire pressure is wrong
            if(frontRight < 33) frontRightStat.setText("The tire pressure on the front-right tire should be " + twoDigits.format(33 - frontRight) + " more PSI, then check again for the rear tires' stats");
            if(frontRight > 43) frontRightStat.setText("The tire pressure on the front-right tire should be " + twoDigits.format(frontRight - 43) + " less PSI, then check again for the rear tires' stats");
        }
    }
    
    public void ruggedBoxTrue()
    {
        if(ruggedBox.getState() == true)
        {
            DecimalFormat twoDigits = new DecimalFormat("##.00");
            //if the front left tire pressure is correct
            if(frontLeft >= 33 && frontLeft <= 43)
            {
                if(rearLeft >= (frontLeft * 1.13) && rearLeft <= (frontLeft * 1.17)) frontLeftStat.setText("Your tire pressure on the front-left and rear-left tires are fine.");
                if(rearLeft <= (frontLeft * 1.13)) frontLeftStat.setText("The tire pressure on the rear-left tire should be between " + twoDigits.format((frontLeft * 1.13) - rearLeft) + " PSI and " + 
                    twoDigits.format((frontLeft * 1.17) - rearLeft) + " PSI more");
                if(rearLeft >= (frontLeft * 1.12)) frontLeftStat.setText("The tire pressure on the rear-left tire should be betwee " + twoDigits.format(rearLeft - (frontLeft * 1.13)) + " PSI and " + 
                    twoDigits.format(rearLeft - (frontLeft * 1.17)) + " PSI less");
            }
            //if the front left tire pressure is wrong
            if(frontLeft < 33) frontLeftStat.setText("The tire pressure on the front-left tire should be " + twoDigits.format(33 - frontLeft) + " more PSI, then check again for the rear tires' stats");
            if(frontLeft > 43) frontLeftStat.setText("The tire pressure on the front-left tire should be " + twoDigits.format(frontLeft - 43) + " less PSI, then check again for the rear tires' stats");
            
            //if the front-right tire pressure is correct
            if(frontRight >= 33 && frontRight <= 43)
            {
                if(rearRight >= (frontRight * 1.13) && rearRight <= (frontLeft * 1.17)) frontRightStat.setText("Your tire pressure on the front-right and rear-right tires are fine.");
                if(rearRight <= (frontRight * 1.13)) frontRightStat.setText("The tire pressure on the rear-right tire should be between " + twoDigits.format((frontRight * 1.13) - rearRight) + " PSI and " + 
                    twoDigits.format((frontRight * 1.17) - rearRight) + " PSI more");
                if(rearRight >= (frontRight * 1.17)) frontRightStat.setText("The tire pressure on the rear-Right tire should be between " + twoDigits.format(rearRight - (frontRight * 1.13)) + " PSI and " + 
                    twoDigits.format(rearRight - (frontRight * 1.17)) + " PSI less");
            }
            //if the front left tire pressure is wrong
            if(frontRight < 33) frontRightStat.setText("The tire pressure on the front-right tire should be " + twoDigits.format(33 - frontRight) + " more PSI, then check again for the rear tires' stats");
            if(frontRight > 43) frontRightStat.setText("The tire pressure on the front-right tire should be " + twoDigits.format(frontRight - 43) + " less PSI, then check again for the rear tires' stats");
        }
    }
}
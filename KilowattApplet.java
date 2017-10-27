/*
 * Programmer:  Patrick Kunst
 * Purpose:     To calculate the annual cost of running an appliance
 */
// I will be writing notes on the things I missed in the program so I know what everything does

//import statements
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class KilowattApplet extends Applet implements ActionListener
{
    //constructing components
    Label lblWelcome = new Label("Welcome to the Applience Energy Calculator");
    Label lblCostKWHR = new Label("Please enter the cost per kilowatt-hour in cents:");
        TextField txtCostKWHR = new TextField(5);
    Label lblHoursPerYear = new Label("Please enter the kilowatt-hours consumed:");
        TextField txtHoursPerYear = new TextField(5);
    Button calcButton = new Button("Calculate");
    Label lblOutput = new Label("Click the Calculate button to display the average energy cost.");
    
    public void init()  //initializes components
    {
        setBackground(Color.orange);
        add(lblWelcome); //adds the component to the program
        add(lblCostKWHR);
        add(txtCostKWHR);
        add(lblHoursPerYear);
        add(txtHoursPerYear);
        add(calcButton);
        add(lblOutput);
        calcButton.addActionListener(this);
    }
    
    //declare variables, convert the input, and perform calculations
    public void actionPerformed(ActionEvent e)  //
        {
            double costKWHR = Double.parseDouble(txtCostKWHR.getText()); //getText() method retrieves user input
            double kwHours = Double.parseDouble(txtHoursPerYear.getText());
            
            double average;
            
            //formula
            average = costKWHR * kwHours;
            
            lblOutput.setText("The average annual cost to operate this appliance is $" + Math.round(average * 100)/100D);
        }
}
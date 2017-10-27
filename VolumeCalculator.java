/**
 * Programmer:  Patrick Kunst
 * Purpose:     To calculate the volume of a box, cylinder, cone, and sphere
 */

//import statements
import java.text.DecimalFormat;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class VolumeCalculator extends Applet implements ItemListener, ActionListener
{
    //variables
    double length, width, height, radius, volume;
    
    // component construction
    Label welcLabel = new Label("Welcome to Patrick's Volume Calculator!");
    Label noticeLabel = new Label("Note: You only need to enter data in the fields that apply to your shape.");
    Label lLabel = new Label("What is the length of the object in feet?");
        TextField txtLength = new TextField(7);
    Label wLabel = new Label("What is the width of the object in feet?");
        TextField txtWidth = new TextField(7);
    Label hLabel = new Label("What is the height of the object in feet?");
        TextField txtHeight = new TextField(7);
    Label rLabel = new Label("What is the radius of the object in feet?");
        TextField txtRadius = new TextField(7);
    Label clickLabel = new Label("Click the button for the shape that you want to find the volume of");
    CheckboxGroup shapeGroup = new CheckboxGroup();
        Checkbox boxBox = new Checkbox("Box", false, shapeGroup);
        Checkbox cylBox = new Checkbox("Cylinder", false, shapeGroup);
        Checkbox coneBox = new Checkbox("Cone", false, shapeGroup);
        Checkbox sphereBox = new Checkbox("Sphere", false, shapeGroup);
        Checkbox hiddenBox = new Checkbox("", true, shapeGroup);
    Button calcButton = new Button("Calculate");
        Label calcLabel = new Label("Click the \"Calculate\" button to calculate the volume of the object");
        
    DecimalFormat twoDigits = new DecimalFormat("#.00"); //for the final volume format
    public void init() //adds components to applet
    {
        setBackground(Color.green);
        
        add(welcLabel);
        add(noticeLabel);
        add(lLabel);
        add(txtLength);
        add(wLabel);
        add(txtWidth);
        add(hLabel);
        add(txtHeight);
        add(rLabel);
        add(txtRadius);
        add(clickLabel);
        add(boxBox);
            boxBox.addItemListener(this);
        add(cylBox);
            cylBox.addItemListener(this);
        add(coneBox);
            coneBox.addItemListener(this);
        add(sphereBox);
            sphereBox.addItemListener(this);
        add(calcButton);
            calcButton.addActionListener(this);
        add(calcLabel);
    }
    
    public void itemStateChanged(ItemEvent choice) //nothing happens, this is to prevent the coding error that stops the program from compiling
    {
    }
    
    public void actionPerformed(ActionEvent a) //occurs when the button is clicked
    {
        boxBoxChecked();
        cylBoxChecked();
        coneBoxChecked();
        sphereBoxChecked();
    }
    
    public void boxBoxChecked() //if the user wants the volume of a box
    {
        if(boxBox.getState() == true)
        {
            try
            {
                length = Double.parseDouble(txtLength.getText());
                width = Double.parseDouble(txtWidth.getText());
                height = Double.parseDouble(txtHeight.getText());
                
                volume = (length * width * height);
                
                if(length <= 0 || width <= 0 || height <= 0 || volume <= 0) throw new NumberFormatException(); //ensures that the data is greater than 0
                
                calcLabel.setText("The volume of the box is " + twoDigits.format(volume) + " cubic feet.");
            }
            catch(NumberFormatException e)
            {
                calcLabel.setText("Make sure your data is greater than 0 and has no commas");
                txtLength.setText("");
                txtLength.requestFocus();
                txtWidth.setText("");
                txtHeight.setText("");
            }
        }
    }
    
    public void cylBoxChecked() //executed if the user wants the volume of a cylinder
    {
        if(cylBox.getState() == true)
        {
            try
            {
                radius = Double.parseDouble(txtRadius.getText());
                height = Double.parseDouble(txtHeight.getText());
                
                volume = (3.14 * Math.pow(radius, 2) * height);
                
                if(radius <= 0 || height <= 0 || volume <= 0) throw new NumberFormatException(); //ensures that the data is greater than 0
                
                calcLabel.setText("The volume of the cylinder is " + twoDigits.format(volume) + " cubic feet.");
            }
            catch(NumberFormatException e)
            {
                calcLabel.setText("Make sure your data is greater than 0 and has no commas");
                txtRadius.setText("");
                txtHeight.setText("");
                txtHeight.requestFocus();
            }
        }
    }
    
    public void coneBoxChecked() //executed if the user wants the volume of a cone
    {
        if(coneBox.getState() == true)
        {
            try
            {
                radius = Double.parseDouble(txtRadius.getText());
                height = Double.parseDouble(txtHeight.getText());
                
                volume = ((3.14 * Math.pow(radius, 2) * height) / 3);
                
                if(radius <= 0 || height <= 0 || volume <= 0) throw new NumberFormatException(); //ensures that the data is greater than 0
                
                calcLabel.setText("The volume of the cone is " + twoDigits.format(volume) + " cubic feet."); 
            }
            catch(NumberFormatException e)
            {
                calcLabel.setText("Make sure your data is greater than 0 and has no commas");
                txtRadius.setText("");
                txtHeight.setText("");
                txtHeight.requestFocus();
            }
        }
    }
    
    public void sphereBoxChecked() //executed if the user wants the volume of a sphere
    {
        if(sphereBox.getState() == true)
        {
            try
            {
                radius = Double.parseDouble(txtRadius.getText());
                
                volume = ((4/3) * 3.14 * Math.pow(radius, 3));
                
                if(radius <= 0 || volume <= 0) throw new NumberFormatException(); //ensures that the data is greater than 0
                
                calcLabel.setText("The volume of the sphere is " + twoDigits.format(volume) + " cubic feet.");
            }
            catch(NumberFormatException e)
            {
                calcLabel.setText("Make sure your data is greater than 0 and has no commas");
                txtRadius.setText("");
                txtRadius.requestFocus();
            }
        }
    }
}
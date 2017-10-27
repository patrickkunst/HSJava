/*
 * Programmer:  Patrick Kunst
 * Purpose:     To display the current flowing through a device
 */

//import statements
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class OhmsLaw extends Applet implements ActionListener
{
    //constructing components
    Label welcLabel = new Label("Welcome to Patrick's electrical current calculator");
    Label voltLabel = new Label("What is the voltage of your device in volts?");
        TextField txtVolt = new TextField(10);
    Label resistLabel = new Label("What is the resistance of the device in ohms?");
        TextField txtResist = new TextField(10);
    Button calcButton = new Button("Calculate");
    Label calcLabel = new Label("Press the \"Calculate\" button to calculate the electrical current!");
    
    //add components to applet
    public void init()
    {
        setBackground(Color.black);
        setForeground(Color.magenta);
        add(welcLabel);
        add(voltLabel);
        add(txtVolt);
        add(resistLabel);
        add(txtResist);
        add(calcButton);
        calcButton.addActionListener(this);
        add(calcLabel);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        //declaring variables
        double voltage, resistance, current;
        
        //defining variables
        voltage = Double.parseDouble(txtVolt.getText());
        resistance = Double.parseDouble(txtResist.getText());
        
        //formula
        current = Math.round((voltage / resistance) * 100) / 100D;
        
        calcLabel.setText("The current is " + current + " amps.");
    }
}
/**
 * Programmer:  Patrick Kunst
 * Purpose:     To calculate the charge for a traffic violation
 */

//import statements
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.text.DecimalFormat;

public class TrafficViolations extends Applet implements ActionListener
{
    //construction
    Label lblWelcome = new Label("Welcome to the LPD Traffic Ticket Calculator");
    Label lblLimit = new Label("What was the actual speed limit?");
        TextField txtLimit = new TextField(5);
    Label lblSpeed = new Label("How fast was the offender going?");
        TextField txtSpeed = new TextField(5);
    Label lblTickets = new Label("How many previous tickets has the offender had?");
        TextField txtTickets = new TextField(5);
    Button calcButton = new Button("Calculate!");
        Label calcLabel = new Label("Press the \"Calculate\" button to calculate the cost.");
    
    int tickets = 0;
    int limit = 0;
    double speed = 0.0;
    double price = 0.0; //variable: Cost of the violation
    
    public void init() //adds components to applet
    {
        setBackground(Color.blue);
        setForeground(Color.white);
        
        add(lblWelcome);
        add(lblLimit);
        add(txtLimit);
            txtLimit.setBackground(Color.black);
        add(lblSpeed);
        add(txtSpeed);
            txtSpeed.setBackground(Color.black);
        add(lblTickets);
        add(txtTickets);
            txtTickets.setBackground(Color.black);
        add(calcButton);
            calcButton.addActionListener(this);
            calcButton.setBackground(Color.black);
        add(calcLabel);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            limit = Integer.parseInt(txtLimit.getText());
            speed = Double.parseDouble(txtSpeed.getText());
            tickets = Integer.parseInt(txtTickets.getText());
            if(limit < 0 || speed < 0 || tickets < 0) throw new NumberFormatException();
        }
        catch(NumberFormatException q)
        {
            calcLabel.setText("Make sure the limit and tickets are both whole numbers, and that you have no symbols anywhere");
        }
        
        price = (speed - limit) * 40.00;
        if(tickets == 1) price = price + 94.80;
        if(tickets == 2) price = price + 124.80;
        if(tickets >= 3) price = price + 154.80;
        
        DecimalFormat twoDigits = new DecimalFormat("$##,###.00");
        calcLabel.setText("The offender's fine is " + twoDigits.format(price));
    }
}
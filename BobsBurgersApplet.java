/*
 * Programmer:  Patrick Kunst
 * Purpose:     To create an applet that displays the total cost of a meal including sales tax
 */

//import statements
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class BobsBurgersApplet extends Applet implements ActionListener
{
    //constructing components
    Label lblWelcome = new Label("Welcome to Bob's Burgers total meal price calculator!");
    Label lblSubtotal = new Label("What is your subtotal?");
        TextField txtSubtotal = new TextField(5);
    Label lblOutput = new Label("Click the \"Calculate\" button to see the total of your meal ");
    Button calcButton = new Button("Calculate");
        
    public void init()
    {
        setBackground(Color.black);
        setForeground(Color.magenta);
        add(lblWelcome);
        add(lblSubtotal);
        add(txtSubtotal);
        add(calcButton);
        calcButton.addActionListener(this);
        add(lblOutput);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        //declaring variables
        double subtotal = Double.parseDouble(txtSubtotal.getText());
        double total;
        
        //formula
        total = subtotal + (subtotal * .0825);
        
        //final output
        lblOutput.setText("The tax is 8.25%. Your total is $" + Math.round(total * 100)/100D);
    }
}
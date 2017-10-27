/**
 * Programmer:  Patrick Kunst
 * Purpose:     To create an applet which displays shipping for orders
 */

//import statements
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.text.DecimalFormat;

public class CandleLine extends Applet implements ItemListener
{
    Label lblWelcome = new Label("CandleLine--Candles On-Line");
    Label lblTotal = new Label("Please enter the total dollar amound of your order:");
        TextField txtTotal = new TextField(8);
    Label lblShipping = new Label("Please choose your method of shipping:");
    
    //checkboxes
    CheckboxGroup shippingGroup = new CheckboxGroup();
        Checkbox priorityBox = new Checkbox("Priority (Overnight)", false, shippingGroup);
        Checkbox expressBox = new Checkbox("Express (2 business days)", false, shippingGroup);
        Checkbox standardBox = new Checkbox("Standard (3 to 7 business days)", false, shippingGroup);
        Checkbox hiddenBox = new Checkbox("", true, shippingGroup);
        
    Label lblOutput = new Label("We guarantee on time delivery, or your money back");
    
    double price, total, shipping;
    
    public void init() //adds components
    {
        setBackground(Color.cyan);
        setForeground(Color.black);
        add(lblWelcome);
        add(lblTotal);
        add(txtTotal);
            txtTotal.requestFocus();
        add(lblShipping);
        add(priorityBox);
            priorityBox.addItemListener(this);
        add(expressBox);
            expressBox.addItemListener(this);
        add(standardBox);
            standardBox.addItemListener(this);
        add(lblOutput);
    }
    
    public void itemStateChanged(ItemEvent choice)
    {
        try //makes sure user correctly inputted amount
        {
            price = Double.parseDouble(txtTotal.getText());
            
            if(price < 0) throw new NumberFormatException();
            
            //recieves shipping input
            if(priorityBox.getState() == true) shipping = 16.95;
            if(expressBox.getState() == true) shipping = 13.95;
            if(standardBox.getState() == true && price >= 100) shipping = 0.0;
            if(standardBox.getState() == true && price < 100) shipping = 7.95;
            
            DecimalFormat twoDigits = new DecimalFormat("$##,###.00");
        
            total = price + shipping; //calcualtion
        
            lblOutput.setText("Your total price is " + twoDigits.format(total));
        }
        catch(NumberFormatException e)
        {
            lblOutput.setText("You must enter an amount greater than zero with no dollar signs or commas.");
            txtTotal.setText("");
            hiddenBox.setState(true);
            txtTotal.requestFocus();
        }
    }
}
/**
 * Programmer:  Patrick Kunst
 * Purpose:     To create an applet for Lucie's Fast Food (Wasn't here yesterday)
 */

//import statements
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Lucie extends Applet implements ItemListener
{
    //constructors
    Label sandwichPromptLabel = new Label("What kind of sandwich do you want?");
        TextField sandwichInputField = new TextField(35);
    Label sizePromptLabel = new Label("Please select the size and condiments you want.");
    
    //checkboxes
    CheckboxGroup sizeGroup = new CheckboxGroup();
        Checkbox smallBox = new Checkbox("Small", true, sizeGroup);
        Checkbox mediumBox = new Checkbox("Medium", false, sizeGroup);
        Checkbox largeBox = new Checkbox("Large", false, sizeGroup);
        
    Checkbox ketchupBox = new Checkbox("Ketchup", false);
    Checkbox mustardBox = new Checkbox("Mustard", false);
    Checkbox picklesBox = new Checkbox("Pickles", false);
    
    Label confirmationLabel = new Label();
    
    String sandwich = sandwichInputField.getText();
    String ketchup, mustard, pickles, size;
    
    public void init() //adds components
    {
        setBackground(Color.black); //sets background color
        setForeground(Color.white);
        
        add(sandwichPromptLabel);
        add(sandwichInputField);
            sandwichInputField.requestFocus();
            sandwichInputField.setForeground(Color.black);
        add(sizePromptLabel);
        add(smallBox);
            smallBox.addItemListener(this);
        add(mediumBox);
            mediumBox.addItemListener(this);
        add(largeBox);
            largeBox.addItemListener(this);
        add(ketchupBox);
            ketchupBox.addItemListener(this);
        add(mustardBox);
            mustardBox.addItemListener(this);
        add(picklesBox);
            picklesBox.addItemListener(this);
        add(confirmationLabel);
    }
    
    public void itemStateChanged(ItemEvent choice)
    {
    }
}
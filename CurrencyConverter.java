/*
 * Programmer:  Patrick Kunst
 * Purpose:     To create a program that converts currency
 */

//import statements
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverter extends Applet implements ActionListener
{
    Label welcLabel = new Label("Welcome to Patrick's USD currency converter!");
    Label moneyLabel = new Label("How much USD would you like to convert?");
        TextField txtMoney = new TextField(5);
    Button calcButton = new Button("Convert!");
    Label lblOutput = new Label("Press the button to covert to pounds, euros, pesos, and rubles.");
    Label lblPounds = new Label();
    Label lblEuros = new Label();
    Label lblPesos = new Label();
    Label lblRubles = new Label();
    Label lblWhales = new Label();
    //initialize method
    public void init()
    {
        setBackground(Color.black);
        setForeground(Color.green);
        add(welcLabel);
        add(moneyLabel);
        add(txtMoney);
        add(calcButton);
            calcButton.addActionListener(this);
        add(lblOutput);
        add(lblPounds);
        add(lblEuros);
        add(lblPesos);
        add(lblRubles);
        add(lblWhales);
    }
    
    //finalize
    public void actionPerformed(ActionEvent e)
    {
        //declaring variables
        double moneyUS = Double.parseDouble(txtMoney.getText());
        double moneyPound, moneyEuro, moneyPeso, moneyRuble;
        
        //conversions
        moneyPound = Math.round(moneyUS * 0.620856 * 100)/100D;
        moneyEuro = Math.round(moneyUS * 0.788611 * 100)/100D;
        moneyPeso = Math.round(moneyUS * 13.4653 * 100)/100D;
        moneyRuble = Math.round(moneyUS * 39.9231 * 100)/100D;
        
        //output
        lblOutput.setText("Your conversion rates are as follows: ");
        lblPounds.setText("Pounds: " + moneyPound);
        lblEuros.setText("Euros: " + moneyEuro);
        lblPesos.setText("Pesos: " + moneyPeso);
        lblRubles.setText("Rubles: " + moneyRuble);
        
    }
}
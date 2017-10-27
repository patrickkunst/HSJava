/**
 * Programmer:  Patrick Kunst
 * Purpose:     To allow the user to enter a stock purshase transaction and determine the stockbroker's commission
 */

//import statements
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class StockbrokersCommission
{
    public static void main(String[] args)
    {
        //Methods: getPrice(), getRate(), getShares()
        
        //declare variables
        double price, rate;
        int shares;
        
        displayWelcome();
        
        //set variables
        price = getPrice();
        shares = getShares();
        rate = calcRate(shares, price);        
        calcCommission(rate * shares);
    }
    
    public static void displayWelcome() //displays a welcome message to the user
    {
        JOptionPane.showMessageDialog(null, "Welcome to Patrick's Stockbroker's Commission Calculator!",
            "Welcome!", JOptionPane.PLAIN_MESSAGE);
    }
    
    public static double getPrice()
    {
        double stockPrice = 0.0;
        String txtPrice;
        
        try //make sure user input is correct
        {
            txtPrice = JOptionPane.showInputDialog(null, "What is the stock price? Please only use numbers and decimals. Do not use dollar signs or commas.");
                stockPrice = Double.parseDouble(txtPrice);
        }
        
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "The price must not include commas or dollar signs.",
                "Error", JOptionPane.PLAIN_MESSAGE);
        }
        return stockPrice;
    }
    
    public static int getShares() //This method gets the number of shares sold from the user
    {
        int sharesSold = 0; //declare variables
        
        try //make sure user put input in correctly
        {
            String txtShares = JOptionPane.showInputDialog(null, "How many shares with this price have you sold?");
                sharesSold = Integer.parseInt(txtShares);
        }
        
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Make sure the number of shares is a whole number!", "Error",
                JOptionPane.PLAIN_MESSAGE);
        }
        
        return sharesSold;
    }
    
    public static double calcRate(int shares, double price) //calculates the rate
    {
        double commRate = 0.0; //declaring variables
        
        if (price <= 75) commRate = 0.25;
        if (price > 75) commRate = 0.31;
        
        if (shares < 150) commRate = commRate * 1.5;
        return commRate;
    }
    
    public static void calcCommission(double commission) //finnaly calculates the commission
    {
        DecimalFormat twoDigits = new DecimalFormat("$#,000.00");
        JOptionPane.showMessageDialog(null, "Your total commission is " + 
            twoDigits.format(commission), "Commission", JOptionPane.PLAIN_MESSAGE);
    }
}
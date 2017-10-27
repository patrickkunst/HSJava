/**
 * Programmer:  Patrick Kunst
 * Purpose:     To display the commission a stockbroker gets
 */

import javax.swing.JOptionPane; //import statements
import java.text.DecimalFormat;

public class CommissionThatWorks
{
    static double commissionRate = 0.0;
    static double price = 0.0;
    static double commission = 0.0;
    static String stockName, stockbrokerName;
    static int sharesSold;
   
    public static void main(String[] args)
    {
        getInput();
        calculate();
        output();
        finish();
    }
   
    public static void getInput()
    {
        stockName  = JOptionPane.showInputDialog(null, "What is the name of the purchased stock?");
        stockbrokerName = JOptionPane.showInputDialog(null, "What is the name of the stockbroker who sold the stock?");
        
        String txtPrice = JOptionPane.showInputDialog(null, "What is the price of the stock?");
            price = Double.parseDouble(txtPrice);
        
        String txtSharesSold = JOptionPane.showInputDialog(null, "How many shares have been sold?");
            sharesSold = Integer.parseInt(txtSharesSold);
    }
    
    public static void calculate()
    {
        if (price <= 75) commissionRate = 0.25;
        else if (price > 75) commissionRate = 0.31;
        
        if (sharesSold < 150) commissionRate = commissionRate * 1.5;
        
        commission = commissionRate * sharesSold;
    }
    
    public static void output()
    {
        DecimalFormat twoDigits = new DecimalFormat("$##,###.00");
        String message = sharesSold + " shares of " + stockName + " at a cost of " +
            twoDigits.format(price) + " per share " + "\n results in a commission of " + twoDigits.format(commission);
        JOptionPane.showMessageDialog(null, message, stockbrokerName + "'s Commission", JOptionPane.PLAIN_MESSAGE);
    }
    
    public static void finish()
    {
        System.exit(0);
    }
}
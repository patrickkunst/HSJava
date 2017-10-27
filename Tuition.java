/**
 * Programmer:  Patrick Kunst
 * Purpose:     To calculate the tuition based on the number of hours
 */

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Tuition
{
    public static void main(String[] args)
    {
        int hours;
        double tuition, rate, fees;
        
        displayWelcome();
        hours = getHours();
        rate = getRate(hours);
        tuition = calcTuition(hours, rate);
        fees = calcFees(tuition);
        displayTotal(tuition + fees);
    }
    
    public static void displayWelcome()
    {
        JOptionPane.showMessageDialog(null, "Welcome to the Tuition Calculator",
            "Tuition Program", JOptionPane.PLAIN_MESSAGE);
    }
    
    public static int getHours()
    {
        int hours = 0;
        
        try
        {
            String strHours = JOptionPane.showInputDialog(null, "What is the total number of hours?");
            hours = Integer.parseInt(strHours);
        }
        
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "The number of hours must be a whole number", "ERROR",
                JOptionPane.PLAIN_MESSAGE);
        }
        
        return hours;
    }
    
    public static double getRate(int hours)
    {
        double rate;
        if (hours > 15) rate = 94.50;
        else rate = 105;
        
        return rate;
    }
    
    public static double calcTuition(int hours, double rate)
    {
        double tuition;
        tuition = rate * hours;
        
        return tuition;
    }
    
    public static double calcFees(double tuition)
    {
        double fees;
        
        fees = tuition * 0.08;
        return fees;
    }
    
    public static void displayTotal(double total)
    {
        DecimalFormat twoDigits = new DecimalFormat("$#,000.00");
        JOptionPane.showMessageDialog(null, "The total tuition and fees is " + 
            twoDigits.format(total), "Calcualation", JOptionPane.PLAIN_MESSAGE);
    }
}
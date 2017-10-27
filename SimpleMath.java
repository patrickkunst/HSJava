/*
    Programmer:     Patrick Kunst
    Purpose:        To create a program that does simple calculations
*/


import javax.swing.JOptionPane;
public class SimpleMath
{
    public static void main (String args[] )
    {

        // declare variables
        String number1, number2;
        int integer1, integer2, sum, difference, product;
        double quotient, double1, double2;

        //get first of two integers using an input dialog box
        number1 = JOptionPane.showInputDialog(null, "Enter your first number");
            // change your string to an integer
            integer1 = Integer.parseInt(number1);
        // get second of two integers using an input dialog box
        number2 = JOptionPane.showInputDialog(null, "Enter your second number");
            // change your string to an integer
            integer2 = Integer.parseInt(number2);
        // enter your math 
        sum = integer1 + integer2;
        difference = integer1 - integer2;
        product = integer1 * integer2;
        double1 = Double.parseDouble(number1); //I put this line and the next so the quotient doesn't say
            //0.0 if the numbers don't evenly divide
        double2 = Double.parseDouble(number2);
        quotient = double1 / double2;
        
        // display the sum in a message dialog 
        JOptionPane.showMessageDialog(null, "Sum equals " + sum + ".",
            "Sum of the numbers", JOptionPane.PLAIN_MESSAGE);
        // display the difference in a message dialog box
        JOptionPane.showMessageDialog(null, "Difference equals " + difference + ".",
            "Difference of the numbers", JOptionPane.PLAIN_MESSAGE);
        // display the product in a message dialog box
        JOptionPane.showMessageDialog(null, "Product equals " + product + ".",
            "Product of the numbers", JOptionPane.PLAIN_MESSAGE);
        // display the quotient in a message dialog box
        JOptionPane.showMessageDialog(null, "Quotient equals " + quotient + ".",
            "Quotient of the numbers", JOptionPane.OK_CANCEL_OPTION);
        // exit method
        System.exit(0);
    }

}
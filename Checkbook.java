/*
 * Programmer:  Patrick Kunst
 * Purpose:     To balance a checkbook
 */

//import statements
import javax.swing.JOptionPane;
public class Checkbook
{
    public static void main(String[] args)
    {
        //declaring variables
        String beginBalance, deposits, totalChecks, fees;
        double beginBalanceD, depositsD, totalChecksD, feesD, endBalance;
        
        //getting user input
        beginBalance = JOptionPane.showInputDialog(null, "What is the balance from your last statement?");
            beginBalanceD = Double.parseDouble(beginBalance);
        deposits = JOptionPane.showInputDialog(null, "What is the total amount of all deposits?");
            depositsD = Double.parseDouble(deposits);
        totalChecks = JOptionPane.showInputDialog(null, "What is the total amount of all checks?");
            totalChecksD = Double.parseDouble(totalChecks);
        fees = JOptionPane.showInputDialog(null, "What is the total amount of all transaction fees?");
            feesD = Double.parseDouble(fees);
        
        //calculation
        endBalance = (beginBalanceD + depositsD - totalChecksD - feesD);
        
        //display balance to user
        JOptionPane.showMessageDialog(null, "Your ending balance is $" + endBalance + ".",
            "Ending Balance", JOptionPane.PLAIN_MESSAGE);
            
        //exit
        System.exit(0);
    }
}
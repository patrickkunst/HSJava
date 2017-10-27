/*
 * Programmer:  Patrick Kunst
 * Purpose:     To create a program that displays the user's income to debt ratio.
 */

//import statements
import javax.swing.JOptionPane;

//header
public class DebtRatio
{
    public static void main(String[] args)
    {
        //declaring variables
        String strMonthlyIncome, strMortgage, strAutoLoan, strOtherDebt;
        double monthlyIncome, mortgage, autoLoan, otherDebt, ratio;
        
        //collect user input
        strMonthlyIncome = JOptionPane.showInputDialog(null, "What is your monthly income?");
            monthlyIncome = Double.parseDouble(strMonthlyIncome);
        strMortgage = JOptionPane.showInputDialog(null, "How much do you pay for your mortgage/rent each month?");
            mortgage = Double.parseDouble(strMortgage);
        strAutoLoan = JOptionPane.showInputDialog(null, "How much do you pay on your auto loan each month");
           autoLoan = Double.parseDouble(strAutoLoan);
        strOtherDebt = JOptionPane.showInputDialog(null, "How much other debt do you have each month?");
            otherDebt = Double.parseDouble(strOtherDebt);
        
        //calculations
        ratio = (mortgage + autoLoan + otherDebt) / monthlyIncome;
        
        //show the final ratio
        JOptionPane.showMessageDialog(null, "Your income to debt ratio is " + ratio,
            "Income to Debt Ratio", JOptionPane.PLAIN_MESSAGE);
        
        //exit method
        System.exit(0);
    }
}
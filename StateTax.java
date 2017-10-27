/*
 * Programmer:  Patrick Kunst
 * Purpose:     To determine an employee's state tax
 */
import javax.swing.JOptionPane;

public class StateTax
{
    public static void main(String[] args)
    {
        //declare and construct variables
        String txtIncome, txtDependents;
        int dependents;
        double stateTax, income;
        
        //get the taxpayer's income
        txtIncome = JOptionPane.showInputDialog(null, "Enter the taxpayer's income.");
            income = Double.parseDouble(txtIncome);
        
            //get the number of dependents
        txtDependents = JOptionPane.showInputDialog(null, "Enter the number of the taxpayer's dependents.");
            dependents = Integer.parseInt(txtDependents);
        
        //calculation
        stateTax = 0.03 * (income - (600 * dependents));
        
        //display output
        JOptionPane.showMessageDialog(null, "Your state tax is $" + stateTax,
            "State tax", JOptionPane.OK_CANCEL_OPTION);
        
        //Exit method
        System.exit(0);
    }
}
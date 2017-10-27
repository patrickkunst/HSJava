/**
 * Programmer:  Patrick Kunst
 * Purpose:     To give users a walkthrough for Java Programming
 */

//import statements
import javax.swing.JOptionPane;
import java.io.*;

public class MyType
{
    public static void main(String[] args)
    {
        String strChoice, strTryString, strTryInt, strTryDouble;
        int choice, tryInt;
        double tryDouble;
        boolean done = false;
        
        while(!done)
        {
            try
            {
                strChoice = JOptionPane.showInputDialog(null, "What's My Type?" + 
                    "\n\n1) String \n2) Integer \n3)double \n4)Quit the program");
                    choice = Integer.parseInt(strChoice);
                    if (strChoice == null) strChoice = "4";
                switch(choice)
                {
                    case 1:
                        strTryString = JOptionPane.showInputDialog(null, "Give an example of a String");
                        JOptionPane.showMessageDialog(null, "Correct, any input can be saved as a String", "Correct!", JOptionPane.PLAIN_MESSAGE);
                        break;
                    case 2:
                        strTryInt = JOptionPane.showInputDialog(null, "Give an example of an Integer");
                        tryInt = Integer.parseInt(strTryInt);
                        JOptionPane.showMessageDialog(null, "Correct", "Correct", JOptionPane.PLAIN_MESSAGE);
                        break;
                    case 3:
                        strTryDouble = JOptionPane.showInputDialog(null, "Give an example of a Double");
                        tryDouble = Double.parseDouble(strTryDouble);
                        JOptionPane.showMessageDialog(null, "Correct", "Correct", JOptionPane.PLAIN_MESSAGE);
                        break;
                    case 4:
                        done = true;
                        JOptionPane.showMessageDialog(null, "The program will now close", "Closing",
                            JOptionPane.PLAIN_MESSAGE);
                        break;
                    default:
                        throw new NumberFormatException();
                        
                }
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Try again", "Incorrect", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
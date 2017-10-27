/*
 * Programmer:  Patrick Kunst
 * Purpose:     This program creates a splash screen by displaying a welcome message, the user's name,
 *              and the system date when the user opens the program.
 */
import java.util.Date;

public class Welcome
{
   public static void main(String[] args)
   {
       Date currentDate = new Date(); //date constructor
       System.out.println();
       System.out.println("\t\t\tWelcome to my day!");
       System.out.println("\t\t\tDaily planner for Patrick Kunst");
       System.out.println("\t\t\t" + currentDate);
       System.out.println();
   }
}
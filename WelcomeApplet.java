/*
 * Programmer:      Patrick Kunst
 * Purpose:         The purpose of this code is to create an applet welcoming the user to the program
 */

import java.util.Date;
import java.awt.*;
import java.applet.*;

public class WelcomeApplet extends Applet
{
    public void paint(Graphics g)
    {
        Date currentDate = new Date(); //date constructor
        g.drawString("Welcome to my day!", 200, 70);
        g.drawString("Daily planner for Patrick Kunst", 200, 100);
        g.drawString(currentDate.toString(), 200, 130);
        Image smile;    // declare an Image object
        smile = getImage(getDocumentBase(), "Smile.gif");
        g.drawImage(smile, 10, 10, this);   // Places the smile
        setBackground(Color.black);
        setForeground(Color.magenta);   //Text color
    }
}
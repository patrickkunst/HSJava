/*
 * Programmer:  Patrick Kunst
 * Purpose:     To display information about myself in an applet
 */

//import statements
import java.applet.*;
import java.awt.*;

public class InformationApplet extends Applet
{
    public void paint(Graphics g)
    {
        //Display my information
       g.drawString("Patrick Kunst", 200, 70);
       g.drawString("Pumpkin Gnocchi", 200, 100);
       g.drawString("Dragon Ball Z", 200, 130);
       
       //Set bacground color
       setBackground(Color.black);
       //Set text (foreground) colors
       setForeground(Color.magenta);
    }
}
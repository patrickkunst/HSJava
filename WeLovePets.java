/**
 * Programmer:  Patrick Kunst
 * Purpose:     To provide prices for various services
 */

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.text.DecimalFormat;

public class WeLovePets extends Applet implements ActionListener, ItemListener
{
    //constructors
    Label welcLabel = new Label("Welcome to the We Love Pets Service Calculator!");
    Label checkLabel = new Label("Check all the boxes for the sevices you would like performed.");
    
    Checkbox visitBox = new Checkbox("Office Visit", false);
    Checkbox vaccineBox = new Checkbox("Vaccination", false);
    Checkbox hospitalBox = new Checkbox("Hospitalization", false);
    Checkbox heartwormBox = new Checkbox("Heartworm Prevention", false);
    Checkbox boardBox = new Checkbox("Boarding", false);
    Checkbox dentistBox = new Checkbox("Dentistry", false);
    Checkbox xrayBox = new Checkbox("X-Rays", false);
    Checkbox labBox = new Checkbox("Labratory Work", false);
    Checkbox prescriptionBox = new Checkbox("Prescriptions", false);
    
    Button calcButton = new Button("Calculate Total");
    Label lblCalc = new Label("Press the button to calculate your total after checking all the checkboxes that apply");
    
    //Labels to display cost of each (WHY ARE THEERE SO MANY!!!???)
    Label lblVisit = new Label("");
    Label lblVaccine = new Label("");
    Label lblHospital = new Label("");
    Label lblHeartworm = new Label("");
    Label lblBoard = new Label("");
    Label lblDentist = new Label("");
    Label lblXray = new Label("");
    Label lblLab = new Label("");
    Label lblPrescription = new Label("");
    
    double visit, vaccine, hospital, heartworm, boarding, dentist, xray, labratory, prescription, total;
    
    public void init()  //adds items to constructors
    {
        setBackground(Color.red);
        
        add(welcLabel);
        add(checkLabel);
        add(visitBox);
            visitBox.addItemListener(this);
        add(vaccineBox);
            vaccineBox.addItemListener(this);
        add(hospitalBox);
            hospitalBox.addItemListener(this);
        add(heartwormBox);
            heartwormBox.addItemListener(this);
        add(boardBox);
            boardBox.addItemListener(this);
        add(dentistBox);
            dentistBox.addItemListener(this);
        add(xrayBox);
            xrayBox.addItemListener(this);
        add(labBox);
            labBox.addItemListener(this);
        add(prescriptionBox);
            prescriptionBox.addItemListener(this);
        add(calcButton);
            calcButton.addActionListener(this);
        add(lblCalc);
        add(lblVisit);
        add(lblVaccine);
        add(lblHospital);
        add(lblHeartworm);
        add(lblBoard);
        add(lblDentist);
        add(lblXray);
        add(lblLab);
        add(lblPrescription);
    }
    
    public void itemStateChanged(ItemEvent choice) //activates when checkboxes are checked
    {
        if(visitBox.getState() == true)
        {
            lblVisit.setText("A visit costs $40");
            visit = 40;
        }
        if(vaccineBox.getState() == true)
        {
            lblVaccine.setText("A vaccine costs $30");
            vaccine = 30;
        }
        if(hospitalBox.getState() == true)
        {
            lblHospital.setText("A hospitalization costs $100");
            hospital = 100;
        }
        if(heartwormBox.getState() == true)
        {
            lblHeartworm.setText("Heartworm prevention costs $10");
            heartworm = 10;
        }
        if(boardBox.getState() == true)
        {
            lblBoard.setText("Boarding will cost $75");
            boarding = 75;
        }
        if(dentistBox.getState() == true)
        {
            lblDentist.setText("Dentistry will cost $30");
            dentist = 30;
        }
        if(xrayBox.getState() == true)
        {
            lblXray.setText("X-rays will cost $25");
            xray = 25;
        }
        if(labBox.getState() == true)
        {
            lblLab.setText("Labratory work will cost $25");
            labratory = 25;
        }
        if(prescriptionBox.getState() == true)
        {
            lblPrescription.setText("Prescriptions will cost $10");
            prescription = 10;
        }
    }  
    
    public void actionPerformed(ActionEvent e)
    {
        total = prescription + labratory + xray + dentist + boarding + heartworm + vaccine + hospital + visit; //total calculation
        
        DecimalFormat twoDigits = new DecimalFormat("$##,###.00");
        
        lblCalc.setText("Your total is " + twoDigits.format(total));
        
        clearBoxes();
    }
    
    public void clearBoxes() //this method clears out all the boxes and sets them to false
    {
        boardBox.setState(false);
        dentistBox.setState(false);
        xrayBox.setState(false);
        labBox.setState(false);
        prescriptionBox.setState(false);
        heartwormBox.setState(false);
        hospitalBox.setState(false);
        visitBox.setState(false);
        vaccineBox.setState(false);
    }
}
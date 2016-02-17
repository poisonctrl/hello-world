package assignmentone;

import java.util.Scanner;

/* This is the answer to Comp 272 Assignment 1 Question 3 for Eric Belrose student number 2312903 */

//This class must follow very stringent requirements from the question.

public class chcIQCalculator {
    
    //each category of the IQ test is given a private instance variable
    private int fluidint;
    private String crystalized;
    private boolean quantitative;
    private String readwrite;
    private String shortterm;
    private int longterm;
    private int visual;
    private int auditory;
    private double procspd;
    private double decisionrxtime;
    
    //empty constructor to instantiate the class
    public chcIQCalculator () {}
    
    //constructor that requests input from the user.  In this case there are some categories that are part of the generic.  The question requires that certain fields be defined in the code.  This a a realistic scenerio
    //because you could develop a lighter version in which case the most common response is defaulted.  This is common in both commercial trial versions of software and in cases where you may sell a reduced function version
    public void newCalc () {
        Scanner read = new Scanner(System.in);
        
        System.out.println("Please enter the participants fluid intelligence (1 - 15): ");
        this.fluidint = read.nextInt();
        System.out.println("If the participant has quantitative intelligence please enter (true): ");
        this.quantitative = read.nextBoolean(); //initially thought I had the wrong form for nextBoolean because there was one less prompt.  I tested this by inputing unexpected values for each type of prompt.  
        //The inputmismatch called on certain lines.
        System.out.println("Please enter (good) if the participant has good short-term memory: ");
        this.shortterm = read.next();  //this is where the true error
        System.out.println("Please enter the auditory skill level (1-5): ");
        this.auditory = read.nextInt();
        System.out.println("Please state the participants age (21 - 75): ");
        this.procspd = (100-read.nextInt())/10;
        
        //this section is the pre-determined values
        this.crystalized = "excellent";
        this.readwrite = "good";
        this.longterm = 7;
        this.visual = 4;
        
    }
    
    //this constructor allows you to input the full values and design your own interface. 
    public chcIQCalculator(int gf, String gc, boolean gq, String grw, String gsm, int glr, int gv, int ga, int age) {
        fluidint = gf; // interactively from console range from 1 - 15
        crystalized = gc; // known possvalues are 'excellent = 15','acceptable = 8','poor = 3' 
        quantitative = gq; // interactively 'true = 10' or 'false = 0'
        readwrite = grw; // known 'brilliant = 15', 'good = 10', 'normal = 6', 'poor = 2'
        shortterm = gsm; // interactively 'good = 15', 'bad = 5'
        longterm = glr; // known range 1 - 15
        visual = gv; // known range 1 - 10
        auditory = ga; // interactively 1 - 5
        procspd = (100-age)/10;  // interactive age from 21 - 75 [gs = (100-age)/10
        decisionrxtime = 10 - procspd; // 10-gs
    }
    
    //the planned section here would prompt for full value input
    
    //this method allows you to manipulate the value for fluid intelligence
    public void assigngf (int f) {
        this.fluidint = f;
    }
    
    //this method allows you to manipulate the value for crystalized intelligence
    public void assigngc (String c) {
        this.crystalized = c;
    }
    
    //this method allows you to manipulate the value for quantitative intelligence
    public void assigngq (boolean q) {
        this.quantitative = q;
    }
    
    //this method allows you to manipulate the value for reading and writing intelligence
    public void assigngrw (String rw) {
        this.readwrite = rw;
    }
    
    //this method allows you to assign short-term memory
    public void assigngsm (String sm) {
        this.shortterm = sm;
    }
    
    //this method allows you to assign longterm memory
    public void assignglr (int lr) {
        this.longterm = lr;
    }
    
    //this method allows you to manipulate your visual intelligence
    public void assigngv (int v) {
        this.visual = v;
    }
    
    //this method allows you to manipulate your auditory intelligence
    public void assignga (int a) {
        this.auditory = a;
    }
    
    //this method allows you to manipulate 
    public void assigngs (int s) {
        this.procspd = (100 - s)/10;
        this.decisionrxtime = calcdrxtime (procspd);
    }
    
    //this method allows you to manipulate
    public double calcdrxtime (double s) {
        return 10-s;
    }
    
    
    //this method retrieves the value for fluid intelligence
    public int getgf() {
        return this.fluidint;
    }
    
    //this method converts the string input to the numerical value
    public int calcgc (String crystalin) {
        switch (crystalin) {
            case "excellent": return 15;
            case "acceptable": return 8;
            default: return 3;
        }
    }
    
    //this method is to convert the boolean value to numerical value
    public int calcgq (boolean quantin) {
        if (quantin) {return 10;}
        return 0;
    }
    
    //this method is to convert the string value for reading and writing into the numerical value
    public int calcgrw (String inrw) {
        switch (inrw) {
            case "brilliant": return 15;
            case "good": return 10;
            case "normal": return 6;
            default: return 2;
        }
       
    }
    
    //this method is to convert the string value for short-term memory into the numerical value.  Note that any input other than good is going to default return a bad value
    public int calcgsm (String gsmin) {
        if (gsmin.equals("good")) {return 15;}
        return 5;
    }
    
    
    //this is the final calculation.  This could be done also with a manual input, or tagged onto a constructor easily
    public double calcIQ () {
        double totalIQ = this.fluidint + calcgc(this.crystalized) + calcgq(this.quantitative) + calcgrw(this.readwrite) + calcgsm(this.shortterm) + this.longterm + this.visual +this.auditory + this.procspd + calcdrxtime(this.procspd);
        return totalIQ;
    }
    
    //this is the main method body.  I would normally remove this to a separate class to black box the calculator.  That way you can reuse it's functionality.  In this case the question didn't demand much. 
    public static void main(String [] args) {
        chcIQCalculator Calculator = new chcIQCalculator();
        Calculator.newCalc();
        double IQ = Calculator.calcIQ();
        System.out.println("The participant's IQ is: " + IQ);
        
        //to test separate instance create new object
        
        chcIQCalculator clctesttwo = new chcIQCalculator();
        double TQ = clctesttwo.calcIQ();
        System.out.println("The participant's IQ is: " + TQ);

    }
}
    
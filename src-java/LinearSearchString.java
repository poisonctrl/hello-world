package assignmentone;

import java.util.Random;
import java.util.Scanner;

/* This is the answer to Comp 272 Assignment 1 Question 2 for Eric Belrose student number 2312903 */

public class LinearSearchString {
    public static int statistic;
    public static void main (String [] args) {
        String[] random = {"test", "is", "random", "string", "now", "it", "will", "need", "to", "eggs"};
        statistic = 780; //the initial statistic should not be 780, in 1000 runs 780 was faster b2f
        //thus it would have incremented 780 times and decremented 220 times for a stat of 560
        //the assignment indicated 780 being incremented and decremented so it was left
        String tester = "Y";
        while (!tester.equals("N")) {
            random = ranstr(random, random.length);
            int test = search (random, "random");
            System.out.println("The search string was found at position " + test);
            System.out.println("The back to front search has found the search value " + statistic + " times.");
            System.out.println("Do you wish to shake things up and try again? (Y/N)");
            Scanner read = new Scanner(System.in);
            tester = read.nextLine(); //forgot to enter tester as variable so it never quit
        }
        
        
    }
    
    public static String[] ranstr(String[] shakeme, int size) { //eventually puts test case to 0 and leaves it there need to debug
        //for (String e : shakeme) System.out.print (" " + e);
        //System.out.println();
        Random num = new Random();
        int swapval;
        String strHolder;
        for (int x = 0 ; x < size ; x++) { //error was in this function as it was not swapping but replacing.
            swapval = num.nextInt(size); //System.out.println("The swapval is " + swapval + " and x is " + x);
            strHolder = shakeme[swapval];
            shakeme[swapval]=shakeme[x];
            //shakeme[x] = shakeme[swapval]; //this was the faulty line should have put x to strHolder
            shakeme[x] = strHolder;
        }
            
        
        return shakeme;
    }
    
    public static int search (String[] ranStringArray, String searchStr) {
        int f2b = 0;
        int b2f = 0;
        int f2bindex = 0;
        int b2findex = 0;
        
        for (int x = 0 ; x < ranStringArray.length-1 ; x++) {
            if (ranStringArray[x].equals(searchStr)) {f2bindex = x; break;}
            f2b++;
        }   

        for (int x = ranStringArray.length-1 ; x >= 0 ; x--) {
            if (ranStringArray[x].equals(searchStr)) {b2findex = x; break;}
            b2f++;
        }   
        
        if (f2b > b2f) {statistic++;} else {statistic--;} //count doesn't behave as expected... 
        /* One flaw with the count would be in odd number of elements it would decrement for equals.  
         * /I would fix this with making it neither on equal case.
         */
        
        //b2f is always 0 weird
        
        //debugging
        System.out.println(f2b + " is f2b " + b2f + " is b2f ");
        
        
        return f2bindex;
    }
}
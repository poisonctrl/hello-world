package assignmentone;

/* This is the answer to Comp 272 Assignment 1 Question 1 for Eric Belrose student number 2312903 */

import java.util.Scanner;
import java.util.StringTokenizer;

public class age {
    public static void main(String [] args) {
        String test = "";

        Scanner input = new Scanner(System.in);
        System.out.println("Please input the ages of 12 of your friends separated by a space");
        test = input.nextLine();
        
        StringTokenizer strcutter = new StringTokenizer(test, " "); 
        
        try {
            int agessize = strcutter.countTokens(); //had to look up counttokens tried size and length
            int [] ages = new int [agessize];
            int min = 0;
            int max = 0;
            int x = 0;

            double agesum = 0;
            while (strcutter.hasMoreTokens()) { //originally had hasNext vice hasMoreTokens
                ages[x] = Integer.parseInt(strcutter.nextToken());//guessed nextToken could not make it convert string to int
                //System.out.print (ages[x] + " "); //was used for debugging had (int) instead of parseInt() had to look up again
                if (x == 0) {max = ages[x]; min = max;}
                if (ages[x]>max){ max=ages[x];}
                if (ages[x]<min){ min=ages[x];}
            
                x++;
            }

            while (x>0) {
                x--;
                agesum += ages[x];
                
            }
            double aveage = agesum/agessize;
            System.out.println("The average age is " + aveage);
            System.out.println("The difference between the youngest and oldest is " + (max-min) + " years.");
        } catch (Exception e) {}
                
    }
}

/* Test cases - 
 * age.main({ });
Please input the ages of 12 of your friends separated by a space
2 3 5 26 2 62 35
2 3 5 26 2 62 35 The average age is 19.285714285714285

age.main({ });
Please input the ages of 12 of your friends separated by a space
2 4 6 8 this will make my program break
2 4 6 8 

age.main({ });
Please input the ages of 12 of your friends separated by a space
1 3 1 41 3 23 42
1 3 1 41 3 23 42 7
The average age is 16.285714285714285 
The difference between the youngest and oldest is 42 years.
(error was because min was set to 0 in declaration


age.main({ }); //truest test case since it has 12 inputs
Please input the ages of 12 of your friends separated by a space
1 25 52 12 42 23 28 28 92 108 23 15
The average age is 37.416666666666664
The difference between the youngest and oldest is 107 years.

 */
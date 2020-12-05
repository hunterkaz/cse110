/*-------------------------------------------------------------
// AUTHOR: Hunter Kasprzyk
// FILENAME: Lab3
// SPECIFICATION: This program takes user input for homework, mid-term, and final exam scores. After making sure these values are correct and work it calculates the weighted final grade and tells the student if they passed or not.
// FOR: CSE 110- Lab #3
// TIME SPENT: 2 hours
//-----------------------------------------------------------*/

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        // This scanner is prepared for you to get inputs
        Scanner scanner = new Scanner(System.in);
        // Declare three variables for HW, mid-term, and final exam grades
        double homeworkScore = 0;
        double midtermScore = 0;
        double finalScore = 0;
        // Declare a loop control variable i
        int i = 0;

        while (i<3) {
        	
            // Design if-else control flow
           //if i is 0 ask for the homework grade
           if (i == 0) {
                // Ask the user for homework grade
            	System.out.println("Enter your HOMEWORK grade: ");
            	homeworkScore = scanner.nextDouble();
                // Do input validation
           
                if (homeworkScore > 100 || homeworkScore < 0) {  // - homework grade is in [0, 100]
                    // Show the error message
                	System.out.println("[ERR] Invalid input. A homework grade should be in [0, 100]"); //error message if the grade is not in the range
                } else {
                    // Update the loop variable
                	i++;
                }
           }
           // if i is 1, asks for the mid-term exam grade
           if (i==1) {
            	System.out.println("Enter your MIDTERM EXAM grade: ");
            	midtermScore = scanner.nextDouble();
            	
            	if(midtermScore > 100 || midtermScore < 0) { // - mid-term grade is in [0, 100]
            		System.out.println("[ERR] Invalid input. A midterm grade should be in [0, 100]"); //error message if the grade is not in the range
            	} else {
            		// Update the loop variable
            		i++;
            	}
           }
           // if i is 2, ask for the final exam grade
           if (i==2) {
        	   System.out.println("Enter your FINAL EXAM grade: ");
        	   finalScore = scanner.nextDouble();
        	   
        	   if (finalScore > 200 || finalScore < 0) { // - final exam grade is in [0, 200]
        		   System.out.println("[ERR] Invalid input. A final exam grade should be in [0, 200]"); //error message if the grade is not in the range
        	   } else {
        		   // Update the loop variable
        		   i++;
        	   }
        	   
           }
        }
        

        // Calculate the weighted total by the formula showed in the PDF
        // By factoring the final exam score and weight with the mid-term score and weight with the homework score and weight we get the overall weighted total for the grade.
        double weighted_total = ((finalScore/200) * 50) + (midtermScore * .25) + (homeworkScore * .25);
        System.out.println("[INFO] Student's Weighted Total is " + weighted_total);
        // Show the weighted total and tell the user s/he passed or not
        if (weighted_total >= 50) {  // if a student's total is greater than or equal to 50 then they pass, else they fail.
            System.out.println("[INFO] Student PASSED the class");
        } else {
        	System.out.println("[INFO] Student FAILED the class");
        }

        scanner.close();

    }  // End of main
}  // End of class

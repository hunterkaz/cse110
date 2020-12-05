/*-------------------------------------------------------------
// AUTHOR: Hunter Kasprzyk
// FILENAME: Lab4
// SPECIFICATION: This program gives the user 3 different functions. Entering 1 and then an integer finds the sum from 1 to that number entered and loops back around. Entering 2 and then an integer finds that factorial of that given number and loops back around. Entering 3 and then a integer will output the leftmost digit of that number and loops back around. And then entering 4 ends the loop and said "Bye"
// FOR: CSE 110- Lab #4
// TIME SPENT: 2 hours
//-----------------------------------------------------------*/

// Import Scanner class
import java.util.*;
public class Lab4 {

    public static void main(String[] args) {
        // Declare some variables you need
        // Declaring and initializing a Scanner
    	Scanner in = new Scanner(System.in);
    	int choice = 1;
        do { //do loop containing our switch statement
            // Display the menu
            displayMenu();
            
            // Ask the user for one option
            choice = in.nextInt();

            switch (choice) { //switch including our case numbers
                // Define four cases for different options. Don't forget "break".
            case 1 : //Takes the user inputed integer and calculates the sum from 1 to that number.
            	System.out.println("Enter a number: ");
            	int m = in.nextInt();
            	int answer1 = 0;
            	for (int i = m; i > 0 ; i--) { //starting at the inputed integer and then continuing as long as it's greater than 0, reducing by 1 each time it goes through the loop.
            		answer1 = answer1 + i; //calculating sum
            		
            	}
            	//Printing out results
            	System.out.println("The sum of 1 to " + m + " is " + answer1);
            	System.out.println();
            break;

            case 2 : //Takes the user inputed integer and calculates the factorial of that number
            	System.out.println("Enter a number: ");
            	int n = in.nextInt();
            	int answer2 = 1;
            	for (int i = n; i > 0 ; i--) { //starting at the inputed integer and then continuing as long as it's greater than 0, reducing by 1 each time it goes through the loop.
            		answer2 = answer2 * i; //calculating factorial
            		
            	}
            	//Printing out results
            	System.out.println("The factorial of " + n + " is " + answer2);
            	System.out.println();
            	
            break;
            
            case 3 : // Takes the user input integer and then continues to cut off a decimal place at the end until there is only one left, finding the leftmost digit.
            	System.out.println("Enter a number: ");
            	int o = in.nextInt();
            	int answer3 = 0;
            	int originalNum = o;
            	while (o != 0)  { //As long as the inputed integer does not equal 0 the while loop will continue to divide by 10. This results in us stopping once we have only the leftmost digit.
            		answer3 = o;
            		o = o/10;
            	}
            	//Printing out results
            	System.out.println("The leftmost digit of " + originalNum + " is " + answer3);
            	System.out.println();
            break;
            
            case 4 :
            	//Printing out results
            	System.out.println("Bye");
            	
            break;
                // -->
            }
        } while (choice != 4); //as long as the choice does not equal 4 then the do loop will continue

    }

    /**
     * Print the menu
     */
    private static void displayMenu() {
        System.out.println("Please choose one option from the following menu:");
        System.out.println("1) Calculate the sum of integers from 1 to m");
        System.out.println("2) Calculate the factorial of a given number");
        System.out.println("3) Display the leftmost digit of a given number");
        System.out.println("4) Quit");
    }
}
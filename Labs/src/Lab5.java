/*-------------------------------------------------------------
// AUTHOR: Hunter Kasprzyk
// FILENAME: Lab5
// SPECIFICATION: This program gives the user the option to create a row pattern, pyramid, or quit. If they choose to build a row they are given the option to input how many characters they want the side to be as well as the middle. If they decide to build a pyramid they input the amount of symbols they want at the bottom. If they input an even number it will subtract one and notify them they at has been changed to an odd number so that the program will work. I did not end up doing the diamond challenge. If the user inputs q to quit the program will say Bye and end.
// FOR: CSE 110- Lab #5
// TIME SPENT: 3 hours
//-----------------------------------------------------------*/

import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        final char SIDE_SYMB = '-';
        final char MID_SYMB = '*';
        Scanner scanner = new Scanner(System.in);
        String inputStr = "";
        char choice = ' ';
        int numSymbols = -1, sideWidth = -1, midWidth = -1;

        do {
            displayMenu();
            inputStr = scanner.nextLine();
            if (inputStr.length() > 0) {
                choice = inputStr.charAt(0);
            }

            switch (choice) {
            case 'r':
                System.out.println("Width of the sides?");
                sideWidth = scanner.nextInt();
                System.out.println("Width of the middle?");
                midWidth = scanner.nextInt();
                scanner.nextLine();  // Flush junk newline symbols

                System.out.println();
                System.out.println(buildRow(SIDE_SYMB, sideWidth, MID_SYMB, midWidth));

                break;
            case 'p':
                System.out.println("Number of symbols on the lowest layer?");
                numSymbols = scanner.nextInt(); 
                scanner.nextLine();  // Flush junk newline symbols

                System.out.println();
                System.out.println(buildPyramid(SIDE_SYMB, MID_SYMB, numSymbols));

                break;
            case 'd': //I did not end up doing the challenge
                System.out.println("Number of symbols on the middle layer?");
                numSymbols = scanner.nextInt();
                scanner.nextLine();  // Flush junk newline symbols

                System.out.println();
                System.out.println(buildDiamond('*', ' ', numSymbols));

                break;
            case 'q':
                System.out.println("Bye");
                break;
                
            default:
                System.out.println("Please choose a valid option from the menu.");
                break;
            }
            System.out.println();
        } while (choice != 'q');
        
        scanner.close();
    }
    
    
    /**
     * @param sideSymb  A char to be repeated on both sides
     * @param sideWidth Number of symbols on each side
     * @param midSymb   A char to be repeated in the middle
     * @param midWidth  Number of symbols in the middle
     * @return          A String of a row of the designed pattern
     */
    private static String buildRow(
        char sideSymb, int sideWidth, char midSymb, int midWidth) { //build Row takes in the side symbol, the amount of characters wide the side will be, the middle symbol and then amount of characters wide the middle will be
    	
        String result = ""; //This string result will be used as the final print for the build row
        int numSideWidth = sideWidth; //this variable will represent the integer of the side width that the user inputs
        String side = ""; //this variable will be a String to build the side symbols into using the loop
        for (int i = 0; i<numSideWidth; i++) { //This loop will add the side symbol into the side string the amount of times the user prompts
        	side+=sideSymb; //the side String is adding one Side Symbol each time the loop goes through
        }
        int numMidWidth = midWidth; //This integer will represent the middle width the user wants
        String middle = ""; //This string will be used to build into using the loop
        for (int i = 0; i < numMidWidth; i++) { // This loop will add the middle symbol into the middle string the amount of times the user wants
        	middle+=midSymb; //he middle String is adding one Middle Symbol each time the loop goes through
        }
        
        // Combining the side + middle + side, save into "result" for the complete row
        result = side + middle + side;

        return result; //returning the final result
    } 

    /**
     * 
     * @param  sideSymb   A char to be repeated on both sides
     * @param  midSymb    A char to be repeated in the middle
     * @param  numSymbols The number of symbols on the lowest layer
     * @return            A String of the pyramid pattern.
     */
    private static String buildPyramid(
        char sideSymb, char midSymb, int numSymbols) { //build Pyramid takes the side symbol, the middle symbol and the number of symbols at the bottom

        String result = ""; // String for the end result
        
        // If numSymbols is 0, return an empty string
        int numAtBottom = numSymbols;
        if (numAtBottom == 0) { //if the number of symbols is 0
        	return ""; //returns empty string
        }
        
        // If numSymbols is not an odd number, find the
        // odd number less than numSymbols and replace it
        if (numAtBottom % 2 == 0) {  //finds if the number is odd and if it isn't then we subtract 1 end notify the user.
        	numAtBottom = numAtBottom - 1;
        	System.out.println("The input is not an odd number. Use the closest odd number below " + numSymbols); //Notifies user that their number was even and that we are going to go to the closest odd number that is less than the number they inputed.
        }
        
        //loop to iterate the pyramid's levels
        int pyramidMiddle = 1; //initializing variable for the pyramid middle, since the top will always have 1 symbol we start at 1
        int pyramidSide = (numSymbols - pyramidMiddle) / 2; //the pyramid side is equal to the number of symbols subtracted from the pyramid middle all divided by 2
        for (int i = 0; i < pyramidSide + 1; i++) { //this loop calls the build row and and adds it to the result for each loop through as long at the i is less than the pyramid side plus 1.
            // Compute the number of middle symbols
            // pyramidMiddle = midSymb + midSymb;
        	// buildRow(sideSymb, pyramidSide, midSymb, pyramidMiddle);
            result += buildRow(sideSymb, pyramidSide - i, midSymb, pyramidMiddle + 2*i) + "\n"; //as well call buildRow we input the side symbol, the pyramid side - i to make sure that as it goes through it is subtracted the amount that is being added by the middle. then adding the middle symbol, and the pyramid middle plus i times 2 so that it starts at 1 and is adding onto the middle each time we go through the loop. Then \n prints a line.
        }

        return result; //returning the final result after all the loops finish
    }

    /**
     * Build a diamond pattern. The parameters are the same 
     * as {@link #buildPyramid(char, char, int)}.
     * 
     * @param  sideSymb  A char to be repeated on both sides
     * @param  midSymb   A char to be repeated in the middle
     * @param  numSymbols The height of a pyramid
     * @return           A String of the inverted diamond pattern.
     */
    private static String buildDiamond(
        char sideSymb, char midSymb, int numSymbols) {

        String result = "";
        
        // YOUR CODE HERE
        // -->
        
        return result;
    }
    
    /**
     * Display the menu
     */
    private static void displayMenu() {
        System.out.println("Please choose one pattern from the list:"); //prompts user input
        System.out.println("r) Row"); //choosing this option will start the process of building the row
        System.out.println("p) Pyramid"); //choosing this option will start the process of building the pyramid
        System.out.println("d) Shallow diamond"); //I did not end up doing the shallow diamond challenge
        System.out.println("q) Quit"); //Quits the program
    }  // End of displayMenu

}  // End of Lab5
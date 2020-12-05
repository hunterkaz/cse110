// CSE 110    : 1096 / Wednesday 10:45am-11:45am
//Assignment  : Assignment04
//Author      : Hunter Kasprzyk #1218558263
//Description : This program generates a 4 digit integer secretly and the user tries to guess the digit. If one of the guess digits matches the corresponding value and position of the randomly generated number it will notify the user that they matched 1. If they match another it will go to 2 and so on until they guess all 4. After they guess all 4 it will congratulate the user and tell them the number of guesses it took to guess correctly. After each guess the user is notified which guess they are on. Then after everything they are asked if they want to play again and if they say "yes" then the program will restart with a new number and go back through.
import java.util.*; 
import java.lang.*;
public class Assignment04 {

    public static void main(String[] args) {
    	//Prompt user input and create a scanner and random number generator
    	System.out.println("----- MASTERMIND -----" + "\n" + "Guess the 4 digit number!");
    	Scanner in = new Scanner(System.in);
    	Random num = new Random();
    	//the while loop will continue as long as the keepPlaying boolean is set to true meaning that the user still wants to play
    	boolean keepPlaying = true;
    	while (keepPlaying) {
    		//Here the random number is being generated randomly from 0 to 9 and then multiplied accordingly to represent the thousandths place, hundredths, tenths, and single.
    		int firstDigit = num.nextInt(10);
        	int secondDigit = num.nextInt(10);
        	int thirdDigit = num.nextInt(10);
        	int fourthDigit = num.nextInt(10);
        	int answer = (firstDigit * 1000) + (secondDigit * 100) + (thirdDigit * 10) + fourthDigit; // Building the answer which will be the number that the user is trying to guess
        	int userGuess = 0; //This variable will hold the number that the user guesses
        	int i = 0; //initializing variables to represent the number of guesses the user has had
        	while (answer != userGuess) { //This while look will continue as long as the user has not guessed the answer that matches the one that was generated
        		i++;
        		System.out.println("Guess " + i + ": "); //Printing out the amount of guesses the user has made
        		userGuess = in.nextInt(); //Scanning in the guess
        		int firstGuessDigit = userGuess/1000; //First guess digit is divided by 1000 so reach the single digit in the thousandths place
        		int secondGuessDigit = (userGuess- (firstGuessDigit * 1000)) /100;  //Second guess digit is subtracted by the first digit *1000 to make sure it is only the hundredths place and then divided by 100 to get the single digit that is in the hundredths place
        		int thirdGuessDigit = ((userGuess - (firstGuessDigit * 1000) - (secondGuessDigit * 100)) /10); //Third guess digit is reached by subtracted the thousandths and hundreths place to make sure it's only the tenths and then divided by 10 to get the single digit that is in the tenths place.
        		int fourthGuessDigit = (userGuess) - (thirdGuessDigit * 10) - (secondGuessDigit *100) - (firstGuessDigit * 1000); //the fourth guess digit is reached by subtracting the thousandths, hundredths, and tenths place to get the final digit in the rightmost place.
        		int correctDigits = 0; //initialize variable to represent how many digits the user has gotten correct
        		if (firstDigit == firstGuessDigit) { //if the first digit of the randomly generated number matches the corresponding place in the user guess the number of correct digits increments up 1.
        			correctDigits++;
        			
        		}
        		if (secondDigit == secondGuessDigit) { //if the second digit of the randomly generated number matches the corresponding place in the user guess the number of correct digits increments up 1.
        			correctDigits++;
        			
        		}
        		if (thirdDigit == thirdGuessDigit) {//if the third digit of the randomly generated number matches the corresponding place in the user guess the number of correct digits increments up 1.
        			correctDigits++;
        			
        		}
        		if (fourthDigit == fourthGuessDigit) {//if the fourth digit of the randomly generated number matches the corresponding place in the user guess the number of correct digits increments up 1.
        			correctDigits++;
        			
        		}
        		System.out.println("You matched " + correctDigits); //Prints out the amount of correct digits are in the guess
        		
        	}
        	//Once the user gets the number right they are congratulated and told how many guesses it took.
        	System.out.println("Congratulations! You guessed the right number in " +  i + " guesses."); 
        	//Now they are asked if they want to play again and their input is scanned in
        	System.out.println("Would you like to play again (yes/no)?");
        	in.nextLine();
        	//if their input is not equal to yes then the keep playing variable is changed to false making the program end, if they do say yes then the loop will start over restarting everything.
        	String restart = in.nextLine();
        	if (!restart.equals("yes")) {
        		keepPlaying = false;
        	
        	}
    	}
    }
}

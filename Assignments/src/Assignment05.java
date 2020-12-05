// CSE 110     : 1096 / Wednesday 10:45am-11:45am
// Assignment  : Assignment05
// Author      : Hunter Kasprzyk #1218558263
// Description : This program holds 10 different methods of various types. From various purposes like printing simple messages to a little more complex methods with a combination of loops working together to make calculations and print out a message of *'s that is equal length to the argument passed in with a length that is in the middle of the other two. This programs is a demonstration of my success to understand how methods work to the extend this class expects.
import java.text.DecimalFormat;
import java.util.*;
public class Assignment05 {

    public static void main(String[] args) {
        // Write any code here that you may wish to test your methods defined below.
    	Scanner scan = new Scanner(System.in);
         // Code to test methods
 		displayGreeting();
 		String str = scan.nextLine();
 		System.out.printf("displayText(\"%s\"): ", str);
 		displayText(str);
 		int a = scan.nextInt();
 		int b = scan.nextInt();
 		int c = scan.nextInt();
 		printTotal(a, b, c);
 		System.out.printf("getTotal(%s,%s,%s) : %s\n", a, b, c, getTotal(a,b,c));
 		System.out.printf("getAverage(%s,%s,%s) :%s\n", a, b, c, getAverage(a,b,c));
 		String s1 = scan.next();
 		String s2 = scan.next();
 		String s3 = scan.next();
 		System.out.printf("averageLength(%s,%s,%s) :%s\n", s1, s2, s3, averageLength(s1, s2, s3));
 		System.out.printf("lengthOfShortest(%s,%s) :%s\n", s1, s2, lengthOfShortest(s1, s2));
 		System.out.printf("stringOfStars(%s) :%s\n", s1, stringOfStars(s1));
 		System.out.printf("maxStringOfStars(%s,%s) :%s\n", s1, s2, maxStringOfStars(s1, s2));
 		System.out.printf("midStringOfStars(%s,%s,%s) :%s\n", s1, s2, s3, midStringOfStars(s1, s2, s3));	

    }
    
    // 1) Write (define) a static method named displayGreeting, 
    //  that takes no arguments and returns no value. 
    //  When this function is called, it should print the text "Hello, and welcome!".
    public static void displayGreeting() {
    	System.out.println("Hello, and welcome!"); //just one statement that prints "Hello, and welcome!"
    }
    
    //2) Write (define) a static method named displayText, 
    //  that takes a single String argument and returns no value. 
    //  When this function is called, it should print the value of the argument that was passed to it.
    public static void displayText(String arg) {
    	System.out.println(arg); //Just one statement that prints out the string parameter that's passed into the method
    }
    
    //3) Write (define) a static method named printTotal, 
    //  that takes three int arguments. 
    //  When this function is called, it should print the sum of the three arguments passed to it. 
    //  This function should return no value.
    public static void printTotal(int numOne, int numTwo, int numThree) {
    	System.out.println(numOne + numTwo + numThree); //Prints out the sum of the three parameters passed in by adding them together
    }
    
    //4) Write (define) a static method named getTotal, 
    //  that takes three int arguments. 
    //  When this function is called, it should return the sum 
    //  of the three arguments passed to it as an int.
    public static int getTotal(int numOne, int numTwo, int numThree) {
    	int sum = numOne + numTwo + numThree; //finds the sum of the three parameters passed in
    	return sum; //returns the sum calculated above
    }
    
    //5) Write (define) a static method named getAverage, 
    //  that takes three int arguments. 
    //  When this function is called, it should return the average 
    //  of the three arguments passed to it as a double.
    public static double getAverage(int numOne, int numTwo, int numThree) {
    	double average = ((double) numOne + numTwo + numThree) / 3; //finding the sum of the three parameters passed in and then finding the average of the three by dividing the sum by 3.
    	return average; //return the average calculated above
    }
    
    //6) Write (define) a static method named averageLength, 
    //  that takes three String arguments. 
    //  When this function is called, it should return the average length (number of characters) 
    //  of the String arguments passed to it as a double.
    public static double averageLength(String argOne, String argTwo, String argThree) {
    	double lengthOne = argOne.length(); //set variable to the string length of the first parameter
    	double lengthTwo = argTwo.length(); //set variable to the string length of the second parameter
    	double lengthThree = argThree.length(); //set variable to the string length of the third parameter
    	double averageLength = (lengthOne + lengthTwo + lengthThree) / 3; //find the sum of the three string lengths and then divide by 3 to find the average string length of all 3 of the parameters passed in.
    	String format = "#.00"; //to make sure the output only goes to .00 in the output we use decimal format
    	DecimalFormat formater = new DecimalFormat(format); //creating a DecimalFormat variable and putting in the format variable we made above
    	String result = formater.format(averageLength); // create the string result to hold the formatted averageLength
    	double answer = Double.parseDouble(result); //parseDouble the result to the variable answer in order to convert it to  double
    	return answer; //return the average length calculated above in the new format
    }
    
    
    //7) Write (define) a static method named lengthOfShortest, 
    //  that takes two String arguments. When this function is called, 
    //  it should return the length (number of characters) 
    //  of the shortest String argument passed to it as an int.
    public static int lengthOfShortest(String argOne, String argTwo) {
    	int lengthOne = argOne.length(); //set variable to the string length of the first parameter
    	int lengthTwo = argTwo.length(); //set variable to the string length of the second parameter
    	int shortest = 0; //initialize a variable to eventually be set to the lenght of the shortest string to be returned
    	if (lengthOne < lengthTwo) { //this if statement determines if the length of the first argument is shorter than the second and if so then it'll set the length of the first argument to the shortest length to be returned
    		shortest = lengthOne;
    	} else { //if the if statement above fails then we know that the second argument is shorter in length so the shortest length is set to the length of the second argument to be returned later
    		shortest = lengthTwo;
    	} 
    	return shortest; //the method returns the variable shortest which is set to the length of the shortest argument
    }
    
    //8) Write (define) a static method named stringOfStars, 
    //  that takes one String argument.
    //  When this function is called, it should return a String of asterisks (*) 
    //  that is the same length as the string argument passed to it.
    public static String stringOfStars(String arg){
    	int length = arg.length(); //the arguments length is set to the variable length
    	String output = ""; //output variable is initialized to be returned later
    	for (int i = length; i>0; i--) { //the for loop adds a "*" for each length that is in the argument passed into the method
    		output+="*";
    	}
    	return output; //the output holds the number of *'s that is equal to the length of the argument and is returned by the method
    }
    
    //9) Write (define) a static method named maxStringOfStars, 
    //  that takes two String arguments. 
    //  When this function is called, it should return a String of asterisks (*) 
    //  that is the same length as the longest string argument passed to it.
    public static String maxStringOfStars(String argOne, String argTwo) {
    	int lengthOne = argOne.length(); //set variable to the string length of the first parameter
    	int lengthTwo = argTwo.length(); //set variable to the string length of the second parameter
    	int max = 0; //variable max is initialized to eventually hold the length of the longest string
    	if (lengthOne > lengthTwo) { //if the string length of the first argument is longer than the one of the second then the length of the first is set to the max
    		max = lengthOne;
    	} else { //if the if above fails then we know that the second argument is longer so the max is set to the length of it
    		max = lengthTwo;
    	}
    	String output = ""; //output string is initialized to hold the *'s and be returned later
    	for (int i = max; i>0; i--) { //this for loop will create a string of *'s that'll be the same length as the longest String argument passed into the method
    		output+="*"; //each length adds one * to the output string
    	}
    	return output; //once the output has the *'s equal to the length of the longest string we return the String output.
    }
    
    //10) Write (define) a static method named midStringOfStars, 
    //   that takes three String arguments. 
    //   When this function is called, it should return a String of asterisks (*) 
    //   that is the same length as the string argument with the length 
    //   that would be in the middle if the lengths of the arguments were arranged in ascending order.
    public static String midStringOfStars(String argOne, String argTwo, String argThree) {
    	int lengthOne = argOne.length(); //set variable to the string length of the first parameter
    	int lengthTwo = argTwo.length(); //set variable to the string length of the second parameter
    	int lengthThree = argThree.length(); //set variable to the string length of the third parameter
    	int middleLength = 0; // variable is initialized to hold the length of the middle String
    	if ((lengthOne > lengthTwo && lengthOne < lengthThree) || (lengthOne < lengthTwo && lengthOne > lengthThree)) { //this if statement determines if the first arguments length is in the middle of the second and third argument
    		middleLength = lengthOne; // if first argument is in the middle then the length of it is set to the middle length
    	} else if ((lengthTwo > lengthOne && lengthTwo < lengthThree) || (lengthTwo < lengthOne && lengthTwo > lengthThree)) { //this if statement determines if the second arguments length is in the middle of the first and third argument
    		middleLength = lengthTwo; //if the second argument's length is in the middle of the first and third then it's length is set to the middle length
    	} else { //if neither the first or second argument are in the middle then we know the third argument's length is in the middle
    		middleLength = lengthThree; //we set the middle length to that of the third argument
    	}
    	
    	String output = ""; //initialized the variable output to hold the string of *'s equal to the middle length and return it at the end of the method
    	for (int i = middleLength; i>0; i--) { //this loop creates a string of *'s equal to the length of the argument passed into the method that is in the middle of the other two in regards to length
    		output+="*"; //add one * per string length of the middle argument
    	}
    	return output; //return the output that holds an * for each length of the middle argument
    	
    }

}
/*-------------------------------------------------------------
//AUTHOR: Hunter Kasprzyk
//FILENAME: Lab10
//SPECIFICATION: This program reads information from our lab10_student_data_txt using a BufferReader and FileReader, then it collects the information using a while loop to collect the information. Then after that we check to see if there are any duplicates in the data by outputting if two names share the same id. This program uses the class Student.java that holds getter and setter methods like last lab but now has a toString and equals method to check 3 criteria and make sure we return the correct string information when we print out the class.
//FOR: CSE 110 - Lab #10
//TIME SPENT: 3 Hours
//-----------------------------------------------------------*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lab10
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        /* Create an array of Student */
        final int NUM_STUDENTS = 10;
        Student[] gradebook = new Student[NUM_STUDENTS];

        // >>>>> YOUR CODE HERE <<<<<
        
        /* Read the input file and add new records into the Student array */

        //Instantiating a buffer reader and passing through our data from the text file lab10_students_data
        BufferedReader br = new BufferedReader(new FileReader("lab10_student_data.txt"));
        //Creating a string to hold the lines read in by the buffer reader
        String contentLine = "";
        contentLine = br.readLine();
        int lineCount = 0;
        
        //While loop for as long as there is data (not equal to null)
        while(contentLine != null) {
        	//Using .split to take input until there is a "," 
        	String[] rawInput = contentLine.split(",");
        	//This formats the data from our lab10_student_data.txt while incrementing the line count
        	gradebook[lineCount] = new Student(rawInput[0], rawInput[1], Double.parseDouble(rawInput[2])); 
        	lineCount++;
        	contentLine = br.readLine();
        }
        
        // >>>>> YOUR CODE HERE <<<<<
        //loop to print out our output
        for(int i = 0; i <gradebook.length; i++) {
        	System.out.println("Read #" + (i+1) + " : " + gradebook[i].toString());
        }
        /* Find out duplicate student records by .equals() */
        for (int i = 0; i < NUM_STUDENTS; i++)
        {
            for (int j = i + 1; j < NUM_STUDENTS; j++)
            {
                if (gradebook[i].equals(gradebook[j]))
                {
                    System.out.printf("\"%s\" and \"%s\": %s\n",
                            gradebook[i].getFullName(), gradebook[j].getFullName(), gradebook[i].getId());
                }
            }
        }
    }
}

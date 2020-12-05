
/*-------------------------------------------------------------
// AUTHOR: Hunter Kasprzyk
// FILENAME: Lab7
// SPECIFICATION: To show case my ability to use arrays, this program will take user input for the group number and grade for students and list each of their records in an order reverse to how they were inputed, then using a method it calculates the statics for each group which includes the number of students and their group average. 
// FOR: CSE 110 - Lab #7
// TIME SPENT: 2 hours
//-----------------------------------------------------------*/

import java.util.Scanner;

public class Lab7
{
    public static void main(String[] args)
    {
        /* Declare initial variables you need */
        Scanner scanner = new Scanner(System.in);

        /* Ask the user for the number of students */
        System.out.println("How many students do you have?");
        int numStudents = scanner.nextInt();

        /* Create two arrays: one for groups the other for grades */
        int[] studentGroups = new int[numStudents]; //create the student groups array the size of the number of students inputed by the user
        double[] studentGrades = new double[numStudents]; //create the student grades array the size of the number of students inputed by the user
        //here
        /* A loop to fill up the array of */
        for (int i = 0; i<numStudents; i++) { //i starts a 0 so that we can start at the first position in the index for the arrays and fill it up the end being one less than the number of students
        	System.out.println("[Group #] and [Grade] for Entry " + i); //prompts user input
        	studentGroups[i] = scanner.nextInt(); //the user inputs an integer for the group number for each entry
        	studentGrades[i] = scanner.nextDouble(); //the user inputs a double for the grade for each entry
        }

        /* Print out the content of the two arrays as a list (from the back). */
        System.out.println("\n===== List of Student Records =====");
        
        // this for loop starts at the number of students minus 1 to start at the end of the index so that we can print in reverse, it stops before 0 to get the right amount of loops for the number of groups. we subtract 1 from i each time to print the data backwards
        for (int i = numStudents - 1; i>=0; i--) {
        	//This prints out the Group # using the i variable minus 1 and the grade at the index of i.
        	System.out.printf("Group " + (studentGroups[i]) + " - " + "%.2f" + " Points\n", studentGrades[i]); // using printf we format the output of the group number and the students grades
        }

        /* Print some statistics for each group. You must use the method "printStats" */
        System.out.println("\n===== Group Statistics =====");
        for (int i = 0; i < findTotalNumOfGroups(studentGroups); i++)
        {
            printStats(studentGroups, studentGrades, i + 1);
        }

        /* Clean up */
        scanner.close();
    }

    /**
     * Print out the count and average for targetGroup.
     * 
     * @param groups      an array of all students' groups
     * @param grades      an array of all students' grades
     * @param targetGroup the target group
     */
    private static void printStats(int[] groups, double[] grades, int targetGroup)
    {
        int count = 0;
        double sum = 0;
        double average = 0;

        /* For each record in groups */
        for (int i = 0; i < groups.length; i++)
        {
            /* If we find a record matching targetGroup, update count and sum */
            if (groups[i] == targetGroup) { //if the group number matches the target groups number that we're testing then the loop will run
            	count++; //increment count to represent the number of students in the group
            	sum = sum + grades[i]; //add the students grade to the sum of scores for students in this group
            }
            
        }

        /* Update the average */
        
        average = sum / count; //average is the sum of grades in that group divided by the number of students in that group
   
        /* Output */
        System.out.printf("Group #%d has %d student(s), the average is %.2f\n", targetGroup, count, average);
    }

    /**
     * Find out the total number of groups on record. Group numbers are assumed to
     * be a cumulative sequence starting from 1, e.g., [1, 2, 3, 4, 5]. Therefore,
     * the total number of groups is simply the maximum number on a record (array)
     * of group numbers.
     * 
     * @param groups an array of group numbers
     * @return the total number of groups on the record
     */
    private static int findTotalNumOfGroups(int[] groups)
    {
        if (groups == null)
        {
            return 0;
        }

        int numGroups = 0;
        for (int i = 0; i < groups.length; i++)
        {
            if (groups[i] > numGroups)
            {
                numGroups = groups[i];
            }
        }
        return numGroups;
    }

}

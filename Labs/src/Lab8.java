/*-------------------------------------------------------------
//AUTHOR: Hunter Kasprzyk
//FILENAME: Lab8
//SPECIFICATION: This program takes the user input for a given month and year and then generates the calendar with the correct dates at the correct positions for that month having "-"'s in place for any days that don't have a date for that month. It does this utilizing given methods and a 2D array. To demonstrate my understanding of 2D arrays I will use loops to input the correct values for each position in the array and make calculations make sure these inputs are placed in the correct locations. 
//FOR: CSE 110 - Lab #8
//TIME SPENT: 2 hours
//-----------------------------------------------------------*/

import java.time.LocalDate;
import java.util.Scanner;

public class Lab8
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        /* Ask the user for month/year */
        System.out.println("Which month/year would you like to look up the calendar?\n(ex. 11 2020)");
        int month = scan.nextInt(), day = 1, year = scan.nextInt();

        int numOfDays = getNumOfDays(month, year);  // the number of days
        int firstWeekday = getFirstWeekday(month, day, year);  // the first weekday

        /* Create a 2D array with enough space for at least 30 days */
        
        String[][] calendar = new String[5][7]; //This 2D string calendar will store the strings we get from our loops and calculations below

        /* Initialize the content of calendar by "-" */
        
        for (int i = 0; i < calendar.length; i++) { //this loop fills our 2d array with dashes for each day so that we can replace the days we need to change later and if not the correct value of "-" will be there
        	for (int j = 0; j < calendar[0].length; j++) { //To go through each position in the loop this for loop checks the j position in the array as well
        		calendar[i][j] = "-"; //For the [i][j] position in the array each time this loop goes through it will set this value to a dash, which helps us later in the lab
        	}
        }
      
        /*
         * Fill in the 2D array by the calendar in November 2020 You need to align
         * weekdays with indices in your 2D array. The first index of a row of week is
         * Sunday and the last is Saturday.
         */
        
        int currentDay = 1; //create a variable to place the first day of the month at the correct position in the array and then eventually increment it to make sure the dates count up as we go through the calendar
        final int DAYSINAWEEK = 7; //instead of hard-coding a 7 into our loop I have initialized a final variable to hold the number of days in a week (7)
        for (int i = 0; i < calendar.length; i++) //Starting at index 0 the i position in the array will be incremented to go through each position in the array, using i is less than the array length to hit each index location
        	for (int j = 0; j < calendar[0].length; j++) { //Start at index0 the j position in the array will be incremented to go through each position in the array, using j is less than the column length of [i] to make sure we hit each index location in this 2d array
        		if (i == 0 && j < firstWeekday - 1) { //now to make sure we start the calendar on the right day in the first week, we make sure that if i==0 (first week) and the j value is less than the first day minus 1 (which finds the index of the first day). This ensures we start on the correct day of the first week using the user input
        			continue; //we will continue until the correct day is found and then start from there below		
        		} else if (currentDay <= numOfDays) { //now if we don't need to keep skipping days at the beginning this else if loop will run for the amount of days in the month
        			calendar[i][j] = Integer.toString(currentDay); //This takes the integer representing the day in the calendar and converts it into a string and then inputs it into the correct location in the array
        			currentDay++; //We increment currentDay to make sure the value goes up 1 for the next day as the loop continues
        		}
        	}
        
        /**
         * Print out the calendar
         */
        
        System.out.println();
        System.out.printf("     The Calendar for %2d/%4d\n", month, year);
        System.out.printf("-----------------------------\n");
        System.out.printf("  Su  Mo  Tu  We  Th  Fr  Sa\n");
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                System.out.printf("%4s", calendar[i][j]);
            }
            System.out.println();
        }

        scan.close();
    }

    /**
     * Get the weekday of a given date. This method follow the convention in the US
     * where the week begins with Sunday.
     * 
     * @param date
     * @return the weekday of date in integer (1 is Sunday, 7 is Saturday)
     */
    private static int getFirstWeekday(int month, int day, int year)
    {
        LocalDate date = LocalDate.of(year, month, day); // ISO
        int val = date.getDayOfWeek().getValue() + 1;
        return val == 8 ? val - 7 : val;
    }

    /**
     * Get the length of a given month in year.
     * 
     * @param month
     * @param year
     * @return the length of month in year
     */
    private static int getNumOfDays(int month, int year)
    {
        return LocalDate.of(year, month, 1).lengthOfMonth();
    }
}

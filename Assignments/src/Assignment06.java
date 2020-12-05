// CSE 110     : 1096 / Wednesday 10:45am-11:45am
// Assignment  : Assignment06
// Author      : Hunter Kasprzyk #1218558263
// Description : This program has created 10 methods that all have their own manipulations or processes on inputed arrays. This ranges from simply printing out an array to inputing a certain value into a certain index of an array to calculating if an array has values that are ascending in value and outputting a true or false statement. I have completed this assignment to show case my understanding of arrays, 2D arrays, and the mechanics of each of them while also showing my ability to critically think and solve the problems I had faced.
import java.util.*;
public class Assignment06 {

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
 		int arrSize = scan.nextInt();
 		int[] arr = new int[arrSize];
 		for(int i = 0; i < arrSize; i++)
 			arr[i] = scan.nextInt();
 		int[] arrCopy = Arrays.copyOf(arr, arrSize);
 		String sep = scan.next();
 		int idx1 = scan.nextInt(), idx2 = scan.nextInt();
 		
 		//Method 1
 		System.out.printf("printArray(%s,\"%s\"): ", Arrays.toString(arr), sep);printArray(arr, sep);
 		
 		//Method 2
 		System.out.printf("getFirst(%s): %d\n", Arrays.toString(arr), getFirst(arr));
 		
 		//Method 3
 		System.out.printf("getLast(%s): %d\n", Arrays.toString(arr), getLast(arr));
        
 		//Method 4
 		System.out.printf("getAllButFirst(%s): %s\n", Arrays.toString(arr), Arrays.toString(getAllButFirst(arr)));
 		
 		//Method 5
 		System.out.printf("getIndexOfMin(%s): %d\n", Arrays.toString(arr), getIndexOfMin(arr));
 		
 		//Method 6
 		System.out.printf("getIndexOfMax(%s): %d\n", Arrays.toString(arr), getIndexOfMax(arr));
 		
 		//Method 7
 		arr = swapByIndex(arr, idx1, idx2);System.out.printf("swapByIndex(%s, %d, %d): %s\n", Arrays.toString(arrCopy), idx1, idx2, Arrays.toString(arr));
 		
 		//Method 8
 		System.out.printf("removeAtIndex(%s, %d): %s\n", Arrays.toString(arr), idx1, Arrays.toString(removeAtIndex(arr, idx1)));
 		
 		//Method 9
 		System.out.printf("insertAtIndex(%s, %d, 100): %s\n", Arrays.toString(arr), idx2, Arrays.toString(insertAtIndex(arr, idx2, 100)));
 		
 		
 		//Method 10
 		System.out.printf("isSorted(%s): %s\n", Arrays.toString(arr), isSorted(arr));
 		
 		
    }
    
    // 1) Write a public static method named printArray, 
    //   that takes two arguments. The first argument is an Array of int 
    //   and the second argument is a String. The method should print out 
    //   a list of the values in the array, each separated by the value of the second argument.
    public static void printArray(int [] a, String b) {
    	for(int i = 0; i < a.length; i++) { //Loops through each value in the array
    		System.out.print(a[i]); //Printing out each value in the array
    		if (i < a.length - 1) { //Loop that prints out the b value in-between each value of the array
    			System.out.print(b);
    		}
    	}
    	System.out.println(); //Printing line at the end
    }
    
    // 2) Write a public static method named getFirst, 
    //    that takes an Array of int as an argument and returns 
    //    the value of the first element of the array.
    
    public static int getFirst(int[] a) {
    	int first = a[0];
    	return first;
    }
    // 3) Write a public static method named getLast, 
    //    that takes an Array of int as an argument and returns 
    //    the value of the last element of the array.
    public static int getLast(int[] a) {
    	int last = a[a.length-1];
    	return last;
    }
    
    // 4) Write a public static method named getAllButFirst, 
    //    that takes an Array of int as an argument and creates and returns 
    //    a new array with all of the values in the argument array except the first value.
    public static int[] getAllButFirst(int[] a) {
    	int[] allButFirst = new int[a.length - 1];
    	for (int i = 1; i < a.length; i++){
    		allButFirst[i-1] = a[i];
    	}
    	return allButFirst;
    }
    
    // 5) Write a public static method named getIndexOfMin, 
    //    that takes an Array of int as an argument and returns 
    //    the index of the least value in the array.
    public static int getIndexOfMin(int[] a) {
    	int minIndex = 0;
    	int minOfIndex = a[0];
    	for (int i = 0; i<a.length; i++) {
    		if (a[i] < minOfIndex) {
    			minOfIndex = a[i];
    			minIndex = i;
    		}
    	}
    	return minIndex;
    }
    
    // 6) Write a public static method named getIndexOfMax, 
    //    that takes an Array of int as an argument and returns 
    //    the index of the largest value in the array.
    public static int getIndexOfMax(int[] a) {
    	int maxIndex = 0;
    	int maxOfIndex = a[0];
    	for (int i = 0; i<a.length; i++) {
    		if (a[i] > maxOfIndex) {
    			maxOfIndex = a[i];
    			maxIndex = i;
    		}
    	}
    	return maxIndex;
    }
    
    
    // 7) Write a public static method named swapByIndex, 
    //    that takes three arguments. The first argument is an Array of int, 
    //    and the second and third arguments are int indexes. 
    //    This method will swap the values at the two given index arguments 
    //    in the array, and return a reference to the array.
    public static int[] swapByIndex(int[] a, int first, int second) {
    	int temp = a[first];
    	a[first] = a[second];
    	a[second] = temp;
    	return a;
    }
    
    //8) Write a public static method named removeAtIndex, 
    //  that takes two arguments. The first argument is an Array of int, 
    //  and the second argument is an int index. This method create and return 
    //  a new array with all of the values in the argument array 
    //  except the value at the argument index.
    public static int[] removeAtIndex(int[] a, int removeIndex) {
    	for(int i = removeIndex; i<a.length-1; i++) {
    		a[i] = a[i+1];
    	}
    	return a;
    }
    
    //9) Write a public static method named insertAtIndex, 
    //   that takes three arguments. The first argument is an Array of int, 
    //   the second argument is an int index, and the third argument is an int value. 
    //   This method create and return a new array with all of the values 
    //   in the argument array and including the third argument value 
    //   inserted at the index specified by the second argument value.
    
    public static int[] insertAtIndex(int[] a, int index, int value) {
    	int[] newInt = new int[a.length + 1];
    	for(int i = 0; i<a.length; i++) {
    			newInt[i] = a[i];
    	}
    	for(int j = index; j<newInt.length-1; j++) {
    		newInt[j + 1] = a[j];
    	}
    	int temp = a[index];
    	newInt[index] = value;
    	return newInt;
    }
    
    //10) Write a public static method named isSorted, 
    //    that takes an Array of int as an argument. 
    //    This method should return the boolean value true 
    //    if all the element values in the array are in ascending order; 
    //    otherwise the method should return the boolean value false.
    public static boolean isSorted(int[] a) {
    	boolean isAscending = true;
    	for(int i = 0; i < a.length-1; i++) {
    		if (a[i] > a[i+1]) {
    			isAscending = false;
    		}
    	}
    	return isAscending;
    }

}

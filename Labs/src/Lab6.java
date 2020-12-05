
/*-------------------------------------------------------------
//AUTHOR: Hunter Kasprzyk
//FILENAME: Lab6
//SPECIFICATION: This program uses methods to save lines of code when taking the user input for the retail price of their laptop, phone, and backpack. To do this it will use the method readRetailPrice to verify that the input is positive and loop through until the user does so, after this it will set that value to the retail price for that specific variable. From here the addTax methods will be used to calculate the price after tax for the inputed values in Arizona and a given state. After the after tax prices are calculated the program will compare the two and let the user know if they saved and if so how much they saved.
//FOR: CSE 110 - Lab #6
//TIME SPENT: 3 hours
//-----------------------------------------------------------*/
import java.util.Scanner;

public class Lab6
{
    public static void main(String[] args)
    {
        /* Some variables */
        Scanner scan = new Scanner(System.in);

        /* Get the retail price of something */
        double rpLaptop = -1;
        double rpPhone = -1;
        double rpBackpack = -1;
        
        // Here the retail price of the laptop, phone, and backpack are found by using the readRetailPrice method that will verify that the number is positive, if the user inputs something negative or zero it will notify them of the error and they will have to input another value. Once the user inputs a positive number for each of these variables the program can move onto the next step.
        // By using the strings "laptop", "mobile phone", and "backpack" the same method can be used for all 3 of these variables, then by having scan as a parameter we can use a scanner in the method saving us some extra code.
        rpLaptop = readRetailPrice("laptop", scan);
        rpPhone = readRetailPrice("mobile phone", scan);
        rpBackpack = readRetailPrice("backpack", scan);
        
        /* Compute after-tax prices in one state with those in AZ */
        System.out.println("Enter one state you'd like to compare after-tax prices: ");
        String targetState = scan.next();
        double targetStateTax = getSalesTaxRate(targetState);

        /* Compute the after-tax prices */
        double afterTaxAZ = addTax(rpLaptop) + addTax(rpPhone) + addTax(rpBackpack);
        double afterTaxTarget = addTax(rpLaptop, targetStateTax) + addTax(rpPhone, targetStateTax)
                + addTax(rpBackpack, targetStateTax);
        double diff = afterTaxAZ - afterTaxTarget;

        /* Show the total after-tax prices of your stuff in AZ and the target state */
        System.out.println();
        System.out.printf("The total after-tax price in AZ: %.2f\n", afterTaxAZ);
        System.out.printf("The total after-tax price in %s: %.2f\n", targetState, afterTaxTarget);

        /* Show whether you have a chance to save */
        if (diff > 0)
        {
            System.out.printf("You may save %.2f for those stuff in %s.\n", diff, targetState);
        }

        scan.close();
    }

    /**
     * Prompts and asks the user for the price of something. The price must be
     * non-negative.
     * 
     * @param name the name of something
     * @param scan a Scanner object
     * @return the price user inputs
     */
    private static double readRetailPrice(String name, Scanner scan)
    {
        // first the method readRetailPrice uses a while loop to check if the input is positive, if the input is positive then the price will be set to that value and if not then the user will be notified that there is an error and that they need to input a positive value. This was loop until a positive value is inputed.
        //Initialize variables isNegative and price
    	boolean isNegative = true;
        double price = 0;
        while (isNegative) { //while the number is negative the user will continue to be prompted for another input so that they can eventually input a positive value 
        	System.out.println("What's the retail price of your " + name);
            price = scan.nextDouble();
        
    	if (price <= 0) { //if the price is not positive then they will be given the error and told to once again input a value
        	System.out.println("[ERR] a price must be non-negative. Please type it again.");
        } else { //if the price is positive then the isNegative boolean will be set to false exiting the while loop and continuing to the next step of the program.
        	isNegative = false;
        }
        }	
        
        return price; //Once a positive working value is inputed the method will return that price
    }

    /**
     * Add the sales tax of AZ to a price and return the result.
     * 
     * @param price
     * @return the after-tax price
     */
    private static double addTax(double price) //The method addTax with 1 parameter will find the price with Arizona tax factored in
    {
        final double AZTAX = 8.40; //the Arizona sales tax is set to a constant
        price = price + (price * (AZTAX/100)); //the price after tax will be the initial price plus the tax found by taking the AZTAX divided by 100
        return price; // The method addTax will return the price after Arizona tax is added
    }

    /**
     * Add a sales tax to a price and return the result.
     * 
     * @param price
     * @param rate  sales tax in percent
     * @return the after-tax price
     */
    private static double addTax(double price, double rate) // The method addTax with 2 parameters will find the price with the given states tax rate factored into the price.
    {
        price = price + (price * (rate/100)); //The price after tax is found by taking the initial price and adding the price multiplied by the given state tax rate divided by 100
        return price; //Returns the price with the given states tax rate factored in.
    }

    /**
     * Get the sales tax for a given state.
     * 
     * @param state an abbreviation of a state in the US
     * @return the sales tax in percent
     */
    private static double getSalesTaxRate(String state)
    {
        double SALES_TAX_AZ = 8.40;
        double SALES_TAX_CA = 8.66;
        double SALES_TAX_NV = 8.32;
        double SALES_TAX_UT = 7.18;
        double SALES_TAX_CO = 7.65;
        double SALES_TAX_NM = 7.82;
        double SALES_TAX_OR = 0.00;

        double rt = 0;
        switch (state)
        {
        case "AZ":
            rt = SALES_TAX_AZ;
            break;
        case "CA":
            rt = SALES_TAX_CA;
            break;
        case "NV":
            rt = SALES_TAX_NV;
            break;
        case "UT":
            rt = SALES_TAX_UT;
            break;
        case "CO":
            rt = SALES_TAX_CO;
            break;
        case "NM":
            rt = SALES_TAX_NM;
            break;
        case "OR":
            rt = SALES_TAX_OR;
            break;
        default:
            System.out.println("[WARN] The current database does not have sales tax info for " + state + ". Set to 0");
        }

        return rt;
    }
}
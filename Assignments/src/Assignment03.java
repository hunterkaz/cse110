// CSE 110    : 1096 / Wednesday 10:45am-11:45am
//Assignment  : Assignment03
//Author      : Hunter Kasprzyk #1218558263
// Description : This program evaluates whether a someone should sell, buy, or hold stocks based upon their number of shares, purchase price, the market price, and their available funds. After receiving this data the program calculate if they will make a profit by buying/selling stocks as well as the amount they should sell/purchase. If neither of these are possible it will tell them to hold their stocks. 
import java.util.*; //import to enable the user of the Scanner we need
public class Assignment03 {

    public static void main(String[] args) {
        // declare and instantiate a Scanner
    	Scanner in = new Scanner(System.in);
        
        // declare and initialize variables
    	int numShares = 0; // - This is the number of shares of this stock currently held in the account
    	int purchasePrice = 0; //- (per share) paid for current stock in the account
    	int marketPrice = 0; // - (per share) of this stock. This is the current market price for buying or selling this stock
    	int availableFunds = 0; //- the amount the client is willing to spend on a transaction
        int totalBuyCost = 0;
        int transactionFee = 10; //$10 per transaction
        int numOfSharesToBuy = 0;
        int perShareBuyValue = 0;
        int totalBuyValue = 0;
        int perShareSellValue  = 0;
        int totalSellValue = 0;
      
        // prompt for and collect inputs
        // Receiving user input and directing it to the proper variables
    	System.out.println("Current Shares  : ");
        numShares = in.nextInt();
        System.out.println("Purchase Price  : ");
        purchasePrice = in.nextInt();
        System.out.println("Market Price    : ");
        marketPrice = in.nextInt();
        System.out.println("Available Funds : ");
        availableFunds = in.nextInt();
        
        // compute required values
        numOfSharesToBuy = (availableFunds - transactionFee) / marketPrice; //calculating the # of stocks that the user should by if it's profitable, taking the funds subtracted by the fee and dividing it by the cost of the stock
        totalBuyCost = 10 + marketPrice * numOfSharesToBuy; //calculating the total buy cost by adding the fee of $10 to the market price and then multiplying this by the number of stocks
        perShareBuyValue = purchasePrice - marketPrice; //calculating the buy value of each share by taking the purchase price and subtracting the price of the stock on the market
        totalBuyValue = perShareBuyValue * numOfSharesToBuy; //calculating the total buy value by taking the buy value of each share calculated above and multiplying it by the number of shares that they will be buying
        perShareSellValue = marketPrice - purchasePrice; //calculating the profit per share sold by taking the market price they will sell it at and subtracting the initial price that was paid
        totalSellValue = perShareSellValue * numShares; //calculating the total sell value by taking the profit per share and multiplying it by the number of shares that will be sold
        
        // display required outputs
        //if the market price is greater than the purchase price and the available funds will account for the $10 fee then we can move onto determining if if the profit made by selling is greater than the transaction fee and if these all check out the program tells the user the amount of stocks they should buy
        
        if (marketPrice < purchasePrice && availableFunds > 10) {
        	if (totalBuyValue > transactionFee) {
        		System.out.println("Buy " + numOfSharesToBuy + " shares");
        	}
        
        // if the market price is greater than the original purchase price and the profit made by selling is greater than the $10 transaction fee then the program tells the user how many stocks to sell
        } else if (marketPrice > purchasePrice && totalSellValue > 10) {
        	System.out.println("Sell " + numShares + " shares");
        //if neither purchasing or selling stocks proves profitable then the program will tell the user to just hold their shares
        } else {
        	System.out.println("Hold shares");
        }

    }
}

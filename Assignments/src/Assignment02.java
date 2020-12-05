// CSE 110    : 1096 / Wednesday 10:45am-11:45am
//Assignment  : Assignment02
//Author      : Hunter Kasprzyk #1218558263
//Description : This program takes the user input of the length of the road in miles, number of lanes, depth of asphalt (inches), and days to complete the project and calculates the amount of materials (truck loads of asphalt, stop lights, conduit pipes, and crew members) as well as the costs for each one of them. Then finally it determines the total cost of the project


import java.util.*;

public class Assignment02 {

		public static void main(String[] args) {
			//declare and instantiate a Scanner
			Scanner in = new Scanner(System.in);
			
			//declare and initialize variable and collect inputs
			System.out.println("Length of road project (miles) : ");
			double lengthOfRoadProject = in.nextDouble();
			System.out.println("Number of lanes                : ");
			int numOfLanes = in.nextInt();
			System.out.println("Depth of asphalt (inches)      : ");
			int depthOfAsphalt = in.nextInt();
			System.out.println("Days to complete project       : ");
			int daysToComplete = in.nextInt();
			
			//compute required values
			int truckloadsOfAsphalt = (int) Math.ceil(((lengthOfRoadProject*5280)*(numOfLanes*12)*((double) depthOfAsphalt/12)*150)/10000); //calculates the cubic feet of the project with the length of the road converted to feet multiplied by the width in feet by multiplying the number of lanes by their width in feet, and then finally the depth by converting the Asphalt depth from inches to feet. Then once the cubic feet are calculated it's multiplied by 150 to convert it to pounds and then divided by 2000 to convert to tons. Then this is rounded up to find the trucks. 
			int numOfIntersections = (int) (lengthOfRoadProject); //1 intersection per mile, casted as an int so that the decimals are cut off
			int numOfStoplights = (int) (numOfIntersections*2) + (int) (numOfIntersections * numOfLanes); //2 stop lights per intersection and then add the additional stop lights per each intersection lane.
			int numOfPipes = (int) (lengthOfRoadProject * 5280) / 24; //convert the miles to feet and then divide by the 24 feet increments that the pipes come in, rounding up to make sure there is enough.
			int crewMembers = (int) Math.round((50 * (lengthOfRoadProject) * numOfLanes) / daysToComplete); // Each crew member follows the equation of 50 multiplied by (the length of the road multiplied by the number of lanes) divided by the days left to complete.
		
			double costOfAsphalt = truckloadsOfAsphalt * 5 * 200; // the number of truck loads of asphalt times 5 because each can hold 5 tons and then multiplied by 200 because it's $200 per ton
			double costOfStoplights = numOfStoplights * 25000; // each stop light is $25000, multiply the number of stop lights by 25000.
			double costOfPipes = Math.ceil(numOfPipes) * 500; // multiply the rounded up number of pipes by 500 because they're $500 making sure there are enough.
			double costOfLabor = daysToComplete * 8 * 25 * crewMembers; // Labor costs $25 per hour and they work 8 hours per day and so multiply this by the crew members as well as the number of days.
			double totalCost = costOfAsphalt + costOfStoplights + costOfPipes + costOfLabor; // Total cost is adding all the costs of Asphalt, Stop lights, Pipes, and Labor.
			//display results using spaces and printf to make good use of whitespace.
			System.out.println("=== Amount of materials needed ===");
			System.out.println("Truckloads of Asphalt : " + truckloadsOfAsphalt);
			System.out.println("Stoplights            : " + numOfStoplights);
			System.out.println("Conduit pipes         : " + numOfPipes);
			System.out.println("Crew members needed   : " + crewMembers);
			System.out.println("=== Cost of Materials ============");
			System.out.printf("Cost of Asphalt       : $%.2f\n", costOfAsphalt);
			System.out.printf("Cost of Stoplights    : $%.2f\n", costOfStoplights);
			System.out.printf("Cost of Conduit pipes : $%.2f\n", costOfPipes);
			System.out.printf("Cost of Labor         : $%.2f\n", costOfLabor);
			System.out.println("=== Total Cost of Project ========");
			System.out.printf("Total cost of project : $%.2f\n", totalCost);
		}
}

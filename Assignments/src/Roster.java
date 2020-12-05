import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// CSE 110     : 1096 / Wednesday 10:45am-11:45am
// Assignment  : Assignment08
// Author      : Hunter Kasprzyk #1218558263
// Description : This class works with the ArrayList players of type player using a default constructor and an overloaded constructor that will pass in a data file and using a buffer reader and file reader, pass this information about the players name, attack stats, and blocking stats. This class also contains methods that satisfying all the actions that were created in the assignment08 menu. This is adding players, printing out the top 2 attacks/defenders, printing out the players information, the player count, and getting the players names.

public class Roster {
	
	//initialize our private instance variable
	private ArrayList <Player> players;
	
	//default constructor
	public Roster() {
		//instantiate a new ArrayList object as player
		players = new ArrayList <Player>();
	}
	//overloaded construct with one String argument
	public Roster(String rosterFile) throws IOException {
		//instantiate a new ArrayList object as player
		players = new ArrayList <Player>();
		// Opening the roster file
		BufferedReader reader = new BufferedReader(new FileReader(rosterFile));
		String nextLine;
		
		//Populate player by the content from the file called filename
		while ((nextLine = reader.readLine()) != null){
			//Split the input into tokens
			String[] tokens = nextLine.split(" ");
			String playerName = tokens[0] + " " + tokens[1];
			double attackStat = Double.parseDouble(tokens[2]);
			double blockStat = Double.parseDouble(tokens[3]);
			
			//plug in name, attackStat and blockStat into addPlayer
			addPlayer(playerName, attackStat, blockStat);
			
		}
		
		//close file reader
		reader.close();
		
	}
	
	//method to add a new player an their stats into the roster's ArrayList<Player> object
	public void addPlayer (String name, double attackStat, double blockStat) {
		
		//Create a new player object by the arguments
		Player newone = new Player(name, attackStat, blockStat);
		//add the new player to the ArrayList players
		players.add(newone);
	}
	
	//method to return the number of players stored in the roster's ArrayList<Player> object
	public int countPlayers() {
		return players.size();
	}
	
	//method to search if the name passed in the argument is found in the roster's ArrayList<Player>, if found it returns the reference if not it returns null
	public Player getPlayerByName(String playerName) {
		
		//This loop iteratures through the player object and if the players name equals the name passed into the method it returns the reference and if it's not found it returns null
		for (int i = 0; i <players.size(); i++) {
			if (players.get(i).getName().equals(playerName)) {
				return players.get(i);
			}
		}
		return null;
	}
	
	//method to print out the top 2 players with the best attack stats
	public void printTopAttackers() {
		
		//This loop iterates through the players object and finds the players with the highest attack stats, it then prints out these two players
		Player topAttacker = players.get(0);
		Player secondAttacker = players.get(1);
		for (int i = 0; i<players.size(); i++) {
			if (players.get(i).getAttackStat() > topAttacker.getAttackStat()) {
				Player temp = topAttacker;
				secondAttacker = temp;
				topAttacker = players.get(i);
			} else if (players.get(i).getAttackStat() > secondAttacker.getAttackStat()) {
				secondAttacker = players.get(i);
			}
		}
		topAttacker.printPlayerInfo();
		secondAttacker.printPlayerInfo();
		
	}
	
	//method to print out the top 2 players with the best blocking stats
	public void printTopBlockers() {
		
		//This loop iterates through the players object and finds the players with the highest block stats, it then prints out these two players
		Player topBlocker = players.get(0);
		Player secondBlocker = players.get(1);
		for (int i = 2; i<players.size(); i++) {
			if (players.get(i).getBlockStat() > topBlocker.getBlockStat()) {
				Player temp = topBlocker;
				secondBlocker = temp;
				topBlocker = players.get(i);
			} else if (players.get(i).getBlockStat() > secondBlocker.getBlockStat()) {
				secondBlocker = players.get(i);
			}
		}
		topBlocker.printPlayerInfo();
		secondBlocker.printPlayerInfo();
	}
	
	//method to print out all the players names
	public void printAllPlayers() {
		
		//This loop iterates through the player object and prints each players info
		for (int i = 0; i<players.size(); i++) {
			players.get(i).printPlayerInfo();
		}
	}
	
}

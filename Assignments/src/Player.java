import java.text.DecimalFormat;

// CSE 110     : 1096 / Wednesday 10:45am-11:45am
// Assignment  : Assignment08
// Author      : Hunter Kasprzyk #1218558263
// Description : This program consists of methods that are getters and setters for attack and block stats for players. Also a constructor that will set the passed in arguments to the private instance variables in the class. This class also has a method printPlayerInfo that will return the information about the Player's name, attack stats, and block stats.

public class Player {
	
	//initialize our private instance variables for name, attackStat, and blockStat
	private String name = "";
	private double attackStat = 0;
	private double blockStat = 0;
	
	//Player constructor that takes arguments and sets them equal to the instance variables
	public Player (String name, double attackStat, double blockStat) {
		this.name = name;
		this.attackStat = attackStat;
		this.blockStat = blockStat;
	}
	
	//getter method for name
	public String getName() {
		return name;
	}
	
	//getter method for attackStat
	public double getAttackStat() {
		return attackStat;
	}
	
	//setter method for attackStat
	public void setAttackStat (double attack) {
		attackStat = attack;
	}
	
	//getter method for blockStat
	public double getBlockStat() {
		return blockStat;
	}
	
	//setter method for blockStat
	public void setBlockStat (double block) {
		blockStat = block;
	}
	
	//method that prints the players information
	public void printPlayerInfo() {
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println(name + " (attack = " + df.format(attackStat) + ", block = " + df.format(blockStat) + ")");
	}
}

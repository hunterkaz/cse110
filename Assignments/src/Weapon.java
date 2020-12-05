// CSE 110     : 1096 / Wednesday 10:45am-11:45am
// Assignment  : Assignment07
// Author      : Hunter Kasprzyk #1218558263
// Description : This class deals with the Weapon in the monster fight using getters and setters to make sure the user input that is passed through goes to the correct spots. Also containing a default constructor and an overloaded constructor for when the user passes in arguments

class Weapon {
	//initialize private instance variables
	private String name; 
	private int maxDamage;
	
	//default constructor initializing the Weapon object with the name "Pointy Stick" and maxDamage to 1.
	public Weapon () {
		name = "Pointy Stick";
		maxDamage = 1;
	}
	//Overloaded constructor initializing the name and maxDamage with the arguments passed in
	public Weapon (String inputedName, int inputedDamage) {
		name = inputedName;
		maxDamage = inputedDamage;
	}
	//Method to return the String name
	public String getName () {
		return name;
	}
	//Method to set the String name to the passed argument
	public void setName (String inputedName) {
		name = inputedName;
	}
	//Method to return the int maxDamage
	public int getMaxDamage () {
		return maxDamage;
	}
	//Method to set the int maxDamage to the passed argument
	public void setMaxDamage (int inputedDamage) {
		maxDamage = inputedDamage;
	}
}

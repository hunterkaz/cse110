// CSE 110     : 1096 / Wednesday 10:45am-11:45am
// Assignment  : Assignment07
// Author      : Hunter Kasprzyk #1218558263
// Description : This class has a constructor that passes the arguments and initializes them to the instance variables, from there it has methods that will return each of these variables as well as attack method that calculates the damage randomly while still making sure it is below or equal to the max damage allowed, subtracts that from the health, and returns the amount of damage dealt.

class Monster {
	//initialize private instance variables
	private String name;
	private int healthScore;
	private Weapon weapon;
	
	//Constructor that initializes the arguments passed into the method with the instance variables in the Monster class
	public Monster (String inputedName, int inputedHealthScore, Weapon inputedWeapon) { 
		name = inputedName; //??? this.
		healthScore = inputedHealthScore;
		weapon = inputedWeapon;
	}
	//This method returns the String name
	public String getName () {
		return name;
	}
	//This method returns the int healthScore
	public int getHealthScore () {
		return healthScore;
	}
	//This method returns a String containing the weapon name from the Weapon passed into the constructor
	public String getWeaponName () {
		return weapon.getName(); 
	}
	//This method picks a random int between 0 and this Monster's Weapon's maxDamage, subtracts this amount from this Monster's healthScore and then returns the damage inflicted
	public int attack (Monster inputedMonster) {
		double doubleDamage = Math.random() * weapon.getMaxDamage(); 
		int damage = (int) doubleDamage;
		healthScore = healthScore - damage;
		return damage;
	}
}

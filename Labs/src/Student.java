
public class Student {
	
	//Declare our variables according to the table given in the Lab guide to be used in the methods
	private String fullName; //represents the full name of the student
	private String id; //represents the id number of the student
	private double grade; //represents the grade of the student
	
	//This constructor passes three parameters in and sets them equal to the Student.java variables
	public Student (String fullName, String id, double grade) {
		this.fullName = fullName;
		this.id = id;
		this.grade = grade;
	}
	
	//Our .equals method that returns a boolean based off of the 3 conditions
	public boolean equals(Object obj) {
		Student other = (Student) obj;
		
		//1st condition, if the object is null then we return false
		if (obj == null) {
			return false;
		}
		//2nd condition, if the obj is not of the same class as Student, return false
		if ( obj.getClass() != this.getClass() ) { //help how do I compare the classes
			return false;
		} 
		
		//3rd condition, if the id of the obj matches the id of this class, return true
		if (other.getId().equals(this.getId())) {
			return true;
		}
		//if none of these conditions check out, return false
		return false;
	}
	
	//Our toString() method that returns the string of fullName and id
	public String toString() {
		return fullName + "\t" + id;
	}
	
	//This method increments the numAccessed as well as returns the String fullName
	public String getFullName() {
		//numAccessed++;
		return fullName;
	}
	//This method increments the numAccessed as well as returns the String id
	public String getId() {
		//numAccessed++;
		return id;
	}
	//This method increments the numAccessed as well as returns the String grade
	public double getGrade() {
		//numAccessed++;
		return grade;
	}
	//This method increments the numUpdated as well as updates the String fullName to the parameter name inserted into the method
	public void setFullName(String name) {
		//numUpdated++;
		fullName = name;
	}
	//This method increments the numUpdated as well as updates the String id to the parameter asuID inserted into the method
	public void setId(String asuId) {
		//numUpdated++;
		id = asuId;
	}
	//This method increments the numUpdated as well as updates the String grade to the parameter asuGrade inserted into the method
	public void setGrade(double asuGrade) {
		//numUpdated++;
		grade = asuGrade;
	}
}

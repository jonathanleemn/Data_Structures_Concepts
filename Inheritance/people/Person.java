package people;

import java.util.Scanner;

public class Person {
	private String firstName, lastName;
	

	private int ageYears, weightPounds, heightInches;
	private boolean isSleeping, isAlive;
	
	public Person(String fName, String lName, int weightLbs, int heightIn, int ageYears){
		this.setValues(fName, lName, weightLbs, heightIn, ageYears);
		isAlive=true;
		isSleeping=false;
	}
	
	public Person(){
		this.setValues();
		isAlive=true;
		isSleeping=false;
	}
	
	//kill person will set isAlive to false
	public void killPerson(){
		this.isAlive=false;	
	}
	
	//goToSleep() will set is awake to false
	public void goToSleep(){
		this.isSleeping=true;
	}
	//wakeUp() will set isAwake to true
	public void wakeUp(){
		this.isSleeping=false;
	}
	
	public String toString(){
		return "First Name: "+firstName+"\n"+
			"last Name: "+lastName+"\n"+
			"Age: "+ageYears+"\n"+
			"Weight: "+weightPounds+"\n"+
			"Height: "+heightInches+"\n"+
			"isAlive: "+ isAlive;
		
	}
	
	//Setters and getters========================================================================================
	public void setValues(String fName, String lName, int weightLbs, int heightIn, int ageYears){
				this.setFirstName(fName);
				this.setLastName(lName);
				this.setWeightPounds(weightLbs);
				this.setHeightInches(heightIn);
				this.setAgeYears(ageYears);
	}
	
	public void setValues(){
		Scanner scan=new Scanner(System.in);
		System.out.printf("%s inputs:\n", this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.')+1));
		System.out.println("==============================");
		System.out.println("Please enter your first name:");
		setFirstName(scan.next());
		System.out.println("Please enter your last name:");
		setLastName(scan.next());
		System.out.println("Please enter your height in inches:");
		setHeightInches(scan.nextInt());
		System.out.println("Please enter your weight in pounds:");
		setWeightPounds(scan.nextInt());
		System.out.println("Please enter your age in years:");
		setAgeYears(scan.nextInt());
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName==null)
			throw new IllegalArgumentException("You must provide a valid String for first name.");
		else
			this.firstName=firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName==null)
			throw new IllegalArgumentException("You must provide a valid String for last name.");
		else
			this.lastName=lastName;
	}
	
	
	public int getAgeYears() {
		return ageYears;
	}

	public void setAgeYears(int ageYears) {
		if(ageYears<0)
			throw new IllegalArgumentException("You must provide a positive integer value for age in years.");
		else if(ageYears>130)
			throw new IllegalArgumentException("Come now. Do you really expect me to believe that you are older than 130?");
		else
			this.ageYears=ageYears;
	}
	

	public int getWeightPounds() {
		return weightPounds;
	}

	public void setWeightPounds(int weightPounds) {
		if(weightPounds<0)
			throw new IllegalArgumentException("You must provide a positive integer value for weight.");
		else 
			this.weightPounds=weightPounds;
	}

	public int getHeightInches() {
		return heightInches;
	}

	public void setHeightInches(int heightInches) {
		this.heightInches = heightInches;
	}

	public boolean isSleeping() {
		return isSleeping;
	}

	public void setSleeping(boolean isSleeping) {
		this.isSleeping = isSleeping;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	

}

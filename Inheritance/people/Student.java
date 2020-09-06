package people;

import java.util.Scanner;

public class Student extends Person{
	
	private int studentId;	
	private double gpa;
	private String emailAddress;
	
	//constructors
	public Student(){
		super();
		setValues();
	}
	public Student(String fName, String lName, int weightLbs, int heightIn, int ageYears){
		super(fName, lName, weightLbs, heightIn, ageYears);
				setValues();//java knows to call the no parameter setValues() method.
	}
	
	public void setValues(int id, double gpa, String email){
		this.setGpa(gpa);
		this.setEmailAddress(email);
		this.setStudentId(id);
	}
	
	//this overrides the method from Person
	@Override
	public void setValues(){
		Scanner scan=new Scanner(System.in);
		System.out.printf("%s inputs:\n", this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.')+1));
		System.out.println("==============================");
		System.out.println("Student ID:");
		setStudentId(scan.nextInt());
		System.out.println("Please enter your GPA:");
		setGpa(scan.nextDouble());
		System.out.println("Please enter your email address:");
		setEmailAddress(scan.next());		
	}
	
	//we have access to all of the parents public data fields and methods
	public void changeLastName(String newLName){
		//super.lastName=newLName;//lastName is not available to us.  It is private
		super.setLastName(newLName);
		setLastName(newLName);//the call to super is implicit, the compiler will do it even if we don't specify
	}
	
	
	public String toString(){
		return super.toString()+"\n"+" Email: "+emailAddress+"\n"+" GPA: "+ gpa+ "\n"+" Student ID: "+studentId;//call to super toString will return the data from Person.
		}
	
	//getters and setters======================================================================
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}

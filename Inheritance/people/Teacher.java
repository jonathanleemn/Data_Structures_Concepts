package people;

import java.util.Scanner;

public class Teacher extends Person{
	private boolean isFullTime;
	private int employeeId;
	private double salary;
	
	public Teacher(String fName, String lName, int weightLbs, int heightIn, int ageYears){
		super(fName, lName, weightLbs, heightIn, ageYears);
		setValues();
	}
	public Teacher(){
		/*if there is not explicit call to the super constructor, 
		 * then an implicit call is made before anything executes in this constructor*/
		//super();//this will call setValues()  but which one gets called?
		super.setValues();//this will call setValues(), but which one?
		//setValues();//this will call setValues, but which one?
	} 
	
	@Override
	public void setValues(){		
		Scanner scan=new Scanner(System.in);
		//this long series of method calls will get the fully qualified name for the class and then trim off the package name
		System.out.printf("%s inputs:\n", this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.')+1));
		System.out.println("==============================");
		System.out.println("Employee ID:");
		setEmployeeId(scan.nextInt());
		System.out.println("Please enter your current salary");
		setSalary(scan.nextDouble());
		System.out.println("Are you fulltime? yes or no");
		setFullTime(scan.next().equalsIgnoreCase("yes"));		
	}
	
	public String toString(){
		return super.toString()+"\n"+"Employee ID: "+employeeId+"\n"+"Salary: "+salary+"\n"+"is full time: "+isFullTime;
	}
	
	public boolean isFullTime() {
		return isFullTime;
	}
	public void setFullTime(boolean isFullTime) {
		this.isFullTime = isFullTime;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

}

package ifStuff;
import java.util.Scanner;


public class ifElse {
	public static void main(String[]args){
	int x,y,z;
	double a=5.90873402234, b=5.90873455555, c, tolerance=.00001;
	String name1="Pete", name2, name3, userName;
	Scanner scan=new Scanner(System.in);
	
	x=3;
	y=5;
	z=15;
	//simple if/else
	if(x>y)
		System.out.println("x is greater than y");
	else 
		System.out.println("x is not greater than y");
	
	//complex boolean conditions
	System.out.println("Please enter your name");
	userName=scan.next();
	if(z>=y&&name1.equalsIgnoreCase(userName)) 
		System.out.println("z is greater than or equal to y and the two names match!");
	else
		System.out.println("Not a match!");	
	
	
	}
}

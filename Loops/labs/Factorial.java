package labs;
// ****************************************************************
//   Factorial.java
//
//   Compute the factorial of a given number
//          
// ****************************************************************
import java.util.Scanner;

public class Factorial
{
    public static void main(String[] args)
    {
	int num;       //number to find factorial of
	int fac;       //factorial so far
	Scanner scan = new Scanner (System.in);

	//Get value to compute factorial of
	System.out.print("Please enter a nonnegative integer: ");
	num = scan.nextInt();

	//Make sure it's nonnegative
	while (num < 0)
	    {
		System.out.println("Factorial is undefined for negative numbers.");
		System.out.print("Please enter a non-negative integer: ");
		num = scan.nextInt();
	    }

	//Compute and print factorial
	System.out.print(num + "! = ");	
	fac = 1;
	while (num > 0)
	    {
		fac *= num;
		num--;
	    }
	System.out.println(fac);
    }	    
}


   

package ifStuff;
import java.util.Scanner;


public class NestingIfElse {
	public static void main(String[]args){
		Scanner scan=new Scanner(System.in);
		//Nesting statements
		System.out.println("Please enter an integer");
		int x=scan.nextInt();
		if(x>=100)
			System.out.println("Awesome!");
		else if(x>=80)
			System.out.println("pretty good");
		else if(x>=70)
			System.out.println("ok");
		else if(x>=60)
			System.out.println("not so hot!");
		else
			System.out.println("terrible!");
		
					/*
					 * if(x>=100)
						System.out.println("Awesome!");
						else if(x>=80)
							System.out.println("pretty good");
						else if(x>=70)
							System.out.println("ok");
						else if(x>=60)
							System.out.println("not so hot!");
						else
							System.out.println("terrible!");
					 * */
		
	}
}

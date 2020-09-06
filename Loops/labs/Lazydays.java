package labs;

import java.util.Scanner;

public class Lazydays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int temp=0;
		Scanner scan= new Scanner(System.in);
		boolean isSnowing = false;
		
		System.out.println("What is the temp? please enter an integer:");
		temp=scan.nextInt();
		if(temp<=40){
			System.out.println("is it snowing?");
			if(scan.next().equalsIgnoreCase("yes"))
				isSnowing=true;
		}
		
		if(temp>90||temp<10)
			System.out.println("Program");
		else if(temp>80)
			System.out.println("Swimming");
		else if(temp>60){
			System.out.println("Do you like cycling?");
			if(scan.next().equalsIgnoreCase("yes"))
				System.out.println("Go cycling!");
			else
				System.out.println("Go climbing!");
		}
		else if(temp>40)
			System.out.println("Golfing");
		else if(isSnowing)
			System.out.println("Skiing!");
		else
			System.out.println("your instructor did not provide sufficient info");
	}

}

package whileStuff;

import java.util.Scanner;

public class SentinelLoop {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		//Query controlled
		Scanner scan=new Scanner(System.in);
		String response="";
		
		while(!response.equalsIgnoreCase("no")){
			System.out.println("Would you like another taco? yes or no");
			response=scan.nextLine();
		}
		
		//USEFUL FOR ZOMBIE PROJECT
		//boolean flag
		boolean isTimeToPanic=false;
		int daysLeftTilFinals=130;
		
		while(!isTimeToPanic){
			System.out.printf("%d days til finals man! I'm just relaxin!\n", daysLeftTilFinals);
			if(daysLeftTilFinals==2)
				isTimeToPanic=true;
			daysLeftTilFinals--;
		}
		System.out.println("I'MFREAKINGOUTMAAAAN!!!!!!!!!!");
		
		//data validation
		int input;
		System.out.println("Please enter a positive integer between 0 and 100");
		input=scan.nextInt();
		//while input is not positive and not less than 100
		while(!(input<=100&&input>-1)){
			System.out.println("Invalid input");
			System.out.println("Please enter a positive integer between 0 and 100");
			input=scan.nextInt();
		}
		
		System.out.println("Thank you, have a nice day!");
		
		
	}

}

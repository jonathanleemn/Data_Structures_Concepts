package ifStuff;

import java.util.Scanner;

public class PerformanceReview {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// data
		String rating;
		double salary = 200, raise;
		boolean onProbation = true;

		// inputs
		System.out.println("Input a rating: Excellent, " + 
		"Good, Satisfactory, or Poor");
		rating = scan.next();

		while(!(rating.equalsIgnoreCase("Excellent")||rating.equalsIgnoreCase("good")||
				rating.equalsIgnoreCase("Satisfactory")||rating.equalsIgnoreCase("Poor"))){
		System.out.println("invalid input");
		System.out.println("Input a rating: Excellent, Good, Satisfactory, or Poor");
		rating = scan.next();
			
		}
		
		// outputs
		if (rating.equalsIgnoreCase("Excellent")) {
			raise = (salary * .06);
			salary = (raise + salary);
			System.out.printf("New salary: $%.2f", salary);
			onProbation = false;
		} 
		else if (rating.equalsIgnoreCase("Good")) {
			raise = (salary * .04);
			salary = (raise + salary);
			System.out.printf("New salary: $%.2f", salary);
			onProbation = false;
		} 
		else if (rating.equalsIgnoreCase("Satisfactory")) {
			raise = (salary * .03);
			salary = (raise + salary);
			System.out.printf("New salary: $%.2f", salary);
			onProbation = false;
		} 
		else if (rating.equalsIgnoreCase("Poor")) 
		{
			if (onProbation)
			{
				System.out.println("You're fired");
			}
			else
				System.out.println("You are on probation");
		}

	}

}

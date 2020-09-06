package lab;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PredictRunTime
{
	static int sample_n = 10000;
	static int target_n = 30000;
	static int sample_time = 10;
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		try
		{
			System.out.print("Pick a sample n: ");
			sample_n = input.nextInt();

			System.out.print("Pick a target n: ");
			target_n = input.nextInt();

			System.out.print("Enter 1 for log complexity case \nEnter 2 for log linear complexity case"
					+ "\nEnter 3 for n^2 complexity case \nEnter 4 for n^3 complexity case\n");
			int caseSelect = input.nextInt();

			if (caseSelect == 1)
				logarithmic();
			else if (caseSelect == 2)
				logLinear();
			else if (caseSelect == 3)
				nSquared();
			else if (caseSelect == 4)
				nCubed();
			else
				System.out.println("Invalid input");
			System.out.println("Process Completed");
		} 
		catch (InputMismatchException e)
		{
			System.err.printf("%nException: %s%n", e);
			input.nextLine(); // discard input so user can try again
			System.out.printf("You must enter an integer. Please try again.%n%n");
		}
	}

	public static void nSquared()
	{
		double c = sample_time / Math.pow(sample_n, 2);
		double estimated_time = c * Math.pow(target_n, 2);

		System.out.println(estimated_time + " seconds");
	}

	public static void nCubed()
	{
		double c = sample_time / Math.pow(sample_n, 3);
		double estimated_time = c * Math.pow(target_n, 3);

		System.out.println(estimated_time + " seconds");
	}

	public static void logarithmic()
	{
		double c = sample_time / Math.log(sample_n);
		double estimated_time = c * Math.log(target_n);
		
		System.out.println(estimated_time + " seconds");
	}

	public static void logLinear()
	{
		double c = sample_time / (sample_n * Math.log(sample_n));
		double estimated_time = c * (target_n * Math.log(target_n));

		System.out.println(estimated_time + " seconds");
	}

}

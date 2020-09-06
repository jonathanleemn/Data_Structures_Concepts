package switchExamples;

import java.util.Random;
import java.util.Scanner;

public class SwitchExample {

	public static void main(String[] args) {
		Random rand = new Random();
		int die, maxCount = 0, goodCount = 0, okCount = 0, poorCount = 0;
		String status = "";

		for (int i = 0; i < 5; i++) 
		{
			status = "";
			die = 0;
			
			for (int j = 0; j < 3; j++)
				die += rand.nextInt(6) + 1;
			switch (die / 3) 
			{
			case 4:
				status = die + ": ok roll.";
				okCount++;
				break;
			case 5:
				status = die + ": good roll!";
				goodCount++;
				break;
			case 6:
				status = die + ": MAX ROLL!!!!!!!";
				maxCount++;
				break;
			default:
				status = die + ": poor roll!";
				poorCount++;
				break;
			}// end switch
			System.out.println(status);
		}
		System.out.println();

		System.out.print("18's rolled: \t");
		for (int j = 0; j < maxCount; j++)
			System.out.print("*");
		System.out.println();

		System.out.print("15-17 rolled: \t");
		for (int j = 0; j < goodCount; j++)
			System.out.print("*");
		System.out.println();

		System.out.print("12-14 rolled: \t");
		for (int j = 0; j < okCount; j++)
			System.out.print("*");
		System.out.println();

		System.out.print("0-11 rolled: \t");
		for (int j = 0; j < poorCount; j++)
			System.out.print("*");
		System.out.println();
	}

}

package lectureFiles;

import java.util.Random;
import java.util.Scanner;

public class Map
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Random randNum = new Random();
		int[][] map = new int[10][10];
		int rowLoc = 4, colLoc = 4;
		String response;
		char direction;

		for (int row = 0; row < map.length; row++)
		{
			for (int column = 0; column < map[row].length; column++)
			{
				map[row][column] = randNum.nextInt(7) + 1;
			}
		}

		for (int row = 0; row < map.length; row++)
		{
			for (int column = 0; column < map[row].length; column++)
			{
				System.out.printf("element at index: [%s],[%s] is: %s\n", row, column, map[row][column]);
			}
		}

		do
		{
			System.out.printf("Your starting location is index[%s],[%s]\n", rowLoc, colLoc);
			System.out.println("Pressing \"W\" will move you north, pressing \"S\" will move you south,"
					+ "Pressing \"D\" will move you east and pressing \"A\" will move you west.");
			System.out.println("Please enter W, S, D or A");

			direction = scan.next().charAt(0);

			switch (direction)
			{
			case 'w':
			case 'W':
				rowLoc--;
				break;
			case 's':
			case 'S':
				rowLoc++;
				break;
			case 'd':
			case 'D':
				colLoc++;
				break;
			case 'a':
			case 'A':
				colLoc--;
				break;

			}

			System.out.printf("Your starting location is index [%s],[%s]\n", rowLoc, colLoc);
			System.out.printf("The element at this location is %s\n", map[rowLoc][colLoc]);
			System.out.println("Would you like to move again? y or n");
			response = scan.next();
		} while (response.equalsIgnoreCase("y"));

	}

}

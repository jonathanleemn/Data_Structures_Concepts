

import java.util.Scanner;

public class BasicMultiDimArray
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int input;

		// Outer brackets indicate initialization of an array
		// two sets of inner brackets initialize two individual arrays
		// Multi-Dimensional arrays can be thought of as arrays with arrays in
		// the elements
		int[][] basic2Dim = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 } };

		// This loop will print out all of the values of an array.
		for (int row = 0; row < basic2Dim.length; row++)
		{// this for loop will iterate over the outer array
			// iterates 5 times for the first outer array and then loop back to
			// the top
			for (int column = 0; column < basic2Dim[row].length; column++)
			{// this will iterate over the inner arrays
				System.out.printf("%d\t", basic2Dim[row][column]);
			}
			System.out.println();
		} // end for

		// Read in values from the user
		for (int row = 0; row < basic2Dim.length; row++)
		{// this for loop will iterate over the outer array
			for (int column = 0; column < basic2Dim[row].length; column++)
			{
				System.out.println("Please enter an integer into index [" + row + "],[" + column + "]");
				basic2Dim[row][column] = scan.nextInt();
			} // end inner for
		} // end outer for

		for (int row = 0; row < basic2Dim.length; row++)
		{// this for loop will iterate over the outer array
			for (int column = 0; column < basic2Dim[row].length; column++)
			{
				System.out.println(
						"The value held in index [" + row + "],[" + column + "] is: " + basic2Dim[row][column]);
			} // end inner for
		} // end outer for

		// ================================================================================
		// nested enhanced for loop to iterate over a 2d array
		// don't need counters
		System.out.println("Output using nested enhanced for loop.");
		// extracts inner array from outer array
		for (int[] column : basic2Dim)
		{
			// extracts int from inner array
			for (int cell : column)
			{
				System.out.print(cell + "\t");
			}
			System.out.println();
		}

		// looks at a single row
		// ================================================================================
		// read a value into only one of the rows
		for (int column = 0; column < basic2Dim[1].length; column++)
		{
			System.out.println("please enter an int");
			basic2Dim[1][column] = scan.nextInt();
		}

		// looks at a single column
		int colChoice = scan.nextInt();
		for (int row = 0; row < basic2Dim.length; row++)
		{
			System.out.println(basic2Dim[row][colChoice]);
		}

		System.out.println("Output using nested enhanced for loop.");
		for (int[] column : basic2Dim)
		{
			for (int cell : column)
			{
				System.out.print(cell + "\t");
			}
			System.out.println();
		}

	}// end main

}

package lectureFiles;

import java.util.Random;

public class MultiDimPractice
{
	Random rand = new Random();
	int[][] twoD = new int[10][8];
	int count = 1;
	int[][] ragged =
	{
			{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
			{ 1, 2, 3, 4, 5, 6 },
			{ 1, 2, 3, 4, 5, 6, 7, 8 },
			{ 1, 2, 3 },
			{ 1, 2, 3, 4, 5, 6 },
			{ 1, 2, 3, 4, 5, 6, 7, 8, 9 } };

	public void fillArray()
	{
		// outer for, iterates through the individual rows
		// accessing the individual rows
		for (int row = 0; row < twoD.length; row++)
		{
			// inner for, iterates through the individual columns
			// accessing each element w/in the rows
			for (int col = 0; col < twoD[row].length; col++)
			{
				twoD[row][col] = count;
				count++;
			}
		}
	}

	public void printArray()
	{
		// iterate through the rows
		// up to but not including the outer row
		for (int row = 0; row < twoD.length; row++)
		{
			for (int col = 0; col < twoD[row].length; col++)
			{
				System.out.print("[" + twoD[row][col] + "] ");
			}
			System.out.println();
		}
	}

	// fills a specific column in an array
	public void fillColumn(int target)
	{
		final int TARGET_COL = target;
		for (int row = 0; row < twoD.length; row++)
		{
			for (int col = 0; col < twoD[row].length; col++)
			{
				twoD[row][TARGET_COL] = 0;
			}
		}

		// print only one column
		for (int row = 0; row < twoD.length; row++)
		{
			for (int col = TARGET_COL; col < TARGET_COL + 1; col++)
			{
				System.out.print("[" + twoD[row][TARGET_COL] + "] ");
			}
			System.out.println();
		}
	}

	// iterate over ragged arrays
	public void printRagged()
	{
		// iterates through each row
		for (int row = 0; row < ragged.length; row++)
		{
			// iterates through each cell w/in a single row
			for (int col = 0; col < ragged[row].length; col++)
			{
				System.out.print("[" + ragged[row][col] + "] ");
			}
			System.out.println();
		}
	}

	
	//constraining traversals over a given range
	//checks all the squares w/in 1 square of a given target
	public void traverseRange(int targetRow, int targetCol) //starting point of traversal
	{
		System.out.println("Range");
		final int TARGET_ROW = targetRow, TARGET_COL = targetCol;
		//start traversal at target row - 1, looks at row directly above target
		//end at target row + 2 non-inclusive, looks at row directly below target
		for (int row = TARGET_ROW - 1; row < TARGET_ROW + 2; row++)
		{
			//looks at the cell directly to the left of the target
			//end at target col + 2 non-inclusive, looks at cell to the right of the target
			for (int col = TARGET_COL - 1; col < TARGET_COL + 2; col++)
			{
				if (!(row == TARGET_ROW && col == TARGET_COL))
					System.out.print("[" + twoD[row][col] + "] ");
				else
					System.out.print("[xx] ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

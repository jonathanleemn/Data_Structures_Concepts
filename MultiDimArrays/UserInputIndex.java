package lectureFiles;

import java.util.Scanner;

public class UserInputIndex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int[][] twoDimArray={{1, 2, 3, 4, 5},{6, 7, 8, 9, 10}};
		int row, column;
		int[] arrayRow = {0, 1};
		int[] arrayCol = {0, 1, 2, 3, 4};
		
		//Use variables to retrieve data from the array
		System.out.println("Which index would you like to retrieve?");
		System.out.println("please enter the row:");
		row=scan.nextInt();
		System.out.println("please enter the column:");
		column=scan.nextInt();
		
		System.out.printf("the value at [%s],[%s] is: %s\n", row, column, twoDimArray[row][column]);
		
		//randomly chooses from row and then randomly chooses from column
		row = (int)(Math.random() * 2);
		column = (int)(Math.random() * 2);
		System.out.printf("the random value at [%s],[%s] is: %s", row, column, twoDimArray[row][column]);

	}

}

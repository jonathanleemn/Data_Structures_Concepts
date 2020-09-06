package assignment;

import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*
 * Author: Jonathan Lee
 * Program: SortDriver
 * Purpose: To test the speed of sorting methods
 * Date Due: 3/30/17
 */
public class SortDriver
{
	@SuppressWarnings({"unchecked", "rawtypes"})
	public static void main(String[] args) throws IOException
	{
        Scanner scan = new Scanner(System.in);
		FileIO fio = new FileIO();
		Preprocess pp = new Preprocess();
		Timer stopwatch = new Timer();		
		Long[] volLong = (Long[]) pp.convertToLong(fio.volume);
		
		System.out.println("Sorting Methods: ");
		System.out.println("1. Selection Sort");
		System.out.println("2. Insertion Sort");
		System.out.println("3. Shell Sort");
		System.out.println("4. Merge Sort");
		System.out.println("5. Quick Sort");
		System.out.println("6. Radix Sort");
		System.out.print("Enter a sorting method number: ");
		int userInput = scan.nextInt();
		
		fio.writeToFile(volLong);

		if(userInput == 1)
		{
			stopwatch.start();
			SortMethods.selectionSort(volLong, volLong.length);
			stopwatch.end();
			stopwatch.printResult();
		}
		
		else if(userInput == 2)
		{
			stopwatch.start();
			SortMethods.insertionSort(volLong, 0, (int)(volLong.length-1));
			stopwatch.end();
			stopwatch.printResult();
		}
		
		else if(userInput == 3)
		{
			stopwatch.start();
			SortMethods.shellSort(volLong, 0, (int)(volLong.length-1));
			stopwatch.end();
			stopwatch.printResult();
		}
		
		else if(userInput == 4)
		{
			stopwatch.start();
			SortMethods.mergeSort(volLong, 0, volLong.length-1);
			stopwatch.end();
			stopwatch.printResult();
		}
		
		else if(userInput == 5)
		{
			stopwatch.start();
			System.out.println("Quick Sort initiated...");
			SortMethods.quickSort(volLong, 0, volLong.length-1);
			stopwatch.end();
			stopwatch.printResult();
			System.out.println("Number of elements processed: " + SortMethods.elementCounter);
			System.out.println("Number of operations: " + SortMethods.operationCounter);
		}
		
		else if(userInput == 6)
		{
			int[] volInt = pp.convertToInt(fio.volume2);
			stopwatch.start();
			SortMethods.radixsort(volInt);
			stopwatch.end();
			stopwatch.printResult();	
		}
		else
			System.out.println("Invalid input. Please try again.");
				
	}	
}

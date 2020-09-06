package assignment;

import java.io.IOException;
import java.util.concurrent.SynchronousQueue;
/*
 * Author: Jonathan Lee
 * Date: 3/16/2017
 * Purpose: Modifying assignment 6 to incorporate binary and sequential search. 
 * 
 * Ideally, a binary search would be the best case for my data because my list is already sorted.
 * I used the sequential search because the arrays I created were of type comparable and that did 
 * not properly work with the compareTo function in the binary search method. Although the sequential
 * search does not require the list to be sorted, the efficiency does not change if it is sorted.
 * 
 *  The worst case for a sorted (and unsorted) sequential search is O(n) because it would then have to
 *  traverse through the entire array. 
 * 
 */
public class TemperatureFinder
{

	public static <T> void main(String[] args) throws IOException
	{
		SortedListStats stats = new SortedListStats();
		
		//creates a new list and populates it from values from the scaledList
		int list[] = new int[7960];
		for(int i=1; i<list.length; i++)
		{
			list[i] = stats.scaledListRounded.getEntry(i);
		}
		
		binarySearch(list, stats.MPRjun);
		iterativeSearch(stats.scaledList, stats.MPRjan);
	}
	
	//my attempt at using binary search but having trouble figuring out how to do a binary search using a range
	//so I scaled it down to using integers. but since it's in ints, it finds it after one pass.
	public static void binarySearch(int[] list, int MPR)
	{
		long startTime = System.nanoTime();
		int matches = 0;
		int passes = 1;
		int deviation = 1 * passes;
		int min = MPR - deviation;
		int max = MPR + deviation;
		int sampleTime = 10;
		
		if(SearchIterator.inArrayRecursiveSorted(list, MPR) == true)
		{
			matches++;
		}
		
		if(matches == 0)
		{
			passes++;
			deviation = 1 * passes;
			min = MPR - deviation;
			max = MPR + deviation;
			if(SearchIterator.inArrayRecursiveSorted(list, min) == true)
			{
				matches++;
			}
			if(SearchIterator.inArrayRecursiveSorted(list, max) == true)
			{
				matches++;
			}
			
			
		}
		System.out.printf("%d matches found after %d passes\n", matches,
				passes);
		System.out.println("Big O: O(logn)");
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000;
		System.out.println("Time to compile: " + duration + " milliseconds");
	}


	/*
	 * Iteratively searches through the SortedList for a match.
	 * If no matches are found after the first pass, passes will increment and
	 * the deviation, min, and max values will compensate by updating its values
	 * until a match is found.
	 */
	public static void iterativeSearch(SortedList<Double> scaledList, int MPR)
	{
		long startTime = System.nanoTime();
		int matches = 0;
		int passes = 1;
		int deviation = 1 * passes;
		int min = MPR - deviation;
		int max = MPR + deviation;

		matches = searchList(scaledList, min, max, matches);

		//updates values if no matches are found after each pass
		while (matches == 0)
		{
			passes++;
			deviation = 1 * passes;
			min = MPR - deviation;
			max = MPR + deviation;
			matches = searchList(scaledList, min, max, matches);
		}

		System.out.printf("%d matches found after %d passes\n", matches,
				passes);
		System.out.println("Big O: O(n)");
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000;
		System.out.println("Time to compile: " + duration + " milliseconds");
	}

	// iterates through the list and looks for a match
	public static int searchList(SortedList<Double> scaledList, int min,
			int max, int matches)
	{
		for (int i = 1; i <= scaledList.getLength(); i++)
		{
			if (scaledList.getEntry(i) > min && scaledList.getEntry(i) < max)
			{
				matches++;
			}
		}
		return matches;
	}
}
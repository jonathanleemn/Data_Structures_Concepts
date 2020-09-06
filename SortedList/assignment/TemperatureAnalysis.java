package assignment;

import java.io.IOException;
/*
 * Author: Jonathan Lee
 * Date: 2/27/2017
 * Purpose: To record temperature data into a SortedList. Data will then be used to plot graphs.
 * 
 * When using SortedList to implement statistical methods, the efficiency
 * depends on the efficiency of the methods found within it. Since I am using
 * the getEntry() method in my SortedListStats class, its efficiency is O(n).
 * This is because I am using a LinkedSortedList to implement this method. If I had
 * implemented getEntry() using an array it would be more efficient, with a big O of O(1), 
 * since it automatically finds the data right away. From my understanding, I would expect that 
 * retrieving the data from a file would be more efficient since you're grabbing everything all at once 
 * instead of sorting it into lists. From what I can gather, the efficiency of these statistcal methods
 * really depends on how the user sets up his/her list. 
 */
public class TemperatureAnalysis
{

	public static void main(String[] args) throws IOException
	{
		SortedListStats stats = new SortedListStats();

		stats.averageTemperature();
		stats.medianTemperature();
	
		System.out.println(stats.janAvgTemp);
		System.out.println(stats.febAvgTemp);
		System.out.println(stats.marAvgTemp);
		System.out.println(stats.aprAvgTemp);
		System.out.println(stats.mayAvgTemp);
		System.out.println(stats.junAvgTemp);
		System.out.println(stats.julAvgTemp);
		System.out.println(stats.augAvgTemp);
		System.out.println(stats.septAvgTemp);
		System.out.println(stats.octAvgTemp);
		System.out.println(stats.novAvgTemp);
		System.out.println(stats.decAvgTemp);

		stats.plotMax();
		stats.plotMedian();
		stats.plotMin();
	}
}

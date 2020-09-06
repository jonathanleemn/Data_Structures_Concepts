package assignment;

import java.util.Arrays;
import java.util.Comparator;
/*
 * Author: Jon Skeet
 * http://stackoverflow.com/questions/4859261/get-the-indices-of-an-array-after-sorting
 * 
 * Class that sorts an array while keeping its index stored in a separate array
 * I use this stored index in my writeToFile() method in my FileIO class to determine which index to write over
 */
public class ArrayIndexComparator implements Comparator<Integer>
{
	private final Long[] array;

	public static void main(String[] args)
	{
		Long[] test = {(long) 0, (long) 11, (long) 1};
		ArrayIndexComparator comparator = new ArrayIndexComparator(test);
		Integer[] indexes = comparator.createIndexArray();
		Arrays.sort(indexes, comparator);
		
		for (int i = 0; i < indexes.length; i++)
		{
			System.out.println(indexes[i]);
		}
	}

	public ArrayIndexComparator(Long[] array)
	{
		this.array = array;
	}

	public Integer[] createIndexArray()
	{
		Integer[] indexes = new Integer[array.length];
		for (int i = 0; i < array.length; i++)
		{
			indexes[i] = i;
		}
		return indexes;
	}

	@Override
	public int compare(Integer index1, Integer index2)
	{
		return array[index1].compareTo(array[index2]);
	}

}

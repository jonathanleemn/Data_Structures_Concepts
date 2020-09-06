package lab;

import java.util.ArrayList;
import java.util.List;

public class Tester
{
	static ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args)
	{
		Preprocess<Integer> convert = new Preprocess<Integer>();
		Timer stopwatch = new Timer();
		addList();
		Integer[] newList = convert.convertList(list);
	
//		printArray(newList);
//		stopwatch.start();
//		SortArray.selectionSort(newList, newList.length);
//		stopwatch.end();
//		stopwatch.printResult();
//		printArray(newList);

		
//		printArray(newList);
//		stopwatch.start();
//		SortArray.shellSort(newList, 0, newList.length-1);
//		stopwatch.end();
//		stopwatch.printResult();
//		printArray(newList);


	}
	
	static <T> void printArray(T[] array)
	{
		for(int i = 0; i<array.length; i++)
		{
			System.out.println(array[i]);
		}
	}

	public static void addList()
	{
		list.add(2);
		list.add(null);
		list.add(1);
		list.add(0);
	}
}

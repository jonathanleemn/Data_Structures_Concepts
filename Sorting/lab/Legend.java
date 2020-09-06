package lab;

/*
 * prints information about types of sorting
 */
class Legend
{
	String bApp = "Best Applications: ", wApp = "Worst Applications: ";

	public Legend()
	{
		bubbleSort();
		insertionSort();
		selectionSort();
		shellSort();
		mergeSort();
		quickSort();
		radixSort();
	}

	// print given string
	void printStr(String in)
	{
		StringBuilder sb = new StringBuilder(in);

		int i = 0;
		while (i + 100 < sb.length()
				&& (i = sb.lastIndexOf(" ", i + 100)) != -1)
		{
			sb.replace(i, i + 1, "\n");
		}

		System.out.println(sb.toString());
	}

	// blank line -- for added white space
	void space()
	{
		System.out.println();
	}

	// print each string in an array
	void printArray(String[] in)
	{
		for (String n : in)
			System.out.printf("%s%n", n);
	}

	// begin series of methods that describe types of sorting
	void bubbleSort()
	{
		printStr(
				"Bubble sort is a sort that continually iterates through a list and compares adjacent"
						+ " data swapping the smaller data to the left as needed until no more swaps are needed");
		space();
		printStr(bApp + "small data sets, or when learning sorting");
		printStr(wApp + "large or very complex data sets");
		space();
	}

	void insertionSort()
	{
		printStr(
				"Insertion sort creates a sorted section on one side and gradually take pieces of "
						+ "the unsorted side and inserts it into the expanded sorted side");
		space();
		printStr(bApp
				+ "semi-sorted data sets, great for data sets that you continually add data to");
		printStr(wApp + "large data sets, complete unsorted data sets");
		space();
	}

	void selectionSort()
	{
		printStr(
				"Selection sort searches for the smallest in a list and swaps it for the first index"
						+ "it then moves on to the second index and the next smallest number and so on until the index reaches the end of the list");
		space();
		printStr(bApp
				+ "semi-sorted data sets, great for data sets that you continually add data to");
		printStr(wApp + "large data sets, complete unsorted data sets");
		space();
	}

	void shellSort()
	{
		printStr(
				"Shell sort sorts pairs of elements across a gap, then on each cycle it "
						+ "reduces the gap between items to sort until the collection is sorted");
		space();
		printStr(bApp + "large data sets");
		printStr(wApp
				+ "worst case generally depends on the gap sequence used for the sorts");
		space();
	}

	void mergeSort()
	{
		printStr(
				"Merge sort uses a divide and conquer algorithm by repeatedly splitting the array "
						+ "into halves and then combining them into one array");
		space();
		printStr(bApp + "Big data, used by Java to sort objects");
		printStr(wApp
				+ "Small data because a temporary array is necessary for merging");
		space();
	}

	void quickSort()
    {
        printStr(
                "Quick Sort uses a pivot value and sorts data to either side of that pivot based on relation to the pivot value"
                        + " keeps finding new pivot value until there is nothing left to sort.");
        space();
        printStr(bApp
                + "Big data, not as efficient as most because it has a time complexity of O(n^2)");
        printStr(wApp + "anything that is not a primitive data type");
        space();
    }

	void radixSort()
	{
		printStr(
				"Radix sort looks at a position in the string and sorts them sorts it into 1 of 10 buckets depending on "
						+ "the character of said position, this is repeated until all positions in the string have been sorted");
		space();
		printStr(bApp
				+ "Big data, faster than most other sorts because it has a big O of O(n)");
		printStr(
				wApp + "Not suitable as a general-purpose sorting algorithm because it does not compare "
						+ "array entries");
		space();
	}
}

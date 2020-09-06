
public class ArraySearcher
{
	public static void main(String[] args)
	{
		Integer[] unsortedArray = {20, 24, 4, 12, 8, 14};
		Integer[] sortedArray = {4, 8, 12, 14, 20, 24};

		System.out
				.println("Iterative sequential search of an unsorted array: ");
		ArraySearching.display(unsortedArray);
		System.out.println("4 in array? "
				+ ArraySearching.inArrayIterativeUnsorted(unsortedArray, 4));
		
		System.out.println(
				"\nRecursive sequential search of an unsorted array: ");		
		ArraySearching.display(unsortedArray);
		System.out.println("4 in array? "
				+ ArraySearching.inArrayRecursiveUnsorted(unsortedArray, 4));
		
		System.out.println("\nRecursive binary search of a sorted array: ");
		ArraySearching.display(sortedArray);
		System.out.println("14 in array? "
				+ ArraySearching.inArrayRecursiveSorted(sortedArray, 14));
	}
}

class ArraySearching
{
	public static <T extends Comparable<? super T>> boolean binarySearch(
			T[] anArray, T anEntry)
	{
		return binarySearch(anArray, 0, anArray.length - 1, anEntry);
	}
	public static <T extends Comparable<? super T>> boolean binarySearch(
			T[] anArray, int first, int last, T anEntry)
	{
		boolean found = false;
		int mid = first + (last - first) / 2;

		if (first > last)
			found = false;
		else if (anEntry.equals(anArray[first]))
			found = true;
		else if (anEntry.compareTo(anArray[mid]) < 0)
			found = binarySearch(anArray, first, mid - 1, anEntry);

		else if (anEntry.compareTo(anArray[mid]) == 0)
			found = true;
		else
			found = binarySearch(anArray, mid + 1, last, anEntry);

		return found;
	}

	public static <T> void display(T[] anArray)
	{
		System.out.println("The array contains the following entries");
		for (int index = 0; index < anArray.length; index++)
		{
			System.out.println(anArray[index] + " ");
		}
		System.out.println();
	}

	public static <T> boolean inArrayIterativeUnsorted(T[] anArray, T anEntry)
	{
		boolean found = false;
		int index = 0;
		while (!found && (index < anArray.length))
		{
			if (anEntry.equals(anArray[index]))
				found = true;
			index++;
		}
		return found;
	}

	public static <T> boolean inArrayRecursiveUnsorted(T[] anArray, T anEntry)
	{
		return search(anArray, 0, anArray.length - 1, anEntry);
	}
	// Searches anArray[first] through anArray[last] for desiredItem.
	// first >= 0 and < anArray.length.
	// last >= 0 and < anArray.length.
	private static <T> boolean search(T[] anArray, int first, int last,
			T desiredItem)
	{
		boolean found = false;
		if (first > last)
			found = false; // No elements to search
		else if (desiredItem.equals(anArray[first]))
			found = true;
		else
			found = search(anArray, first + 1, last, desiredItem);
		return found;
	}

	public static <T extends Comparable<? super T>> boolean inArrayRecursiveSorted(
			T[] anArray, T anEntry)
	{
		return binarySearch(anArray, 0, anArray.length - 1, anEntry);
	}
}
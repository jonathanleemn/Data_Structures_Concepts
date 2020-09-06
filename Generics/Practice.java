import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Practice
{
	public static void main(String[] args)
	{
		myMethod(null, null, null);

		String[] myStringArray =
		{ "abc", "def", "ghi", "jkl" };
		printArray(myStringArray);

		Character[] myCharArray =
		{ 'A', 'B', 'C', 'D' };
		printArray(myCharArray);

		Integer i[] =
		{ 1, 2, 3, 4, 5 };
		Character c[] =
		{ 'a', 'b', 'c', 'd', 'e' };

		/*
		 * can't do this b/c no upper bound List<B> lb = new ArrayList<>();
		 * List<A> la = b;
		 * 
		 * needs an upper bound List<? extends Integer> li = new ArrayList<>();
		 * List<? extends Number> ln = li;
		 * 
		 */
		
		List<String> words = new LinkedList<>();
		words.add("hello");
		words.add("world");
		printReversedList(words);
	
		
	}

	// USING A CAST
	// public class List<T>
	// {
	// public void add(T desired type, List<Date> variablename)
	// {
	// T newVarName = (T) variablename;
	// }
	// }

	
	public static<T extends Comparable<T>> T maximum(T x, T y, T z)
	{
		T max = x;
		if(y.compareTo(max)>0)
			max = y;
		if(z.compareTo(max)>0)
			max = z;
		
		return max;
	}
	
	private static <T> void printReversedList(List<String> list)
	{
		ListIterator<String> iterator = list.listIterator(list.size());
		
		System.out.printf("%nReversed List: %n");
		
		while(iterator.hasPrevious())
			System.out.printf("%s ", iterator.previous());
	}
	
	public static <T> void myMethod(T arg1, T arg2, T[] arg3)
	{
		// T is arbitrary
		// could also define multiple types <T, U, E>

		ArrayList<Integer> myList = new ArrayList<>();
		myList.add(5); // autoboxing

		// Generics (T, U, S, . . .)
		// can be a return type
		// can be a single variable or array

		// compareTo of interface Comparable
		/*
		 * Aclass obj1 = new Aclass(); obj1.compareTo(obj2); //may need to
		 * override compareTo
		 */
	}
	

	public static <T> void printArray(T[] someArray)
	{
		for (T element : someArray)
		{
			System.out.println(element);
		}
	}

	interface TestMaxInterface<T extends Comparable<T>>
	{
		T max();
	}

	class TestMax<T extends Comparable<T>> implements TestMaxInterface<T>
	{
		T[] values;

		TestMax(T[] t)
		{
			values = t;
		}

		public T max()
		{
			T v = values[0];

			for (int i = 1; i < values.length; i++)
				if (values[i].compareTo(v) > 0)
					v = values[i];
			return v;
		}
	}

	public class UBGeneric
	{
		public double average(List<? extends Number> ln)
		{
			double sum = 0.0;
			int count = 0;

			for (Number n : ln)
			{
				sum += n.doubleValue();
				count++;
			}
			return sum / count;
		}
	}

}



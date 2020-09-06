package lab;

import java.util.Iterator;
import java.util.ListIterator;

public class Driver
{

	public static void main(String[] args)
	{
		ListWithIteratorInterface<String> nameList = new LinkedListWithIterator<String>();
		nameList.add("Joe");
		nameList.add("Jess");
		nameList.add("Joe");
		nameList.add("Jen");

		// problem 1
		Iterator<String> nameIterator = nameList.getIterator();
		nameIterator.next();
		nameIterator.next();
		nameIterator.next();
		System.out.println(nameIterator.next());

		// problem 2
		for (String name : nameList)
			System.out.print(name + " ");
		System.out.println();

		// problem 3
		for (String name : nameList)
			nameList.remove(1);
		
		// problem 4
		while (nameIterator.hasNext())
		{
			if (nameIterator.equals("CANCEL"))
			{
				nameIterator.remove();
			}
			nameIterator.next();
		}
		
		
	}
}

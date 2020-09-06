package lab;

public class Driver
{
	public static void main(String[] args)
	{
		//problem 1
		SortedList<String> nameList = new SortedList<String>();		
		nameList.add("Hi");
		nameList.add("Hi");
		nameList.add("Wurld");
		System.out.println(nameList.contains("Hi"));
	}
}

/*
 * Problem 5
 * Since it's a SortedList, adding duplicate objects is acceptable. 
 * public boolean add(newEntry) has an efficiency of O(n) for both array sorted lists and linked sorted lists.
 * public boolean add(int newPosition, T newEntry) also has an efficiency of O(n) for both array sorted lists and 
 * linked sorted lists. Because these both have the same time efficiency of O(n) it will depend on the size of the 
 * lists. 
 * 
 * Problem 6
 * You could, because you can make your node have multiple data types in it, and then make a list of those nodes, 
 * and chain them by date. This is because LinkedChainBase is a base for a linked list. Realistically you wouldn't need 
 * to overwrite any methods, but you would have to add more data entries, and add more methods to get/set that data. 
 * If any method should be overwritten or changed it would be Node methods to create Nodes. In some cases containment
 * can be more appropriate but not all cases, this is not always the case.
 * 
 * Problem 7
 * You could used LinkedSortedList as well. Again you would just have to change the Node class you are using to 
 * encapsulate all the data. You would have to pick one of the data types as the sort option but you could use it 
 * effectively. You would only need to overwrite the Node method, along with adding more getters and setters.
 * In some cases containment can be more appropriate but not all cases, this is not always the case.
 */

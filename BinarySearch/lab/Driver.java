package lab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
		nameList.add("CANCEL");
		
		//problem 1
		Iterator<String> nameIterator = nameList.getIterator();
		nameIterator.next();
		nameIterator.next();
		nameIterator.next();
		System.out.println(nameIterator.next());
		
		//problem 2
		for (String name : nameList)
			System.out.print(name + " ");
		System.out.println();
		
		//problem 3
		for(String name : nameList)
			nameList.remove(1);
		
		//problem 4
		while(nameIterator.hasNext()){
			if(nameIterator.equals("CANCEL")){
				nameIterator.remove();
			}
			nameIterator.next();
		}
		
		//problem 5
		for(String name: nameList)
			while(nameIterator.hasNext()){
				if(nameIterator.equals(name))
					nameIterator.remove();
				else
					nameIterator.next();
			}
		
		// problem 6
		ArrayList test = new ArrayList<String>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		for (Iterator<String> iterator = nameList.iterator(); iterator.hasNext();) {
			if(!test.contains(iterator)){
				test.add(iterator);
				count.add(1);
			}else{
				int index = test.indexOf(iterator);
				int value = (int) count.get(index) + 1;
				count.set(index, value);
			}
		}		
	}
	
	//problem 7
	public static <T extends Comparable<? super T>> boolean binarySearch(T[] array, int first, int last, T desiredItem){
		boolean found = false;
		while(!found && (first <= last)){
			int mid = first + (last - first) / 2;
			
			if(desiredItem.equals(array[mid]))
				found = true;
			else if (desiredItem.compareTo(array[mid]) < 0)
				last = mid - 1;
			else
				first = mid + 1;
		}
		return found;
	}
	
	// problem 8
	// takes in a desired object and array to search and returns a list of the indices that are equal to desired object
	public static <T> List<Integer> duplicateList(T desiredObj, T[] array){
		List<Integer> indices = new ArrayList<Integer>();
		for(int i = 0; i < array.length; i++)
			if(array[i].equals(desiredObj))
				indices.add(i);
		return indices;
	}
	
	
	// problem 9
	public static <T> List<Integer> duplicateSorted(T desiredObj, T[] array){
		List<Integer> duplicates = new ArrayList();
		int index = 0;
		return duplicateSorted(desiredObj, array, index, duplicates);
	}
	
	public static <T> List<Integer> duplicateSorted(T desiredObj, T[] array, int index, List<Integer> duplicates){
		if(index < array.length){
			if(desiredObj.equals(array[index]))
				duplicates.add((Integer) array[index]);
			return duplicateSorted(desiredObj, array, index + 1, duplicates);
		}
		return duplicates;
	}
}

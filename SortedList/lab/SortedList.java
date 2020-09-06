package lab;

import java.util.List;

/*
 * Author: Frank M. Carrano
 * Source code found from the textbook and methods taken from
 * http://www.mathcs.richmond.edu/~barnett/cs221/source/LList.java
 */
public class SortedList<T extends Comparable<? super T>>
		extends
			LinkedChainBase<T>
		implements
			SortedListInterface<T>
{
	private Node firstNode; // Reference to first node of chain
	private Node lastNode;
	private int numberOfEntries;

	public SortedList()
	{
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
	} // end default constructor

	/*
	 * < Implementations of the sorted list operations go here.> . . .
	 */

	@Override
	public void add(T newEntry)
	{
		firstNode = add(newEntry, firstNode);
		numberOfEntries++;
	} // end add

	private Node add(T newEntry, Node currentNode)
	{
		if ((currentNode == null)
				|| (newEntry.compareTo(currentNode.getData()) <= 0))
		{
			currentNode = new Node(newEntry, currentNode);
		} else
		{
			Node nodeAfter = add(newEntry, currentNode.getNext());
			currentNode.setNext(nodeAfter);
		} // end if
		return currentNode;
	} // end add

	@Override
	public boolean remove(T anEntry)
	{
		boolean result = false;
		int position = getPosition(anEntry);
		if (position > 0)
		{
			result = true;
		} // end if
		return result;
	} // end remove

	@Override
	public int getPosition(T anEntry)
	{
		int position = 1;
		Node currentNode = firstNode;
		while ((currentNode != null)
				&& (anEntry.compareTo(currentNode.getData()) > 0))
		{
			currentNode = currentNode.getNext();
			position++;
		}
		if ((currentNode == null)
				|| anEntry.compareTo(currentNode.getData()) != 0)
			position = -position;
		return position;
	}

	private Node getNodeBefore(T anEntry)
	{
		Node currentNode = firstNode;
		Node nodeBefore = null;
		while ((currentNode != null)
				&& (anEntry.compareTo(currentNode.getData()) > 0))
		{
			nodeBefore = currentNode;
			currentNode = currentNode.getNext();
		}
		return nodeBefore;
	}

	public T getEntry(int givenPosition)
	{
		T result = null; // result to return

		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();
			result = getNodeAt(givenPosition).getData();
		} // end if

		return result;
	} // end getEntry

	private Node getNodeAt(int givenPosition)
	{
		assert !isEmpty() && (1 <= givenPosition)
				&& (givenPosition <= numberOfEntries);
		Node currentNode = firstNode;

		// traverse the list to locate the desired node
		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.getNext();

		assert currentNode != null;
		return currentNode;
	} // end getNodeAt

	public T remove(int givenPosition)
	{
		T result = null; // return value

		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();

			if (givenPosition == 1) // case 1: remove first entry
			{
				result = firstNode.getData(); // save entry to be removed
				firstNode = firstNode.getNext();
				if (numberOfEntries == 1)
					lastNode = null; // solitary entry was removed
			} else // case 2: givenPosition > 1
			{
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.getNext();
				Node nodeAfter = nodeToRemove.getNext();
				nodeBefore.setNext(nodeAfter); // disconnect the node to be
												// removed
				result = nodeToRemove.getData(); // save entry to be removed

				if (givenPosition == numberOfEntries)
					lastNode = nodeBefore; // last node was removed
			} // end if

			numberOfEntries--;
		} // end if

		return result; // return removed entry, or
		// null if operation fails
	} // end remove

	// Problem 2
	@SuppressWarnings("unchecked")
	public T mode(SortedList<String> list)
	{
		int counter = 0;
		String tempString = null;
		for (int i = 0; i < list.getLength(); i++)
		{
			if (list.getEntry(0).compareTo(list.getEntry(1)) == 0)
			{
				tempString = list.getEntry(0);
				counter++;
			} else if (list.getEntry(0).compareTo(list.getEntry(1)) == 1)
			{
				counter = 0;

			}
		} // end if
		return (T) tempString;
	} // end Mode
	
	/*
	 * problem 2b and 2c
	 * the big O for both these algorithms would be O(n) since there is 
	 * only one for loop. it iterates based on the length of the list, so the 
	 * type is irrelevant. 
	 * 
	 */

	// problem 3
	public boolean contains(T anEntry)
	{
		return getPosition(anEntry) > 0;
	} // end contains

	// problem 4
	public void mergeList(List<T> list)
	{
		for (T elem : list)
		{
			add(elem);
		}
	}

	public void mergeListArray(List<T> list)
	{
		Node place = firstNode;
		Node previous = null;

		for (T elem : list)
		{
			if (elem.compareTo(place.getData()) >= 0)
			{
				previous = new Node(elem, place);
			} else
			{
				previous = place;
				place = new Node(elem, previous.getNext());
				previous.setNext(place);
			}
		}
	}

	public void mergeListLinked(SortedList list)
	{
		while (list.getFirstNode() != null)
		{
			add((T) list.remove(0));
		}
	}

	public void clear()
	{
		firstNode = null;
		numberOfEntries = 0;
	}

	public int getLength()
	{
		return numberOfEntries;
	}

	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	}

	@Override
	public T[] toArray()
	{
		int numberOfEntries = getLength();
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[numberOfEntries];
		int index = 0;
		Node currentNode = getFirstNode();
		while ((index < numberOfEntries) && (currentNode != null))
		{
			result[index] = currentNode.getData();
			currentNode = currentNode.getNext();
			index++;
		}
		return result;
	}

	private Node getFirstNode()
	{
		return firstNode;
	}

} // end LinkedSortedList

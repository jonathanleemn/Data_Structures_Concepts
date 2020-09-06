package lab;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A class that implements the ADT list by using a chain of nodes. The list has
 * an iterator. The class is similar to LList.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 4.0

 * Implementations of the following methods found at
 * https://github.com/richardszeto/Java/blob/master/Graphs/LabX/LinkedListWithIterator.java
 */
 
public class LinkedListWithIterator<T> implements ListWithIteratorInterface<T>
{
	private Node firstNode;
	private int numberOfEntries;;

	public LinkedListWithIterator()
	{
		clear();
	} // end default constructor

	/*
	 * < Implementations of the methods of the ADT list go here; you can see
	 * them in Chapter 14, beginning at Segment 14.7 > . . .
	 */

	public Iterator<T> iterator()
	{
		return new IteratorForLinkedList();
	} // end iterator

	public Iterator<T> getIterator()
	{
		return iterator();
	} // end getIterator

	private class IteratorForLinkedList implements Iterator<T>
	{
		private Node nextNode;

		private IteratorForLinkedList()
		{
			nextNode = firstNode;
		} // end default constructor

		// 15.11
		public T next()
		{
			if (hasNext())
			{
				Node returnNode = nextNode; // Get next node
				nextNode = nextNode.getNextNode(); // Advance iterator

				return returnNode.getData(); // Return next entry in iteration
			} else
				throw new NoSuchElementException("Illegal call to next(); "
						+ "iterator is after end of list.");
		} // end next

		// 15.12
		public boolean hasNext()
		{
			return nextNode != null;
		} // end hasNext

		// 15.13
		public void remove()
		{
			throw new UnsupportedOperationException(
					"remove() is not " + "supported by this iterator");
		} // end remove
	} // end IteratorForLinkedList

	private class Node
	{
		private T data; // Entry in list
		private Node next; // Link to next node

		private Node(T dataPortion)
		{
			data = dataPortion;
			next = null;
		} // end constructor

		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;
		} // end constructor

		private T getData()
		{
			return data;
		} // end getData

		private void setData(T newData)
		{
			data = newData;
		} // end setData

		private Node getNextNode()
		{
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} // end setNextNode
	} // end Node

	
	@Override
	public void add(T newEntry)
	{
		Node newNode = new Node(newEntry);

		if (isEmpty())
			firstNode = newNode;
		else // add to end of nonempty list
		{
			Node lastNode = getNodeAt(numberOfEntries);
			lastNode.next = newNode; // make last node reference new node
		} // end if

		numberOfEntries++;
	}

	@Override
	public void add(int newPosition, T newEntry)
	{
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1))
		{
			Node newNode = new Node(newEntry);

			if (isEmpty() || (newPosition == 1)) // case 1: add to beginning of
													// list
			{
				newNode.next = firstNode;
				firstNode = newNode;
			} else // case 2: list is not empty and newPosition > 1
			{
				Node nodeBefore = getNodeAt(newPosition - 1);
				Node nodeAfter = nodeBefore.next;
				newNode.next = nodeAfter;
				nodeBefore.next = newNode;
			} // end if

			numberOfEntries++;
		}
	}

	@Override
	public T remove(int givenPosition)
	{
		T result = null; // return value

		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();

			if (givenPosition == 1) // case 1: remove first entry
			{
				result = firstNode.data; // save entry to be removed
				firstNode = firstNode.next;
			} else // case 2: givenPosition > 1
			{
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.next;
				Node nodeAfter = nodeToRemove.next;
				nodeBefore.next = nodeAfter; // disconnect the node to be
												// removed
				result = nodeToRemove.data; // save entry to be removed
			} // end if

			numberOfEntries--;
		} // end if

		return result; // return removed entry, or
						// null if operation fails
	}

	@Override
	public void clear()
	{
		firstNode = null;
		numberOfEntries = 0;
	} // end clear

	@Override
	public T replace(int givenPosition, T newEntry)
	{
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();

			Node desiredNode = getNodeAt(givenPosition);
			desiredNode.data = newEntry;
		}
		return newEntry;
	} // end replace

	@Override
	public T getEntry(int givenPosition)
	{
		T result = null; // result to return

		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();
			result = getNodeAt(givenPosition).data;
		} // end if

		return result;
	}

	private Node getNodeAt(int givenPosition)
	{
		assert !isEmpty() && (1 <= givenPosition)
				&& (givenPosition <= numberOfEntries);
		Node currentNode = firstNode;

		// traverse the list to locate the desired node
		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.next;

		assert currentNode != null;
		return currentNode;
	} // end getNodeAt

	@Override
	public T[] toArray()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T anEntry)
	{
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		} // end while

		return found;
	} // end contains

	@Override
	public int getLength()
	{
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty()
	{
		boolean result;

		if (numberOfEntries == 0) // or getLength() == 0
		{
			assert firstNode == null;
			result = true;
		} else
		{
			assert firstNode != null;
			result = false;
		} // end if

		return result;
	}

} // end LinkedListWithIterator

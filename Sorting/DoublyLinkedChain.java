 

/**
 * A class that implements a deque of objects by using a chain of doubly linked
 * nodes.
 * 
 */
public class DoublyLinkedChain<T>
{
	private DLNode firstNode; // references node for front of deque
	private DLNode lastNode; // references node for back of deque

	public DoublyLinkedChain()
	{
		firstNode = null;
		lastNode = null;
	} // end default constructor

	 
	//problem 1a and 1b
	private class DLNode
	{
		private T data; // deque entry
		private DLNode next; // link to next node
		private DLNode previous; // link to previous node

		public T getData()
		{
			return data;
		}

		public void setData(T data)
		{
			this.data = data;
		}

		public DLNode getNext()
		{
			return next;
		}

		public void setNext(DLNode next)
		{
			this.next = next;
		}

		public DLNode getPrevious()
		{
			return previous;
		}

		public void setPrevious(DLNode previous)
		{
			this.previous = previous;
		}
	} // end DLNode

	//problem 1c
	public void addToFront(T newEntry)
	{
		DLNode newNode = new DLNode();
		if (isEmpty())
			lastNode = newNode;
		else
			firstNode.setPrevious(newNode);
		firstNode = newNode;
	} // end addToFront

	public void addToBack(T newEntry)
	{
		DLNode newNode = new DLNode();
		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.setNext(newNode);
		lastNode = newNode;
	} // end addToBack

	//problem 1d
	public T removeFront()
	{
		T front = null;
		if (!isEmpty())
		{
			front = firstNode.getData();
			firstNode = firstNode.getNext();
			if (firstNode == null)
				lastNode = null;
		} // end if
		return front;
	} // end removeFront

	public T removeBack()
	{
		T back = null;
		if (!isEmpty())
		{
			back = lastNode.getData();
			lastNode = lastNode.getPrevious();
			if (lastNode == null)
				firstNode = null;
			else
				lastNode.setNext(null);
		} // end if
		return back;
	} // end removeBack

	public boolean isEmpty()
	{
		return firstNode == null;
	}

} // end LinkedDeque
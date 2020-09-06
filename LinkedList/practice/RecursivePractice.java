package practice;

public class RecursivePractice
{

	public static void main(String[] args)
	{
		// create some nodes
		Node one = new Node(1); // puts 1 into the node
		Node two = new Node(2); // puts 2 into the node
		Node three = new Node(3); // puts 3 into the node
		one.setNext(two);
		two.setNext(three);

		// use listbuilder class, independent of nodes created above
		List ll = new List();
		ll.addToBack(1);
		ll.addToBack(2);
		ll.addToBack(3);
		ll.addToBack(4);
		ll.displayList();

		System.out.println("Length of list is " + ll.length());

		ll.removeFront();
		ll.sumOfList();
		// ll.removeFirstOccurance(4);
		ll.displayList();

		// recursive versions
		System.out.println("Contains 12? " + ll.rcontains(12));
		System.out.println("Contains 6? " + ll.rcontains(6));
		ll.displayList();
		ll.addToBack(1);
		//System.out.println("Smallest is: " + ll.rfindSmallest());
		ll.displayList();
		System.out.println("Length: " + ll.rlength());
		//ll.rinsertAtBack(14);
		ll.displayList();

	}
}

class List
{
	private Node head;

	public List()
	{
		head = null;
	}

	public boolean rcontains(int item)
	{
		return rcontains(item, head);
	}

	public boolean rcontains(int item, Node n)
	{
		if (n == null)
		{
			return false;
		} 
		else
		{
			if (item == n.datum())
			{
				return true;
			} 
			else
			{
				return rcontains(item, n.next());
			}
		}
	}

	public void addToBack(int item)
	{
		Node current = head;

		if (current == null)
		{
			head = new Node(item, current);
			head.setNext(null);
		} else
		{
			while (current.next() != null)
			{
				current = current.next();
			}
			Node n = new Node(item, null); // append new node to back
			current.setNext(n);
		}
	}

	public void insertAtFront(int item)
	{
		head = new Node(item, head);
	}

	public int length()
	{
		Node place = head;
		int i = 0;

		while (place != null)
		{
			i++;
			place = place.next();
		}
		return i;
	}

	public boolean contains(int item)
	{
		Node place = head;
		Node previous = null;
		boolean exists = false;

		while (place != null)
		{
			if (place.datum() == item)
			{
				if (place == head)
				{
					exists = true;
					break;
				} else
				{
					previous = place;
				}
			}
			place = place.next();
		}
		return exists;
	}

	public void displayList()
	{
		Node place = head;
		while (place != null)
		{
			System.out.print(place.datum() + " ");
			place = place.next();
		}
		System.out.println();
	}

	public boolean isEmpty()
	{
		return head == null;
	}

	public int removeFront()
	{
		Node front = head;
		head = head.next();
		return front.datum();
	}

	public int sumOfList()
	{
		int sum = 0;
		Node place = head;
		while (place != null)
		{
			sum += place.datum();
			place = place.next();
		}
		return sum;
	}

	public void rdeleteAll(int item)
	{
		head = rdeleteAll(head, item);
	}

	public Node rdeleteAll(Node n, int item)
	{
		if (n == null)
		{
			return null;
		} else
		{
			n = n.next();
			if (n.datum() == item)
			{
				n = rdeleteAll(n.next(), item);
			}
		}
		return n;
	}

	public int rfindSmallest()
	{
		if (isEmpty())
		{
			throw new RuntimeException("Nothing in list");
		}
		Node n = head;
		int min = n.datum();
		return rfindSmallest(n, min);
	}

	public int rfindSmallest(Node n, int min)
	{
		if (min > n.datum())
		{
			min = n.datum();
			return rfindSmallest(n.next(), min);
		}
		return min;
	}

	public int rlength()
	{
		return rlength(head);
	}

	public int rlength(Node n)
	{
		if (n == null)
			return 0;
		else
			return 1 + rlength(n.next());
	}

	public void rinsertAtBack(int item)
	{
		if (head == null)
			insertAtFront(item);
		else
		{
			rinsertAtBack(head, item);
		}
	}
	
	public void rinsertAtBack(Node n, int item)
	{
		if(n.next() != null)
			rinsertAtBack(n.next(), item);
		else
		{
			n = new Node(item, null);
		}
	}

}

package practice;
//driver class
public class LinkedListPractice
{
	public static void main(String[] args)
	{
		Node one = new Node(1); // puts 1 into the node
		Node two = new Node(2); // puts 2 into the node
		Node three = new Node(3); //puts 3 into the node
		// links nodes one and two
		one.setNext(two);
		System.out.println(one.datum()); //prints out the stuff in node one
		System.out.println();

		ListBuilder lb = new ListBuilder();
		lb.addToBack(10);
		lb.addToBack(12);
		lb.addToBack(14);
		lb.displayList();
		lb.insertAtFront(8);
		lb.displayList();
		System.out.println("Length: " + lb.length());
		System.out.println("Is empty? " + lb.isEmpty());
		System.out.println(lb.removeFront() + " removed from front");
		lb.displayList();
		System.out.println("Sum of list: " + lb.sumOfList());
		System.out.println("5 in list? " + lb.contains(5));

	}
}

// building block
class Node
{
	private int datum;
	private Node next;

	public Node(int datum)
	{
		this.datum = datum;
	}

	public Node(int datum, Node next)
	{
		this.datum = datum;
		this.next = next;
	}

	public void setNext(Node next)
	{
		this.next = next;
	}

	public int datum()
	{
		return datum;
	}

	public Node next()
	{
		return next;
	}
}

class ListBuilder
{
	private Node head;

	public ListBuilder()
	{
		head = null;
	}

	public void addToBack(int item)
	{
		Node current = head;

		if (current == null)
		{
			head = new Node(item, current);
			head.setNext(null);
		} 
		else
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
}
package lab;

class LinkedList
{
	private Node head;

	public void add(int position, int newEntry)
	{
		Node current = head;
		Node nextOne;

		if (position == 0)
		{
			insertAtFront(newEntry);
		} else
		{
			int counter = 1;
			while (current.next() != null && counter < position)
			{
				current = current.next();
				counter++;
			}

			nextOne = current.next();
			Node n = new Node(newEntry, null);
			current.setNext(n);
			n.setNext(nextOne);
		}
	}

	public void r_add(int position, int newEntry)
	{
		int counter = 1;
		if (head == null)
		{
			insertAtFront(newEntry);
		} else
		{
			Node current = head;
			current = r_add(current, position, newEntry, counter);

			Node nextOne = current.next();
			Node n = new Node(newEntry, null);
			current.setNext(n);
			n.setNext(nextOne);
		}
	}

	public Node r_add(Node n, int position, int newEntry, int counter)
	{
		if (n.next() != null && counter < position)
		{
			counter++;
			return r_add(n.next(), position, newEntry, counter);
		}

		return n;
	}

	public int remove(int position)
	{
		if (position == 0)
		{
			head = head.next();
			return head.datum();
		}

		else
		{
			Node current = head;
			Node tailEnd = current.next();

			for (int i = 0; i < position - 1; i++)
			{
				current = current.next();
			}
			Node removed = current.next();

			tailEnd = current.next().next();
			current.setNext(tailEnd);

			return removed.datum();
		}

	}

	public int r_remove(int position)
	{
		int counter = 1;
		if (position == 0)
		{
			head = head.next();
			return head.datum();
		}

		else
		{
			Node current = head;
			Node tailEnd = current.next();

			return (r_remove(current.next(), position, counter++, current));

		}

	}

	public int r_remove(Node n, int position, int counter, Node previous)
	{

		if (counter < position)
		{
			counter++;
			return r_remove(n.next(), position, counter, n);
		}

		previous.setNext(n.next());

		return n.datum();
	}

	public void clear()
	{
		head = null;
	}

	public void r_clear()
	{
		head = r_clear(head);
	}

	public Node r_clear(Node n)
	{
		if (n == null)
			return null;
		else
		{
			while (n != null)
			{
				n = r_clear(n.next());
			}
		}
		return n;
	}

	public int replace(int position, int newEntry)
	{
		Node current = head;
		Node nextOne;
		int replaced;

		if (position == 0)
		{
			replaced = current.datum();
			nextOne = current.next();
			head = new Node(newEntry, head);
			head.setNext(nextOne);
		}

		else
		{
			int counter = 1;
			while (current.next() != null && counter < position)
			{
				current = current.next();
				counter++;
			}

			replaced = current.next().datum();
			nextOne = current.next().next();
			Node n = new Node(newEntry, null);
			current.setNext(n);
			n.setNext(nextOne);
		}
		return replaced;
	}

	public int r_replace(int position, int newEntry)
	{
		Node current = head;
		Node nextOne;
		int replaced = 0;

		if (position == 0)
		{
			replaced = current.datum();
			nextOne = current.next();
			head = new Node(newEntry, head);
			head.setNext(nextOne);
		}

		else
		{
			int counter = 1;
			if (current.next() != null)
			{

				return r_replace(current.next(), position, newEntry, counter, current);
			}
		}
		return replaced;
	}

	public int r_replace(Node n, int position, int newEntry, int counter, Node previous)
	{

		if (n != null && counter < position)
		{
			counter++;
			System.out.println(counter);
			return r_replace(n.next(), position, newEntry, counter, n);
		} else
		{

			int replaced = n.datum();
			Node nextOne = n.next();
			Node n1 = new Node(newEntry, null);
			previous.setNext(n1);
			n1.setNext(nextOne);
			System.out.println("replaced " + replaced);
			return replaced;
		}

	}

	public int getEntry(int position)
	{
		Node current = head;
		int counter = 0;
		while (current != null && counter < position)
		{
			current = current.next();
			counter++;
		}
		return current.datum();
	}

	public int r_getEntry(int position)
	{
		int counter = 1;
		if (isEmpty())
		{
			throw new RuntimeException("Nothing in list");
		}
		Node n = head;
		if (position == 0)
		{
			return n.datum();
		}
		return r_getEntry(n.next(), position, counter);
	}

	public int r_getEntry(Node n, int position, int counter)
	{

		if (n != null && counter < position)
		{
			counter++;
			System.out.println(counter + "  " + n.datum());
			return r_getEntry(n.next(), position, counter);
		}

		return n.datum();
	}

	public int[] toArray()
	{
		if (isEmpty())
		{
			throw new RuntimeException("Nothing in list");
		}
		Node current = head;
		Node nextOne;
		int counter = 1;
		int[] array = new int[getLength()];

		array[counter] = current.datum();

		for (counter = 0; counter < getLength(); counter++)
		{
			array[counter] = getEntry(counter);
		}
		return array;
	}

	public int[] r_toArray()
	{
		if (isEmpty())
		{
			throw new RuntimeException("Nothing in list");
		}

		Node current = head;
		Node nextOne;
		int counter = 1;
		int[] array = new int[getLength()];

		array[counter] = current.datum();

		if (current.next() == null)
		{
			return array;
		} else
		{
			return r_toArray(current.next(), counter, array);
		}
	}

	public int[] r_toArray(Node n, int counter, int[] array)
	{
		counter++;
		if (n.next() == null)
		{
			array[counter] = n.datum();
			return array;
		} else
		{
			array[counter] = n.datum();
			return r_toArray(n.next(), counter, array);
		}
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

	public boolean r_contains(int item)
	{
		Node place = head;
		Node previous = null;
		boolean exists = false;

		if (place != null)
		{
			if (place.datum() == item)
			{
				return exists = true;
			} else
			{
				return r_contains(place.next(), item, exists);
			}
		} else
		{
			return exists;
		}
	}

	public boolean r_contains(Node n, int item, boolean exists)
	{
		if (n != null)
		{
			if (n.datum() == item)
			{
				return exists = true;
			} else
			{
				return r_contains(n.next(), item, exists);
			}
		} else
		{
			return exists;
		}
	}

	// returns the number of nodes within the linkedlist
	public int getLength()
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

	public int r_getLength()
	{
		Node place = head;
		int i = 0;

		if (place != null)
		{
			i++;
			return r_getLength(place.next(), i);
		} else
		{
			return i;
		}
	}

	public int r_getLength(Node place, int i)
	{
		if (place.next() != null)
		{
			i++;
			return r_getLength(place.next(), i);
		} else
		{
			i++;
			return i;
		}
	}

	// returns true if the list is empty, false otherwise
	public boolean isEmpty()
	{
		Node n = head;
		int counter = 0;

		while (n != null)
		{
			counter++;
			n = n.next();
		}
		return counter == 0;
	}

	public boolean r_isEmpty()
	{
		Node n = head;
		int counter = 0;

		if (n != null)
		{
			counter++;
			return r_isEmpty(n, counter);
		}
		return counter == 0;
	}

	public boolean r_isEmpty(Node n, int counter)
	{

		if (n != null)
		{
			counter++;
			return r_isEmpty(n.next(), counter);
		}
		return counter == 0;
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

	public void r_addToBack(int item)
	{
		if (head == null)
		{
			insertAtFront(item);
		} else
		{
			r_addToBack(head, item);
		}
	}

	public void r_addToBack(Node n, int item)
	{
		if (n.next() != null)
		{
			r_addToBack(n.next(), item);
		} else
		{
			n = new Node(item, null);
		}
	}

	public void insertAtFront(int item)
	{
		head = new Node(item, head);
	}

	public void removeHeadNode()
	{
		Node current = head;
		head = current.next();
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

	public void deleteFirstOccurence(int item)
	{
		Node current = head;
		int counter = 0;
		while (current != null)
		{
			if (current.datum() == item)
			{
				remove(counter);
			}
			counter++;
			current = current.next();
		}
	}

	public Node r_deleteFirstOccurrence(Node n, int item)
	{
		if (n == null)
			return null;
		else if (n.datum() == item)
			return n.next();
		else
		{
			n.setNext(r_deleteFirstOccurrence(n.next(), item));
			return n;
		}
	}

	public void r_deleteFirstOccurrence(int item)
	{
		head = r_deleteFirstOccurrence(head, item);
	}

	public void deleteAll(int item)
	{
		Node current = head;
		int counter = 0;
		while (current != null)
		{
			if (current.datum() == item)
			{
				remove(counter);
			}
			counter++;
			current = current.next();
		}
	}

	public void r_deleteAll(int item)
	{
		head = r_deleteAll(head, item);
	}

	public Node r_deleteAll(Node n, int item)
	{
		if (n == null)
		{
			return null;
		} else
		{
			n = n.next();
			if (n.datum() == item)
			{
				n = r_deleteAll(n.next(), item);
			}
		}
		return n;
	}

	public int summarize()
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

	public int r_summarize()
	{
		if (isEmpty())
		{
			throw new RuntimeException("Nothing in list");
		}
		Node n = head;
		int total = n.datum();

		return r_summarize(n.next(), total);
	}

	public int r_summarize(Node n, int total)
	{

		if (n.next() != null)
		{
			total += n.datum();
			return r_summarize(n.next(), total);
		} else
		{
			return total += n.datum();
		}
	}

	public int findSmallest()
	{
		if (isEmpty())
		{
			throw new RuntimeException("Nothing in list");
		}
		Node n = head;
		int min = n.datum();

		while (n.next() != null)
		{

			if (min > n.datum())
				min = n.datum();

			n = n.next();
		}
		return min;
	}

	public int r_findSmallest()
	{
		if (isEmpty())
		{
			throw new RuntimeException("Nothing in list");
		}
		Node n = head;
		int min = n.datum();
		return r_findSmallest(n.next(), min);
	}

	public int r_findSmallest(Node n, int min)
	{

		if (n.next() != null)
		{

			if (min > n.datum())
				min = n.datum();

			return r_findSmallest(n.next(), min);
		}
		return min;
	}

	public void removeSmallest()
	{
		Node current = head;
		int counter = 0;
		int smallest = findSmallest();
		while (current != null)
		{
			if (current.datum() == smallest)
			{
				remove(counter);
			}
			counter++;
			current = current.next();
		}
	}

	public void r_removeSmallest()
	{
		Node current = head;
		int counter = 0;
		int smallest = findSmallest();
		if (current != null)
		{
			if (current.datum() == smallest)
			{
				remove(counter);
			}
			if (current.next() != null)
			{
				counter++;
				r_removeSmallest(current.next(), smallest, counter);
			}
		}
	}

	public void r_removeSmallest(Node n, int smallest, int counter)
	{

		if (n.datum() == smallest)
		{
			remove(counter);
			counter--;
		}
		if (n.next() != null)
		{
			System.out.println(counter);
			counter++;
			r_removeSmallest(n.next(), smallest, counter);
		}

	}

	public Node makeReverse()
	{
		Node previous = null;
		Node place = head;
		Node next = null;

		while (place != null)
		{
			next = place.next();
			place.setNext(previous);
			previous = place;
			place = next;

		}
		head = previous;

		return head;
	}
	
	public void r_makeReverse()
	{
		r_makeReverse(head);
	}
	
	public void r_makeReverse(Node curr)
	{
		if(curr == null)
		{
			return;
		}
		
		if(curr.next() == null)
		{
			this.head = curr;
			return;
		}
		
		r_makeReverse(curr.next());
		curr.next().setNext(curr);
		curr.setNext(null);
	}
}
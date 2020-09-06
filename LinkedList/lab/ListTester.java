package lab;

import java.util.ArrayList;

public class ListTester
{
	public static void main(String[] args)
	{
		LinkedList LL = new LinkedList();
		List AL = new List();

		LL.addToBack(1);
		LL.addToBack(4);
		LL.addToBack(5);
		LL.addToBack(8);
		LL.addToBack(1);
		LL.addToBack(2);
		LL.addToBack(5);
		LL.addToBack(0);
		LL.addToBack(2);
		LL.addToBack(0);
		LL.addToBack(65);
		LL.addToBack(5);

		LL.displayList();
		LL.makeReverse();
		LL.displayList();

	}
}





class List
{
	public ArrayList list = new ArrayList();

	public void addEntry(int entry)
	{
		list.add(entry);
	}

	public void addEntry(int position, int entry)
	{
		list.add(position, entry);
	}

	public int removeEntry(int position)
	{
		return (int) list.remove(position);
	}

	public void clear()
	{
		for (int i = 0; i < list.size(); i++)
		{
			list.remove(0);
		}
	}

	public int replace(int position, int entry)
	{
		return 0;
	}

	public int getEntry(int position)
	{
		return (int) list.get(position);
	}

	public void toArray()
	{
		list.toArray();
	}

	public boolean contains(int item)
	{
		return list.contains(item);
	}

	public int getLength()
	{
		return 0;
	}

	public void addToBack(int entry)
	{
		list.add(entry);
	}

	public void insertAtFront(int entry)
	{
		list.add(0, entry);
	}

	public void removeHeadNode()
	{
		list.remove(0);
	}

	public void displayList()
	{
		for (int i = 0; i < list.size(); i++)
		{
			System.out.print(list.get(i) + " ");
		}
	}

	public void deleteFirstOccurence(int item)
	{
		list.remove(list.indexOf(item));
	}

	public void deleteAll(int item)
	{
		for (int i = 0; i < list.size(); i++)
		{
			if ((int) list.get(i) == item)
			{
				list.remove(i);
			} else
			{
			}
		}
	}

	public int summarize()
	{
		int sum = 0;

		for (int i = 0; i < list.size(); i++)
		{
			sum += (int) list.get(i);
		}

		return sum;
	}

	public int findSmallest()
	{
		int small = (int) list.get(0);

		for (int i = 0; i < list.size(); i++)
		{
			if ((int) list.get(i) < small)
			{
				small = (int) list.get(i);
			}
		}
		return small;
	}

	public int removeSmallest()
	{
		int removed = findSmallest();
		deleteFirstOccurence(findSmallest());
		return removed;
	}

	public ArrayList makeReverse()
	{
		for (int i = 0, j = list.size() - 1; i < j; i++)
		{
			list.add(i, list.remove(j));
		}
		return list;
	}
}
package lab;

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

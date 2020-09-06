import java.util.Iterator;

public class BinaryTreeTest
{
	public static void main(String[] args) throws Exception
	{
		BinaryTreeInterface<String> a = new ArrayBinaryTree<>();
		BinaryTreeInterface<String> b = new ArrayBinaryTree<>();
		BinaryTreeInterface<String> c = new ArrayBinaryTree<>();
				
		a.setTree("A", null, null);
		b.setTree("B", null, null);
		c.setTree("C", null, null);
		
		System.out.println("\nTree node count: " + c.getNumberOfNodes() + "\nTree height: " + c.getHeight());
		System.out.println("\nLevel order traversal: ");
		Iterator<String> iter = c.getLevelOrderIterator();
		while (iter.hasNext())
		{
			System.out.print(iter.next() + " "); /* output: A B C */
		}
	}
}
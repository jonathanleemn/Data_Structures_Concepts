import java.util.Iterator;

/*
 * Source: https://github.com/jssf/ArrayBinaryTree/blob/master/ArrayBinaryTree.java
 */
public class ArrayBinaryTree<T> implements BinaryTreeInterface<T>
{
	private BinaryTreeInterface<T> root;
	private T theData[];
	private int height; // height of tree
	private int size; // number of locations in array for a full tree of this
						// height
	ArrayBinaryTree<T> leftTree, rightTree;

	@Override
	public Iterator<T> getPreorderIterator()
	{
		return root.getPostorderIterator();
	}

	@Override
	public Iterator<T> getPostorderIterator()
	{
		return root.getPostorderIterator();
	}

	@Override
	public Iterator<T> getInorderIterator()
	{
		return root.getInorderIterator();
	}

	@Override
	public Iterator<T> getLevelOrderIterator()
	{
		return root.getLevelOrderIterator();
	}

	@Override
	public void setTree(T rootData)
	{
		privateSetTree(rootData, new ArrayBinaryTree<T>(), new ArrayBinaryTree<T>());
	}

	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree)
	{
		if (leftTree == null)
			leftTree = new ArrayBinaryTree<T>();
		if (rightTree == null)
			rightTree = new ArrayBinaryTree<T>();
		privateSetTree(rootData, (ArrayBinaryTree<T>) leftTree, (ArrayBinaryTree<T>) rightTree);

	}

	public void privateSetTree(T rootData, ArrayBinaryTree<T> leftTree, ArrayBinaryTree<T> rightTree)
	{
		height = 1 + Math.max(leftTree.getHeight(), rightTree.getHeight());

		size = getSizeFromHeight(height);

		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[size];
		theData = temp;

		theData[0] = rootData;
		setLeftSubtree(leftTree);
		setRightSubtree(rightTree);

	}

	private void setRightSubtree(ArrayBinaryTree<T> subTree)
	{
		// IT TAKES IN THE VALUES OF THE LEFT SUBTREE AND ADDS THEM TO THE ARRAY

		int subTreeIndex = 0;
		int nodesInRow = 1;
		int firstIndex = 0;
		int lastIndex = 0;
		for (int a = 1; a <= subTree.height; a++)
		{
			lastIndex = 2 * lastIndex + 2;
			firstIndex = lastIndex - nodesInRow + 1;
			int currentIndex = firstIndex;

			for (int b = firstIndex; b <= lastIndex; b++)
			{
				theData[currentIndex] = subTree.theData[subTreeIndex];
				currentIndex++;
				subTreeIndex++;
			}

			nodesInRow = 2 * nodesInRow;
		}
	}

	private void setLeftSubtree(ArrayBinaryTree<T> subTree)
	{
		// IT TAKES IN THE VALUES OF THE LEFT SUBTREE AND ADDS THEM TO THE ARRAY

		int subTreeIndex = 0;
		int nodesInRow = 1;
		int firstIndex = 0;
		int lastIndex = firstIndex + nodesInRow - 1;
		for (int a = 1; a <= subTree.getHeight(); a++)
		{
			firstIndex = 2 * firstIndex + 1;
			lastIndex = firstIndex + nodesInRow - 1;
			int currentIndex = firstIndex;

			for (int b = firstIndex; b <= lastIndex; b++)
			{
				theData[currentIndex] = subTree.theData[subTreeIndex];
				currentIndex++;
				subTreeIndex++;
			}

			nodesInRow = 2 * nodesInRow;
		}
	}

	private int getSizeFromHeight(int h)
	{
		// IT CALCULATES THE SIZE OF THE ARRAY NEEDED TO ACCOMODATE A TREE OF
		// HEIGHT H
		return (int) Math.round(Math.pow(2.0, (double) h) - 1.0);
	}

	@Override
	public T getRootData()
	{
		return root.getRootData();
	}

	@Override
	public int getHeight()
	{
		return root.getHeight();
	}

	@Override
	public int getNumberOfNodes()
	{
		return root.getNumberOfNodes();
	}

	@Override
	public boolean isEmpty()
	{
		return root.isEmpty();
	}

	@Override
	public void clear()
	{
		root.clear();
	}

}
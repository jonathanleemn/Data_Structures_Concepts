public interface BinaryTreeInterface<T> extends TreeInterface<T>, TreeIteratorInterface<T>
{
	// Set binary tree to new one-node binary tree using object that
	public void setTree(T rootData);

	// Set this binary tree to a new binary tree with rootData, leftTree,
	// rightTree
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree);

	// other methods
	public T getRootData();

	public int getHeight();

	public int getNumberOfNodes();

	public boolean isEmpty();

	public void clear();
}
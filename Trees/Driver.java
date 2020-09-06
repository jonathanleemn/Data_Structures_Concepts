public class Driver
{
	public static void main(String[] args) throws Exception
	{
//		TreeNode tree = new TreeNode('A', new TreeNode('B', new TreeNode('D'), new TreeNode('E')),
//				new TreeNode('C', new TreeNode('F'), new TreeNode('G')));

		BinaryTree<Integer> t = BinaryTree.btree(1, BinaryTree.btree(2, BinaryTree.btree(3), BinaryTree.btree(4)),
				BinaryTree.btree(5, BinaryTree.btree(6), BinaryTree.btree(7)));
		
		System.out.println(t.toString());

		System.out.println(t.height());

	}
}

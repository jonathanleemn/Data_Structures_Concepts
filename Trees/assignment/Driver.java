package assignment;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Driver
{
	public static <T> void main(String args[]) throws NoSuchAlgorithmException
	{
		List<String> tempTxList = new ArrayList<String>();
		tempTxList.add("a");
		tempTxList.add("b");
		tempTxList.add("c");
		tempTxList.add("d");
		MerkleTrees mt = new MerkleTrees(tempTxList);
		mt.merkle_tree();

//		System.out.println(mt.nodeTxList.get(0).getHash());
//		System.out.println(mt.nodeTxList.get(1).getHash());
//		System.out.println(mt.nodeTxList.get(2).getHash());
//		System.out.println(mt.nodeTxList.get(3).getHash());
//		String hash1 = MerkleTrees.hash(mt.nodeTxList.get(0).getHash() + mt.nodeTxList.get(1).getHash());
//		String hash2 = MerkleTrees.hash(mt.nodeTxList.get(2).getHash() + mt.nodeTxList.get(3).getHash());
//		String hash3 = MerkleTrees.hash(hash1 + hash2);
//		System.out.println(hash3);

		validateKeys(mt, tempTxList);
		validateMerkleTree(mt, mt);
		System.out.println("Ending Balance (number of transactions): " + mt.balance);
	}

	static void validateKeys(MerkleTrees stored, List<String> tempTxList)
	{
		MerkleTrees temp = new MerkleTrees(tempTxList);
		temp.merkle_tree();
		
		if(stored.getRoot().equals(temp.getRoot()))
		{
			System.out.println("These keys are valid.");
		}
		else
			System.out.println("These keys are NOT valid.");
	}

	static void validateMerkleTree(MerkleTrees stored, MerkleTrees copy)
	{
		if (stored.getRoot().equals(copy.getRoot()))
		{
			System.out.println("This Merkle Tree is valid.");
		}
		else
			System.out.println("This Merkle Tree is NOT valid.");
	}
}

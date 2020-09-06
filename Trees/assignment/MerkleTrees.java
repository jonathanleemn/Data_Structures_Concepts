package assignment;

import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/*
 * Source: http://java-lang-programming.com/en/articles/29
 */
public class MerkleTrees
{
	// transaction List
	List<String> txList;
	// Merkle Root
	String root;
	
	static String hashValue;
	BinaryNode node;
	List<BinaryNode> nodeTxList = new ArrayList<BinaryNode>();
	int balance = 0;

	/**
	 * constructor
	 * 
	 * @param txList
	 *            transaction List
	 */
	public MerkleTrees(List<String> txList)
	{
		this.txList = txList;
		root = "";
	}

	/**
	 * execute merkle_tree and set root.
	 * @param <T>
	 */
	public <T> void merkle_tree()
	{
		List<String> tempTxList = new ArrayList<String>();
		
		for (int i = 0; i < this.txList.size(); i++)
		{
			tempTxList.add(this.txList.get(i));
			//tempTxList.add(hash(this.txList.get(i)));
			BinaryNode tempNode = new BinaryNode(this.txList.get(i), hash(this.txList.get(i)));
			nodeTxList.add(tempNode);
		}

		List<String> newTxList = getNewTxList(tempTxList);
		while (newTxList.size() != 1)
		{
			newTxList = getNewTxList(newTxList);
	
		}

		this.root = newTxList.get(0);
	}

	/**
	 * return Node Hash List.
	 * 
	 * @param tempTxList
	 * @return
	 */
	private List<String> getNewTxList(List<String> tempTxList)
	{
		List<String> newTxList = new ArrayList<String>();

		int index = 0;
		while (index < tempTxList.size())
		{
			// left
			String left = tempTxList.get(index);
			index++;

			// right
			String right = "";
			if (index != tempTxList.size())
			{
				right = tempTxList.get(index);
			}

			// sha2 hex value
			String sha2HexValue = hash(left + right);
			newTxList.add(sha2HexValue);
			
			balance++;
			index++;
			System.out.println(hashValue);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			System.out.println("Transaction Successful." );
			System.out.println(timestamp+"\n");
		}

		return newTxList;
	}

	/**
	 * Return hex string
	 * 
	 * @param str
	 * @return
	 */
	public static String hash(String str)
	{
		byte[] cipher_byte;
		try
		{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(str.getBytes());
			cipher_byte = md.digest();
			StringBuilder sb = new StringBuilder(2 * cipher_byte.length);
			for (byte b : cipher_byte)
			{
				sb.append(String.format("%02x", b & 0xff));
			}
			hashValue = sb.toString();
			return sb.toString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * Get Root
	 * 
	 * @return
	 */
	public String getRoot()
	{
		return this.root;
	}

}
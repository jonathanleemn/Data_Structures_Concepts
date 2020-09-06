package assignment;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;

public interface HashTableInterface<K, V>
{
	//converts a String pass into a String hash
	public String hashFunction(String pass) throws NoSuchAlgorithmException;
	
	//displays hashtable
	public void displayHashTable();
	
	//changes the password of an entry
	// calls both makePassword and validatePassword
	public void changePassword() throws NoSuchAlgorithmException;
	
	//passes in a String pass and then converts it into a String hash
	public void makePassword(String userID, String pass) throws NoSuchAlgorithmException;
		
	//hashes user's password+existingSalt to check if resulting hash matches
	//that in the hash table
	public boolean validatePassword(String input);
	
	//ensures user ID is unique
	public boolean isUniqueID(String input);	
}

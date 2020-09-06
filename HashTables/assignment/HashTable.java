package assignment;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

import javax.xml.bind.DatatypeConverter;

public class HashTable<V, K> extends Password implements HashTableInterface<K, V>
{
	static Scanner scan = new Scanner(System.in);

	// creates an instance of hashmap to use as the basis for the HashTable
	// class
	public HashMap<String, String> hm = new HashMap<String, String>();

	// creates a hashmap that will take in a linkedlist as one of its parameters
	// demonstrates separate chaining
	public HashMap<String, LinkedList<String>> chain = new HashMap<String, LinkedList<String>>();
	public LinkedList<String> userIDlist = new LinkedList<String>();

	// Source for method implementation:
	// https://stackoverflow.com/questions/18268502/how-to-generate-salt-value-in-java
	// generates a random salt value
	public String generateSalt()
	{
		final Random r = new SecureRandom();
		byte[] byteSalt = new byte[32];
		r.nextBytes(byteSalt);
		salt = DatatypeConverter.printBase64Binary(byteSalt);

		return salt;
	}

	// Source for method implementation:
	// https://stackoverflow.com/questions/18142745/how-do-i-generate-a-salt-in-java-for-salted-hash
	// Calls Java's SHA256 hash function.
	// converts a String saltedPass into a String
	// hash that is used as the key for the hashmap
	@Override
	public String hashFunction(String saltedPass) throws NoSuchAlgorithmException
	{
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] byteHash = digest.digest(saltedPass.getBytes(StandardCharsets.UTF_8));
		hash = DatatypeConverter.printBase64Binary(byteHash);
		return hash;
	}

	// displays all keys and their corresponding values within the hashmap
	@Override
	public void displayHashTable()
	{
		System.out.println(hm.toString());
	}

	// changes the password of an entry
	// checks to make sure the userID exists in the hashmap
	// if so, then it appends the salt and then hashes it to see if it exists in
	// the hashmap
	// if so, then it removes the old entry, and then adds in the new one
	// if user enters a userID or password that is not in the system, it will spit out an error message
	@Override
	public void changePassword() throws NoSuchAlgorithmException
	{
		System.out.print("Enter user ID you wish to change: ");
		String idInput = scan.next();
		boolean isUnique = isUniqueID(idInput);
		if (isUnique == false)
		{
			System.out.print("Enter password for " + idInput + ": ");
			String oldPassInput = scan.next();
			String oldHash = hashFunction(oldPassInput + database.get(idInput));
			boolean isValidated = validatePassword(oldHash);
			if (isValidated == true)
			{
				hm.remove(oldHash);
				System.out.print("Enter new password for " + idInput + ": ");
				makePassword(idInput, scan.next());
				System.out.println("The password for " + idInput + " was successfully changed.");
			}
			else if (isValidated == false)
			{
				System.out.println("The ID or password you entered does not exist in the database.");
			}
		}
		else if (isUnique == true)
		{
			System.out.print("Enter password for " + idInput + ": ");
			scan.next();
			System.out.println("Authentication fail");
			System.out.println("The ID or password you entered does not exist in the database.");
		}
	}

	/*
	 * calls isUniqueID; appends a random number (the “salt”) with the password
	 * to ensure a unique hash; calls hashFunction; populates hash table4
	 */
	@Override
	public void makePassword(String userID, String pass) throws NoSuchAlgorithmException
	{
		if (isUniqueID(userID) == true)
		{
			this.userID = userID;
			generateSalt();
			hashFunction(pass + salt);
			hm.put(hash, userID);
			database.put(userID, salt);
		}
	}

	/*
	 * hashes user's password+existingSalt to check if resulting hash matches
	 * that in the hash table; displays "Authentication fail" or
	 * "Authentication OK"
	 */
	@Override
	public boolean validatePassword(String hash)
	{

		if (hm.containsKey(hash))
		{
			System.out.println("Authentication OK.");
			return true;
		}

		else
		{
			System.out.println("Authentication fail.");
			return false;
		}

	}

	// ensures user ID is unique
	@Override
	public boolean isUniqueID(String userID)
	{
		if (hm.containsValue(userID))
			return false;

		else
			return true;
	}

	// allows the user to create an ID and password
	// password is salted and then hashed hashed for extra security
	void addUser() throws NoSuchAlgorithmException
	{
		System.out.print("Create a user ID: ");
		String userIDinput = scan.next();
		System.out.print("Create a password: ");
		makePassword(userIDinput, scan.next());
	}

	// sets a common password to be used for problem 5
	void setCommonPassForChain() throws NoSuchAlgorithmException
	{
		System.out.print("Enter a shared password for all users: ");
		setHash(hashFunction(scan.next() + generateSalt()));
	}

	// updates the userIDlist by clearing the hashmap and then
	// adding the new updated linkedlist to the hashmap
	// demonstrates separate chaining, used for problem 5
	void addUserToChain() throws NoSuchAlgorithmException
	{
		chain.clear();
		System.out.print("Enter userID: ");
		String userIDinput = scan.next();
		userIDlist.add(userIDinput);
		chain.put(hash, userIDlist);
	}

}

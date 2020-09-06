package assignment;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/*
 * Author: Jonathan Lee
 * Program: Login.java (driver class)
 * Purpose: Using HashTables to simulate creating usernames and passwords. 
 * Also, to practice hashing and separate chaining.
 * Date: 4/9/2017
 */
public class Login
{
	static HashTable<Password, String> ht = new HashTable<>();

	public static void main(String[] args) throws NoSuchAlgorithmException
	{
		ht.addUser();
		ht.addUser();
		ht.addUser();
		ht.displayHashTable();
		
		System.out.println();
		ht.changePassword();
		ht.displayHashTable();
		

//		// number 5
//		// forces the program to use separate chaining
//		ht.setCommonPassForChain();
//		ht.addUserToChain();
//		ht.addUserToChain();
//		ht.addUserToChain();
//		System.out.println(ht.chain.toString());

	}
}

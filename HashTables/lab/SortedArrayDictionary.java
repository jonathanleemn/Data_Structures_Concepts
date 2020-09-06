package lab;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
   A class that implements the ADT dictionary by using a resizable sorted array.
   The dictionary has distinct search keys.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public class SortedArrayDictionary<K extends Comparable<? super K>, V>
             implements DictionaryInterface<K, V>
{
	private Entry<K, V>[] dictionary; // Array of entries sorted by search key
	private int numberOfEntries; 
    private boolean initialized = false;
	private final static int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

/* < Constructors analogous to those in Listing 20-1. >
   . . . */
	
	// problem 4
	public Map<K,V> union(Dictionary first, Dictionary second){
		Map<K, V> one = valueOf(first);
		Map<K, V> two = valueOf(second);
		Map<K, V> union = new HashMap<K, V>();
		union.putAll(one);
		union.putAll(two);
		return union;
	}
	// credit to StackOverflow
	// http://stackoverflow.com/a/19792670 from Daniel Pacak
	public static <K, V> Map<K, V> valueOf(Dictionary<K, V> dictionary) {
		if (dictionary == null) {
		    return null;
		}
		  Map<K, V> map = new HashMap<K, V>(dictionary.size());
		  Enumeration<K> keys = dictionary.keys();
		  while (keys.hasMoreElements()) {
		    K key = keys.nextElement();
		    map.put(key, dictionary.get(key));
		}
		  return map;
	}
	
	
	SortedArrayDictionary(){
		//dictionary = new Entry<K, V>[25];
		initialized = true;
	}

   // 20.11
	/** Precondition: key and value are not null. */
   public V add(K key, V value)
	{
		checkInitialization();
      if ((key == null) || (value == null))
         throw new IllegalArgumentException("Cannot add null to a dictionary.");
      else
      {
         V result = null;
         int keyIndex = locateIndex(key);

         if ( (keyIndex < numberOfEntries) && 
               key.equals(dictionary[keyIndex].getKey()) )
         {
            // Key found, return and replace entry's value
            result = dictionary[keyIndex].getValue(); // Old value
            dictionary[keyIndex].setValue(value); 		// Replace value
         }
         else // Key not found; add new entry to dictionary
         {  
            makeRoom(keyIndex); // Make room for new entry
            dictionary[keyIndex] = new Entry<>(key, value); // Insert new entry in array
            numberOfEntries++;
            ensureCapacity(); // Ensure enough room for next add
         } // end if
         
         return result;
      } // end if
	} // end add

   /* < Implementations of other methods in DictionaryInterface. >
    . . . */
   
   public void ensureCapacity(){
	   
   }
   
   // removes select key/value from dictionary and returns the value
   public V remove(K key){
	   V result = null;
	   numberOfEntries--;
	   int keyIndex = locateIndex(key);
	   result = dictionary[keyIndex].getValue();
	   dictionary[keyIndex] = null;
	   
	   
	   return result;
   }
   
   // gets value at selected key without removing data from dictionary
   public V getValue(K key){
	   int keyIndex = locateIndex(key);
	   return dictionary[keyIndex].getValue();
   }
   
   // returns whether key is in dictionary
   public boolean contains(K key){
	   boolean contains = true;
	   int keyIndex = locateIndex(key);
	   
	   if ( (keyIndex < numberOfEntries) && key.equals(dictionary[keyIndex].getKey()) )
		   contains = false;
	   
	   return contains;
   }
   
   public Iterator<K> getKeyIterator(){
	   return new KeyIterator();
   }
   
   public Iterator<V> getValueIterator(){
	   return new ValueIterator();
   }
   
   // returns boolean saying whether dictionary is empty or not
   public boolean isEmpty(){
	   boolean empty = true;
	   if(numberOfEntries > 0)
		   empty = false;
	   return empty;
   }
   
   // clears dictionary
   public void clear(){
	   for(int i = 0; i < dictionary.length; i++)
		   dictionary[i] = null;
	   numberOfEntries = 0;
   }
   
   private boolean checkInitialization(){
	   return initialized;
   }
   
   // 20.12
	// Returns the index of either the entry that contains key or
   // the location that should contain key, if no such entry exists.
	private int locateIndex(K key)
	{
      // Search until you either find an entry containing key or
      // pass the point where it should be
		int index = 0;
		while ( (index < numberOfEntries) && 
		         key.compareTo(dictionary[index].getKey()) > 0 )
		{
			index++;
		} // end while
		
		return index;
	} // end locateIndex

   // Makes room for a new entry at a given index by shifting
   // array entries towards the end of the array.
   // Precondition: keyIndex is valid; list length is old length.
   private void makeRoom(int keyIndex)
   {
      // . . . To be implemented
   } // end makeRoom

	// Removes an entry at a given index by shifting array
   // entries toward the entry to be removed.
	private void removeArrayEntry(int keyIndex)
	{
      // . . . To be implemented
	}  // end removeArrayEntry

	private class Entry<S, T>
	{
		private S key;
		private T value;
		
		private Entry(S searchKey, T dataValue)
		{
         key = searchKey;
         value = dataValue;
		} // end constructor
		
		private S getKey()
		{
			return key;
		} // end getKey
		
		private T getValue()
		{
			return value;
		} // end getValue
		
		private void setValue(T dataValue)
		{
         value = dataValue;
		} // end setValue
	} // end Entry
	
	private class KeyIterator<K> implements Iterator<K>{
		Object array;
		private int index = 0;
		private int endIndex = 0;
		
		public KeyIterator(){
			array = dictionary;
			endIndex = dictionary.length;
		}
		
		@Override
		public boolean hasNext(){
			return (index < endIndex);
		}

		@Override
		public K next() {
			if (hasNext() == false) {
	            throw new NoSuchElementException();
	        }
	        return (K) Array.get(array, index++);
		}	
	}// end KeyIterator
	
	class ValueIterator<V> implements Iterator<V>{
		private int index = 0;
		private int endIndex = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (index < endIndex);
		}

		@Override
		public V next() {
			if(!hasNext())
				throw new NoSuchElementException();
			return (V) dictionary[index];
		}	
	}// end ValueIterator

	@Override
	public int getSize() {	
		return dictionary.length;
	}
} // end SortedArrayDictionary
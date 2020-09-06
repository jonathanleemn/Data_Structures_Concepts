package lab;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

//import main.SortedArrayDictionary.KeyIterator;
import lab.SortedArrayDictionary.ValueIterator;

/**
   A class that implements the ADT dictionary by using a resizable array.
   The dictionary is unsorted and has distinct search keys.
  
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public class ArrayDictionary<K, V> implements DictionaryInterface<K, V>
{
	private Entry<K, V>[] dictionary; // Array of unsorted entries
	private int numberOfEntries;
    private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	// problem 3
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
	
	
	public ArrayDictionary()
	{
		this(DEFAULT_CAPACITY);        // Call next constructor
	} // end default constructor
	
	public ArrayDictionary(int initialCapacity)
	{
      checkCapacity(initialCapacity);

		// The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      Entry<K, V>[] tempDictionary = (Entry<K, V>[])new Entry[initialCapacity];
      dictionary = tempDictionary;
		numberOfEntries = 0;
      initialized = true;
	} // end constructor

/* < Implementations of methods in DictionaryInterface. >
   . . . */
	
	public V add(K key, V value){
		return null;
	}
	
	public void checkCapacity(int initCapacity){
		//DEFAULT_CAPACITY = initCapacity;
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
	private int locateIndex(K key)
	{
      // Search until you either find an entry containing key or
      // pass the point where it should be
		int index = 0;
		while ( (index < numberOfEntries) && 
		         !key.equals(dictionary[index].getKey()))
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
} // end ArrayDictionary

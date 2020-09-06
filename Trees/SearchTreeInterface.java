import java.util.Iterator;

public interface SearchTreeInterface<T extends Comparable<? super T>> extends TreeInterface<T>
{
	// Search for a specific entry in this tree.
	public boolean contains(T entry);

	// Retrieve specific entry in this tree. Return the object if found, or null
	public T getEntry(T entry);

	// Adds a new entry to this tree, if not in tree, or replace existing object
	public T add(T newEntry);

	// Remove specific entry from tree; return the object if exists or null
	public T remove(T entry);

	// return an iterator to traverse all entries in tree
	public Iterator<T> getInorderIterator();
}
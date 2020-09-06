package lab;import java.util.Iterator;/** * An interface for the ADT list that has an iterator. *  * @author Frank M. Carrano * @version 2.0 */public interface ListWithIteratorInterface<T> extends ListInterface<T>, Iterable<T>{  public Iterator<T> getIterator();} // end ListWithIteratorInterface
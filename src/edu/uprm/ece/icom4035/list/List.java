package edu.uprm.ece.icom4035.list;

public interface List<E> extends Iterable<E>{
	/**
	 * Adds a new element at the end of the list
	 * @param obj - the new element to be added
	 */
	public void add(E obj);
	
	/**
	 * Adds a new element at position index in the list
	 * @param index - the position to add the element
	 * @param obj - the new element to be added
	 */
	public void add(int index, E obj);
	
	/**
	 * Removes the first copy of the element obj from the list
	 * @param obj - the element to remove (first copy)
	 * @return true if the element is removed or false otherwise
	 */
	public boolean remove(E obj);
	
	/**
	 * Removes the element at position index
	 * @param index - the position to remove
	 * @return true if the element is remove, or an IndexOutOfBoundsException if the index is invalid.
	 */
	
	public boolean remove(int index);
	
	/**
	 * Removes all copies of element obj from the list
	 * @param obj - the element to remove
	 * @return the total number of copies (if any) removed.
	 */
	public int removeAll(E obj);
	
	/**
	 * Returns the element at position index
	 * @param index - the target position
	 * @return element at position  index, or IndexOutOfBoundsException if the index is invalid
	 */
	public E get(int index);
	
	/**
	 * Updates the element at position index
	 * @param index - the target position
	 * @param obj - the new element to store
	 * @return the old value at position index, or IndexOutOfBoundsException if the index is invalid
	 */
	public E set(int index, E obj);
	/**
	 * Returns the first element in the list
	 * @return first element in the list, or null if empty
	 */
	public E first();
	
	/**
	 * Returns the last element in the list.
	 * @return last element in the list, or null if empty
	 */
	
	public E last();
	
	/**
	 * First index of position where element obj is found.
	 * @param obj - the element to search for
	 * @return index of first position where element obj is found, or -1 if not found
	 */
	public int firstIndex(E obj);
	
	/**
	 * Last index of position where element obj is found.
	 * @param obj - the element to search for
	 * @return index of last position where element obj is found, or -1 if not found
	 */

	public int lastIndex(E obj);

	/**
	 * Size of the list
	 * @return size of the list
	 */
	public int size();
	
	/**
	 * Indicates if the list is empty.
	 * @return true if the list is empty, or false otherwise
	 */
	public boolean isEmpty();
	
	
	/**
	 * Checks if an element obj is currently in the list.
	 * @param obj - the element to search for
	 * @return true if the element is found, or false otherwise.
	 */
	public boolean contains(E obj);
	
	/**
	 * Erases all elements from the list.
	 */
	public void clear();

}

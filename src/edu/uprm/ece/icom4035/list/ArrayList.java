package edu.uprm.ece.icom4035.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List {
	private static final int INITCAP = 5;
	private E[] elements;
	
	private int size;

	public ArrayList() {
		elements = (E[]) new Object[INITCAP];
		size = 0;
	}
	
	private class ArrayListIterator<E> implements Iterator<E>{
		int i = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i < size;
		}
		@Override
		public E next() {
			// TODO Auto-generated method stub
			if(i == size)
				throw new NoSuchElementException("");
			return (E) elements[i++];
		}
	}
	
	public Iterator iterator() {
		// TODO Auto-generated method stub
		Iterator<E> iter = new ArrayListIterator<E>();
		return iter;
	}

	@Override

	public void add(Object obj) {
		// TODO Auto-generated method stub
		if (size == elements.length)
			changeCapacity();
		elements[size] = (E) obj;
		size++;
	}

	@Override

	public void add(int index, Object obj) {
		// TODO Auto-generated method stub
		if (size == length())
			changeCapacity();
		if (index == size)
			add(obj);
		
		moveDataAfterAdd(index);
		elements[index] = (E) obj;
		size++;
	}

	@Override
	///////////////IMPLEMENTED-NOT TESTED///////////////////
	public boolean remove(Object obj) {
		// TODO Auto-generated method stub
		int indexOfObj = firstIndex((E) obj);
		if(indexOfObj != -1){
			remove(indexOfObj);
			return true;
		}
		return false;
	}

	@Override

	public boolean remove(int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Invalid index to remove");

		moveDataAfterRemove(index);
		size--;
		return true;
	}

	@Override
	///////////////IMPLEMENTED-NOT TESTED///////////////////
	public int removeAll(Object obj) {
		// TODO Auto-generated method stub
		int objectsFounds = 0;
		for(int i = 0; i < size;i++){
			if(elements[i] == (E) obj)
				remove(i);
			objectsFounds++;
		}
		
		return objectsFounds;
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index is not valid for access");
		return elements[index];
	}

	@Override
	
	public Object set(int index, Object obj) {
		// TODO Auto-generated method stub
		
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("index is not valid to modify");
		E objTR = elements[index];
		elements[index] = (E) obj;
		return objTR;
	}

	@Override

	public Object first() {
		// TODO Auto-generated method stub
		if (isEmpty())
			return null;
		return (E) elements[0];
	}

	@Override

	public Object last() {
		// TODO Auto-generated method stub
		if (isEmpty()) 
			return null;
		return (E) elements[size - 1];
	}

	@Override
	
	public int firstIndex(Object obj) {
		// TODO Auto-generated method stub
		int indexOfObj = 0;
		for (int i = 0; i < size(); i++) {
			if (((E) obj) == elements[i])
				return indexOfObj;
			indexOfObj++;
		}
		return -1;
	}

	@Override
	
	public int lastIndex(Object obj) {
		// TODO Auto-generated method stub
		int indexOfObj = -1;
		for (int i = 0; i < size(); i++) {
			if (elements[i] == ((E) obj))
				indexOfObj = i;

		}
		return indexOfObj;

	}

	@Override
	
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public int length() {
		return elements.length;
	}

	@Override
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	
	public boolean contains(Object obj) {
		// TODO Auto-generated method stub
		boolean isInList = false;
		for (int i = 0; i < length(); i++) {
			if (elements[i] == (E) obj) {
				isInList = true;
				break;
			}
		}
		return isInList;
	}

	@Override
	
	public void clear() {

		// TODO Auto-generated method stub
		
		for(int i = 0; i < size; i ++){
			elements[i] = null;
		}
		size = 0;
	}
	
	/**
	 * Doubles the size of the array
	 */
	private void changeCapacity() {
		E[] newArray = (E[]) new Object[elements.length * 2];
		for (int i = 0; i < elements.length; i++) {
			newArray[i] = elements[i];
		}
		elements = newArray;
		
	}
	
	
	/**
	 * Move data one position to right after adding a value.
	 * @param from index where the new element is going to be added          
	 */
	private void moveDataAfterAdd(int from) {
		for (int desde = size - 1; desde >= from; desde--) {
			elements[desde + 1] = elements[desde];
		}
	}

	/**
	 * Move data one position to left to delete a value.
	 * @param from the index from which the elements are to be moved to the left
	 */
	private void moveDataAfterRemove(int from) {
		// TODO Auto-generated method stub
		for (int i = from; i < size - 1; i++) {
			elements[i] = elements[i + 1];
			elements[i + 1] = null;
		}
	}

}

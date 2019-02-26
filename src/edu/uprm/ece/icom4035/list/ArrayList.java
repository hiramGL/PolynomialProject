package edu.uprm.ece.icom4035.list;

import java.util.Iterator;

public class ArrayList<E> implements List{
	private static final int INITCAP = 5;
	private E[] terms;
	private int size = 0;
	
	
	public ArrayList(){
		terms =(E[]) new Object[INITCAP]; 
	}
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null ;
	}

	
	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		if(size == terms.length)
			changeCapacity();
		terms[size] = (E) obj;	
		size++;
	}

	@Override
	public void add(int index, Object obj) {
		// TODO Auto-generated method stub
		if(size == length())
			changeCapacity();
		if(index == size)
			add(obj);
		
		moveDataAfterAdd(index);
		terms[index] = (E) obj;
		size++;
	}

	@Override
	public boolean remove(Object obj) {
		// TODO Auto-generated method stub
		
		return false;
	}

	
	@Override
	public boolean remove(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int removeAll(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		
		return terms[index];
	}

	@Override
	public Object set(int index, Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub
		if(isEmpty())
			return null;
		return terms[0];
	}

	@Override
	public Object last() {
		// TODO Auto-generated method stub
		if(isEmpty())
			return null;
		return terms[size - 1];
	}

	@Override
	public int firstIndex(Object obj) {
		// TODO Auto-generated method stub
		int indexOfObj = 0;
		for(int i = 0; i < length();i++){
			if(terms[i] == (E) obj)
				return indexOfObj;
			indexOfObj++;
		}
		return -1;
	}

	@Override
	public int lastIndex(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	public int length(){
		return terms.length;
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
		for(int i = 0; i < length();i++){
			if(terms[i] == (E) obj){
				isInList = true;
				break;
				}
		}
		return isInList;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
		
	}
	////////////CHANGE CAPACITY OF ARRAY////////////////////
	private void changeCapacity(){
		E[] newArray = (E[]) new Object[terms.length*2];
		for(int i = 0; i < terms.length;i++){
			newArray[i] = terms[i];
		}
		terms = newArray;
	}
	
	//////////Privates methods for moving data after adding or removing an element
	/**
	 * Move data one position to right after adding a value.
	 * @param from index where the new element is going to be added
	 */
	private void moveDataAfterAdd(int from){
		for(int desde = size - 1; desde >= from; desde-- ){
			terms[desde + 1] = terms[desde];
		}
	}
	/**
	 * Move data one position to left after deleting a value.
	 * @param from 
	 */
	private void moveDataAfterDelete() {
		// TODO Auto-generated method stub
		for(int i = 0; i < size - 1; i++){
			terms[i] = terms[i+1];
			
		}
	}

}

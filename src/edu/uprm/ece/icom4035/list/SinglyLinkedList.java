package edu.uprm.ece.icom4035.list;

import java.util.Iterator;

public class SinglyLinkedList<E> implements List{
	private class SinglyIterator implements Iterator<E>{
		Node<E> current = header.getNext();
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current == null;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			current = current.getNext();
			return  current.getTerm();
		}
		
	}
	
	/**--------------INNER CLASS-NODE------------- */
	private class Node<E>{
		private E term;
		private Node<E> next;
		
		public E getTerm(){
			return term;
		}
		public Node<E> getNext(){
			return next;
		}
		
		private void setNext(Node<E> n){
			next = n;
		}
		public Node(E e, Node<E> next){
			term = e;
			this.next = next;
		}
		
	}
	//-----------Instance variables and Constructors--------------
	private Node<E> header;
	private int size;
	
	public SinglyLinkedList(){
		header = new Node<E>(null,null); 
		size = 0;
	}
	//
	
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		
		return new SinglyIterator();
	}
	

	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		E eobj = (E) obj;
		if(isEmpty()){
			header.setNext( new Node<E>(eobj,null));
		}
		size++;
	}

	@Override
	public void add(int index, Object obj) {
		// TODO Auto-generated method stub
		
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
		return null;
	}

	@Override
	public Object set(int index, Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub
		return header.getNext().getTerm();
	}

	@Override
	public Object last() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int firstIndex(Object obj) {
		// TODO Auto-generated method stub
		return 0;
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

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public boolean contains(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}

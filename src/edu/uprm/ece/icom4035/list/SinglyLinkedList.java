package edu.uprm.ece.icom4035.list;

import java.util.Iterator;

public class SinglyLinkedList<E> implements List{
	private class SinglyIterator implements Iterator<E>{
		Node<E> current = header.getNext();
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public E next() {
			if(hasNext()){
				E element = current.getTerm();
				current = current.getNext();
				return element;
			}
			return null;
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
		public void setTerm(E newterm){
			term = newterm;
		}
		
		private void setNext(Node<E> n){
			next = n;
		}
		public Node(E e, Node<E> next){
			term = e;
			this.next = next;
		}
		public void clear(){
			term =  null;
			next = null;
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
		
		E eobj = (E) obj;
		if(isEmpty()){
			header.setNext(new Node<E>(eobj,null));
			size++;
			return;
			
		}
		Node<E> current = header.getNext();
		while(current.getNext() != null){
			current = current.getNext();
		}
		current.setNext(new Node<E>(eobj,null));
		size++;
	}

	@Override
	public void add(int index, Object obj) {
		
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("invalid index");
		}
		if(index == 0){
			header.setNext(new Node<E>((E)obj,header.getNext()));
			size++;
			return;
		}
		E eobj = (E) obj;
		int i = 0;
		Node<E> nodeBefore = getNode(index- 1);
		Node<E> newnode = new Node<E>(eobj,nodeBefore.getNext());
		nodeBefore.setNext(newnode);
		size++;
	}

	@Override
	public boolean remove(Object obj) {
		
		Node<E> current = header.getNext();
		int index = 0;
		while(current != null){
			if(current.getTerm().equals((E) obj)){
				remove(index);
				return true;
			}
			current = current.getNext();
			index++;
		}
		return false;
	}

	@Override
	public boolean remove(int index) {
		
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException("invalid index");
		}
		int i = 0;
		Node<E> current = header.getNext();
		if(index == 0){
			header.setNext(current.getNext());
			size--;
			return true;
		}
		while(i < index){
			current = current.getNext();
			i++;
		}
		Node<E> nodebefore = getNode(i - 1);
		
		nodebefore.setNext(current.getNext());
		current.clear();
		size--;
		return true;
	}

	@Override
	public int removeAll(Object obj) {
		
		return 0;
	}

	@Override
	public Object get(int index) {
		
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException("invalid index");
		}
		if(isEmpty()){
			throw new IndexOutOfBoundsException("list is empty");
		}
		int i = 0;
		Node<E> current = header.getNext();
		while(i < index){
			i++;
			current = current.getNext();
		}
		return current.getTerm();
	}

	@Override
	public Object set(int index, Object obj) {
		// TODO Auto-generated method stub
		if(index < 0|| index >= size){
			throw new IndexOutOfBoundsException("invalid index.");
		}
		 E etr = (E)get(index);
		 Node<E> current = header.getNext();
		 int i = 0;
		 while(i < index){
			 i++;
			 current = current.getNext();
		 }
		 current.setTerm((E) obj);
		return etr;
	}

	@Override
	public Object first() {
		
		if(isEmpty())
			return null;
		return header.getNext().getTerm();
	}

	@Override
	public Object last() {
		
		Node<E> last = null;
		if(isEmpty())
			return null;
		last = header.getNext();
		while(last.getNext() != null){
			last = last.getNext();
		}
		return last.getTerm();
	}

	@Override
	public int firstIndex(Object obj) {
		
		int index = 0;
		Node<E> current = header.getNext();
		while(current != null){
			if(current.getTerm().equals((E)obj)){
				return index;
			}
			index++;
			current = current.getNext();
		}
		
		return -1;
	}

	@Override
	public int lastIndex(Object obj) {
		
		int index = -1;
		int i = 0;
		Node<E> current = header.getNext();
		while(current != null){
			if(current.getTerm().equals((E)obj)){
				 index = i;
			}
			i++;
			current = current.getNext();
		}
		
		return index;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		
		return size == 0;
	}

	@Override
	public boolean contains(Object obj) {
		boolean contain = false;
		Node<E> current = header.getNext();
		while(current != null){
			if(current.getTerm().equals((E)obj)){
				contain = true;
			}
			current = current.getNext();
		}
		return contain;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		Node<E> current = header.getNext();
		Node<E> nextoc = current.getNext();
		while(nextoc.getNext() != null){
			current.clear();
			nextoc = nextoc.getNext();
		}
		size =0;
	}
	//--------------------Private Methods--------------------
	private Node<E> getNode(int index){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException("invalid index");
		}
		int i = 0;
		Node<E> current = header.getNext();
		while(i < index){
			i++;
			current = current.getNext();
		}
		return current;
	}
}

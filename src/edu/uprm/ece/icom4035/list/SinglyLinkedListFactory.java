package edu.uprm.ece.icom4035.list;

public class SinglyLinkedListFactory<E> implements ListFactory{

	@Override
	public List newInstance() {
		// TODO Auto-generated method stub
		return new SinglyLinkedList<E>();
	}

}

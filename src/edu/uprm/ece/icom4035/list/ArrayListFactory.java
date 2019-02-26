package edu.uprm.ece.icom4035.list;

public class ArrayListFactory<E> implements ListFactory{

	@Override
	public List newInstance() {
		// TODO Auto-generated method stub
		return new ArrayList<E>();
	}

}

package edu.uprm.ece.icom4035.list;

public interface ListFactory<E> {
	
	/**
	 * Creates a new List container
	 * @return the newlycreated container.
	 */
	public List<E> newInstance();

}

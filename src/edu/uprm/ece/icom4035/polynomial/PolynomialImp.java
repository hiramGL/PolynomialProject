package edu.uprm.ece.icom4035.polynomial;

import java.util.Iterator;

import edu.uprm.ece.icom4035.list.ArrayList;
import edu.uprm.ece.icom4035.list.ArrayListFactory;
import edu.uprm.ece.icom4035.list.List;
import edu.uprm.ece.icom4035.list.ListFactory;

public class PolynomialImp implements Polynomial {
	private String polynomialStructure;
	private ListFactory listFactory = TermListFactory.newListFactory();
	private List termList;

	public PolynomialImp(String string) {
		polynomialStructure = string;
		termList = listFactory.newInstance();
		convertToTerms(polynomialStructure);
		
	}
	
	public String toString(){
		return polynomialStructure;
		
	}
	
	/**
	 * Add the terms in the polynomial to an arrayList
	 * 
	 * @param string
	 *            TODO it just add the term to the arrayList it doesn't know the
	 *            coefficient nor the exponent yet
	 */
	private void convertToTerms(String string) {
		String[] termsString = string.split("[+]");
		for (String s : termsString) {
			termList.add((TermImp) new TermImp(s));
		}
		Iterator<TermImp> iterator = termList.iterator();
	}

	@Override
	public Iterator<Term> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Polynomial add(Polynomial P2) {
		// TODO Auto-generated method stub
		return P2;
	}

	@Override
	public Polynomial subtract(Polynomial P2) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Polynomial multiply(Polynomial P2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Polynomial multiply(double c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Polynomial derivative() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Polynomial indefiniteIntegral() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double definiteIntegral(double a, double b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int degree() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double evaluate(double x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Polynomial P) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private class PolynomialIterator<Term> implements Iterator<Term>{
		String[] termsString = polynomialStructure.split("[+]");
		int TermsInPolynomial = termsString.length - 1;
		int index = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return TermsInPolynomial < termsString.length;
		}

		@Override
		public Term next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}

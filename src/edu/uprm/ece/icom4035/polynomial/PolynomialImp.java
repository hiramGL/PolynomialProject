package edu.uprm.ece.icom4035.polynomial;

import java.util.Iterator;

import edu.uprm.ece.icom4035.list.ArrayList;
import edu.uprm.ece.icom4035.list.ArrayListFactory;
import edu.uprm.ece.icom4035.list.List;
import edu.uprm.ece.icom4035.list.ListFactory;

public class PolynomialImp implements Polynomial {
	//----------Instance Variable--------------------------------------
	private String polynomialStructure;
	private ListFactory listFactory = TermListFactory.newListFactory();
	private List termList;
	//-----------------------------------------------------------------
	//----------------Constructors-------------------------------------
	public PolynomialImp(String string) {
		polynomialStructure = string;
		termList = listFactory.newInstance();
		convertToTerms(polynomialStructure);

	}
	public PolynomialImp() {
		polynomialStructure = "";
		termList = listFactory.newInstance();
	}
	//-----------------------------------------------------------------
	
	
	public String toString() {
		convertToStructure();
		return polynomialStructure;

	}
	//-------------------Private methods-------------------------------
	/**
	 * Add the terms in the polynomial to an arrayList
	 * 
	 * @param string
	 */
	private void convertToTerms(String string) {
		String[] termsString = string.split("[+]");
		for (String s : termsString) {
			termList.add((TermImp) new TermImp(s));
		}

	}
	private void convertToStructure(){
		String structure = "";
		Iterator<TermImp> iter = termList.iterator();
		TermImp ct;
		while(iter.hasNext()){
			ct = iter.next();
			structure += ct.toTerm();
			if(iter.hasNext())
				structure+= "+";
		}
		this.polynomialStructure = structure;
	}
	private void checkPolynomial(){
		Iterator<Term> iter = this.iterator();
		TermImp ct = null;
		int firstIndex = 0;
		int lastIndex = 0;
		while(iter.hasNext()){
			ct = (TermImp) iter.next();
			firstIndex = termList.firstIndex(ct);
			lastIndex = termList.lastIndex(ct);
			while(firstIndex != lastIndex){
				TermImp newterm = new TermImp(((TermImp) termList.get(firstIndex)).getCoefficient() + ((TermImp) termList.get(lastIndex)).getCoefficient(),((TermImp) termList.get(lastIndex)).getExponent());
				termList.set(firstIndex, newterm);
				termList.remove(lastIndex);
			}
		}
	 convertToStructure();
	}
	//-----------------------------------------------------------------
	@Override
	public Iterator<Term> iterator() {
		// TODO Auto-generated method stub
		Iterator<Term> iter = termList.iterator();
		return iter;
	}

	@Override
	public Polynomial add(Polynomial P2) {
		// TODO Auto-generated method stub
		PolynomialImp pp2 = (PolynomialImp) P2;
		PolynomialImp resultPol = new PolynomialImp();
		Iterator<Term> iter1 =  this.iterator();
		Iterator<Term> iter2 =  pp2.iterator();
		
		while(iter1.hasNext()){
			Term ct1 = iter1.next();
			Term ct2 = iter2.next();
			TermImp newterm = new TermImp(ct1.getCoefficient()+ct2.getCoefficient(),ct1.getExponent());
			resultPol.termList.add(newterm);
			resultPol.convertToStructure();
		}
		
		
		return resultPol;
	}

	@Override
	public Polynomial subtract(Polynomial P2) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public Polynomial multiply(Polynomial P2) {
		// TODO Auto-generated method stub
		PolynomialImp newPol = new PolynomialImp();
		PolynomialImp pP2 = (PolynomialImp) P2;
		Iterator<Term> iter = this.iterator();
		Iterator<Term> iter2 = pP2.iterator();
		TermImp ct1 = null;
		TermImp ct2 = null;
		while(iter.hasNext()){
			ct1 = (TermImp) iter.next();
			while(iter2.hasNext()){
				ct2 = (TermImp) iter2.next();
				TermImp newTerm = new TermImp(ct1.getCoefficient()*ct2.getCoefficient(),ct1.getExponent()+ct2.getExponent());
				newPol.termList.add(newTerm);
			}
			iter2 = pP2.iterator();
		}
		newPol.checkPolynomial();
		return newPol;
	}

	@Override
	public Polynomial multiply(double c) {
		
		PolynomialImp newPol = new PolynomialImp(this.polynomialStructure);
		newPol.termList.clear();
		
		Iterator<Term> iter = this.iterator();
		TermImp ct;
		while(iter.hasNext()){
			ct = (TermImp) iter.next(); 
			TermImp newterm = new TermImp((Double) ct.getCoefficient()*c, ct.getExponent());
			newPol.termList.add(newterm);
		}
		newPol.convertToStructure();
		
		return newPol;
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
		return ((TermImp) termList.first()).getExponent();
	}

	@Override
	public double evaluate(double x) {
		// TODO Auto-generated method stub
		double result = 0;
		Iterator<Term> iter = this.iterator();
		while(iter.hasNext()){
			result += iter.next().evaluate(x);
		}
		return result;
	}

	@Override
	public boolean equals(Polynomial P) {
		
		return (this.polynomialStructure.equals(((PolynomialImp) P).polynomialStructure));
	}
	// private class PolynomialIterator<Term> implements Iterator<Term>{}

}

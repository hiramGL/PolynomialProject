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
		if(termList.isEmpty()){
			this.polynomialStructure = "0.00";
			return;
		}
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
	/** Simplify a polynomial if it has same terms*/
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
			
				TermImp term1 = (TermImp) termList.get(firstIndex);
				TermImp term2 = (TermImp) termList.get(lastIndex);
				TermImp newTerm = new TermImp(term1.getCoefficient()+term2.getCoefficient(),term1.getExponent());
						
				
				termList.remove(lastIndex);
				termList.set(firstIndex, newTerm);
				
				firstIndex = termList.firstIndex(ct);
				lastIndex = termList.lastIndex(ct);
				
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
		Term ct1 = null;
		Term ct2 = null;
		TermImp newterm = null;
		ct1 = iter1.next();
		ct2 = iter2.next();
		while(iter1.hasNext()){
			
			if(ct1.getExponent() < ct2.getExponent()){
				resultPol.termList.add(ct2);
				ct2 = iter2.next();
				
			}
			if(ct1.equals(ct2)){
				newterm = new TermImp(ct1.getCoefficient()+ct2.getCoefficient(),ct1.getExponent());
				resultPol.termList.add(newterm);
				ct1 = iter1.next();
				ct2 = iter2.next();
			}
			if(ct1.getExponent() > ct2.getExponent()){
				resultPol.termList.add(ct1);
				ct1 = iter1.next();
			}
		}
		
		resultPol.convertToStructure();
		System.out.println("add method, final result is " + resultPol);
		
//		while(iter1.hasNext()){
//			Term ct1 = iter1.next();
//			Term ct2 = iter2.next();
//			TermImp newterm = new TermImp(ct1.getCoefficient()+ct2.getCoefficient(),ct1.getExponent());
//			resultPol.termList.add(newterm);
//			resultPol.convertToStructure();
//		}
		
	
		return resultPol;
	}

	@Override
	public Polynomial subtract(Polynomial P2) {
		// TODO Auto-generated method stub
		PolynomialImp pp2 = (PolynomialImp) P2;
		PolynomialImp resultPol = new PolynomialImp();
		Iterator<Term> iter1 =  this.iterator();
		Iterator<Term> iter2 =  pp2.iterator();
		
		while(iter1.hasNext()){
			Term ct1 = iter1.next();
			Term ct2 = iter2.next();
			TermImp newterm = new TermImp(ct1.getCoefficient()-ct2.getCoefficient(),ct1.getExponent());
			resultPol.termList.add(newterm);
			resultPol.convertToStructure();
		}
		
		
		return resultPol;

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
				if(newTerm.getCoefficient() != 0)
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
		Iterator<Term> iter = iterator();
		TermImp ct = null;
		TermImp nt = null;
		int indexOfTerm = 0;
		while(iter.hasNext()){
			ct = (TermImp) iter.next();
			if(ct.getExponent() > 0){
				nt= new TermImp(ct.getCoefficient()*ct.getExponent(),ct.getExponent()- 1);
				termList.set(indexOfTerm, nt);
			}
			else{
				termList.remove(indexOfTerm);
			}
			indexOfTerm++;
		}
		return this;
	}

	@Override
	public Polynomial indefiniteIntegral() {
		// TODO Auto-generated method stub
		Iterator<Term> iter = iterator();
		TermImp ct = null;
		TermImp newterm = null;
		int indexOfTerm = 0;
		while(iter.hasNext()){
			ct = (TermImp) iter.next();
			newterm = new TermImp(ct.getCoefficient()/(ct.getExponent()+1),ct.getExponent()+1);
			termList.set(termList.firstIndex(ct), newterm);
		}
		termList.add(new TermImp(1,0));
		System.out.println(this);
		return this;
	}

	@Override
	public double definiteIntegral(double a, double b) {
		// TODO Auto-generated method stub
		this.indefiniteIntegral();
		Iterator<Term> iter = iterator();
		double evaluatedB = 0;
		double evaluatedA = 0;
		TermImp ct = null;
		while(iter.hasNext()){
			ct = (TermImp) iter.next();
			evaluatedB += ct.evaluate(b);
			evaluatedA += ct.evaluate(a);
		}
		return evaluatedB - evaluatedA;
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
		
		return (this.polynomialStructure.equals( ((PolynomialImp) P).polynomialStructure));
	}
	// private class PolynomialIterator<Term> implements Iterator<Term>{}

}

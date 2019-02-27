package edu.uprm.ece.icom4035.polynomial;

public class TermImp implements Term {
	private double coefficient;
	private int exponent;
	private String term; //term to be examinated and divided into coefficient and exponent
	public TermImp(String term){
		this.term = term;
	}
	public void setTerm(String term){
		this.term = term;
	}
	
	public String getTerm(){
		return term;
	}
	
	public void setCoefficient(double coefficient){
		this.coefficient = coefficient;
	}
	
	public void setExponent(int exponent){
		this.exponent = exponent;
	}
	@Override
	public double getCoefficient() {
		// TODO Auto-generated method stub
		return coefficient;
	}

	@Override
	public int getExponent() {
		// TODO Auto-generated method stub
		return exponent;
	}

	@Override
	public double evaluate(double x) {
		// TODO Auto-generated method stub
		return 0;
	}

}

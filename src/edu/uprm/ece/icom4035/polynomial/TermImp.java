package edu.uprm.ece.icom4035.polynomial;

public class TermImp implements Term {
	private Double coefficient;
	private Integer exponent;
	private String term; // term to be examinated and divided into coefficient
							// and exponent

	public TermImp(String term) {
		this.term = term;
	}

	/**
	 * Based on the term it sets the coefficient and exponent
	 * TODO implement this method correctly
	 */
	public void setup() {
		if(term.contains("x")){
			if(term.contains("^")){
				exponent = Integer.parseInt(term.substring(term.charAt('^') + 1, term.length() - 1));
			}
			exponent = 1;
			coefficient = Double.parseDouble(term.substring(0, term.charAt('x') - 1));
			
			return;
		}
		exponent = 0;
		coefficient = coefficient.parseDouble(term);
	}
	

	public void setTerm(String term) {
		this.term = term;
	}

	public String getTerm() {
		return term;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public void setExponent(int exponent) {
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

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.exponent == ((TermImp) obj).exponent ;
	}
	
	public String toString(){
		return "term is " + term + ": \n its coefficient and exponent are "+ coefficient + " " + exponent;
	}

}

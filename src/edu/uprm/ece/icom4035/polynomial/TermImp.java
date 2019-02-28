package edu.uprm.ece.icom4035.polynomial;

public class TermImp implements Term {
	private Double coefficient;
	private Integer exponent;
	private String term; // term to be examinated and divided into coefficient
							// and exponent

	public TermImp(String term) {
		this.term = term;
		setup();
	}
	/**
	 * Set the value of coefficient and exponent based on the term.
	 */
	private void setup(){
		if(term.contains("x")){
			exponent = 1;
			if(term.contains("^")){
				exponent = exponent.parseInt(term.substring(term.indexOf("^")+1, term.length()));
			}
			coefficient = coefficient.parseDouble(term.substring(0, term.indexOf("x")));
		}
		if(!term.contains("x")){
			coefficient = coefficient.parseDouble(term);
			exponent = 0;
		}
	}
	
	public String getTerm() {
		return term;
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

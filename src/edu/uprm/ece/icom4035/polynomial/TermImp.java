package edu.uprm.ece.icom4035.polynomial;

import edu.uprm.ece.icom4035.list.ParameterCheck;

public class TermImp implements Term {
	//------------Instance Variables-----------------------------
	private Double coefficient;
	private Integer exponent;
	private String term; // term to be examinated and divided into coefficient and exponent
							
	//-----------Constructors----------------
	public TermImp(String term) {
		this.term = term;
		setup();
	}
	public TermImp(double coef, int exp){
		coefficient = coef;
		exponent = exp;
		this.term = toTerm();
	}
	//----------------------------------------
	
	//----------Private method-----------------
	/**Set the value of coefficient and exponent based on the term.*/
	private void setup(){
	
		if(term.contains("x")){
			exponent = 1;
			if(term.contains("^")){
				exponent = exponent.parseInt(term.substring(term.indexOf("^")+1, term.length()));
			}
			try{
			coefficient = coefficient.parseDouble(term.substring(0, term.indexOf("x")));
			}
			catch(NumberFormatException e){
				coefficient = 1.0;
			}
		}
		if(!term.contains("x")){
			coefficient = coefficient.parseDouble(term);
			exponent = 0;
		}
		
	}
	/** Return the string representation of this term*/
	public String toTerm(){
		String termS = "";
			
			termS += String.format("%.2f",coefficient) ;
			if(exponent > 0)
				if(exponent == 1){
					termS += "x";
				}
				else{
				termS += "x^" + exponent;
				}
		return termS;
	}
	//-----------------------------------------------
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
		if(exponent == 0)
			return coefficient;
		return coefficient*(Math.pow(x, exponent));
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		TermImp tobj = (TermImp) obj;
		return ((this.exponent ==  tobj.exponent)) ;
	}
	
	public String toString(){
		return term ;
	}

}

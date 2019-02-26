package edu.uprm.ece.icom4035.polynomial;

public interface Term {
	/**
	 * Return the coefficient of the term
	 * @return a double of the coefficient
	 */
	public double getCoefficient();
	
	/**
	 * Return the exponent of the term
	 * @return a double of the exponent
	 */
	public int getExponent();
	
	/**
	 * Evaluate each term of the polynomial
	 * @param x is the value to replace in the factors
	 * @return a double of each term evaluate
	 */
	public double evaluate(double x);
	
}

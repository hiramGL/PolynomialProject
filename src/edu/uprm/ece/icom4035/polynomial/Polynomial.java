package edu.uprm.ece.icom4035.polynomial;


public interface Polynomial extends Iterable<Term> {
	/**
	 * Adds two polynomials, the current one
	 * and the polynomial provided P2.
	 * @param P2 is polynomial to add
	 * @return a polynomial which is the 
	 * result of adding two polynomial.
	 */
	public Polynomial add(Polynomial P2);
	
	/**
	 * Subtracts two polynomial, the current one
	 * and the polynomial provided P2.
	 * @param P2 is polynomial to subtract
	 * @return a polynomial which is the 
	 * result of subtracting two polynomial
	 */
	public Polynomial subtract(Polynomial P2);
	
	/**
	 * Multiply two polynomial, the current one
	 * and the polynomial provided P2.
	 * @param P2 is polynomial to multiply
	 * @return a polynomial which is the 
	 * result of multiplying two polynomial.
	 */
	public Polynomial multiply(Polynomial P2);
	
	/**
	 * Multiply a polynomial with a constant and return
	 * a new polynomial times the constant
	 * @param c is the constant to multiply
	 * @return a polynomial which is the 
	 * result of multiplying a constant with a polynomial 
	 */
	public Polynomial multiply(double c);

	/**
	 * Derives the current polynomial
	 * @return a derivative of the current polynomial
	 */
	public Polynomial derivative();
	
	/**
	 * Integrated the current polynomial
	 * @return a integrate of the current polynomial
	 */
	public Polynomial indefiniteIntegral();
	
	/**
	 * Integrated and evaluate its definite
	 * integral over an interval [a,b]
	 * @param a is the lower limit
	 * @param b is the upper limit
	 * @return
	 */
	public double definiteIntegral(double a, double b);
	
	/**
	 * Returns the degree of the current polynomial
	 * @return a degree of the polynomial
	 */
	public int degree();
	
	/**
	 * evaluate the polynomial at value x, to compute y = P(x)
	 * @param x is the value to replace in the factors
	 * @return
	 */
	public double evaluate(double x);
	
	/**
	 * Check if the polynomials are similar, the current one
	 * polynomial and the polynomial provided P2
	 * @param P is the polynomial to check
	 * @return false if the polynomial is not the same
	 * and true if is similar
	 */
	boolean equals(Polynomial P);
	

	

}

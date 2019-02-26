package edu.uprm.ece.icom4035.list;


public class ParameterCheck {
	
	public static void checkGT(int n, int min){
		if (n < min){
			throw new IllegalArgumentException("Parameter is too small.");
		}
	}

	public static void checkNull(Object obj){
		if (obj == null){
			throw new IllegalArgumentException("Parameter cannot be null.");
		}
	}
	public static void checkRange(int i, int a, int b){
		if ((i < a) || ( i > b)){
			throw new IndexOutOfBoundsException();
		}
	}
}
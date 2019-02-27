package edu.uprm.ece.icom4035.list;

import java.util.Iterator;

public class ArrayListTester {
	
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(15);
		list.add(12);
		list.add(13);
		list.add(15);
		list.add(13);
		
		printArray((ArrayList<Integer>) list);
		
	}
	
	public static void printArray(ArrayList<Integer> list){
		System.out.println("List is: ");
		for(int i = 0; i < list.size();i++){
			System.out.println(list.get(i)+ " ");
		}
		System.out.println("size is " + list.size());
		System.out.println("length is " + list.length());
	}
}

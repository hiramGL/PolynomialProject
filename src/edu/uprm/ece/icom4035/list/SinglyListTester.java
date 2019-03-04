package edu.uprm.ece.icom4035.list;

import java.util.Iterator;

public class SinglyListTester {
	
	
	public static void main(String[] args) {
		List<Integer> list = new SinglyLinkedList<Integer>();
		list.add(15);
		System.out.println(list.first());
		
		
	}
	
	public static void printArray(SinglyLinkedList<Integer> list){
		System.out.println("List is: ");
		for(int i = 0; i < list.size();i++){
			System.out.println(list.get(i)+ " ");
		}
		System.out.println("size is " + list.size());
	
	}
}

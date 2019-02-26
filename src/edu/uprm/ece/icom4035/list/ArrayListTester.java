package edu.uprm.ece.icom4035.list;

public class ArrayListTester {
	public static void main(String[] args) {
		ArrayList<double[]> list = new ArrayList();
		list.add(10.0);
		list.add(10.0);
		list.add(49);
		list.add(10.0);
		list.add(20392.0);
		printArray(list);
		System.out.println("first index of 10 is " + list.firstIndex(49));
		
	}
	
	public static void printArray(ArrayList list){
		System.out.println("List is: ");
		for(int i = 0; i < list.length();i++){
			System.out.println(list.get(i)+ " ");
		}
		System.out.println("size is " + list.size());
		System.out.println("length is " + list.length());
	}
}

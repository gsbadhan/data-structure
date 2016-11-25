package com.circularLinklist;

public class Test {

	public static void main(String[] args) {
		CircularLinkedList<Integer> cll=new CircularLinkedList<>();
		//add data
		cll.add(10);
		cll.add(22);
		cll.add(34);
		cll.add(19);
		
		//show all data
		cll.print();
		
		//search data
		System.out.println("found ?:"+cll.search(19));
		
		//remove data
		cll.remove(22);
		
		//print after removal
		cll.print();
	}

}

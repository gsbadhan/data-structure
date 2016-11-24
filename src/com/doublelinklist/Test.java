package com.doublelinklist;

public class Test {

	public static void main(String[] args) {
		DoubleLinklist<Integer> dll = new DoubleLinklist<>();
		
		//add data 
		dll.add(11);
		
		//add at last place
		dll.addLast(103);
		
		//add at first place
		dll.addFirst(5);

		//show all data
		dll.print();

		//search data
		System.out.println("data present in list :" + dll.search(103));

		//remove data from first place
		dll.removeFirst();
		dll.print();

		//remove data from last place
		dll.removeLast();
		dll.print();

		//remove data by value
		dll.remove(11);
		dll.print();

		System.out.println("check list is empty ?:" + dll.isEmpty());

	}

}

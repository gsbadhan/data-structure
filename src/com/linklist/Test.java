package com.linklist;

public class Test {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		// add
		list.add(10);
		list.add(11);
		//add at first place
		list.addFirst(5);
		list.addFirst(4);
		//add at last place
		list.addLast(100);
		list.addLast(120);
		list.print();
		
		//remove by data match:if found
		list.remove(11);
		list.print();
		
		//remove from first place
		list.removeFirst();
		list.print();
		
		System.out.println("data exist ?:"+list.search(100));
		
		//just print in reverse order
		list.reversePrint();
		
		//reverse list
		list.reverseList();
		list.print();
		
	}

}

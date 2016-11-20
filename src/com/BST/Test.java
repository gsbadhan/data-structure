package com.BST;

public class Test {

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<Integer>();
		tree.insert(20);
		tree.insert(7);
		tree.insert(8);
		tree.insert(9);
		tree.insert(50);
		tree.insert(40);
		tree.insert(45);
		tree.insert(35);
		tree.insert(15);
		tree.insert(18);
		tree.insert(19);
		tree.insert(13);
		
		tree.sortedOrder();
		
		tree.delete(20);
		
		tree.sortedOrder();
		
		
	}

}

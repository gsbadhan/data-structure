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
		
		//In Order
		tree.inOrderTraversing();
		
		//Post Order
		tree.postOrderTraversing();
		
		//Pre Order
		tree.preOrderTraversing();
		
		//Deletion
		tree.delete(20);
		
		//see after deletion
		tree.inOrderTraversing();
		
	}

}

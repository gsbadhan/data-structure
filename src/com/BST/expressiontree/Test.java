package com.BST.expressiontree;

public class Test {

	public static void main(String args[]) {
		String exp = "2+(3*4-(5/6^2)*3)*4)";
		Tree tree = new Tree();
		tree.insert(exp);
		tree.show();
	}
}

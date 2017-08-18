package com.fenwicktree;

public class Test {

	public static void main(String[] args) {
		int ar[] = { 1, 3, 2, 6, 5, 6, 10 };
		FenwickTree fenwickTree = new FenwickTree(ar);
	
		fenwickTree.buildIndexTree();
		
		int sum = fenwickTree.getSumUpto(4);
		System.out.println("sum:" + sum);
		
		fenwickTree.updateIndexTree(4, -3);
		
		
	}

}

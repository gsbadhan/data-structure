package com.fenwicktree;

public class Test {

	public static void main(String[] args) {
		int ar[] = { 1, 3, 2, 6, 5, 6, 10 };
		FenwickTree fenwickTree = new FenwickTree(ar);

		fenwickTree.buildIndexTree();

		int sum = fenwickTree.getSumUpto(4);
		System.out.println("sum:" + sum);

		sum = fenwickTree.rangeSum(3,6);
		System.out.println("range sum:" + sum);
		
		// update: decrease old value with new value
		fenwickTree.updateIndexTree(3, 9);
		sum = fenwickTree.getSumUpto(4);
		System.out.println("sum:" + sum);
		
		// update: increase old value with new value
		fenwickTree.updateIndexTree(3, 3);
		sum = fenwickTree.getSumUpto(4);
		System.out.println("sum:" + sum);

	}

}

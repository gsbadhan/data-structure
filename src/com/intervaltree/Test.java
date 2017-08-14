package com.intervaltree;

import com.intervaltree.IntervalTree.Tree.Interval;

public class Test {

	public static void main(String[] args) {
		IntervalTree intervalTree = new IntervalTree();

		// insert interval
		intervalTree.insert(17, 19);
		intervalTree.insert(5, 8);
		intervalTree.insert(21, 24);
		intervalTree.insert(4, 8);
		intervalTree.insert(15, 18);
		intervalTree.insert(7, 10);
		intervalTree.insert(16, 22);

		// search interval
		Interval<Integer> interval = intervalTree.search(23, 25);
		System.out.println("search:" + interval);
		
		interval = intervalTree.search(21, 23);
		System.out.println("search:" + interval);
		
		interval = intervalTree.search(12, 14);
		System.out.println("search:" + interval);

	}

}

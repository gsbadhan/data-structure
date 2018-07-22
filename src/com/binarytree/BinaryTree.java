package com.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary tree opeartions
 *
 */
public class BinaryTree {

	private Tree<Number> tree;

	public Tree<Number> getRootOfTree() {
		return tree;
	}

	public void buildTree(Number[] data) {
		tree = new Tree<>();
		tree.setData(data[0]);
		Queue<Tree<Number>> queue = new LinkedList<>();
		queue.add(tree);
		int childCount = 0;
		while (childCount < data.length) {
			Tree<Number> parent = queue.poll();
			childCount = childCount + 1;
			if (childCount < data.length) {
				Tree<Number> left = new Tree<>(data[childCount]);
				parent.setLeft(left);
				queue.add(left);
			}
			childCount = childCount + 1;
			if (childCount < data.length) {
				Tree<Number> right = new Tree<>(data[childCount]);
				parent.setRight(right);
				queue.add(right);
			}
		}
	}

	// Pre Order traversing
	public void preOrderTraversing() {
		preOrder(tree);
		System.out.println();
	}

	private void preOrder(Tree<Number> t) {
		if (t != null) {
			System.out.print(t.getData() + " ");
		}
		if (t.getLeft() != null) {
			preOrder(t.getLeft());
		}
		if (t.getRight() != null) {
			preOrder(t.getRight());
		}
	}

	// test
	public static void main(String args[]) {
		BinaryTree binaryTree = new BinaryTree();
		Number data[] = { 10, 100, 34, 89, 56, 6, 79, 45 };
		binaryTree.buildTree(data);
		binaryTree.preOrderTraversing();
	}
}

package com.BST;

public class Tree<D extends Number> {
	private Tree<D> left;
	private Tree<D> right;
	private D data;

	public Tree() {
	}

	public Tree(D data) {
		super();
		this.data = data;
	}

	public void sortedOrder() {
		inOrderTraversing(this);
		System.out.println();
	}

	public void insert(D item) {
		if (this.data == null) {
			this.data = item;
			return;
		}
		BSTInsertion(this, item);
	}

	private Tree<D> BSTInsertion(Tree<D> tree, D item) {
		if (tree == null || tree.data == null) {
			Tree<D> newNode = new Tree<D>(item);
			return newNode;
		} else if (item.intValue() < tree.data.intValue()) {
			Tree<D> newNode = BSTInsertion(tree.left, item);
			tree.left = newNode;
		} else if (item.intValue() > tree.data.intValue()) {
			Tree<D> newNode = BSTInsertion(tree.right, item);
			tree.right = newNode;
		}
		return tree;
	}

	public void delete(D item) {
		delete(this, item);
	}

	private Tree<D> delete(Tree<D> tree, D item) {
		if (item.intValue() == tree.data.intValue()) {
			if (tree.left == null && tree.right == null) {
				return null;
			} else if (tree.left == null && tree.right != null) {
				return tree.right;
			} else if (tree.left != null && tree.right == null) {
				return tree.left;
			} else if (tree.left != null && tree.right != null) {
				Tree<D> leftMostTree = rightToLeftMostNode(tree.right);
				tree.data = leftMostTree.data;
				tree.right = delete(tree.right, leftMostTree.data);
				return tree;
			}
		} else if (item.intValue() > tree.data.intValue()) {
			tree.right = delete(tree.right, item);
		} else if (item.intValue() < tree.data.intValue()) {
			tree.left = delete(tree.left, item);
		}

		return tree;
	}

	private Tree<D> rightToLeftMostNode(Tree<D> tree) {
		while (tree.left != null) {
			tree = tree.left;
		}
		return tree;
	}

	// In Order traversing
	private void inOrderTraversing(Tree<D> t) {
		if (t.left != null) {
			inOrderTraversing(t.left);
		}

		System.out.print(t.data + " ");

		if (t.right != null) {
			inOrderTraversing(t.right);
		}
	}

}

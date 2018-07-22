package com.binarytree;

/**
 * binary tree data structure
 */
public class Tree<D> {
	private D data;
	private Tree<D> left;
	private Tree<D> right;

	public Tree() {
		super();
	}

	public Tree(D data) {
		super();
		this.data = data;
	}

	public Tree(D data, Tree<D> left, Tree<D> right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public D getData() {
		return data;
	}

	public void setData(D data) {
		this.data = data;
	}

	public Tree<D> getLeft() {
		return left;
	}

	public void setLeft(Tree<D> left) {
		this.left = left;
	}

	public Tree<D> getRight() {
		return right;
	}

	public void setRight(Tree<D> right) {
		this.right = right;
	}

}

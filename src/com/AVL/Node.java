package com.AVL;

public class Node {
	private Node left;
	private Number data;
	private Node right;
	private int height = 0;

	public Node() {
	}

	public Node(Number data) {
		super();
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Number getData() {
		return data;
	}

	public void setData(Number data) {
		this.data = data;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", height=" + height + "]";
	}

	
}

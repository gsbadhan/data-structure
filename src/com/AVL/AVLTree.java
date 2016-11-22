package com.AVL;

public class AVLTree {
	private Node node;

	protected int max(int n1, int n2) {
		return (n1 > n2 ? n1 : n2);
	}

	protected int getHeight(Node n) {
		if (n == null)
			return -1;
		return n.getHeight();
	}

	protected int getBalanceFactor(Node n) {
		return (getHeight(n.getLeft()) - getHeight(n.getRight()));
	}

	public void add(int data) {
		if (node == null) {
			node = new Node(data);
			return;
		}
		node = insertNode(node, data);
	}

	private Node insertNode(Node node, int data) {
		if (node == null) {
			return new Node(data);
		} else if (node.getData().intValue() > data) {
			Node newNode = insertNode(node.getLeft(), data);
			node.setLeft(newNode);
		} else if (node.getData().intValue() < data) {
			Node newNode = insertNode(node.getRight(), data);
			node.setRight(newNode);
		}
		node.setHeight(max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
		int balanceFactor = getBalanceFactor(node);

		if (balanceFactor > 1 && data < node.getLeft().getData().intValue()) {
			System.out.println("R-Rot:" + node);
			node = rightRotation(node);
		} else if (balanceFactor < -1 && data > node.getRight().getData().intValue()) {
			System.out.println("L-Rot:" + node);
			node = leftRotation(node);
		} else if (balanceFactor > 1 && data > node.getLeft().getData().intValue()) {
			System.out.println("LR-Rot:" + node);
			Node lrotNode = leftRotation(node.getLeft());
			node.setLeft(lrotNode);
			node = rightRotation(node);
		} else if (balanceFactor < -1 && data < node.getRight().getData().intValue()) {
			System.out.println("RL-Rot:" + node);
			Node rrotNode=rightRotation(node.getRight());
			node.setRight(rrotNode);
			node=leftRotation(node);
		}

		return node;
	}

	private Node rightRotation(Node root) {
		Node newRoot = root.getLeft();
		root.setLeft(newRoot.getRight());
		newRoot.setRight(root);

		root.setHeight(max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1);
		newRoot.setHeight(max(getHeight(newRoot.getLeft()), getHeight(newRoot.getRight())) + 1);
		return newRoot;
	}

	private Node leftRotation(Node root) {
		Node newRoot = root.getRight();
		root.setRight(newRoot.getLeft());
		newRoot.setLeft(root);

		root.setHeight(max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1);
		newRoot.setHeight(max(getHeight(newRoot.getLeft()), getHeight(newRoot.getRight())) + 1);
		return newRoot;
	}

	public void show() {
		inorder(node);
		System.out.println();
	}

	private void inorder(Node node) {
		if (node.getLeft() != null) {
			inorder(node.getLeft());
		}
		System.out.print(node.getData() + "(" + node.getHeight() + ") ");
		if (node.getRight() != null) {
			inorder(node.getRight());
		}
	}

}

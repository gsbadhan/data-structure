package com.BST.expressiontree;

import java.util.Stack;

public class Tree {
	private Node root;

	public Tree() {
		root = null;
	}

	public void insert(String exp) {
		System.out.println("infix Exp:" + exp);
		String postfixExp = InfixPostfixConvertor.infixToPostfix(exp);
		System.out.println("postfix Exp:" + postfixExp);

		Stack<Node> treeStack = new Stack<>();
		Node newNode;
		int symbolCounter = 0;
		while (symbolCounter < postfixExp.length()) {
			char symbol = postfixExp.charAt(symbolCounter++);

			if (InfixPostfixConvertor.isOperand(symbol)) {
				newNode = new Node(symbol);
				treeStack.push(newNode);
			} else if (InfixPostfixConvertor.isOperator(symbol)) {
				Node right = treeStack.pop();
				Node left = treeStack.pop();

				newNode = new Node(symbol);
				newNode.leftChild = left;
				newNode.rightChild = right;
				treeStack.push(newNode);
			}
		}
		root = treeStack.pop();
	}

	public void show() {
		traverse(root);
	}

	private void traverse(Node node) {
		if (node != null)
			traverse(node.leftChild);

		if (node != null)
			System.out.print(node.data + " ");

		if (node != null)
			traverse(node.rightChild);
	}

	public static class Node {
		public char data;
		public Node leftChild;
		public Node rightChild;

		public Node(char data) {
			this.data = data;
		}

	}
}

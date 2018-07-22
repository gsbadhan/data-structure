package com.binarytree;

/**
 * lowest common ancestor (LCA) of Binary Tree
 *
 */
public class LCA {

	public static void main(String args[]) {
		BinaryTree binaryTree = new BinaryTree();
		
		//number must be unique
		Number[] data = { 67, 45, 89, 100, 56, 60, 20, 70, 90 };
		//build binary tree
		binaryTree.buildTree(data);
		
		// LCA pair input
		Number a = 45;
		Number b = 89;
		Number lca = findLCA(binaryTree.getRootOfTree(), a, b);
		System.out.println("LCA :" + lca);
	}

	private static Number findLCA(Tree<Number> tree, Number a, Number b) {
		Tree<Number> lcaNode = LCA(tree, a, b);
		return lcaNode != null ? lcaNode.getData() : null;
	}

	private static Tree<Number> LCA(Tree<Number> tree, Number a, Number b) {
		if (tree == null)
			return tree;
		if (tree.getData() == a || tree.getData() == b)
			return tree;
		Tree<Number> left = LCA(tree.getLeft(), a, b);
		Tree<Number> right = LCA(tree.getRight(), a, b);
		if (left != null && right != null)
			return tree;
		if (left == null && right == null)
			return null;
		return left != null ? left : right;
	}
}

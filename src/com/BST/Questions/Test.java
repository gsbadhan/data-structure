package com.BST.Questions;


public class Test {

	public static void main(String[] args) {
		Tree<Number> tree = new Tree<Number>();
		//insert data
		tree.insert(6);
		tree.insert(20);
		tree.insert(18);
		tree.insert(21);
		tree.insert(5);
		tree.insert(7);
		
		//in-order sorting
		tree.sortedOrder();
		
		//Horizontal traversing
		tree.horizontalTraversing();

		//Vertically traversing
		tree.verticalTraversing();
		
		//Left side view of Tree
		tree.showLeftView();
		
		//Right side view of Tree
		tree.showRightView();
		
		//Top side view of Tree
		tree.showTopView();
		
		//Bottom side view of Tree
		tree.showBottomView();
		
		//Maximum diameter/width of Tree 
		tree.maxWidthDepthWise();
		
		//Minimum diameter/width of Tree
		tree.minWidthDepthWise();
		
		//Sum of all data
		tree.sumOfNodesLevelWise();
		
		// Lowest common Ancestor of Two Node
		tree.lowestCommonAncestor(5,14);
		
		// Transform Tree to Linked List
		tree.converTreeToLinkedList();
		
		// Sum of Greater Nodes
		tree.sumOfAllGreaterNodes();
		
		//Mirror of tree
		tree.mirrorOfTree();
		
	}

}

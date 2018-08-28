package com.BST.Questions;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

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

	public void showLeftView() {
		System.out.print("left view:");
		// to avoid taking global variables, i have taken Queue to main maximum depth
		Queue<Integer> maxDepth = new LinkedList<>();
		maxDepth.add(0);
		int currentDepth = 1;
		leftSide(this, maxDepth, currentDepth);
		System.out.println();
	}

	private void leftSide(Tree<D> tree, Queue<Integer> maxDepth, int currentDepth) {
		if (tree == null)
			return;

		if (currentDepth > maxDepth.element()) {
			System.out.print(tree.data + " ");
			// remove old depth, set new max depth
			maxDepth.remove();
			maxDepth.add(currentDepth);
		}
		leftSide(tree.left, maxDepth, currentDepth + 1);
		leftSide(tree.right, maxDepth, currentDepth + 1);
	}

	public void showRightView() {
		System.out.print("right view:");
		Queue<Integer> maxDepth = new LinkedList<>();
		maxDepth.add(0);
		int currentDepth = 1;
		rightSide(this, maxDepth, currentDepth);
		System.out.println();
	}

	private void rightSide(Tree<D> tree, Queue<Integer> maxDepth, int currentDepth) {
		if (tree == null)
			return;

		if (currentDepth > maxDepth.element()) {
			System.out.print(tree.data + " ");
			// remove old depth, set new max depth
			maxDepth.remove();
			maxDepth.add(currentDepth);
		}

		rightSide(tree.right, maxDepth, currentDepth + 1);
		rightSide(tree.left, maxDepth, currentDepth + 1);
	}

	// In-Order traversing
	private void inOrderTraversing(Tree<D> t) {
		if (t.left != null) {
			inOrderTraversing(t.left);
		}

		System.out.print(t.data + " ");

		if (t.right != null) {
			inOrderTraversing(t.right);
		}
	}

	// Horizontal/Level wise traversing
	public void horizontalTraversing() {
		System.out.print("Horizontal view:");
		levelTraversing(this);
	}

	private void levelTraversing(Tree<D> tree) {
		Queue<Tree<D>> que = new LinkedList<>();
		que.add(tree);
		while (!que.isEmpty()) {
			Tree<D> t = que.remove();
			System.out.print(t.data + " ");

			if (t.left != null) {
				que.add(t.left);
			}
			if (t.right != null) {
				que.add(t.right);
			}
		}
		System.out.println();
	}

	// vertical traversing
	public void verticalTraversing() {
		System.out.print("Vertival view:");
		int depth = 0;
		TreeMap<Integer, LinkedList<D>> map = new TreeMap<>();
		verticalTraversing(this, depth, map);
		System.out.println(map);
	}

	private void verticalTraversing(Tree<D> tree, int depth, TreeMap<Integer, LinkedList<D>> map) {
		if (tree.left != null) {
			verticalTraversing(tree.left, depth + 1, map);
		}

		if (map.containsKey(depth)) {
			map.get(depth).add(tree.data);
		} else {
			LinkedList<D> list = new LinkedList<>();
			list.add(tree.data);
			map.put(depth, list);
		}

		if (tree.right != null) {
			verticalTraversing(tree.right, depth - 1, map);
		}
	}

	// Top View traversing
	public void showTopView() {
		topViewHzTraversing(this);
	}

	private void topViewHzTraversing(Tree<D> tree) {
		Set<Integer> depthTracker = new HashSet<>();
		String topView = "";
		Queue<MetaTree> que = new LinkedList<>();
		int depth = 0;
		que.add(new MetaTree(tree, depth));
		while (!que.isEmpty()) {
			MetaTree mt = que.remove();
			Tree<D> t = mt.getTree();
			depth = mt.getLevel();

			if (!depthTracker.contains(depth)) {
				depthTracker.add(depth);
				topView = topView + t.data + " ";
			}

			if (t.left != null) {
				que.add(new MetaTree(t.left, depth - 1));
			}
			if (t.right != null) {
				que.add(new MetaTree(t.right, depth + 1));
			}
		}
		System.out.println("top view:" + topView);
	}

	// Bottom view traversing
	public void showBottomView() {
		TreeMap<Integer, D> map = new TreeMap<>();
		bottomViewHzTraversing(this, map);
		System.out.println("bottom view:" + map);
	}

	private void bottomViewHzTraversing(Tree<D> tree, TreeMap<Integer, D> map) {
		Queue<MetaTree> que = new LinkedList<>();
		int depth = 0;
		que.add(new MetaTree(tree, depth));
		while (!que.isEmpty()) {
			MetaTree mt = que.remove();
			Tree<D> t = mt.getTree();
			depth = mt.getLevel();

			map.put(depth, t.data);

			if (t.left != null) {
				que.add(new MetaTree(t.left, depth - 1));
			}
			if (t.right != null) {
				que.add(new MetaTree(t.right, depth + 1));
			}
		}
	}

	public void maxWidthDepthWise() {
		maxWidth(this);
	}

	private String maxWidth(Tree<D> tree) {
		Queue<Tree<D>> que = new LinkedList<>();
		que.add(tree);
		int width = 0;
		int depth = 0;

		int maxWidth = 0;
		int maxWidthDepth = 0;

		while (!que.isEmpty()) {
			width = que.size();

			if (width > maxWidth) {
				maxWidth = width;
				maxWidthDepth = depth;
			}
			depth = depth + 1;

			while (width > 0) {
				Tree<D> t = que.remove();
				if (t.left != null) {
					que.add(t.left);
				}
				if (t.right != null) {
					que.add(t.right);
				}
				width = width - 1;
			}
		}

		System.out.println("max width:" + maxWidth + " and max depth:" + maxWidthDepth);

		return maxWidthDepth + ":" + maxWidth;
	}

	// showing all level in ASC width order
	public void minWidthDepthWise() {
		// k:depth,v:width
		TreeMap<Integer, Integer> map = new TreeMap<>();
		minWidth(this, map);

		List<Entry<Integer, Integer>> ll = new LinkedList<>(map.entrySet());
		Collections.sort(ll, new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		LinkedHashMap<Integer, Integer> mm = new LinkedHashMap<>();
		for (Entry<Integer, Integer> en : ll) {
			mm.put(en.getKey(), en.getValue());
		}
		System.out.println(mm);
	}

	private void minWidth(Tree<D> tree, TreeMap<Integer, Integer> treeMap) {
		Queue<Tree<D>> que = new LinkedList<>();
		que.add(tree);
		int width = 0;
		int depth = 0;

		while (!que.isEmpty()) {
			width = que.size();

			treeMap.put(depth, width);
			depth = depth + 1;

			while (width > 0) {
				Tree<D> t = que.remove();
				if (t.left != null) {
					que.add(t.left);
				}
				if (t.right != null) {
					que.add(t.right);
				}
				width = width - 1;
			}
		}
	}

	//
	public void sumOfNodesLevelWise() {
		Map<Integer, Integer> map = sumOfNodesHorizontaly(this);
		System.out.println(map);
	}

	private Map<Integer, Integer> sumOfNodesHorizontaly(Tree<D> tree) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		Queue<Tree<D>> que = new LinkedList<>();
		int depth = 0;

		que.add(tree);
		while (!que.isEmpty()) {
			int width = que.size();
			while (width > 0) {
				tree = que.remove();
				if (!map.containsKey(depth)) {
					map.put(depth, tree.data.intValue());
				} else {
					map.put(depth, map.get(depth) + tree.data.intValue());
				}
				width = width - 1;

				// add their child to queue
				if (tree.left != null)
					que.add(tree.left);
				if (tree.right != null)
					que.add(tree.right);
			}
			depth = depth + 1;
		}
		return map;
	}

	// lowest ancestor
	public void lowestCommonAncestor(int a, int b) {
		lowestAncestor(this, a, b);
	}

	private void lowestAncestor(Tree<D> tree, int a, int b) {
		if (tree.data.intValue() > Math.max(a, b)) {
			lowestAncestor(tree.left, a, b);
		} else if (tree.data.intValue() < Math.min(a, b)) {
			lowestAncestor(tree.right, a, b);
		} else {
			System.out.println("lowest ancestor:" + tree.data);
		}
	}

	// hint: BFS traversing
	public void converTreeToLinkedList() {
		LinkedList<Number> dll = new LinkedList<>();
		Queue<Tree<D>> que = new LinkedList<>();
		que.add(this);
		while (!que.isEmpty()) {
			Tree<D> t = que.remove();

			dll.add(t.data);

			if (t.left != null)
				que.add(t.left);
			if (t.right != null)
				que.add(t.right);
		}

		System.out.println("tree to DLL:" + dll);
	}

	class MetaTree {
		private Tree<D> tree;
		private int level;

		public MetaTree(Tree<D> tree, int level) {
			super();
			this.tree = tree;
			this.level = level;
		}

		public Tree<D> getTree() {
			return tree;
		}

		public void setTree(Tree<D> tree) {
			this.tree = tree;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

	}

	public void sumOfAllGreaterNodes() {
		int sum = sumofTree(this, 0);
		System.out.println("sum of maximum nodes: " + sum);

	}

	private int sumofTree(Tree<D> tree, int sum) {

		if (tree.right != null) {
			sum = sumofTree(tree.right, sum);
		}
		sum = sum + tree.data.intValue();

		if (tree.left != null) {
			sum = sumofTree(tree.left, sum);
		}
		return sum;
	}

	public void mirrorOfTree() {
		Queue<Tree<D>> queue = new LinkedList<>();
		Tree<D> t = this;
		queue.add(t);
		while (!queue.isEmpty()) {
			Tree<D> p = queue.poll();
			Tree<D> temp = p.left;
			p.left = p.right;
			p.right = temp;

			if (p.left != null) {
				queue.add(p.left);
			}
			if (p.right != null) {
				queue.add(p.right);
			}
		}
		// print
		inOrderTraversing(t);
		System.out.println();
	}

	public void maxDiameterOfTree() {
		// assuming root node at 1 index
		int globalMaxCount = 1;

		// traverse left sub tree
		int leftSideMaxDiameter = maxDiameter(this.left, this.left == null ? globalMaxCount : globalMaxCount + 1);
		System.out.println("max diameter of left side:" + leftSideMaxDiameter);

		// traverse right sub tree
		int rightSideMaxDiameter = maxDiameter(this.right, this.right == null ? globalMaxCount : globalMaxCount + 1);
		System.out.println("max diameter of right side:" + rightSideMaxDiameter);

		int maxOfBoth = leftSideMaxDiameter > rightSideMaxDiameter ? leftSideMaxDiameter : rightSideMaxDiameter;
		System.out.println("max diameter of tree:" + maxOfBoth);

	}

	private int maxDiameter(Tree<D> tree, int globalMaxCount) {
		if (tree == null)
			return globalMaxCount;

		if (tree.left != null)
			globalMaxCount = maxDiameter(tree.left, globalMaxCount + 1);
		if (tree.right != null)
			globalMaxCount = maxDiameter(tree.right, globalMaxCount + 1);

		return globalMaxCount;
	}

	public void isoMorphicTree(Tree<D> treeA, Tree<D> treeB) {
		boolean isIsomorphic = isIsomorphic(treeA, treeB);
		System.out.println("isIsomorphic:" + isIsomorphic);
	}

	private boolean isIsomorphic(Tree<D> treeA, Tree<D> treeB) {
		if (treeA == null && treeB == null) {
			return true;
		}
		if (treeA == null || treeB == null) {
			return false;
		}
		if (treeA.data != treeB.data) {
			return false;
		}

		// check same side of tree
		boolean isLeftAEqualsLeftB = isIsomorphic(treeA.left, treeB.left);
		boolean isRightAEqualsRightB = isIsomorphic(treeA.right, treeB.right);
		// check different side of tree
		boolean isLeftAEqualsRightB = isIsomorphic(treeA.left, treeB.right);
		boolean isRightAEqualsLeftB = isIsomorphic(treeA.right, treeB.left);

		return (isLeftAEqualsLeftB && isRightAEqualsRightB) || (isLeftAEqualsRightB && isRightAEqualsLeftB);
	}

	public Tree<D> copyTree(Tree<D> tree) {
		Queue<Tree<D>> queue = new LinkedList<>();
		queue.add(tree);
		Tree<D> newTree = new Tree<>();
		while (!queue.isEmpty()) {
			Tree<D> node = queue.poll();
			newTree.insert(node.data);

			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
		return newTree;
	}

	public void maxVerticalSum() {
		findMaxSumVertically(this);
	}

	private void findMaxSumVertically(Tree<D> tree) {
		Map<Integer, Integer> depthWiseSum = new HashMap<>();
		Queue<MetaTree> que = new LinkedList<>();
		que.add(new MetaTree(this, 0));
		while (!que.isEmpty()) {
			MetaTree mt = que.remove();
			Tree<D> tr = mt.getTree();
			int depth = mt.level;
			if (depthWiseSum.containsKey(depth)) {
				depthWiseSum.put(depth, depthWiseSum.get(depth) + tr.data.intValue());
			} else {
				depthWiseSum.put(depth, tr.data.intValue());
			}

			if (tr.left != null)
				que.add(new MetaTree(tr.left, depth + 1));
			if (tr.right != null)
				que.add(new MetaTree(tr.right, depth - 1));
		}

		//
		int maxSum = 0;
		for (int sum : depthWiseSum.values()) {
			maxSum = Math.max(maxSum, sum);
		}
		System.out.println("maximum vertical sum:" + maxSum);
	}

	// maximum sum of sub-tree from tree
	public void maximumSumOfSubTree() {
		int maxSum = maximumSumOfSubTree(this, 0);
		System.out.println("maximum sum of sub-tree:" + maxSum);
	}

	private int maximumSumOfSubTree(Tree<D> tree, int sum) {
		if (tree == null)
			return 0;
		int leftSubTreeSum = maximumSumOfSubTree(tree.left, sum);
		int rightSubTreeSum = maximumSumOfSubTree(tree.right, sum);
		sum = tree.data.intValue() + Math.max(leftSubTreeSum, rightSubTreeSum);
		return sum;
	}

}

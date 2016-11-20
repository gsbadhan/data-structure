package com.BST.Questions;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
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
		int depth = 0;
		TreeMap<Integer, Number> map = new TreeMap<>();
		leftSide(this, depth, map);

		System.out.println(map);
	}

	private void leftSide(Tree<D> tree, int depth, TreeMap<Integer, Number> map) {
		if (tree.left != null) {
			leftSide(tree.left, depth + 1, map);
		}

		if (!map.containsKey(depth)) {
			map.put(depth, tree.data);
		}

		if (tree.right != null) {
			leftSide(tree.right, depth + 1, map);
		}

	}

	public void showRightView() {
		System.out.print("right view:");
		int depth = 0;
		TreeMap<Integer, Number> map = new TreeMap<>();
		rightSide(this, depth, map);

		System.out.println(map);
	}

	private void rightSide(Tree<D> tree, int depth, TreeMap<Integer, Number> map) {
		if (tree.right != null) {
			rightSide(tree.right, depth + 1, map);
		}

		if (!map.containsKey(depth)) {
			map.put(depth, tree.data);
		}

		if (tree.left != null) {
			rightSide(tree.left, depth + 1, map);
		}

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
		TreeMap<Integer, D> map = new TreeMap<>();
		topViewHzTraversing(this, map);
		System.out.println("top view:" + map);
	}

	private void topViewHzTraversing(Tree<D> tree, TreeMap<Integer, D> map) {
		Queue<MetaTree> que = new LinkedList<>();
		int depth = 0;
		que.add(new MetaTree(tree, depth));
		while (!que.isEmpty()) {
			MetaTree mt = que.remove();
			Tree<D> t = mt.getTree();
			depth = mt.getLevel();

			if (!map.containsKey(depth)) {
				map.put(depth, t.data);
			}

			if (t.left != null) {
				que.add(new MetaTree(t.left, depth - 1));
			}
			if (t.right != null) {
				que.add(new MetaTree(t.right, depth + 1));
			}
		}
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
		String output = maxWidth(this);
		System.out.println("max width:" + output);
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
		System.out.println("sum[" + sum + "]");

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

}

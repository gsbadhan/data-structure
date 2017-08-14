package com.intervaltree;

import com.intervaltree.IntervalTree.Tree.Interval;

public class IntervalTree {
	private Tree<Integer> rootTree;

	public void insert(int min, int max) {
		if (min > max)
			throw new IllegalArgumentException("min value must be less than max value !!");

		if (rootTree == null) {
			rootTree = new Tree<>(min, max);
			return;
		}
		insert(min, max, rootTree);
	}

	private Tree<Integer> insert(int min, int max, Tree<Integer> node) {
		if (node == null) {
			return new Tree<>(min, max);
		}
		if (min < node.getInterval().min) {
			node.left = insert(min, max, node.left);
			node.setMax(Math.max(node.getMax(), node.getLeft().getMax()));
		} else if (min > node.getInterval().min) {
			node.right = insert(min, max, node.right);
			node.setMax(Math.max(node.getMax(), node.getRight().getMax()));
		}
		return node;
	}

	public Interval<Integer> search(int min, int max) {
		Tree<Integer> node = rootTree;
		while (node != null) {
			if (intersect(min, max, node.getInterval())) {
				return node.getInterval();
			} else if (node.left == null || min > node.left.getMax()) {
				node = node.right;
			} else {
				node = node.left;
			}
		}
		return null;
	}

	private boolean intersect(int min, int max, Interval<Integer> interval) {
		int s1 = min;
		int e1 = max;
		int s2 = interval.min;
		int e2 = interval.max;
		return (e1 > s2 && e2 > s1);
	}

	protected static class Tree<T extends Number> {
		private Tree<T> left;
		private Tree<T> right;
		private Interval<Integer> interval;
		private int max;

		public Tree(int min, int max) {
			this.interval = new Interval<>(min, max);
			this.max = Math.max(min, max);
		}

		public Tree<T> getLeft() {
			return left;
		}

		public Tree<T> getRight() {
			return right;
		}

		public Interval<Integer> getInterval() {
			return interval;
		}

		public int getMax() {
			return max;
		}

		public void setMax(int max) {
			this.max = max;
		}

		@Override
		public String toString() {
			return "Tree [interval=" + interval + ", max=" + max + "]";
		}

		protected static class Interval<T extends Number> {
			private T min;
			private T max;

			public Interval(T min, T max) {
				super();
				this.min = min;
				this.max = max;
			}

			public T getMin() {
				return min;
			}

			public T getMax() {
				return max;
			}

			@Override
			public String toString() {
				return "Interval [min=" + min + ", max=" + max + "]";
			}
		}
	}
}

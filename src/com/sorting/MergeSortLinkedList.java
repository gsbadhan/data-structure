package com.sorting;

public class MergeSortLinkedList {
	private Node first;
	private Node last;

	public Node getLast() {
		return last;
	}

	public void insert(int data) {
		if (first == null) {
			first = new Node(data);
			last = first;
		} else {
			last.setNext(new Node(data));
			last = last.getNext();
		}
	}

	public void sort() {
		first = mergeSort(first);
		show();
	}

	private Node mergeSort(Node node) {
		if (node == null || node.next == null)
			return node;

		Node a = node;
		Node b = node.next;

		while (b != null && b.next != null) {
			a = a.next;
			b = b.next.next;
		}

		b = a.next;
		a.next = null;
		a = node;

		a = mergeSort(a);
		b = mergeSort(b);
		Node newList = merge(a, b);

		return newList;
	}

	private Node merge(Node l1, Node l2) {
		Node newNode = new Node();
		Node head = newNode;

		while (l1 != null && l2 != null) {
			if (l1.getData() < l2.getData()) {
				newNode.next = l1;
				l1 = l1.getNext();
			} else {
				newNode.next = l2;
				l2 = l2.getNext();
			}
			newNode = newNode.next;
		}
		newNode.next = (l1 == null ? l2 : l1);

		head = head.next;
		return head;
	}

	public void show() {
		Node node = first;
		while (node != null) {
			System.out.print(node.getData() + " ");
			node = node.getNext();
		}
		System.out.println();
	}

	protected class Node {
		int data;
		Node next;

		public Node() {
		}

		public Node(int data) {
			super();
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "[" + data + "]";
		}

	}

	public static void main(String args[]) {
		MergeSortLinkedList ll = new MergeSortLinkedList();

		ll.insert(11);
		ll.insert(17);
		ll.insert(70);
		ll.insert(67);
		ll.insert(690);
		ll.insert(90);

		ll.show();
		ll.sort();
	}

}

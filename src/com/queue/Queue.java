package com.queue;

public class Queue<T> {
	private Node<T> head;

	public Queue() {
		head = null;
	}

	/**
	 * insert data at last
	 * 
	 * @param data
	 */
	public void add(T data) {
		if (head == null) {
			head = new Node<T>(data);
			return;
		}
		append(head, data);
	}

	private void append(Node<T> head, T data) {
		if (head.getNext() != null) {
			append(head.getNext(), data);
		} else {
			head.setNext(new Node<T>(data));
		}
	}

	/**
	 * Take out data from first
	 * 
	 * @return
	 */
	public T remove() {
		if (head == null) {
			return null;
		}
		T data = head.getData();
		head = head.getNext();
		return data;

	}

	public void printQueue() {
		if (head == null) {
			System.out.println("queue is empty..!!");
			return;
		}
		Node<T> t = head;
		while (t != null) {
			System.out.print(t.getData() + " ");
			t = t.getNext();
		}
		System.out.println();
	}

}

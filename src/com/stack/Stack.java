package com.stack;

public class Stack<T> {
	private Node<T> head;

	public Stack() {
		head = null;
	}

	/**
	 * insert data on top
	 * @param data
	 */
	public void push(T data) {
		if (head == null) {
			head = new Node(data);
			return;
		}
		Node node = new Node(data);
		node.setNext(head);
		head = node;
	}

	/**
	 * Take out data from top
	 * @return
	 */
	public T pop() {
		T data = null;
		if (head == null)
			return null;

		if (head.getNext() == null) {
			data = head.getData();
			head = null;
			return data;
		}

		Node next = head.getNext();
		data = head.getData();
		head = null;
		head = next;
		return data;
	}
	
	public T getTop(){
		if(head!=null){
			return head.getData();
		}
		return null;
	}

}

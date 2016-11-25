package com.circularLinklist;

public class CircularLinkedList<T> {
	private Node<T> head;
	private Node<T> end;

	public void add(T data) {
		if (head == null) {
			Node<T> n = new Node<T>(data);
			n.setNext(n);
			head = n;
			end = head;
			return;
		}
		append(data);
	}

	private void append(T data) {
		Node<T> next = new Node<T>(data);
		end.setNext(next);
		next.setNext(head);
		end = next;
	}

	public boolean search(T data) {
		if (head == null)
			return false;

		Node<T> n = head;
		do {
			if (n.getData() == data) {
				return true;
			}
			n = n.getNext();
		} while (n != head);
		return false;
	}

	public boolean remove(T data) {
		if (head == null) {
			return false;
		}

		Node<T> curr = head;
		Node<T> prev = null;

		do {
			if (curr.getData() == data) {
				if (prev == null) {
					if (curr.getNext() == head) {
						head = null;
						end = null;
					} else {
						head = curr.getNext();
						end.setNext(head);
					}
				} else {
					prev.setNext(curr.getNext());
					if (curr.getNext() == head) {
						end = prev;
					}
				}
				curr = null;
				return true;
			}
			prev = curr;
			curr = curr.getNext();
		} while (curr != head);
		return false;

	}

	public void print() {
		if (head == null)
			return;
		Node<T> n = head;
		do {
			System.out.print(n.getData() + " ");
			n = n.getNext();
		} while (n != head);
		System.out.println();
	}
}

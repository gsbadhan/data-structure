package com.linklist;

public class LinkedList<T> {
	private Node<T> head;
	private Node<T> end;

	public void add(T data) {
		if (head == null) {
			head = new Node<T>(data);
			end = head;
			return;
		}
		append(data);
	}

	private void append(T data) {
		end.setNext(new Node<T>(data));
		end = end.getNext();
	}

	public void addLast(T data) {
		add(data);
	}

	public void addFirst(T data) {
		Node<T> n = new Node<T>(data);
		n.setNext(head);
		head = n;
	}

	public boolean remove(T data) {
		if (head == null)
			return false;
		Node<T> curr = head;
		// if data at first place
		if (curr.getData() == data) {
			if (curr.getNext() == null) {
				curr = null;
				head = null;
				isEndOfList(head);
			} else {
				head = curr.getNext();
				curr = null;
			}
			return true;
		}

		// if data somewhere in-between or end
		Node<T> prev = null;
		while (curr != null) {
			if (curr.getData() == data) {
				prev.setNext(curr.getNext());
				curr = null;
				isEndOfList(prev);
				return true;
			}
			prev = curr;
			curr = curr.getNext();
		}
		return false;
	}

	private void isEndOfList(Node<T> n) {
		if (n == null || n.getNext() == null) {
			end = n;
		}
	}

	public boolean removeFirst() {
		if (head == null)
			return false;
		Node<T> n = head;
		head = n.getNext();
		n = null;
		isEndOfList(head);
		return true;
	}

	public boolean search(T data) {
		Node<T> n = head;
		if (n == null) {
			return false;
		}
		while (n != null) {
			if (n.getData() == data) {
				return true;
			}
			n = n.getNext();
		}
		return false;
	}

	public void print() {
		if (head == null) {
			return;
		}
		Node<T> t = head;
		while (t != null) {
			System.out.print(t.getData() + " ");
			t = t.getNext();
		}
		System.out.println();
	}

	public void reversePrint() {
		reversePrint(head);
		System.out.println();
	}

	private void reversePrint(Node<T> curr) {
		if (curr.getNext() != null)
			reversePrint(curr.getNext());
		System.out.print(curr.getData() + " ");
	}

	public void reverseList() {
		reverseList(head);
	}

	private Node<T> reverseList(Node<T> curr) {
		Node<T> hd = null;
		if (curr.getNext() != null)
			hd = reverseList(curr.getNext());
		if (curr.getNext() == null) {
			head = curr;
			return curr;
		} else {
			hd.setNext(curr);
			curr.setNext(null);
			// just to maintain end pointer to main whole list consistent
			end = hd.getNext();
			return hd.getNext();
		}
	}
}

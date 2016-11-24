package com.doublelinklist;

public class DoubleLinklist<T> {
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
		Node<T> n = new Node<T>(data);
		n.setPrevious(end);
		end.setNext(n);
		end = n;
	}

	public void addFirst(T data) {
		Node<T> n = new Node<T>(data);
		if (head != null) {
			n.setNext(head);
			head.setPrevious(n);
		}
		head = n;
	}

	public void addLast(T data) {
		add(data);
	}

	public boolean removeFirst() {
		if (head == null) {
			return false;
		}
		if (head.getNext() == null) {
			head = null;
			end = head;
			return true;
		} else {
			Node<T> n = head.getNext();
			n.setPrevious(null);
			head = n;
			n = null;
			return true;
		}
	}

	public boolean removeLast() {
		if (end == null) {
			return false;
		}
		if (end.getPrevious() == null) {
			end = null;
			head = end;
			return true;
		} else {
			Node<T> n = end.getPrevious();
			n.setNext(null);
			end = null;
			end = n;
			return true;
		}
	}

	public boolean remove(T data) {
		if (head == null)
			return false;
		Node<T> curr = head;
		while (curr != null) {
			if (curr.getData() == data) {
				if (curr.getPrevious() == null) {
					head = curr.getNext();
					curr = null;
					if (head != null) {
						head.setPrevious(null);
					} else {
						end = head;
					}
				} else {
					Node<T> prev = curr.getPrevious();
					Node<T> next = curr.getNext();
					prev.setNext(next);
					if (next != null) {
						next.setPrevious(prev);
					}
					if (next == null || next.getNext() == null) {
						end = next;
					}
					curr = null;
					return true;
				}
				return true;
			}
			curr = curr.getNext();
		}
		return false;
	}

	public boolean search(T data) {
		if (head == null) {
			return false;
		}
		Node<T> n = head;
		while (n != null) {
			if (n.getData() == data) {
				return true;
			}
			n = n.getNext();
		}
		return false;
	}

	public void print() {
		Node<T> n = head;
		while (n != null) {
			System.out.print(n.getData() + " ");
			n = n.getNext();
		}
		System.out.println();
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}
}

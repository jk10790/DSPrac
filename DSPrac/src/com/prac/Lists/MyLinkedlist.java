package com.prac.Lists;

public class MyLinkedlist<T> {

	Node<T> head;
	Node<T> tail;

	public void baseCase(Node<T> n) {
		head = n;
		tail = n;
	}

	public void add(T e) {
		Node<T> n = new Node<T>();
		n.setValue(e);
		if (head == null) {
			baseCase(n);
		} else {
			tail.next = n;
			tail = n;
		}
	}

	public void addFirst(T e) {
		Node<T> n = new Node<T>();
		n.setValue(e);
		if (head == null) {
			baseCase(n);
		} else {
			n.next = head;
			head = n;
		}
	}

	public void addLast(T e) {
		Node<T> n = new Node<T>();
		n.setValue(e);
		if (head == null) {
			baseCase(n);
		} else if (head.compareTo((T) tail) == 0) {
			head.next = n;
			tail = n;
		} else {
			tail.next = n;
			tail = n;
		}
	}

	public void addAfter(T e, T after) {
		Node<T> tmp = head;
		Node<T> afterNode = null;
		while (true) {
			if (tmp == null) {
				break;
			} else if (tmp.compareTo(after) == 0) {
				afterNode = tmp;
				break;
			}
			tmp = tmp.getNext();
		}

		if (afterNode == null) {
			System.out.println("Unable to find the given element");
		} else {
			Node<T> n = new Node<T>();
			n.setValue(e);
			n.setNext(tmp.getNext());
			if (tail == null)
				tail = n;
			tmp.setNext(n);
		}
	}

	public void addAt(int index, T e) {
		Node<T> n = new Node<T>();
		n.setValue(e);
		Node<T> tmp = head;
		for (int i = 0; i < index - 1 && tmp.next != null; i++) {
			// Gives the previous element of the index
			tmp = tmp.next;
		}
		n.next = tmp.next;
		tmp.next = n;
	}

	public void removeAt(int index) {
		Node<T> tmp = head;
		for (int i = 0; i < index - 1 && tmp.next != null; i++) {
			tmp = tmp.next;
		}
		if (tail.compareTo((T) tmp.next) == 0) {
			tail = tmp;
		}
		tmp.next = tmp.next.next;
	}

	public void printList() {
		Node<T> temp = head;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {

		MyLinkedlist<String> ml = new MyLinkedlist<String>();
		ml.add("Jai");
		ml.add("Kiran");
		ml.add("JK");
		System.out.println("---------Before-----------");
		ml.printList();
		ml.addAt(1, "Jj");
		System.out.println("---------After Add at----------");
		ml.printList();
		ml.removeAt(4);
		System.out.println("After remove at--------------");
		ml.printList();
	}

	@SuppressWarnings("hiding")
	class Node<T> implements Comparable<T> {

		private T value;
		private Node<T> next;

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		@Override
		public int compareTo(T arg) {
			if (arg == this.value)
				return 0;
			else
				return 1;
		}

	}

}

package com.prac.Lists;

public class MyDLLinkedlist<T> {

    private Node<T> head;
    private Node<T> tail;

    public void baseCase(Node<T> n) {
	head = n;
	tail = n;
    }

    public void add(T e) {
	Node<T> n = new Node<T>(e);
	if (head == null) {
	    baseCase(n);
	    return;
	}
	tail.next = n;
	n.prev = tail;
	tail = n;
    }

    public void addFirst(T e) {
	Node<T> n = new Node<T>(e);
	if (head == null) {
	    baseCase(n);
	    return;
	}
	Node<T> tmp = head;
	head = n;
	n.next = tmp;
	tmp.prev = head;
    }

    public void addLast(T e) {
	Node<T> n = new Node<T>(e);
	if (head == null) {
	    baseCase(n);
	    return;
	}
	Node<T> tmp = tail;
	tail = n;
	n.prev = tmp;
	tmp.next = tail;
    }

    public void addAt(T e, int index) {
	Node<T> n = new Node<T>(e);
	Node<T> tmp = head;
	for (int i = 0; i < index - 1 && tmp.next != null; i++) {
	    tmp = tmp.next;
	}
	if (tmp == tail) {
	    tmp.next = n;
	    n.prev = tmp;
	    tail = n;
	} else {
	    Node<T> refNode = tmp.next;
	    tmp.next = n;
	    n.prev = tmp;
	    n.next = refNode;
	    refNode.prev = n;
	}
    }

    public void removeAt(int index) {
	Node<T> tmp = head;
	if (index == 0) {
	    head = tmp.next;
	    tmp.next = null;
	    head.prev = null;
	    return;
	}

	for (int i = 0; i < index - 1 && tmp.next != null; i++) {
	    tmp = tmp.next;
	}
	if (tmp == tail)
	    throw new IndexOutOfBoundsException("Unavailable index");
	Node<T> refNode = tmp.next;
	if (refNode == tail) {
	    tmp.next = null;
	    refNode.prev = null;
	} else {
	    Node<T> nextRef = refNode.next;
	    tmp.next = nextRef;
	    nextRef.prev = tmp;
	    refNode.next = null;
	    refNode.prev = null;
	}
    }

    public void printList() {
	Node<T> temp = head;
	while (temp != null) {
	    System.out.println(temp.value);
	    temp = temp.next;
	}
    }

    public void printListBackwards() {
	Node<T> temp = tail;
	while (temp != null) {
	    System.out.println(temp.value);
	    temp = temp.prev;
	}
    }

    public static void main(String[] args) {
	MyDLLinkedlist<String> ml = new MyDLLinkedlist<>();
	ml.add("Jai");
	ml.add("kiran");
	ml.add("JK");
	ml.addFirst("Raghu");
	ml.addLast("Patki");
	ml.addAt("Tina", 2);
	ml.printList();
	System.out.println("---------------------");
	ml.removeAt(4);
	ml.printListBackwards();
    }

    @SuppressWarnings("hiding")
    class Node<T> {
	private Node<T> next;
	private Node<T> prev;
	private T value;

	public Node(T e) {
	    this.value = e;
	}

	public Node<T> getNext() {
	    return next;
	}

	public void setNext(Node<T> next) {
	    this.next = next;
	}

	public Node<T> getPrev() {
	    return prev;
	}

	public void setPrev(Node<T> prev) {
	    this.prev = prev;
	}

	public T getValue() {
	    return value;
	}

	public void setValue(T value) {
	    this.value = value;
	}
    }

}

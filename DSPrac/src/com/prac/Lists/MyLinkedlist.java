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
	} else if (head == tail) {
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
	    } else if (tmp == after) {
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

	if (index == 0) {
	    head = head.next;
	    tmp.next = null;
	    return;
	}
	for (int i = 0; i < index - 1 && tmp.next != null; i++) {
	    tmp = tmp.next;
	}
	if (tmp == null || tmp == tail)
	    throw new IndexOutOfBoundsException("Index is unavailable");
	else {
	    Node<T> refNode = tmp.next;
	    if (refNode == tail) {
		tmp.next = null;
		tail = tmp;
	    } else
		tmp.next = refNode.next;
	    refNode.setNext(null);

	}
    }

    public void kthElementfromLast(int n) {
	Node<T> tmp = head;
	int len = 0;
	while (tmp != null) {
	    tmp = tmp.next;
	    len++;
	}
	if (len < n) {
	    System.out.println("Index unavailable ");
	    return;
	}
	tmp = head;
	for (int i = 0; i < len - n; i++) {
	    tmp = tmp.next;
	}
	System.out.println(n + "th element from last is " + tmp.value);
    }

    public void reverseList() {
	Node<T> current = head;
	Node<T> prev = null;

	while (current != null) {
	    Node<T> next = current.next; // Point to next node
	    current.next = prev; // change the direction of the link
	    prev = current; // prev will be current now
	    current = next; // move on to next element until null
	}
	head = prev;
	printList();
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
	ml.removeAt(3);
	System.out.println("After remove at--------------");
	ml.printList();
	System.out.println("-----------------------");
	ml.addFirst("Raghu");
	ml.addLast("Patki");
	ml.printList();

	ml.kthElementfromLast(2);
	System.out.println("Reverse of list");
	System.out.println("--------------------------");
	ml.reverseList();
    }

    @SuppressWarnings("hiding")
    class Node<T> {

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

    }

}

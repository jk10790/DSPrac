package com.prac.Queue;

public class MyQueue<T> {

	int MAX = 5;
	Object[] queue;
	int front;
	int rear;
	int size;

	MyQueue() {
		queue = new Object[MAX];
		front = 0;
		rear = -1;
		size = 0;
	}

	boolean isEmpty() {
		return (size == 0);
	}

	void enQueue(T e) {
		if (size > MAX)
			System.out.println("Overflow");
		else {
			System.out.println("Adding element " + e + " at the end");
			queue[++rear] = e;
			size++;
		}
	}

	void deQueue() {
		if (isEmpty())
			System.out.println("Queue is empty");
		else {
			System.out.println("Removing element " + queue[front]);
			++front;
			size--;
		}
	}

	void peek() {
		System.out.println("Current front element is " + queue[front]);
	}

	public static void main(String[] args) {

		MyQueue<Integer> mq = new MyQueue<>();
		mq.enQueue(1);
		mq.deQueue();
		mq.enQueue(1);
		mq.enQueue(2);
		mq.deQueue();
		mq.peek();
	}
}

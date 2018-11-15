package com.prac.Stack;

public class MyStack {

	final int MAX = 5;
	int[] stack;
	int top;

	MyStack() {
		stack = new int[MAX];
		top = -1;
	}

	void push(int x) {
		if (top > MAX)
			System.out.println("Overflow");
		else
			stack[++top] = x;
	}

	void pop() {
		if (top < 0) {
			System.out.println("Underflow");
		} else {
			int x = stack[top--];
		}
	}

	boolean isEmpty() {
		if (top < 0) {
			System.out.println("Stack is empty");
			return true;
		} else {
			return false;
		}
	}

	void peek() {
		if (!isEmpty())
			System.out.println("Top element is " + stack[top]);
	}

	public static void main(String[] args) {
		MyStack ms = new MyStack();
		ms.isEmpty();
		ms.pop();
		ms.push(1);
		ms.push(2);
		ms.push(3);
		ms.peek();
		ms.pop();
		ms.peek();
	}

}

package com.prac.Arrays;

public class MyArraylist {

    public static int MAX_CAPACITY = 5;
    public Object[] myList;
    public int currentIndex;

    public MyArraylist() {
	myList = new Object[MAX_CAPACITY];
    }

    public void ensureCapacity() {
	int newSize = MAX_CAPACITY + (MAX_CAPACITY / 2);
	MAX_CAPACITY = newSize;
	Object[] tempList = new Object[newSize];
	for (int i = 0; i < myList.length; i++) {
	    tempList[i] = myList[i];
	}

	this.myList = tempList;
	System.out.println("New size of myList is " + this.myList.length);

    }

    public void add(Object e) {
	if (currentIndex == MAX_CAPACITY)
	    ensureCapacity();
	myList[currentIndex] = e;
	this.currentIndex++;
    }

    public void remove(int index) throws Exception {
	if (index > currentIndex-1)
	    throw new IndexOutOfBoundsException("LastIndex is " + (currentIndex-1));
	else if (index < 0)
	    throw new Exception("please enter a positive value");
	else {
	    for (int i = index; i < myList.length - 1; i++)
		myList[i] = myList[i + 1];
	}
	this.currentIndex--;
    }

    public Object get(int index) throws Exception {

	if (index > currentIndex-1)
	    throw new IndexOutOfBoundsException("LastIndex is " + (currentIndex-1));
	else if (index < 0)
	    throw new Exception("please enter a positive value");
	else
	    return myList[index];

    }

    public static void main(String[] args) throws Exception {
	MyArraylist ml = new MyArraylist();
	ml.add("Jai");
	ml.add("Kiran");
	ml.add("Kriran");
	ml.add("Kifran");
	ml.add("Kirhgan");
	ml.add("Kirahn");
	System.out.println(ml.get(1));
	ml.remove(0);
	System.out.println(ml.get(1));
    }

}

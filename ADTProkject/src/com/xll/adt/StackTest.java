package com.xll.adt;

public class StackTest {

	public static void main(String[] args) {
		MyStack myStack=new MyStack(4);
		myStack.push(10);
		myStack.push(20);
		myStack.push(30);
		myStack.push(40);
		myStack.push(50);
		
		while(!myStack.isEmpty()) {
			long s = myStack.pop();
			System.out.println(s);
		}

	}

}

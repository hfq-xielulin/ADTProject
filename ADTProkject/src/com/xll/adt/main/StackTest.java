package com.xll.adt.main;

import com.xll.adt.adt.MyQueue;
import com.xll.adt.adt.MyStack;
import com.xll.adt.adt.PriorityQueue;

public class StackTest {

	public static void main(String[] args) {
		
		doStack();
		doqueue();
		doPriQueue();
	}
	
	private static void doPriQueue() {
		System.out.println("**************有序队列********************");
		
		PriorityQueue PriorityQueue=new PriorityQueue(10);
		
		PriorityQueue.insert(10);
		PriorityQueue.insert(15);
		PriorityQueue.insert(13);
		PriorityQueue.insert(17);
		PriorityQueue.insert(19);
		
		System.out.println(PriorityQueue.size());
		while(!PriorityQueue.isEmpty()) {
			System.out.println(PriorityQueue.remove());
		}
		
		System.out.println("******************************************");
		
	}

	/**
	 * 
	 * @author:xielulin 
	 * @Description: 队列的测试用例
	 * @throws:
	 * @date:2017年11月30日 下午6:03:27
	 */
	private static void doqueue() {
		System.out.println("**************队列********************");
		
		MyQueue queue=new MyQueue(10);
		
		/**
		 * 插入8个数据
		 */
		queue.insert(10);
		queue.insert(11);
		queue.insert(12);
		queue.insert(13);
		queue.insert(14);
		queue.insert(15);
		queue.insert(16);
		queue.insert(17);
		
		/**
		 * 删除3个数据
		 */
		queue.remove();
		queue.remove();
		queue.remove();
		
		/**
		 * 插入7个数据
		 */
		queue.insert(4);
		queue.insert(5);
		queue.insert(6);
		queue.insert(7);
		
		queue.insert(8);
		queue.insert(9);
		queue.insert(10);
		
		
		while(!queue.isEmpty()) {
			System.out.println(queue.remove());
		}
		
		System.out.println("************************************");
		
	}


	/**
	 * 
	 * @author:xielulin 
	 * @Description:栈的测试用例
	 * @throws:
	 * @date:2017年11月30日 下午4:56:58
	 */
	public static void doStack() {
		System.out.println("**************栈********************");
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
		System.out.println("************************************");
	}

}

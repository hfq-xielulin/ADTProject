package com.xll.adt.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.xll.adt.adt.BinarySerachTree;
import com.xll.adt.adt.LinkList;
import com.xll.adt.adt.LinkedList;
import com.xll.adt.adt.ListQueue;
import com.xll.adt.adt.MyLinkedList;
import com.xll.adt.adt.MyQueue;
import com.xll.adt.adt.MyStack;
import com.xll.adt.adt.PriorityQueue;
import com.xll.adt.adt.SortedList;
import com.xll.adt.demo.Demo;

@SuppressWarnings("unused")
public class StackTest {

	public static void main(String[] args) throws Exception {
		doBinarySearchTree();
	}
	private static void doBinarySearchTree() throws Exception {
		BinarySerachTree<Integer> tree=new BinarySerachTree<Integer>();
		tree.insert(25);
		tree.insert(10);
		tree.insert(15);
		tree.insert(30);
		tree.insert(35);
		tree.insert(23);
		
//		tree.printTree();
//		tree.preOrder1(tree.getRoot());
//		tree.midOrder1(tree.getRoot());
//		tree.posOrder1(tree.getRoot());
		tree.levelOrder1(tree.getRoot());
		int maxDepth = Demo.MaxDeep(tree.getRoot());
		int minDepth = Demo.MinDepth(tree.getRoot());
		System.out.println("最大深度：" + maxDepth);
		System.out.println("最小深度：" + minDepth);
//		tree.PreOrder(tree.getRoot());
//        System.out.println();
//		tree.InOrder(tree.getRoot());
//        System.out.println();
//		tree.PostOrder(tree.getRoot());
//		System.out.println("aaaaaaaaaaa");
//		System.out.println(tree.finMax());
//	
//		
//		System.out.println(	tree.finMin());
//		System.out.println("aaaaaaaaaaa");
//		tree.remove(30);
//		
//		tree.printTree();
	}
	public void doADT() {

		/*doStack();
		doqueue();
		doPriQueue();
		doList();
		doLinkList();
		doqueue();
		doListQueue();
		doSortedList();

		doLinkedList();*/
		
		
	/*	String key ="1234aA";
		
		if(!verifyString(key, "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[a-zA-Z0-9]{8,32}")) {
			System.out.println("不符合标准");
		}else {
			System.out.println("符合标准");
		}
		if(!verifyString(key, ".*\\d+.*")) {
			System.out.println("密码必须包含数字:" + key);
		}
		if(verifyString(key, "^[A-Z]+$")) {
			System.out.println("密码必须包含大写字母:" + key);
		}
		if(verifyString(key, "^[a-z]+$")) {
			System.out.println("密码必须包含小写字母:" + key);
		}else
			System.out.println("验证完毕");
		
		System.out.println(getRandomString(19));*/
	}
	
	
	public static String getRandomString(int length) {
		String sb;
		String str1="abcdefghijklmnopqrstuvwxyz";
		String str2="1234567890";
		String str3="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String str4="1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		sb=getString(1,str1)+getString(1,str3)+getString(1,str2)+getString(length-3,str4);
		return sb;
	}

	/**
	 * 
	 * @author:xielulin 
	 * @Description: 生成随机字符串
	 * @param length
	 * @param s
	 * @return:
	 * @throws:
	 * @date:2017年12月7日 上午9:52:08
	 */
	public static String getString(int length,String s) {
		StringBuffer buffer = new StringBuffer(s);
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int range = buffer.length();
		for (int i = 0; i < length; i++) {
			sb.append(buffer.charAt(r.nextInt(range)));
		}
		return sb.toString();
	}

	private static boolean verifyString(String cs, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cs);
		return matcher.matches();
	}

	private static void doLinkedList() {
		System.out.println("**************双向链表********************");
		LinkedList<String> list = new LinkedList<String>();
		list.insertHead("hello");
		list.inserLast("world");
		list.insertAfter("hi", "hello");
		list.displayByHead();
		list.delete("hi");
		list.displayByLast();

		System.out.println("****************************************");
	}

	private static void doSortedList() {
		System.out.println("**************有序链表********************");
		SortedList list = new SortedList();
		list.insert(10);
		list.insert(13);
		list.insert(12);
		list.insert(1);
		list.insert(19);
		list.insert(17);

		list.display();

		System.out.println("*****************************************");
	}

	private static void doListQueue() {
		System.out.println("**************基于list实现的队列********************");

		ListQueue<Integer> queue = new ListQueue<Integer>();

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

		queue.display();
		while (!queue.isEmpty()) {
			System.out.println(queue.remove());
		}

		System.out.println("************************************");
	}

	private static void doLinkList() {
		System.out.println("**************list链表********************");
		LinkList<String> list = new LinkList<String>();
		/*list.insretFirst("hello");
		
		list.insretLast("world");
		
		list.insretFirst("hello");
		
		list.insretLast("world");*/

		list.insretFirst("2");
		list.insretFirst("1");
		list.insretLast("3");
		list.insretLast("4");

		list.display();
		list.deleteFirst();
		list.display();
		list.deleteLast();
		list.display();
		System.out.println("******************************************");
	}

	/**
	 * 
	 * @author:xielulin 
	 * @Description: 简单链表测试用例
	 * @throws:
	 * @date:2017年12月1日 下午4:17:35
	 */
	private static void doList() {
		System.out.println("**************list链表********************");
		MyLinkedList<String> list = new MyLinkedList<>();
		list.insertFirst("hello ");
		list.insertFirst("world ");
		list.insertFirst("hi ");
		list.insertFirst("java ");
		list.insertFirst("hello ");

		list.deleteFirst();

		list.display();
		System.out.println("******************************************");
	}

	private static void doPriQueue() {
		System.out.println("**************有序队列********************");

		PriorityQueue PriorityQueue = new PriorityQueue(10);

		PriorityQueue.insert(10);
		PriorityQueue.insert(15);
		PriorityQueue.insert(13);
		PriorityQueue.insert(17);
		PriorityQueue.insert(19);

		System.out.println(PriorityQueue.size());
		while (!PriorityQueue.isEmpty()) {
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

		MyQueue queue = new MyQueue(10);

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

		while (!queue.isEmpty()) {
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
		MyStack myStack = new MyStack(4);
		myStack.push(10);
		myStack.push(20);
		myStack.push(30);
		myStack.push(40);
		myStack.push(50);

		while (!myStack.isEmpty()) {
			long s = myStack.pop();
			System.out.println(s);
		}
		System.out.println("************************************");
	}

}

package com.xll.adt.adt;

/**
 * 
* @ClassName: LinkedList 
* @Description: 双向链表
* @author: xielulin
 * @param <T>
* @date 2017年12月5日 上午10:34:19
 */
	public class LinkedList<T> {
	/**
	 * 头节点
	 */
	private Node<T> head;

	/**
	 * 尾节点
	 */
	private Node<T> last;

	/**
	 * 初始化链表
	 */
	public LinkedList() {
		head = null;
		last = null;
	}

	/**
	 * 
	 * @author:xielulin 
	 * @Description: 判断链表是否为空
	 * @return:
	 * @throws:
	 * @date:2017年12月5日 上午10:50:24
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * 
	 * @author:xielulin 
	 * @Description:从头部插入数据
	 * @param t:
	 * @throws:
	 * @date:2017年12月5日 上午11:09:30
	 */
	public void insertHead(T t) {
		Node<T> node = new Node<T>(t);
		if (isEmpty())
			last = node; //如果是空链表，将最后新节点赋给最后一个节点
		else
			head.previous = node; //如果不为空，将新节点赋给原头结点的上一个节点
		node.next = head; //将原头节点赋给新节点的next节点
		head = node; //将新节点赋给头结点
	}

	/**
	 * 
	 * @author:xielulin 
	 * @Description:从尾部插入数据
	 * @param t:
	 * @throws:
	 * @date:2017年12月5日 上午11:18:50
	 */
	public void inserLast(T t) {
		Node<T> node = new Node<T>(t);
		if (isEmpty())
			head = node; //如果为空，将新节点赋给头结点
		else {
			last.next = node; //如果不为空，将新节点赋给原尾节点的next节点
			node.previous = last; //将新节点的previous指向原尾节点
		}
		last = node; //将尾节点指向新节点
	}

	/**
	 * 
	 * @author:xielulin 
	 * @Description: 在指定节点后面插入新节点
	 * @param t:	要插入的数据
	 * @param key:	指定节点的数据
	 * @return:
	 * @throws:
	 * @date:2017年12月5日 上午11:55:22
	 */
	public boolean insertAfter(T t, T key) {
		Node<T> current = head;
		while (current.data != key) {
			current = current.next;
			if (current == null) //如果未找到，返回false
				return false;
		}
		Node<T> newNode = new Node<T>(t);

		if (current == last) {
			newNode.next = null; //如果在最后插入
			last.next = newNode; //将尾节点的next指向新节点
		} else {
			newNode.next = current.next; //如果不是在最后的节点插入，新节点的next指向指定节点的next节点
			current.next.previous = newNode; //指定节点的next节点的previous节点指向新节点
		}
		newNode.previous = current; //新节点的previous指向指定节点
		current.next = newNode; //指定节点的next指向新节点
		return true;
	}

	/**
	 * 
	 * @author:xielulin 
	 * @Description: 刪除指定节点
	 * @param key
	 * @return:
	 * @throws:
	 * @date:2017年12月5日 下午2:56:36
	 */
	public Node<T> delete(T key) {
		Node<T> current = head;
		while (current.data != key) {
			current = current.next;
			if (current == null) //如果未找到，返回false
				return null;
		}
		if (current == last)
			current.previous.next = null;
		else
			current.previous.next = current.next;
		if (current == head)
			current.previous = null;
		else
			current.next.previous = current.previous;
		return current;
	}

	/**
	 * 
	 * @author:xielulin 
	 * @Description: 从头遍历到尾
	 * @throws:
	 * @date:2017年12月5日 下午2:25:08
	 */
	public void displayByHead() {
		Node<T> current = head;
		while (current != null) {
			current.display();
			current = current.next;
		}
	}

	/**
	 * 
	 * @author:xielulin 
	 * @Description: 从尾遍历到头
	 * @throws:
	 * @date:2017年12月5日 下午2:28:08
	 */
	public void displayByLast() {
		Node<T> current = last;
		while (current != null) {
			current.display();
			current = current.previous;
		}
	}

	@Override
	public String toString() {
		return "LinkedList [head=" + head + ", last=" + last + "]";
	}

	private class Node<T> {
		/**
		 * 节点数据
		 */
		T data;

		/**
		 * 上一个节点
		 */
		Node<T> previous;

		/**
		 * 下一个节点
		 */
		Node<T> next;

		/**
		 * 初始化节点
		 * @param t
		 */
		public Node(T t) {
			data = t;
		}

		/**
		 * 
		 * @author:xielulin 
		 * @Description:打印该节点
		 * @throws:
		 * @date:2017年12月5日 上午10:43:08
		 */
		public void display() {
			System.out.println(data + " ");
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", previous=" + previous + ", next=" + next + "]";
		}

	}
}

package com.xll.adt.adt;

/**
 * 
* @ClassName: MyLinkedList 
* @Description: linkedList 之简单实现
* @author: xielulin
* @date 2017年12月1日 下午3:32:58
 */
public class MyLinkedList <E>{
	
	private Node<E> first; 
	
	/**
	 * 初始化链表
	 */
	public MyLinkedList() {
		first = null;
	}
 
	/**
	 * 
	 * @author:xielulin 
	 * @Description: 判断链表是否为空
	 * @return:
	 * @throws:
	 * @date:2017年12月1日 下午3:46:57
	 */
	public boolean isEmpty() {
		return first==null;
	}
	 
	public void insertFirst(E data) {
		Node<E> node=new Node<E>(data);
		
		node.next=first;//将原来头节点保存的第一个节点的引用赋给新的节点
		first=node;     //将新节点的引用赋给头节点
			
	}
	
	public Node<E> deleteFirst(){
		Node<E> temp=first;
		first=temp.next;
		return temp;
	}
	
	public void display() {
		System.out.println("**List:first->end***");
		
		Node<E> temp=first;
		while(temp!=null) {
			System.out.println(temp.display());
			temp=temp.next;
		}
	}
	
	
	/**
	 * 
	* @ClassName: Node 
	* @Description: 节点类
	* @author: xielulin
	* @date 2017年12月1日 下午3:42:38 
	* @param <E>
	 */
	private class Node<E>{
		/**
		 * 下一个节点的引用
		 */
		Node<E> next;
		
		/**
		 * 节点的数据
		 */
		E data;

		public Node(E data) {
			this.data = data;
		}

		public String display() {
			return "Node [data=" + data + "]";
		}
	}
}

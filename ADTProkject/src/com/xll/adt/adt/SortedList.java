package com.xll.adt.adt;

/**
 * 
* @ClassName: SortedList 
* @Description: 有序链表之简单实现
* @author: xielulin
* @date 2017年12月4日 下午5:21:40 
* @param <E>
 */
public class SortedList {
	
	private Node first; 
	
	/**
	 * 初始化链表
	 */
	public SortedList() {
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
	 
	public void insert(int data) {
		Node node=new Node(data);
		
		Node previous=null;//存储上一个节点
		Node current=first;//存储当前点
		
		/**
		 * 如果下一节点不为空并且值比插入值大
		 */
		while(current!=null&&current.data>data) {
			previous=current;   //将当前节点赋给previous
			current=current.next; //当前节点往后移
		}
		//如果插在链表头
		if(previous==null) {
			node.next=first;
			first=node;
		}else {
			previous.next=node;  //上一个节点的next指向新节点
		}
		node.next=current; //新节点的next指向当前节点
		
	}
		
		
		
		
		
	
	public Node deleteFirst(){
		Node temp=first;
		first=temp.next;
		return temp;
	}
	
	public void display() {
		System.out.println("**List:first->end***");
		
		Node temp=first;
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
	* @date 2017年12月4日 下午5:52:03
	 */
	private class Node{
		/**
		 * 下一个节点的引用
		 */
		Node  next;
		
		/**
		 * 节点的数据
		 */
		int data;

		public Node(int data) {
			this.data = data;
		}

		public String display() {
			return data+"";
		}

	}
}


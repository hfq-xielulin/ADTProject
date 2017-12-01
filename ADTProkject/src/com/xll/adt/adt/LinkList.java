package com.xll.adt.adt;

/**
 * 
* @ClassName: LinkList 
* @Description: 两端链表（不是双向链表） 
* @author: xielulin
* @date 2017年12月1日 下午5:00:57 
* @param <E>
 */
public class LinkList<E> {
	/**
	 * 第一个节点
	 */
	Node<E> first;

	/**
	 * 最后一个节点
	 */
	Node<E> last;

	/**
	 * 初始化链表
	 */
	public LinkList() {
		first = null;
		last = null;
	}

	/**
	 * 
	 * @author:xielulin 
	 * @Description: 判断链表是否为空
	 * @return:
	 * @throws:
	 * @date:2017年12月1日 下午5:05:09
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * 
	 * @author:xielulin 
	 * @Description: 从链表头部插入一个新节点
	 * @param data:
	 * @throws:
	 * @date:2017年12月1日 下午5:16:03
	 */
	public void insretFirst(E data) {
		Node<E> node = new Node<E>(data);
		if (isEmpty())
			last = node;
		node.next = first;
		first = node;
	}

	/**
	 * 
	 * @author:xielulin 
	 * @Description: 从链表尾部插入新节点
	 * @param data:
	 * @throws:
	 * @date:2017年12月1日 下午5:32:26
	 */
	public void insretLast(E data) {
		Node<E> node = new Node<E>(data);
		if (isEmpty()) {
			//如果链表为空，first中保存新节点的引用
			first = node;
		} else {
			//否则 原来last节点中保存保存新节点的引用
			last.next = node;
		}
		last = node; //last中保存新节点的引用
	}

	/**
	 * 
	 * @author:xielulin 
	 * @Description: 删除第一个节点
	 * @return:
	 * @throws:
	 * @date:2017年12月1日 下午5:40:49
	 */
	public Node<E> deleteFirst() {
		Node<E> temp = first;
		if (first.next == null) //如果只有一个节点
			last = null; //last指向null
		first = first.next; //first指向原first的下一个节点
		return temp;
	}

	/**
	 * 
	 * @author:xielulin 
	 * @Description: 删除最后一个节点
	 * @return:
	 * @throws:
	 * @date:2017年12月1日 下午5:42:07
	 */
	public Node<E> deleteLast() {
		Node<E> temp = first;
		if (first.next == null) {//如果只有一个节点
			last = null; //last指向null
			first = null; //first指向null
		} else {
			while (temp.next != last) {
				//如果temp的下一个节点不是last节点，继续向下遍历
				//如果temp的下一个节点是last节点，跳出循环
				temp = temp.next;
			}
			last = temp; //last指向temp节点
		}
		return temp;
	}

	public void display() {
		System.out.println("**List:first->end***");

		Node<E> temp = first;
		while (temp != null) {
			temp.display();
			temp = temp.next;
		}
	}

	
	
	@Override
	public String toString() {
		return "LinkList [first=" + first + ", last=" + last + "]";
	}





	/**
	 * 
	* @ClassName: Node 
	* @Description: 节点类，保存节点相关数据
	* @author: xielulin
	* @date 2017年12月1日 下午4:57:41 
	* @param <E>
	 */
	class Node<E> {

		/**
		 * 节点的数据
		 */
		E data;

		/**
		 * 下一个节点的引用
		 */
		Node<E> next;

		public Node(E date) {
			this.data = date;
		}

		public void display() {
			System.out.println("data:" + data);
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
		
		
	}
}

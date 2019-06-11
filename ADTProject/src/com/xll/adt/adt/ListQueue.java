package com.xll.adt.adt;

/**
 * 
* @ClassName: ListQueue 
* @Description: 基于双端链表实现queue
* @author: xielulin
* @date 2017年12月4日 上午10:21:25
 */
public class ListQueue <E>{
	
	
	/**
	 * List容器
	 */
	LinkList<E> list;
	
	/**
	 * 初始化队列
	 */
	public ListQueue(){
		list=new LinkList<E>();
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description: 在队列里插入数据
	 * @param e:
	 * @throws:
	 * @date:2017年12月4日 下午4:11:45
	 */
	public void insert(E e) {
		list.insretLast(e);
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description: 删除一个数据
	 * @return: 被删除的数据
	 * @throws:
	 * @date:2017年12月4日 下午4:15:58
	 */
	public E remove(){
		return list.deleteFirst().data;
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description: 判断队列是否为空
	 * @return:
	 * @throws:
	 * @date:2017年12月4日 下午4:18:55
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description:输出整个队列的值
	 * @throws:
	 * @date:2017年12月4日 下午4:36:53
	 */
	public void display() {
		list.display();
	}
	
}

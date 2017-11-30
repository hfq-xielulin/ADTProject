package com.xll.adt.adt;

public class MyQueue {
	/**
	 * 队列的大小
	 */
	private int maxSize;
	
	/**
	 * 队列头
	 */
	private int head;
	
	/**
	 * 队列尾
	 */
	private int end;
	
	/**
	 * 数组容器
	 */
	private int [] queue;
	
	/**
	 * 栈里面元素个数
	 */
	private int count;
	
	/**
	 * 队列初始化
	 * @param size
	 */
	public MyQueue(int size) {
		maxSize=size;
		queue=new int [maxSize];
		head=0;
		end=-1;
		count=0;
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description: 插入数据
	 * @param s:
	 * @throws:
	 * @date:2017年11月30日 下午5:13:34
	 */
	public void insert(int s) {
		if(!isFull()) {
			if(end==maxSize-1)
				end=-1;
			queue[++end]=s;
			count++;
		}
		
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description:删除数据
	 * @return: 被删除的数
	 * @throws:
	 * @date:2017年11月30日 下午5:15:38
	 */
	public int remove() {
		count--;
		int temp;
		temp=queue[head];
		if(head==maxSize-1) 
			head=0;
		else
			head++;
		return temp;
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description: 取得数据
	 * @return:
	 * @throws:
	 * @date:2017年11月30日 下午5:16:57
	 */
	public int peek() {
		return queue[head];
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description: 取得队列长度
	 * @return:
	 * @throws:
	 * @date:2017年11月30日 下午5:18:00
	 */
	public int size() {
		return count;
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description: 判断队列是否为空
	 * @return:
	 * @throws:
	 * @date:2017年11月30日 下午5:19:22
	 */
	public boolean isEmpty() {
		return count==0;
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description: 判断队列是否已满
	 * @return:
	 * @throws:
	 * @date:2017年11月30日 下午5:20:24
	 */
	public boolean isFull() {
		return count==maxSize-1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

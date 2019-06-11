package com.xll.adt.adt;

/**
 * 
* @ClassName: priorityQueue 
* @Description: 有序队列
* @author: xielulin
* @date 2017年12月1日 上午10:04:22
 */
public class PriorityQueue {

	/**
	 * 队列的最大长度
	 */
	private int maxSize;
	
	/**
	 * 队列的数组容器
	 */
	private int [] PriQueue;
	
	/**
	 * 队列的长度
	 */
	private int count;
	
	/**
	 * 初始化队列
	 * @param size
	 */
	public PriorityQueue(int size) {
		maxSize=size;
		PriQueue=new int [maxSize];
		count=0;
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description: 插入数据
	 * @param l:
	 * @throws:
	 * @date:2017年12月1日 上午10:59:41
	 */
	public void insert(int l) {
		if(count==0) {
			//如果长度为0，则直接插入
			PriQueue[count++]=l;
		}else {
			int i;
			for(i=count-1;i>-1;i--) {
				//如果队列的值比插入值小，则往前移一个位置
				if(PriQueue[i]<l) {
					PriQueue[i+1]=PriQueue[i];
				}else
					//否则跳出循环
					break;
			}
			//把数据插入到找到的位置上
			PriQueue[i+1]=l;
			count++;
		}
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description: 删除数据
	 * @return:
	 * @throws:
	 * @date:2017年12月1日 上午10:59:52
	 */
	public int remove() {
		return PriQueue[--count];
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description: 取得最小值
	 * @return:
	 * @throws:
	 * @date:2017年12月1日 上午11:00:07
	 */
	public int getMin() {
		return PriQueue[count-1];
	}
	
	/**
	 * 
	 * @author:xielulin  
	 * @Description: 判断是否已满
	 * @return:
	 * @throws:
	 * @date:2017年12月1日 上午11:00:24
	 */
	public boolean isFull() {
		return maxSize==count-1;
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description: 判断是否为空
	 * @return:
	 * @throws:
	 * @date:2017年12月1日 上午11:00:43
	 */
	public boolean isEmpty() {
		return count==0;
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description: 取得队列长度
	 * @return:
	 * @throws:
	 * @date:2017年12月1日 上午11:00:56
	 */
	public int size() {
		return count;
	}

}

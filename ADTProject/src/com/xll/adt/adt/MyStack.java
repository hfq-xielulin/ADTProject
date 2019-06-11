package com.xll.adt.adt;

public class MyStack {
	/**
	 * 栈的最大Size
	 */
	private int maxSize;
	
	/**
	 * 基于数组实现
	 */
	private long [] stack;
	
	/**
	 * 栈顶
	 */
	private int top;
	
	/**
	 * 设定栈的大小
	 * @param s
	 */
	public MyStack(int s) {
		maxSize=s;
		stack=new long [maxSize];
		top=-1;
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description:数据入栈
	 * @param l:
	 * @throws:
	 * @date:2017年11月30日 下午3:21:44
	 */
	public void push(long l) {
		if(top<maxSize-1){
			stack[++top]=l;
		}
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description:数据出栈
	 * @return: 出栈数据
	 * @throws:
	 * @date:2017年11月30日 下午3:22:38
	 */
	public long pop() {
		return stack[top--];
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description:取得栈顶数据
	 * @return:
	 * @throws:
	 * @date:2017年11月30日 下午3:26:05
	 */
	public long peek() {
		return stack[top];
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description:判断栈是否已满
	 * @return:
	 * @throws:
	 * @date:2017年11月30日 下午3:26:27
	 */
	public boolean isFull() {
		return (maxSize==top+1);
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description: 判断栈是否为空
	 * @return:
	 * @throws:
	 * @date:2017年11月30日 下午3:26:56
	 */
	public boolean isEmpty() {
		return (top==-1);
	}
}

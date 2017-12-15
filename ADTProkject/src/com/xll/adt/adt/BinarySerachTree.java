package com.xll.adt.adt;

/**
 * 二叉查找树
* @ClassName: BinarySerachTree 
* @author: xielulin
* @date 2017年12月13日 下午3:22:46
 */
public class BinarySerachTree <T extends Comparable<T>>{
	
	private BinaryNode<T> root;
	
	public BinarySerachTree() {
		root=null;
	}
	
	public void makeEmpty() {
		root=null;
	}
	
	public boolean isEmpty() {
		return root==null;
	}
	
	public boolean contains(T x) {
		return contains(x,root);
	}
	
	public T finMin() throws Exception {
		if(isEmpty())
			throw new Exception("the tree is empty");
		return finMin(root).element;
	}
	
	public T finMax() throws Exception {
		if(isEmpty())
			throw new Exception("the tree is empty");
		return finMax(root).element;
	}
	
	public void insert(T x) {
		root=insert(x,root);
	}
	
	public void remove(T x) {
		root=remove(x,root);
	}
	
	public void printTree() {
		if(isEmpty())
			System.out.println("Empty tree");
		else
			printTree(root);
	}
	
	
	
	
	
	
	
	
	
	
	private void printTree(BinaryNode<T> root) {
		if(root!=null) {
			printTree(root.left);
			System.out.println(root.element);
			printTree(root.right);
		}
	}

	private BinaryNode<T> remove(T x, BinaryNode<T> t) {
		if(t==null) 
			return t;
		
		int compareResult=x.compareTo(t.element);
		
		if(compareResult>0) {
			t.right=remove(x, t.right);
		}else if(compareResult<0) {
			t.left=remove(x, t.left);
		}else if(t.left!=null&&t.right!=null) {
			t.element=finMin(t.right).element;
			t.right=remove(t.element, t.right);
		}else
			t=(t.left!=null)?t.left:t.right;
		return t;
	}

	private BinaryNode<T> insert(T x, BinaryNode<T> root) {
		if(root==null)
			return new BinaryNode<T>(x);
		
		int compareResult=x.compareTo(root.element);
		
		if(compareResult>0)
			root.right= insert(x, root.right);
		if(compareResult<0)
			root.left= insert(x, root.left);
		return root;
	}

	private BinaryNode<T> finMax(BinaryNode<T> root) {
		if(root==null)
			return null;
		if(root.right==null)
			return root;
		else
			return finMax(root.right);
	}

	private BinaryNode<T> finMin(BinaryNode<T> root) {
		if(root==null)
			return null;
		if(root.left==null)
			return root;
		else
			return finMin(root.left);
	}

	/**
	 * 判断某个值是否在该二叉树里
	 * 递归：如果该节点为null，返回false
	 * 如果要判断的值大于该节点的值，往下遍历该节点的右节点
	 * 如果要判断的值小于该节点的值，往下遍历该节点的左节点
	 * 如果相等，则返回true
	 * @author:xielulin 
	 * @param x 需要判断的值
	 * @param root
	 * @return:
	 * @throws:
	 * @date:2017年12月13日 下午4:12:24
	 */
	private boolean contains(T x, BinaryNode<T> root) {
		if(root==null)
			return false;
		
		int compareResult=x.compareTo(root.element);
		
		if(compareResult>0)
			return contains(x,root.right);
		if(compareResult<0)
			return contains(x, root.left);
		else
			return true;
	}




















	@Override
	public String toString() {
		return "BinarySerachTree [root=" + root + "]";
	}




















	private static class BinaryNode<T>{
		/**
		 * the date in the code
		 */
		T element;	
		
		/**
		 * left child
		 */
		BinaryNode<T> left;
		
		/**
		 * right child
		 */
		BinaryNode<T> right;

		public BinaryNode(T element) {
			this(element, null, null);
		}


		public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
			super();
			this.element = element;
			this.left = left;
			this.right = right;
		}


		@Override
		public String toString() {
			return "BinaryNode [element=" + element + ", left=" + left + ", right=" + right + "]";
		}
		
		
	}
}

package com.xll.adt.adt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
	
	public BinaryNode getRoot(){
		return root;
	}

	@Override
	public String toString() {
		return "BinarySerachTree [root=" + root + "]";
	}
	 /**
     * 前序遍历
     * 非递归
     */
    public void preOrder1(BinaryNode<T> Node){
        System.out.println("前序遍历：");
        Stack<BinaryNode> stack = new Stack<>();
        while(Node != null || !stack.empty())
        {
            while(Node != null)
            {
                System.out.print(Node.element + "   ");
                stack.push(Node);
                Node = Node.left;
            }
            if(!stack.empty())
            {
                Node = stack.pop();
                Node = Node.right;
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历
     * 非递归
     */
    public void midOrder1(BinaryNode<T> Node){
        System.out.println("中序遍历：");
        Stack<BinaryNode> stack = new Stack<>();
        while(Node != null || !stack.empty())
        {
            while (Node != null)
            {
                stack.push(Node);
                Node = Node.left;
            }
            if(!stack.empty())
            {
                Node = stack.pop();
                System.out.print(Node.element + "   ");
                Node = Node.right;
            }
        }
        System.out.println();
    }

    /**
     * 后序遍历
     * 非递归
     */
    public void posOrder1(BinaryNode<T> Node){
        System.out.println("后序遍历：");
        Stack<BinaryNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int i = 1;
        while(Node != null || !stack1.empty())
        {
            while (Node != null)
            {
                stack1.push(Node);
                stack2.push(0);
                Node = Node.left;
            }

            while(!stack1.empty() && stack2.peek() == i)
            {
                stack2.pop();
                System.out.print(stack1.pop().element + "   ");
            }

            if(!stack1.empty())
            {
                stack2.pop();
                stack2.push(1);
                Node = stack1.peek();
                Node = Node.right;
            }
        }
        System.out.println();
    }

    /*
     * 层序遍历
     * 非递归
     */
    public void levelOrder1(BinaryNode<T> node) {
        System.out.println("层序遍历：");
        if (node == null) {
            return;
        }

        BinaryNode<T> binaryNode;
        Queue<BinaryNode<T>> queue =new LinkedList<>();
        queue.add(node);

        while (queue.size() != 0) {
            binaryNode = queue.poll();

            System.out.print(binaryNode.element + "  ");

            if (binaryNode.left != null) {
                queue.offer(binaryNode.left);
            }
            if (binaryNode.right != null) {
                queue.offer(binaryNode.right);
            }
        }
        System.out.println();
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

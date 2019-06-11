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
	
	private Node<T> root;

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










	private void printTree(Node<T> root) {
		if(root!=null) {
			printTree(root.left);
			System.out.println(root.element);
			printTree(root.right);
		}
	}

	private Node<T> remove(T x, Node<T> t) {
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

	private Node<T> insert(T x, Node<T> root) {
		if(root==null)
			return new Node<T>(x);

		int compareResult=x.compareTo(root.element);

		if(compareResult>0)
			root.right= insert(x, root.right);
		if(compareResult<0)
			root.left= insert(x, root.left);
		return root;
	}

	private Node<T> finMax(Node<T> root) {
		if(root==null)
			return null;
		if(root.right==null)
			return root;
		else
			return finMax(root.right);
	}

	private Node<T> finMin(Node<T> root) {
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
	private boolean contains(T x, Node<T> root) {
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

	public Node getRoot(){
		return root;
	}

	@Override
	public String toString() {
		return "BinarySerachTree [root=" + root + "]";
	}

	 /*
	    * 前序遍历，递归实现
	    * */
	    public void PreOrder(Node node) {
	        if (node != null) {
	            System.out.print(node.element+"    ");
	            PreOrder(node.left);
	            PreOrder(node.right);
	        }

	    }

		/*
	    * 前序遍历，非递归实现
	    * 1，先入栈根节点，输出根节点val值，再先后入栈其右节点、左结点；
	    * 2，出栈左节点，输出其val值，再入栈该左节点的右节点、左节点；直到遍历完该左节点所在子树。
	    * 3，再出栈右节点，输出其val值，再入栈该右节点的右节点、左节点；直到遍历完该右节点所在子树。
	    * */
    public void preOrder1(Node<T> Node){
        System.out.println("前序遍历：");
        Stack<Node> stack = new Stack<>();
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

    /*
     * 中序遍历，递归实现
     * */
     public void InOrder(Node node) {
         if (node != null) {
             InOrder(node.left);
	         System.out.print(node.element+"    ");
             InOrder(node.right);
         }
     }


     /*
      * 中序遍历，非递归实现
      * 1，首先从根节点出发一路向左，入栈所有的左节点；
      * 2，出栈一个节点，输出该节点val值，查询该节点是否存在右节点，
      * 若存在则从该右节点出发一路向左入栈该右节点所在子树所有的左节点；
      * 3，若不存在右节点，则出栈下一个节点，输出节点val值，同步骤2操作；
      * 4，直到节点为null，且栈为空。
      * */
    public void midOrder1(Node<T> Node){
        System.out.println("中序遍历：");
        Stack<Node> stack = new Stack<>();
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

    /*
     * 后序遍历，递归实现
     * */
     public void PostOrder(Node node) {
         if (node != null) {
             PostOrder(node.left);
             PostOrder(node.right);
	         System.out.print(node.element+"    ");
         }
     }

    /**
     * 后序遍历
     * 非递归
     */
    public void posOrder1(Node<T> Node){
        System.out.println("后序遍历：");
        Stack<Node> stack1 = new Stack<>();
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


    /**
     *对于树的后续遍历，由于要多次经过每个节点，所以要
     *设置一个状态变量来指示到达一个节点后是进入右子树，
     *还是他是从右子树返回的不再需要进入右子树了。
    * @Title: postorderTraversal
    * @Description:
    * @param @param Node
    * @return void
    * @throws
     */

    public void postorderTraversal(Node<T> Node){
        int[] sign = new int[20];
        Stack stack = new Stack();
        Node t =null;
        t = Node;
        if( t==null )
            return;

        while(t!=null){
            stack.push(t);
            sign[ stack.size()-1] = 0;
            t = t.left;
        }
        while(!stack.isEmpty() ){
            t = (Node)stack.peek();

            while( t.right!=null && sign[stack.size()-1]==0 ){
                sign[stack.size()-1] = 1;
                t = t.right;
                while(t!=null){
                    stack.push(t);
                    sign[stack.size()-1] = 0;
                    t = t.left;
                }
                t = (Node)stack.peek();

            }
            System.out.println( t.element);
            stack.pop();
            }
        }


    /*
     * 层序遍历
     * 非递归
     */
    public void levelOrder1(Node<T> node) {
        System.out.println("层序遍历：");
        if (node == null) {
            return;
        }

        Node<T> binaryNode;
        Queue<Node<T>> queue =new LinkedList<>();
        queue.add(node);

        while (queue.size() != 0) {
        	int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
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
    }
/*	private static class BinaryNode<T>{
		*//**
		 * the date in the code
		 *//*
		T element;

		*//**
		 * left child
		 *//*
		BinaryNode<T> left;

		*//**
		 * right child
		 *//*
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
	}*/
}

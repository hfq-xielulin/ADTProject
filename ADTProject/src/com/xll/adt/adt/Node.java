package com.xll.adt.adt;

/**
 * @author xielulin
 * @create 2019-06-11 14:48
 * @desc 节点类
 **/
public class Node<T>{
    /**
     * the date in the code
     */
    public T element;

    /**
     * left child
     */
    public Node<T> left;

    /**
     * right child
     */
    public Node<T> right;

    public Node(T element) {
        this(element, null, null);
    }


    public Node(T element, Node<T> left, Node<T> right) {
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

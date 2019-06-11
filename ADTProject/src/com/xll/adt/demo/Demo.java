package com.xll.adt.demo;

import com.xll.adt.adt.Node;

/**
 * @author xielulin
 * @create 2019-06-11 14:41
 * @desc 算法小demo
 **/
public class Demo {

    /**
     * @description 计算树的最大深度
     * @author xielulin
     * @date 2019/6/11
     * @param root 当前节点
     * @return int
     */
    public static int MaxDeep(Node root){
        if(root == null){
            return 0;
        } else {
            return 1 + Math.max(MaxDeep(root.left),MaxDeep(root.right));
        }
    }

    public static int MinDepth(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null){
            return 1 + MinDepth(root.right);
        }
        if(root.right == null){
            return 1 + MinDepth(root.left);
        }
        int leftDepth = MinDepth(root.left);
        int rightDepth = MinDepth(root.right);
        return 1 + Math.min(leftDepth,rightDepth);
    }
}

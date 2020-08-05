package com.zouxxxyy.tree;

/*
二叉树的后序遍历

方法一：递归
方式二：栈
 */

import com.zouxxxyy.structure.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zxy
 */
public class PostorderTraversal<T> {

    /**
     * 方式一：使用递归实现后序遍历
     */
    public List<T> postorderTraversalRe(BinaryTree<T> root) {

        List<T> res = new ArrayList<>();
        recursive(root, res);
        return res;

    }

    private void recursive(BinaryTree<T> node, List<T> res) {

        if (node != null) {
            recursive(node.left, res);
            recursive(node.right, res);
            res.add(node.val);
        }

    }


    /**
     * 方式二：不使用递归实现后序遍历
     */
    public List<T> postorderTraversal(BinaryTree<T> root) {

        ArrayList<T> res = new ArrayList<>();
        Deque<BinaryTree<T>> stack = new LinkedList<>();

        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {

            BinaryTree<T> pop = stack.pop();

            if (pop != null) {

                // 顺序为 使用n、r(右)、r(左) 入栈

                stack.push(pop);
                stack.push(null);

                if (pop.right != null) {
                    stack.push(pop.right);
                }

                if (pop.left != null) {
                    stack.push(pop.left);
                }

            } else {
                res.add(stack.pop().val);
            }
        }

        return res;
    }

}

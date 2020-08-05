package com.zouxxxyy.tree;

import com.zouxxxyy.structure.BinaryTree;

import java.util.*;

/*
二叉树的前序遍历

方法一：递归
方式二：栈
 */

/**
 * @author zxt
 */
public class PreorderTraversal<T> {

    /**
     * 方式一：使用递归实现前序遍历
     */
    public List<T> preorderTraversalRe(BinaryTree<T> root) {

        List<T> res = new ArrayList<>();
        recursive(root, res);
        return res;

    }

    private void recursive(BinaryTree<T> node, List<T> res) {

        if (node != null) {
            res.add(node.val);
            recursive(node.left, res);
            recursive(node.right, res);
        }

    }


    /**
     * 方式二：不使用递归实现前序遍历
     */
    public List<T> preorderTraversal(BinaryTree<T> root) {

        List<T> res = new ArrayList<>();
        Deque<BinaryTree<T>> stack = new LinkedList<>();

        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {

            BinaryTree<T> pop = stack.pop();

            if (pop != null) {

                if (pop.right != null) {
                    stack.push(pop.right);
                }

                if (pop.left != null) {
                    stack.push(pop.left);
                }

                stack.push(pop);
                stack.push(null);

            } else {
                res.add(stack.pop().val);
            }

        }

        return res;
    }

}

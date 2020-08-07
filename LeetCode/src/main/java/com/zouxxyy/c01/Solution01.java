package com.zouxxyy.c01;

/*
101. 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。



例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3


但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3


进阶：

你可以运用递归和迭代两种方法解决这个问题吗？
 */

import java.util.LinkedList;

/**
 * @author zxy
 */
public class Solution01 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 方法一：使用递归
     */
    public boolean isSymmetricRe(TreeNode root) {
        return root == null || dfs(root.left, root.right);
    }

    /**
     * 两棵树是否对称
     */
    private boolean dfs(TreeNode left, TreeNode right) {

        return (left == null && right == null) ||
                left != null && right != null && left.val == right.val
                        && dfs(left.left, right.right) && dfs(left.right, right.left);

    }


    /**
     * 方法二：使用队列
     */
    public boolean isSymmetric(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root.left);
            queue.add(root.right);
        }

        while (!queue.isEmpty()) {

            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left != null && right != null && left.val == right.val) {
                queue.add(left.left);
                queue.add(right.right);
                queue.add(left.right);
                queue.add(right.left);
            } else {
                return false;
            }

        }

        return true;

    }

}

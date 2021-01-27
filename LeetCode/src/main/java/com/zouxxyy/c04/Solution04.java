package com.zouxxyy.c04;

/*
404. 左叶子之和
计算给定二叉树的所有左叶子之和。

示例：

    3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */


import java.util.*;

/**
 * @author zxy
 */
public class Solution04 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {

        return sumOfLeftLeaves(root, false);

    }

    public int sumOfLeftLeaves(TreeNode root, boolean isLeft) {

        if (root == null) {
            return 0;
        }

        return (root.left == null && root.right == null && isLeft ? root.val : 0) +
                sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }

}

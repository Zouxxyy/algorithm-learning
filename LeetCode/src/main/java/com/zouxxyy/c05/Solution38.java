package com.zouxxyy.c05;

/*
538. 把二叉搜索树转换为累加树
给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。



例如：

输入: 原始二叉搜索树:
              5
            /   \
           2     13

输出: 转换为累加树:
             18
            /   \
          20     13
 */

/*
思路：

由大到小遍历
 */

/**
 * @author zxy
 */
public class Solution38 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {

        // 右 根 左 遍历
        if (root != null) {

            convertBST(root.right);
            root.val += sum;
            sum = root.val;
            convertBST(root.left);

        }
        return root;
    }

}

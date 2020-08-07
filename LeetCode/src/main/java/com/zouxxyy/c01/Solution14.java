package com.zouxxyy.c01;

/*
114. 二叉树展开为链表
给定一个二叉树，原地将它展开为一个单链表。



例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */

/*
思路：

把节点的左子树展开，右子树展开，然后拼接起来即可
 */

/**
 * @author zxy
 */
public class Solution14 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public void flatten(TreeNode root) {
        if (root != null) {
            helper(root);
        }
    }


    /**
     * 将树展开，返回尾节点
     */
    private TreeNode helper(TreeNode node) {

        // 整体思路：把节点的左子树展开，右子树展开，然后拼接起来即可
        TreeNode end = node;
        TreeNode rightTemp = node.right;

        if (node.left != null) {
            end.right = node.left;
            end = helper(node.left);
        }

        if (rightTemp != null) {
            end.right = rightTemp;
            end = helper(rightTemp);
        }

        // 拼接完毕，置空左子树
        node.left = null;

        return end;
    }

}

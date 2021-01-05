package com.zouxxyy.c01;

/*
129. 求根到叶子节点数字之和
给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

例如，从根到叶子节点路径 1->2->3 代表数字 123。

计算从根到叶子节点生成的所有数字之和。

说明: 叶子节点是指没有子节点的节点。

示例 1:

输入: [1,2,3]
    1
   / \
  2   3
输出: 25
解释:
从根到叶子节点路径 1->2 代表数字 12.
从根到叶子节点路径 1->3 代表数字 13.
因此，数字总和 = 12 + 13 = 25.
示例 2:

输入: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
输出: 1026
解释:
从根到叶子节点路径 4->9->5 代表数字 495.
从根到叶子节点路径 4->9->1 代表数字 491.
从根到叶子节点路径 4->0 代表数字 40.
因此，数字总和 = 495 + 491 + 40 = 1026.
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution29 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {

        int res = 0;

        if (root == null) {
            return res;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();

        nodeQueue.offer(root);
        numQueue.offer(root.val);

        while (!nodeQueue.isEmpty()) {

            for (int i = nodeQueue.size(); i > 0; i--) {

                TreeNode node = nodeQueue.poll();
                int num = numQueue.poll();

                if (node.left == null && node.right == null) {
                    res += num;
                }

                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    numQueue.offer(num * 10 + node.left.val);
                }

                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    numQueue.offer(num * 10 + node.right.val);
                }

            }

        }

        return res;

    }
}

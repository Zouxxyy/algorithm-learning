package com.zouxxyy.c01;

/*
113. 路径总和 II
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution13 {

    public static class TreeNode {
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

    List<List<Integer>> res;
    LinkedList<Integer> cur;
    int sum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        res = new ArrayList<>();
        cur = new LinkedList<>();

        if (root != null) {
            dfs(root, targetSum);
        }

        return res;
    }


    private void dfs(TreeNode node, int targetSum) {

        if (node == null) {
            return;
        }

        cur.addLast(node.val);
        sum += node.val;

        if (node.left == null && node.right == null && sum == targetSum) {
            res.add(new ArrayList<>(cur));
        }

        if (node.left != null) {
            dfs(node.left, targetSum);
        }

        if (node.right != null) {
            dfs(node.right, targetSum);
        }

        cur.removeLast();
        sum -= node.val;
    }

}

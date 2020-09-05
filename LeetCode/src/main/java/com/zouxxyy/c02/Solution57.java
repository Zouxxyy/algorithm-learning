package com.zouxxyy.c02;

/*
257. 二叉树的所有路径
给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */

/*
思路：

回溯
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution57 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private final List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        if (root != null) {
            dfs(root, new StringBuilder().append(root.val).append("->"));
        }
        return res;

    }

    private void dfs(TreeNode node, StringBuilder sb) {

        if (node.left == null && node.right == null) {
            res.add(sb.substring(0, sb.length() - 2));
            return;
        }

        int temp;

        if (node.left != null) {
            temp = sb.length();
            sb.append(node.left.val).append("->");
            dfs(node.left, sb);
            sb.delete(temp, sb.length());
        }

        if (node.right != null) {
            temp = sb.length();
            sb.append(node.right.val).append("->");
            dfs(node.right, sb);
            sb.delete(temp, sb.length());
        }

    }

}

/*
面试题54. 二叉搜索树的第k大节点

给定一棵二叉搜索树，请找出其中第k大的节点。
1 ≤ k ≤ 二叉搜索树元素个数
 */

package com.zouxxyy;

public class Solution54 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int res, n;

    public int kthLargest(TreeNode root, int k) {
        n = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node) {
        if (node == null || n == 0) return;
        dfs(node.right);
        if (--n == 0) {
            res = node.val;
            return;
        }
        dfs(node.left);
    }
}

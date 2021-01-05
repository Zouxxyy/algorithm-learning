package com.zouxxyy.c05;

/*
530. 二叉搜索树的最小绝对差
给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。



示例：

输入：

   1
    \
     3
    /
   2

输出：
1

解释：
最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 */

/*
思路：

中序遍历，和前一个比较即可
 */

/**
 * @author zxy
 */
public class Solution30 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int res = Integer.MAX_VALUE;
    private int last = -1;

    public int getMinimumDifference(TreeNode root) {

        dfs(root);
        return res;

    }

    private void dfs(TreeNode node) {

        if (node == null) {
            return;
        }

        dfs(node.left);

        if (last != -1) {
            res = Math.min(node.val - last, res);
        }

        last = node.val;

        dfs(node.right);
    }

}

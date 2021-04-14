package com.zouxxyy.c07;

/*
783. 二叉搜索树节点最小距离
给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同



示例 1：


输入：root = [4,2,6,1,3]
输出：1
示例 2：


输入：root = [1,0,48,null,null,12,49]
输出：1


提示：

树中节点数目在范围 [2, 100] 内
0 <= Node.val <= 105
 */

/**
 * @author zxy
 */
public class Solution83 {

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

    private Integer last = null;
    private int res = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        // 左 根 右
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {

        if (node == null) {
            return;
        }

        dfs(node.left);

        if (last != null) {
            res = Math.min(res, node.val - last);
        }

        last = node.val;

        dfs(node.right);

    }

}

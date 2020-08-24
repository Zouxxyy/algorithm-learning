package com.zouxxyy.c05;

/*
543. 二叉树的直径
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。



示例 :
给定二叉树

          1
         / \
        2   3
       / \
      4   5
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。



注意：两结点之间的路径长度是以它们之间边的数目表示。
 */

/*
思路：

在递归中计算极值！
 */

/**
 * @author zxy
 */
public class Solution43 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    private int res;

    public int diameterOfBinaryTree(TreeNode root) {

        maxLength(root);
        return res;
    }


    /**
     * 计算节点的最大深度，并且同时计算当前节点最长路径
     */
    private int maxLength(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int l = maxLength(node.left);
        int r = maxLength(node.right);

        // 核心
        res = Math.max(res, l + r);
        return 1 + Math.max(l, r);
    }

}

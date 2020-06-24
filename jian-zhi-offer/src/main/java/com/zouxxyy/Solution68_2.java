/*
面试题68 - II. 二叉树的最近公共祖先

给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]

说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。
 */

package com.zouxxyy;

public class Solution68_2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    private TreeNode res;
    private int k;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        k = 2;
        dfs(root, p, q);
        return res;
    }

    private void dfs(TreeNode note, TreeNode p, TreeNode q) {
        if (note == null || k == 0) return;
        int kOld = k;
        if (note.val == p.val || note.val == q.val) k--;
        dfs(note.left, p, q);
        dfs(note.right, p, q);
        if (kOld == 2 && k == 0 && res == null)
            res = note;
    }
}

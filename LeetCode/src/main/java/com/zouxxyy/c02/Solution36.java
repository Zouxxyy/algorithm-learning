package com.zouxxyy.c02;

/*
236. 二叉树的最近公共祖先
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]





示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。


说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。
 */

/*
思路：

递归 + 计数
 */

/**
 * @author zxy
 */
public class Solution36 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 待查找节点总数
     */
    private static final int K = 2;

    /**
     * 当前未查找的节点个数
     */
    private int remain = K;
    private TreeNode res;


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        search(root, p, q);
        return res;
    }

    /**
     * 前序遍历，寻找待查找的节点，在这一过程中，找到最近公共子节点
     */
    private void search(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null || remain == 0) {
            return;
        }

        // 保存查找前，k的值
        int before = remain;
        
        // 前序遍历
        if (node.val == p.val || node.val == q.val) {
            remain--;
        }
        search(node.left, p, q);
        search(node.right, p, q);

        // 如果查找后，k 由 K 变为 0 ，那么当前节点就是公共子节点（通过仅首次赋值，确保它最近公共字节点）
        if (before == K && remain == 0 && res == null) {
            res = node;
        }

    }
}

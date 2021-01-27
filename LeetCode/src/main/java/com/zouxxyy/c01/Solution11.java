package com.zouxxyy.c01;

/*
111. 二叉树的最小深度
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明：叶子节点是指没有子节点的节点。



示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：2
示例 2：

输入：root = [2,null,3,null,4,null,5,null,6]
输出：5
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution11 {

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

    private int res = Integer.MAX_VALUE;
    private int cur = 0;

    public int minDepthOld(TreeNode root) {

        dfs(root);
        return res;

    }

    private void dfs(TreeNode node) {

        if (node == null) {
            return;
        }

        cur++;

        if (node.left == null && node.right == null) {
            res = Math.min(res, cur);
        }

        dfs(node.left);
        dfs(node.right);

        cur--;
    }


    /**
     * 层序遍历更强
     */
    public int minDepth(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        int level = 0;

        while (!queue.isEmpty()) {

            level++;

            for (int i = queue.size(); i > 0; i--) {

                TreeNode poll = queue.poll();

                if (poll.left == null && poll.right == null) {
                    return level;
                }

                if (poll.left != null) {
                    queue.add(poll.left);
                }

                if (poll.right != null) {
                    queue.add(poll.right);
                }

            }

        }

        return level;
    }

}

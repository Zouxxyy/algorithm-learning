package com.zouxxyy.c06;

/*
637. 二叉树的层平均值
给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。



示例 1：

输入：
    3
   / \
  9  20
    /  \
   15   7
输出：[3, 14.5, 11]
解释：
第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。


提示：

节点值的范围在32位有符号整数范围内。
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution37 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {

            double sum = 0;
            int n = queue.size();

            for (int i = 0; i < n; i++) {

                TreeNode poll = queue.poll();
                sum += poll.val;

                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }

            }
            res.add(sum / n);

        }

        return res;
    }

}

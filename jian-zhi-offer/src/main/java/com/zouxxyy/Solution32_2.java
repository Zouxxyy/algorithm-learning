/*
面试题32 - II. 从上到下打印二叉树 II

从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

 

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
 

提示：

节点总数 <= 1000

 */

/*
笔记：

把一层的全输出来后，再跳循环！
 */

package com.zouxxyy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution32_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 个人愚法
    public List<List<Integer>> levelOrderOld(TreeNode root) {

        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            res.add(new ArrayList<>());
        }
        int level = 0;
        long n = 0, N = 1, nextN = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            res.get(level).add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
                nextN++;
            }
            if (poll.right != null) {
                queue.add(poll.right);
                nextN++;
            }
            if (++n == N) {
                level++;
                if (nextN != 0) res.add(new ArrayList<>());
                n = 0;
                N = nextN;
                nextN = 0;
            }
        }
        return res;
    }

    // 学习到的方法
    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> nodes = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                nodes.add(poll.val);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            res.add(nodes);
        }
        return res;
    }
}

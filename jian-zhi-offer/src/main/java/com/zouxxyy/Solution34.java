/*
面试题34. 二叉树中和为某一值的路径

输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

 

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]
 

提示：

节点总数 <= 10000
 */

package com.zouxxyy;

import java.util.LinkedList;
import java.util.List;

public class Solution34 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root != null) dfs(root, sum, 0, res, new LinkedList<>());
        return res;
    }

    public void dfs(TreeNode node, int sum, int count, List<List<Integer>> res, LinkedList<Integer> cur) {
        cur.add(node.val);
        count += node.val;
        if (node.left != null) dfs(node.left, sum, count, res, cur);
        if (node.right != null) dfs(node.right, sum, count, res, cur);
        if (node.left == null && node.right == null && count == sum)
            res.add(new LinkedList<>(cur));
        cur.removeLast();
    }
}

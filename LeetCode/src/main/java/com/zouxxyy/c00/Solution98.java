package com.zouxxyy.c00;

/*
98. 验证二叉搜索树
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
    2
   / \
  1   3
输出: true
示例 2:

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
 */

/*
思路：

二叉搜索树的中序遍历是有序的，因此执行一遍中序遍历即可
 */


import java.util.*;

/**
 * @author zxy
 */
public class Solution98 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {

        double cur = -Double.MAX_VALUE;

        Deque<TreeNode> stack = new LinkedList<>();

        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {

            TreeNode pop = stack.pop();

            if (pop != null) {

                if (pop.right != null) {
                    stack.push(pop.right);
                }

                stack.push(pop);
                stack.push(null);

                if (pop.left != null) {
                    stack.push(pop.left);
                }

            } else {

                int val = stack.pop().val;

                if (cur >= val) {
                    return false;
                } else {
                    cur = val;
                }

            }

        }

        return true;

    }

}

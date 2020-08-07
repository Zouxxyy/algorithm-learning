package com.zouxxyy.c01;

/*
105. 从前序与中序遍历序列构造二叉树
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 */

/*
思路：

找分割点，递归
 */

/**
 * @author zxy
 */
public class Solution05 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);

    }


    /**
     * 辅助函数，左闭右开
     */
    private TreeNode helper(int[] preorder, int pFrom, int pTo, int[] inorder, int iFrom, int iTo) {

        if (pFrom == pTo) {
            return null;
        }

        // preorder[pFrom] 是 root
        TreeNode root = new TreeNode(preorder[pFrom]);

        // 找到分割点，左边是 root 的左子树，右边是 root 的右子树
        int split = iFrom;

        while (inorder[split] != preorder[pFrom]) {
            split++;
        }

        root.left = helper(preorder, pFrom + 1, pFrom + split - iFrom + 1, inorder, iFrom, split);
        root.right = helper(preorder, pFrom + split - iFrom + 1, pTo, inorder, split + 1, iTo);

        return root;

    }

}

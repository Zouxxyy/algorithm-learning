/*
面试题07. 重建二叉树

输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

 

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 

限制：

0 <= 节点个数 <= 5000

 */

/*
思路:

前序：ABDHECFG
中序：DHBEAFCG

以A为分割，（BDHE,DHBE）为左节点，（CFG,FCG）为右节点，递归
 */

package com.zouxxyy;

import java.util.Arrays;

public class Solution07 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;

        if (n == 0) return null;

        int i;
        for (i = 0; i < n; i++) {
            if (preorder[0] == inorder[i]) break;
        }

        TreeNode head = new TreeNode(preorder[0]);

        if (i != 0) {
            head.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1),
                    Arrays.copyOfRange(inorder, 0, i));
        }

        if (i != n - 1) {
            head.right = buildTree(Arrays.copyOfRange(preorder, i + 1, n),
                    Arrays.copyOfRange(inorder, i + 1, n));
        }
        return head;
    }
}

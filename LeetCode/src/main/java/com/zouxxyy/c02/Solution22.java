package com.zouxxyy.c02;

/*
222. 完全二叉树的节点个数
给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。

完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。



示例 1：


输入：root = [1,2,3,4,5,6]
输出：6
示例 2：

输入：root = []
输出：0
示例 3：

输入：root = [1]
输出：1


提示：

树中节点的数目范围是[0, 5 * 104]
0 <= Node.val <= 5 * 104
题目数据保证输入的树是 完全二叉树


进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
 */

/*
思路：

二分模板 + 简单编码
 */

/**
 * @author zxy
 */
public class Solution22 {

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


    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // 计算深度
        int h = 0;
        TreeNode cur = root;
        while (cur != null) {
            h++;
            cur = cur.left;
        }

        // 叶子节点，最左端节点号，比如 3 层完全二叉树，l = 1 0 0
        int l = (int) Math.pow(2, h - 1);
        // 叶子节点，最右端节点号，比如 3 层完全二叉树，l = 1 1 1
        int r = (int) Math.pow(2, h) - 1;
        // 掩码初始值，用于计算次高位，比如 3 层完全二叉树，mask = 0 1 0
        int mask = (int) Math.pow(2, h - 2);

        // 2分右端点模板：找到存在的最大节点号
        while (l < r) {

            int mid = l + (r - l + 1) / 2;

            if (check(mid, root, mask)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }


    /**
     * 根据编码，判断节点是否存在：忽略最高位
     * 1 0 0，左 -> 左
     * 1 1 1，右 -> 右
     * 1 0 1，左 -> 右
     */
    private boolean check(int code, TreeNode node, int mask) {

        while (mask != 0) {
            // 次高位是 0，找左子树；是 1，找右子树
            if ((code & mask) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            mask >>= 1;
        }

        return node != null;
    }
}

package com.zouxxyy.c03;

/*
337. 打家劫舍 III
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

示例 1:

输入: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

输出: 7
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
示例 2:

输入: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

输出: 9
解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */

/*
思路：

看到树的问题，没有其它方法，递归就完事了
 */


import java.util.HashMap;

/**
 * @author zxy
 */
public class Solution37 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private HashMap<TreeNode, Integer> cached = new HashMap<>();

    public int rob(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (cached.containsKey(root)) {
            return cached.get(root);
        }

        int notRobRoot = rob(root.left) + rob(root.right);

        int robRoot = root.val;
        if (root.left != null) {
            robRoot = robRoot + rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            robRoot = robRoot + rob(root.right.left) + rob(root.right.right);
        }

        int res = Math.max(robRoot, notRobRoot);
        cached.put(root, res);
        return res;
    }

}

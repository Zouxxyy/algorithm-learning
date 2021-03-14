package nc00;

/*
二叉树根节点到叶子节点的所有路径和


 */

/**
 * @author zxy
 */
public class Solution05 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    private int res = 0;

    public int sumNumbers(TreeNode root) {
        // write code here
        dfs(root, 0);
        return res;
    }


    private void dfs(TreeNode node, int sum) {

        if (node == null) {
            return;
        }
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            res += sum;
        }

        dfs(node.left, sum);
        dfs(node.right, sum);
    }

}

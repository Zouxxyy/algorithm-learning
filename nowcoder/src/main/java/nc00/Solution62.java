package nc00;

/*
平衡二叉树


 */

/**
 * @author zxy
 */
public class Solution62 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) != -1;
    }

    // 返回深度，如果不是平衡二叉树 返回 -1
    private int depth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int l = depth(root.left);
        if (l == -1) {
            return -1;
        }

        int r = depth(root.right);
        if (r == -1) {
            return -1;
        }

        return Math.abs(l - r) <= 1 ? Math.max(l, r) + 1 : -1;
    }

}

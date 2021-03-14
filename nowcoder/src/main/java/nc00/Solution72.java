package nc00;

/*
二叉树的镜像
 */

/**
 * @author zxy
 */
public class Solution72 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public TreeNode Mirror(TreeNode pRoot) {
        // write code here

        if (pRoot != null) {
            TreeNode temp = pRoot.left;
            pRoot.left = Mirror(pRoot.right);
            pRoot.right = Mirror(temp);
        }

        return pRoot;
    }

}

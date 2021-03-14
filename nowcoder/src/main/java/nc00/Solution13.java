package nc00;

/*
二叉树的最大深度

求给定二叉树的最大深度，
最大深度是指树的根结点到最远叶子结点的最长路径上结点的数量。

示例1
输入
复制
{1,2}
返回值
复制
2
示例2
输入
复制
{1,2,3,4,#,#,5}
返回值
复制
3
 */

/**
 * @author zxy
 */
public class Solution13 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}

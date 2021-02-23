package nc01;

/*
在二叉树中找到两个节点的最近公共祖先

给定一棵二叉树以及这棵树上的两个节点 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
示例1
输入
复制
[3,5,1,6,2,0,8,#,#,7,4],5,1
返回值
复制
3
 */

/**
 * @author zxy
 */
public class Solution02 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    private int k = 0;
    private TreeNode res = null;

    /**
     * @param root TreeNode类
     * @param o1   int整型
     * @param o2   int整型
     * @return int整型
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        dfs(root, o1, o2);
        return res.val;
    }

    private void dfs(TreeNode node, int o1, int o2) {

        if (node == null || k == 2 || res != null) {
            return;
        }

        int curK = k;
        if (node.val == o1 || node.val == o2) {
            k++;
        }
        dfs(node.left, o1, o2);
        dfs(node.right, o1, o2);

        if (curK == 0 && k == 2 && res == null) {
            res = node;
        }

    }

}

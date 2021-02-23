package nc00;

/*
重建二叉树

输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
示例1
输入
复制
[1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
返回值
复制
{1,2,5,3,4,6,7}
 */

/**
 * @author zxy
 */
public class Solution12 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int[] in, int preL, int preR, int inL, int inR) {

        int root = pre[preL];
        TreeNode node = new TreeNode(root);

        int split = inL;
        while (in[split] != root) {
            split++;
        }

        if (split - 1 >= inL) {
            node.left = reConstructBinaryTree(pre, in, preL + 1, split + preL - inL, inL, split - 1);
        }

        if (split + 1 <= inR) {
            node.right = reConstructBinaryTree(pre, in, split + preL - inL + 1, preR, split + 1, inR);
        }

        return node;
    }

}

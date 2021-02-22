package nc00;

/*
题目描述
给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
例如：
给定的二叉树是{3,9,20,#,#,15,7},

该二叉树层序遍历的结果是
[
[3],
[9,20],
[15,7]
]

示例1
输入
复制
{1,2}
返回值
复制
[[1],[2]]
示例2
输入
复制
{1,2,3,4,#,#,5}
返回值
复制
[[1],[2,3],[4,5]]
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution15 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode pop = queue.poll();
                list.add(pop.val);
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}

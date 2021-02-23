package nc00;

/*
二叉树的之字形层序遍历

给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
例如：
给定的二叉树是{3,9,20,#,#,15,7},

该二叉树之字形层序遍历的结果是
[
[3],
[20,9],
[15,7]
]
示例1
输入
复制
{1,#,2}
返回值
复制
[[1],[2]]
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution14 {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write code here

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.offer(root);
        }

        boolean flag = true;

        while (!queue.isEmpty()) {

            ArrayList<Integer> list = new ArrayList<>();
            flag = !flag;

            for (int i = queue.size(); i > 0; i--) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }

            if (flag) {
                Collections.reverse(list);
            }

            res.add(list);
        }

        return res;

    }

}

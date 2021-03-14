package nc00;

/*
二叉树根节点到叶子节点和为指定值的路径

给定一个二叉树和一个值\ sum sum，请找出所有的根节点到叶子节点的节点值之和等于\ sum sum 的路径，
例如：
给出如下的二叉树，\ sum=22 sum=22，

返回
[
[5,4,11,2],
[5,8,9]
]
示例1
输入
复制
{1,2},1
返回值
复制
[]
示例2
输入
复制
{1,2},3
返回值
复制
[[1,2]]
 */

import java.util.*;

/**
 * @author zxy
 */

public class Solution08 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        dfs(root, sum, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode node, int sum, int cur, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {

        if (node == null) {
            return;
        }

        cur += node.val;
        list.add(node.val);
        if (node.left == null && node.right == null && cur == sum) {
            res.add(new ArrayList<>(list));
        }
        dfs(node.left, sum, cur, res, list);
        dfs(node.right, sum, cur, res, list);
        list.remove(list.size() - 1);
    }

}

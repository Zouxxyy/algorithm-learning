package nc00;

/*
题目描述
分别按照二叉树先序，中序和后序打印所有的节点。
示例1
输入
复制
{1,2,3}
返回值
复制
[[1,2,3],[2,1,3],[2,3,1]]
备注:
n \leq 10^6n≤10
6
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution45 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public int[][] threeOrders(TreeNode root) {
        // write code here
        List<Integer> dlr = DLR(root);
        List<Integer> ldr = LDR(root);
        List<Integer> lrd = LRD(root);

        int[][] res = new int[3][dlr.size()];
        for (int i = 0; i < dlr.size(); i++) {
            res[0][i] = dlr.get(i);
        }
        for (int i = 0; i < ldr.size(); i++) {
            res[1][i] = ldr.get(i);
        }
        for (int i = 0; i < lrd.size(); i++) {
            res[2][i] = lrd.get(i);
        }
        return res;
    }

    // 根 左 右
    private List<Integer> DLR(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();

            if (pop != null) {
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }
                stack.push(pop);
                stack.push(null);
            } else {
                list.add(stack.pop().val);
            }
        }

        return list;
    }

    // 左 根 右
    private List<Integer> LDR(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();

            if (pop != null) {
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                stack.push(pop);
                stack.push(null);

                if (pop.left != null) {
                    stack.push(pop.left);
                }
            } else {
                list.add(stack.pop().val);
            }
        }

        return list;
    }

    // 左 右 根
    private List<Integer> LRD(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();

            if (pop != null) {
                stack.push(pop);
                stack.push(null);
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            } else {
                list.add(stack.pop().val);
            }
        }

        return list;
    }

}

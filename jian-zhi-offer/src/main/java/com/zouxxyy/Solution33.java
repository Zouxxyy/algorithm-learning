/*
面试题33. 二叉搜索树的后序遍历序列

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

 

参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3
示例 1：

输入: [1,6,3,2,5]
输出: false
示例 2：

输入: [1,3,2,6,5]
输出: true
 

提示：

数组长度 <= 1000

 */

/*
思路：

2叉排序树的后序遍历：[左子树，右子树，根]
满足 左子树 < 根 && 右子树 > 根，再递归左右子树
 */

package com.zouxxyy;

public class Solution33 {

    public boolean verifyPostorder(int[] postorder) {
        return dfs(postorder, 0, postorder.length - 1);
    }

    boolean dfs(int[] postorder, int start, int end) {
        if (end - start <= 1) return true;
        int cur = start;
        while (postorder[cur] < postorder[end])
            cur++;
        int mid = cur; // 中间值
        while (postorder[cur] > postorder[end])
            cur++;
        return cur == end && dfs(postorder, start, mid - 1) && dfs(postorder, mid, end - 1);
    }
}

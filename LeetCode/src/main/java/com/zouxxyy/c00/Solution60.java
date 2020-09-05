package com.zouxxyy.c00;

/*
60. 第k个排列
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：

给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:

输入: n = 3, k = 3
输出: "213"
示例 2:

输入: n = 4, k = 9
输出: "2314"
 */

import java.util.Arrays;

/**
 * @author zxy
 */
public class Solution60 {

    public String getPermutation(int n, int k) {

        int[] nums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        dfs(nums, k);

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }

        return sb.toString();
    }

    private void dfs(int[] nums, int k) {

        if (k == 1) {
            return;
        }

        int cur = 1, i = 1;

        while (k > cur) {
            cur *= ++i;
        }

        int l = nums.length - i;
        int next = (k - 1) / (cur / i) + l;
        int temp = nums[next];
        System.arraycopy(nums, l, nums, l + 1, next - l);
        nums[l] = temp;

        dfs(nums, k % (cur / i) != 0 ? k % (cur / i) : cur / i);
    }

}

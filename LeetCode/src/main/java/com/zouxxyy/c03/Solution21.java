package com.zouxxyy.c03;

/*
321. 拼接最大数
给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。

求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。

说明: 请尽可能地优化你算法的时间和空间复杂度。

示例 1:

输入:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
输出:
[9, 8, 6, 5, 3]
示例 2:

输入:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
输出:
[6, 7, 6, 0, 4]
示例 3:

输入:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
输出:
[9, 8, 9]
 */

/*
思路：

单调栈计算最大子序列 + 合并
 */


/**
 * @author zxy
 */
public class Solution21 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int[] res = new int[k];

        // 整体思路：两个数组 分别取 i (范围为[start, end]) 和 k - i 个数，进行拼接
        int start = Math.max(0, k - nums2.length);
        int end = Math.min(nums1.length, k);

        for (int i = start; i <= end; i++) {

            int[] nums1Sub = maxSubsequence(nums1, i);
            int[] nums2Sub = maxSubsequence(nums2, k - i);

            int[] mergeSub = mergeSequence(nums1Sub, nums2Sub);

            if (cmp(mergeSub, 0, res, 0)) {
                System.arraycopy(mergeSub, 0, res, 0, k);
            }

        }

        return res;
    }

    /**
     * 计算数组的最大子序列
     */
    private int[] maxSubsequence(int[] nums, int k) {

        // 思路：单调栈，栈底到栈顶由大到小。使用数组实现，从左到右由大到小

        int[] stack = new int[k];

        // 栈顶
        int top = -1;
        //
        int remain = nums.length - k;
        
        for (int num : nums) {

            // 比当前数小的数 出栈，并且注意当
            while (top >= 0 && stack[top] < num && remain > 0) {
                top--;
                remain--;
            }

            // 入栈
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                remain--;
            }

        }

        return stack;
    }


    /**
     * 合并数组，返回最大序列
     * 双指针，注意两数相等时，需要比较后面的序列，才能选择使用哪个数
     */
    private int[] mergeSequence(int[] s1, int[] s2) {

        int[] res = new int[s1.length + s2.length];

        int i = 0;
        int j = 0;

        for (int cur = 0; cur < res.length; cur++) {

            if (cmp(s1, i, s2, j)) {
                res[cur] = s1[i++];
            } else {
                res[cur] = s2[j++];
            }

        }

        return res;
    }

    /**
     * 比较序列，s1 > s2 返回 true
     */
    private boolean cmp(int[] s1, int i, int[] s2, int j) {

        while (i < s1.length && j < s2.length) {

            if (s1[i] > s2[j]) {
                return true;
            } else if (s1[i] < s2[j]) {
                return false;
            }

            i++;
            j++;
        }

        return ((s1.length - i) - (s2.length - j)) > 0;
    }

}

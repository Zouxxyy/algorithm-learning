package com.zouxxyy.c03;

/*
300. 最长上升子序列
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */

/*
思路：

贪心牛比
 */

/**
 * @author zxy
 */
public class Solution00 {


    /**
     * 方法一：dp，时间复杂度 O(N^2)
     */
    public int lengthOfLISDPOld(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        // dp[i]：以 nums[i] 结尾的最长上升子序列的
        int[] dp = new int[nums.length];
        int res = 0;

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }


    /**
     * 方法二：贪心 + 二分查找
     */
    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        // 贪心数组最后一个元素的坐标
        // arr[k] 的值代表 长度为 k+1 子序列 的尾部元素值
        int end = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > arr[end]) {

                // 如果 新数大于结尾的数，加到后面，end++
                arr[++end] = nums[i];
            } else {

                // 否则，二分查找，找到第一个大于等于它的数，替换它，比如 [2 5 7] + 3 -> [2 3 7]
                // 使用二分 左边界模板
                int l = 0;
                int r = end;

                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (arr[mid] >= nums[i]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }

                arr[l] = nums[i];
            }
        }
        return end + 1;
    }

}

package com.zouxxyy.c01;

/*
152. 乘积最大子数组
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。



示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */

/*
思路：

算以nums[i]结尾的情况，再求它们的极值即可
 */

/**
 * @author zxy
 */
public class Solution52 {

    public int maxProduct(int[] nums) {

        // 子问题：已知 以 nums[i - 1] 结尾的连续子数组的最大值 max 和最小值 min ，以及不需要以nums[i - 1]结尾的连续子数组的最大值 res，求 i 时的情况
        // 极值在 nums[i]，nums[i] * max，nums[i] * min 中产生

        int res = nums[0];
        int max = nums[0];
        int min = nums[0];


        for (int i = 1; i < nums.length; i++) {

            int temp1 = min * nums[i];
            int temp2 = max * nums[i];

            min = Math.min(nums[i], Math.min(temp1, temp2));
            max = Math.max(nums[i], Math.max(temp1, temp2));

            res = Math.max(res, max);

        }

        return res;
    }

}

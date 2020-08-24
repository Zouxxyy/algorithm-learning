package com.zouxxyy.c04;

/*
494. 目标和
给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。



示例：

输入：nums: [1, 1, 1, 1, 1], S: 3
输出：5
解释：

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

一共有5种方法让最终目标和为3。


提示：

数组非空，且长度不会超过 20 。
初始的数组的和不会超过 1000 。
保证返回的最终结果能被 32 位整数存下。
 */


/**
 * @author zxy
 */
public class Solution94 {


    /**
     * 方法一：动态规划
     */
    public int findTargetSumWays1(int[] nums, int S) {

        // 非负整数数组，sum > 0
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // S 超出范围时，没必要计算
        if (Math.abs(S) > sum) {
            return 0;
        }

        // dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]
        int[][] dp = new int[nums.length][2 * sum + 1];
        dp[0][sum + nums[0]] += 1;
        dp[0][sum - nums[0]] += 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = -1 * sum; j <= sum; j++) {

                int index = j - nums[i];
                if (index >= -1 * sum && index <= sum) {
                    dp[i][j + sum] += dp[i - 1][index + sum];
                }

                index = j + nums[i];
                if (index >= -1 * sum && index <= sum) {
                    dp[i][j + sum] += dp[i - 1][index + sum];
                }

            }
        }

        return dp[nums.length - 1][S + sum];
    }


    /**
     * 方法二：dfs
     */
    private int count = 0;

    public int findTargetSumWays2(int[] nums, int S) {

        dfs(nums, S, 0);
        return count;
    }

    private void dfs(int[] nums, int s, int index) {

        if (index == nums.length) {
            if (s == 0) {
                count++;
            }
            return;
        }

        dfs(nums, s - nums[index], index + 1);
        dfs(nums, s + nums[index], index + 1);

    }

}

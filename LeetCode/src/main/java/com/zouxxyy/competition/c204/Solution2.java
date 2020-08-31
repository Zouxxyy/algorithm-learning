package com.zouxxyy.competition.c204;

/*
1567. 乘积为正数的最长子数组长度
给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。

一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。

请你返回乘积为正数的最长子数组长度。



示例  1：

输入：nums = [1,-2,-3,4]
输出：4
解释：数组本身乘积就是正数，值为 24 。
示例 2：

输入：nums = [0,1,-2,-3,-4]
输出：3
解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
示例 3：

输入：nums = [-1,-2,-3,0,1]
输出：2
解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
示例 4：

输入：nums = [-1,2]
输出：1
示例 5：

输入：nums = [1,2,3,5,-6,4,0,10]
输出：4


提示：

1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
 */

/**
 * @author zxy
 */
public class Solution2 {

    public int getMaxLen(int[] nums) {

        // dp[i][0]，以 nums[i] 为结尾的，乘积为正数的最长子数组
        // dp[i][1]，以 nums[i] 为结尾的，乘积为负数的最长子数组
        // 转移方程：dp[i][0] = nums[i] > 0: dp[i - 1][0] + 1; nums[i] < 0: dp[i - 1][1] + 1; 0
        //         dp[i][1] = nums[i] > 0: dp[i - 1][1] + 1; nums[i] < 0: dp[i - 1][0] + 1; 0

        int[][] dp = new int[nums.length + 1][2];
        int res = 0;

        for (int i = 1; i <= nums.length; i++) {

            if (nums[i - 1] > 0) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] != 0 ? dp[i - 1][1] + 1 : 0;
            } else if (nums[i - 1] < 0) {
                dp[i][0] = dp[i - 1][1] != 0 ? dp[i - 1][1] + 1 : 0;
                dp[i][1] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = 0;
                dp[i][1] = 0;
            }

            res = Math.max(res, dp[i][0]);

        }

        return res;
    }

}

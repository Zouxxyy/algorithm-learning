package com.zouxxyy.c03;

/*
312. 戳气球
有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。

求所能获得硬币的最大数量。

说明:

你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
示例:

输入: [3,1,5,8]
输出: 167
解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */

/*
思路：

子问题也太难找了 + 区间dp
 */

/**
 * @author zxy
 */
public class Solution12 {

    public int maxCoins(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        // 构建新数组 1 x x x 1
        int[] val = new int[nums.length + 2];
        System.arraycopy(nums, 0, val, 1, nums.length);
        val[0] = 1;
        val[val.length - 1] = 1;

        // 子问题：dp[i][j] 戳破 （i,j）内气球可以得到的最大金币数（左开右开）
        // 转移方程：dp[i][j] = max(dp[i][k] + val[i] * val[k] * val[j] + dp[k][j])
        //         i < k < j，它是（i,j）内最后一个戳爆的气球
        // 计算顺序：区间 dp

        int[][] dp = new int[val.length][val.length];

        for (int interval = 2; interval < val.length; interval++) {
            for (int i = 0; i + interval < val.length; i++) {

                int j = i + interval;

                int max = 0;
                for (int k = i + 1; k < j; k++) {
                    max = Math.max(max, dp[i][k] + val[i] * val[k] * val[j] + dp[k][j]);
                }

                dp[i][j] = max;
            }
        }

        return dp[0][val.length - 1];
    }

}

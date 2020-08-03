package com.zouxxyy.c00;

/*
64. 最小路径和
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 */

/*
思路：

简单动态规划
 */

/**
 * @author zxy
 */
public class Solution64 {

    public int minPathSum(int[][] grid) {

        // dp[i][j] 代表到达(i, j)时的路径总和最小值
        // 转移方程：dp[i][j] = min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j]
        // 初始值：dp[0][0] = grid[0][0]，算出dp[0][x] 和 dp[x][0]
        // 计算顺序：i 从小到大，j 从小到大

        // 降维：dp[j] = min(dp[j - 1], dp[j]) + grid[i][j]
        // 计算顺序：i 从小到大，j 从小到大（因为dp[i][j] 要用到 dp[i][j - 1] 且 dp[i - 1][j]没被替换掉）

        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];

        dp[0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {

            // 0 位置由于没有dp[j - 1]，因此单独提出来计算
            dp[0] = dp[0] + grid[i][0];

            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }

        }

        return dp[n - 1];

    }

}

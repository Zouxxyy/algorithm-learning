/*
面试题47. 礼物的最大价值

在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

 

示例 1:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 

提示：

0 < grid.length <= 200
0 < grid[0].length <= 200

 */

package com.zouxxyy;

public class Solution47 {

    private int cur;
    private int res;

    public int maxValueOld(int[][] grid) {

        int i = grid.length;
        int j = grid[0].length;
        res = 0;
        cur = 0;
        dfs(grid, 0, 0);
        return res;
    }

    // dfs 超时
    public void dfs(int[][] grid, int i, int j) {
        cur += grid[i][j];
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            res = Math.max(cur, res);
            return;
        }

        if (i < grid.length - 1) {
            dfs(grid, i + 1, j);
            cur -= grid[i + 1][j];
        }

        if (j < grid[0].length - 1) {
            dfs(grid, i, j + 1);
            cur -= grid[i][j + 1];
        }
    }

    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) dp[i][j] = grid[i][j];
                else if (i == 0) dp[i][j] = dp[i][j - 1] + grid[i][j];
                else if (j == 0) dp[i][j] = dp[i - 1][j] + grid[i][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}

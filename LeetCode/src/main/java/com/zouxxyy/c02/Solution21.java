package com.zouxxyy.c02;

/*
221. 最大正方形
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4
 */

/*
动态规划

抓点
 */

/**
 * @author zxy
 */
public class Solution21 {

    public int maximalSquare(char[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }

        // 子问题：以 i,j 为右下角的正方形最大边长
        // 当 matrix[i][j] == 1 时，dp[i][j] = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1

        int res = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        // 注意题目给的是 char
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == '1') {
                    dp[i][j] = (i == 0 || j == 0) ? 1 : Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }

                res = Math.max(res, dp[i][j]);
            }
        }

        return res * res;
    }

}

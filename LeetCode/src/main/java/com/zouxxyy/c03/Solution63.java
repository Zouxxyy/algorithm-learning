package com.zouxxyy.c03;

/*
363. 矩形区域不超过 K 的最大数值和
给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。

题目数据保证总会存在一个数值和不超过 k 的矩形区域。



示例 1：


输入：matrix = [[1,0,1],[0,-2,3]], k = 2
输出：2
解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
示例 2：

输入：matrix = [[2,2,-1]], k = 3
输出：3


提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-100 <= matrix[i][j] <= 100
-105 <= k <= 105


进阶：如果行数远大于列数，该如何设计解决方案？
 */

/**
 * @author zxy
 */
public class Solution63 {

    public int maxSumSubmatrix(int[][] matrix, int k) {

        int res = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;

        int[][] dp = new int[m + 1][n + 1];

        // 求前缀和，右开区间
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        // 4重循环 求区间
        for (int i1 = 1; i1 <= m; i1++) {
            for (int i2 = i1; i2 <= m; i2++) {
                for (int j1 = 1; j1 <= n; j1++) {
                    for (int j2 = j1; j2 <= n; j2++) {
                        int cur = dp[i2][j2] + dp[i1 - 1][j1 - 1] - dp[i1 - 1][j2] - dp[i2][j1 - 1];
                        if (cur == k) {
                            return k;
                        } else if (cur < k) {
                            res = Math.max(res, cur);
                        }
                    }
                }
            }
        }

        return res;
    }

}

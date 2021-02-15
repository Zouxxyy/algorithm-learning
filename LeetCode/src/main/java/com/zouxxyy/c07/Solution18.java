package com.zouxxyy.c07;

/*
718. 最长重复子数组
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。



示例：

输入：
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出：3
解释：
长度最长的公共子数组是 [3, 2, 1] 。


提示：

1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100
 */

/**
 * @author zxy
 */
public class Solution18 {

    public int findLength(int[] A, int[] B) {

        // dp[i][j]：A[i:] 和 B[j:] 的最长公共前缀
        // 转移方程：dp[i][j] = A[i] == B[i] ? dp[i + 1][j + 1] + 1 : 0
        // 起始值：dp[m][j] = 0, dp[i][n] = 0
        // 计算顺序：i 和 j 由大到小

        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res;
    }

}

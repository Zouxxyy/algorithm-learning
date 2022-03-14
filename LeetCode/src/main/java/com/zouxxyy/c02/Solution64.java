package com.zouxxyy.c02;

/*
264. 丑数 II
给你一个整数 n ，请你找出并返回第 n 个 丑数 。

丑数 就是只包含质因数 2、3 和/或 5 的正整数。



示例 1：

输入：n = 10
输出：12
解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
示例 2：

输入：n = 1
输出：1
解释：1 通常被视为丑数。
 */

/**
 * @author zxy
 */
public class Solution64 {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int a = 1, b = 1, c = 1;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(dp[a] * 2, Math.min(dp[b] * 3, dp[c] * 5));
            if (next == dp[a] * 2) {
                a++;
            }
            if (next == dp[b] * 3) {
                b++;
            }
            if (next == dp[c] * 5) {
                c++;
            }
            dp[i] = next;
        }
        return dp[n];
    }

}

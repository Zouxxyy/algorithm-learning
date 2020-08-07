package com.zouxxyy.c00;

/*
96. 不同的二叉搜索树
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */

/*

动态规划：dp[n]：n个连续数可以构成的平衡二叉树个数

核心：以新数为中心，比它小的数必定在其左上（必连续），或者在其左下（必连续）。

如图：

   dp[0]       dp[1]        dp[2]             dp[i-2]     dp[i-1]
       \          \           \                  \            \
        i          i           i       ...        i            i
       /          /           /                  /            /
  dp[i-1]      dp[i-2]     dp[i-3]            dp[1]        dp[0]

为了后续代码优雅，定 dp[0] = 1

转移方程：dp[i] = dp[0] * dp[i - 1] + ... + dp[i - 1] * dp[0]

 */

/**
 * @author zxy
 */
public class Solution96 {

    public int numTrees(int n) {

        // dp[n] n个连续数可以构成的平衡二叉树个数
        // 转移方程：dp[i] = dp[0] * dp[i - 1] + ... + dp[i - 1]dp[0]
        // 初始值：dp[0] = 1, dp[1] = 1
        // 计算顺序：i 从小到大

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

}

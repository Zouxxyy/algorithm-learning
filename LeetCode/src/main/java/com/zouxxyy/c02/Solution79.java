package com.zouxxyy.c02;

/*
279. 完全平方数
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.
 */

/*
思路：

DP 或者 bfs
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution79 {

    /**
     * 解法1：使用动态规划
     */
    public int numSquaresDp(int n) {

        // dp[i]：组成和为 i 的完全平方数的最小个数
        // 转移方程：dp[i] = min(dp[i - 1 * 1], dp[i - 2 * 2], ...) + 1;
        // 初始值：dp[0] = 0

        int[] dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            dp[i] = Integer.MAX_VALUE;

            for (int k = 1; k * k <= i; k++) {
                dp[i] = Math.min(dp[i], dp[i - k * k]);
            }

            dp[i] += 1;
        }

        return dp[n];
    }


    /**
     * 解法2：BFS
     *
     * 转换计算树的层数的问题，注意剪除（去除重复的数）
     */
    public int numSquares(int n) {

        // 剪枝
        boolean[] visited = new boolean[n];

        int level = 0;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(n);

        // 树求层数的一般写法
        while (!queue.isEmpty()) {

            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int poll = queue.poll();

                int k = 1, remain;
                while ((remain = (poll - k * k)) > 0) {
                    if (!visited[remain]) {
                        visited[remain] = true;
                        queue.offer(remain);
                    }
                }

                if (remain == 0) {
                    return level;
                }
            }
        }
        return -1;
    }

}

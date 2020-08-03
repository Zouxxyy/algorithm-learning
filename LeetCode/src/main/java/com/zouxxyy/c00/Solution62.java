package com.zouxxyy.c00;

/*
62. 不同路径
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？



例如，上图是一个7 x 3 的网格。有多少可能的路径？



示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28


提示：

1 <= m, n <= 100
题目数据保证答案小于等于 2 * 10 ^ 9
 */

/*
思路：

简单动态规划问题
 */

import java.util.Arrays;

/**
 * @author zxy
 */
public class Solution62 {

    public int uniquePaths(int m, int n) {

        // dp[i][j] 代表到达(i,j)时的路径数
        // 转移方程：dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
        // 初始条件：dp[1][x] = 1， dp[x][1] = 1
        // 计算顺序，i 从小到大，j 从小到大

        // 降维：dp[j] = dp[j - 1] + dp[j]
        // 计算顺序，i 从小到大，j 从小到大（因为dp[i][j] 要用到 dp[i][j - 1] 且 dp[i - 1][j]没被替换掉）

        int[] dp = new int[n + 1];

        Arrays.fill(dp, 1);

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }

        return dp[n];
    }

}

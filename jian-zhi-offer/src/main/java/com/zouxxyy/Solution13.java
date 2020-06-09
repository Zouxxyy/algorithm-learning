/*
面试题13. 机器人的运动范围

地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

 

示例 1：

输入：m = 2, n = 3, k = 1
输出：3
示例 2：

输入：m = 3, n = 1, k = 0
输出：1
提示：

1 <= n,m <= 100
0 <= k <= 20

 */

/*
思路：

使用广搜
 */

package com.zouxxyy;

import java.util.LinkedList;
import java.util.Queue;

public class Solution13 {

    private static final int[][] steps = new int[][]{{1, 0}, {0, 1}};

    public static int movingCount(int m, int n, int k) {

        int res = 0;

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for (int[] step : steps) {
                int M = point[0] + step[0];
                int N = point[1] + step[1];

                if (M >= 0 && M < m && N >= 0 && N < n && !visited[M][N]) {
                    visited[M][N] = true;
                    if ((M / 10 + M % 10 + N / 10 + N % 10) <= k) {
                        queue.add(new int[]{M, N});
                    }
                }
            }
            res += 1;
        }
        return res;
    }
}

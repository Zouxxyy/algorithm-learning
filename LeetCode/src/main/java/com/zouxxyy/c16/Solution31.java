package com.zouxxyy.c16;

/*
1631. 最小体力消耗路径
你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。

一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。

请你返回从左上角走到右下角的最小 体力消耗值 。



示例 1：



输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
输出：2
解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
示例 2：



输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
输出：1
解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
示例 3：


输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
输出：0
解释：上图所示路径不需要消耗任何体力。


提示：

rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106
 */

/**
 * @author zxy
 */
public class Solution31 {

    private static final int[][] STEPS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minimumEffortPath(int[][] heights) {

        // k 为差值，0 <= k <= 最大间隔，使用二分左端点模板
        // 分析 k 时是否可以到达：使用visited[][] 数组 + dfs

        int m = heights.length;
        int n = heights[0].length;

        int l = 0;
        // 计算最大间隔
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                r = Math.max(r, heights[i][j] - heights[i][j - 1]);
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                r = Math.max(r, heights[i][j] - heights[i - 1][j]);
            }
        }

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (can(heights, new boolean[m][n], mid, m, n)) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }

        return l;
    }


    private boolean can(int[][] heights, boolean[][] visited, int k, int m, int n) {

        visited[0][0] = true;
        dfs(heights, visited, k, m, n, 0, 0);
        return visited[m - 1][n - 1];

    }

    private void dfs(int[][] heights, boolean[][] visited, int k, int m, int n, int i, int j) {

        if (visited[m - 1][n - 1]) {
            return;
        }

        for (int[] step : STEPS) {

            int newI = i + step[0];
            int newJ = j + step[1];

            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && !visited[newI][newJ] && Math.abs(heights[newI][newJ] - heights[i][j]) <= k) {
                visited[newI][newJ] = true;
                dfs(heights, visited, k, m, n, newI, newJ);
            }

        }

    }

}

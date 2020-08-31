package com.zouxxyy.competition.c204;

/*
1568. 使陆地分离的最少天数
给你一个由若干 0 和 1 组成的二维网格 grid ，其中 0 表示水，而 1 表示陆地。岛屿由水平方向或竖直方向上相邻的 1 （陆地）连接形成。

如果 恰好只有一座岛屿 ，则认为陆地是 连通的 ；否则，陆地就是 分离的 。

一天内，可以将任何单个陆地单元（1）更改为水单元（0）。

返回使陆地分离的最少天数。



示例 1：



输入：grid = [[0,1,1,0],[0,1,1,0],[0,0,0,0]]
输出：2
解释：至少需要 2 天才能得到分离的陆地。
将陆地 grid[1][1] 和 grid[0][2] 更改为水，得到两个分离的岛屿。
示例 2：

输入：grid = [[1,1]]
输出：2
解释：如果网格中都是水，也认为是分离的 ([[1,1]] -> [[0,0]])，0 岛屿。
示例 3：

输入：grid = [[1,0,1,0]]
输出：0
示例 4：

输入：grid = [[1,1,0,1,1],
             [1,1,1,1,1],
             [1,1,0,1,1],
             [1,1,0,1,1]]
输出：1
示例 5：

输入：grid = [[1,1,0,1,1],
             [1,1,1,1,1],
             [1,1,0,1,1],
             [1,1,1,1,1]]
输出：2


提示：

1 <= grid.length, grid[i].length <= 30
grid[i][j] 为 0 或 1
 */

/*
思路：

只有 0、1、2 三种情况
 */


/**
 * @author zxy
 */
public class Solution3 {

    public int minDays(int[][] grid) {

        int cnt = 0;
        for (int[] ints : grid) {
            for (int i : ints) {
                cnt += i;
            }
        }

        if (isDisConnect(grid, cnt)) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (isDisConnect(grid, cnt - 1)) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }


    /**
     * grid 是否是不连通的，通过一次 dfs 和 cnt比较
     */
    private boolean isDisConnect(int[][] grid, int cnt) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, visited, i, j) < cnt;
                }
            }
        }

        return true;
    }

    private int dfs(int[][] grid, boolean[][] visited, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }

        visited[i][j] = true;

        return 1 + dfs(grid, visited, i + 1, j) +
                dfs(grid, visited, i - 1, j) +
                dfs(grid, visited, i, j + 1) +
                dfs(grid, visited, i, j - 1);
    }

}

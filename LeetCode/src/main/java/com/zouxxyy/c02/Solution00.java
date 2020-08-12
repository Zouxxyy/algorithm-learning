package com.zouxxyy.c02;

/*
200. 岛屿数量
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。



示例 1:

输入:
[
['1','1','1','1','0'],
['1','1','0','1','0'],
['1','1','0','0','0'],
['0','0','0','0','0']
]
输出: 1
示例 2:

输入:
[
['1','1','0','0','0'],
['1','1','0','0','0'],
['0','0','1','0','0'],
['0','0','0','1','1']
]
输出: 3
解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */

/*
思路：

dfs
 */

/**
 * @author zxy
 */
public class Solution00 {

    public int numIslands(char[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        int res = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    spread(i, j, grid, visited);
                }
            }
        }

        return res;
    }


    private void spread(int i, int j, char[][] grid, boolean[][] visited) {

        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1' && !visited[i][j]) {

            visited[i][j] = true;

            spread(i - 1, j, grid, visited);
            spread(i + 1, j, grid, visited);
            spread(i, j - 1, grid, visited);
            spread(i, j + 1, grid, visited);
        }

    }

}

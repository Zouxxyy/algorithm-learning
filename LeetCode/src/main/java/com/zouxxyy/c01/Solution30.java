package com.zouxxyy.c01;

/*
130. 被围绕的区域
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

示例:

X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：

X X X X
X X X X
X X X X
X O X X
解释:

被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution30 {

    private final int[][] STEPS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {

        int m = board.length;
        if (m <= 1) {
            return;
        }
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        int good = 0;
        Queue<int[]> queue = new LinkedList<>();

        // 添加边界上的
        for (int j = 0; j < n; j++) {
            visited[0][j] = true;
            visited[m - 1][j] = true;
            if (board[0][j] == 'O') {
                queue.offer(new int[]{0, j});
                board[0][j] = 'S';
            }
            if (board[m - 1][j] == 'O') {
                queue.offer(new int[]{m - 1, j});
                board[m - 1][j] = 'S';
            }
        }

        for (int i = 1; i < m - 1; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
                board[i][0] = 'S';
            }
            if (board[i][n - 1] == 'O') {
                queue.offer(new int[]{i, n - 1});
                board[i][n - 1] = 'S';
            }
        }

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            for (int[] step : STEPS) {
                int nextI = cur[0] + step[0];
                int nextJ = cur[1] + step[1];

                if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && !visited[nextI][nextJ] && board[nextI][nextJ] == 'O') {
                    visited[nextI][nextJ] = true;
                    queue.offer(new int[]{nextI, nextJ});
                    board[nextI][nextJ] = 'S';
                }
            }

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }

    }

}

package com.zouxxyy.c07;

/**
 * @author zxy
 */
public class Solution78 {

    private static final int[][] STEPS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int swimInWater(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int l = grid[0][0];

        int r = Integer.MIN_VALUE;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                r = Math.max(r, ints[j]);
            }
        }

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (can(grid, new boolean[m][n], mid, m, n)) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }

        return l;
    }


    private boolean can(int[][] grid, boolean[][] visited, int k, int m, int n) {

        visited[0][0] = true;
        dfs(grid, visited, k, m, n, 0, 0);
        return visited[m - 1][n - 1];

    }

    private void dfs(int[][] grid, boolean[][] visited, int k, int m, int n, int i, int j) {

        if (visited[m - 1][n - 1]) {
            return;
        }

        for (int[] step : STEPS) {

            int newI = i + step[0];
            int newJ = j + step[1];

            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && !visited[newI][newJ] && grid[newI][newJ] <= k) {
                visited[newI][newJ] = true;
                dfs(grid, visited, k, m, n, newI, newJ);
            }

        }

    }

}

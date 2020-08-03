package com.zouxxyy.c00;

/*
79. 单词搜索
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。



示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false


提示：

board 和 word 中只包含大写和小写英文字母。
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
 */

/*
思路：

4方向回溯 + reached 数组
 */

/**
 * @author zxy
 */
public class Solution79 {

    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        boolean[][] reached = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, m, n, reached)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j, int m, int n, boolean[][] reached) {

        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index) || reached[i][j]) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        reached[i][j] = true;
        // 4个方向
        for (int[] direction : DIRECTIONS) {
            if (dfs(board, word, index + 1, i + direction[0], j + direction[1], m, n, reached)) {
                return true;
            }
        }
        reached[i][j] = false;
        return false;
    }

}

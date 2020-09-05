package com.zouxxyy.c00;

/*
51. N 皇后
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。



示例：

输入：4
输出：[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。


提示：

皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。

 */

/*
思路：

回溯
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution51 {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new LinkedList<>();
        dfs(new int[n][n], 0, res);
        return res;
    }

    /**
     * 按行回溯
     */
    private void dfs(int[][] grid, int row, List<List<String>> res) {

        if (row == grid.length) {
            // 写入答案
            res.add(arrayToList(grid));
            return;
        }

        // 遍历同一行
        for (int col = 0; col < grid[row].length; col++) {

            if (check(grid, row, col)) {
                grid[row][col] = 1;
                dfs(grid, row + 1, res);
                grid[row][col] = 0;
            }
        }

    }


    /**
     * 此时是否可以放置皇后，这里可以用 Set 存储用过的列、斜线，以空间换时间
     */
    private boolean check(int[][] grid, int i, int j) {

        // 由于我们是一行一行选择，只需要检查上半部分的竖直和斜线

        // 竖直
        for (int k = 0; k < i; k++) {
            if (grid[k][j] == 1) {
                return false;
            }
        }

        // 左斜
        int temp = i + j;
        for (int k = i - 1; temp - k < grid.length && k >= 0; k--) {
            if (grid[k][temp - k] == 1) {
                return false;
            }
        }

        // 右斜
        temp = j - i;
        for (int k = i - 1; temp + k >= 0 && k >= 0; k--) {
            if (grid[k][temp + k] == 1) {
                return false;
            }
        }

        return true;
    }


    /**
     * array 变成 List<String>
     */
    private List<String> arrayToList(int[][] grid) {

        ArrayList<String> res = new ArrayList<>(grid.length);

        for (int[] ints : grid) {

            StringBuilder sb = new StringBuilder();
            for (int i : ints) {
                sb.append(i == 1 ? 'Q' : '.');
            }
            res.add(sb.toString());

        }
        return res;
    }

}

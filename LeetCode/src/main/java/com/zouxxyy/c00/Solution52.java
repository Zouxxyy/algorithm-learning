package com.zouxxyy.c00;


/*
52. N皇后 II
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回 n 皇后不同的解决方案的数量。

示例:

输入: 4
输出: 2
解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]


提示：

皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N-1 步，可进可退。（引用自 百度百科 - 皇后 ）
 */

/*
思路：

回溯
 */


/**
 * @author zxy
 */
public class Solution52 {

    private int res = 0;
    private boolean[][] visited;

    public int totalNQueens(int n) {

        visited = new boolean[n][n];
        dfs(0, n);
        return res;

    }

    private void dfs(int i, int n) {

        if (i == n) {
            res++;
            return;
        }

        for (int j = 0; j < n; j++) {

            if (check(i, j, n)) {

                visited[i][j] = true;
                dfs(i + 1, n);
                visited[i][j] = false;

            }

        }

    }

    private boolean check(int I, int J, int n) {

        // 判断竖着的
        for (int i = 0; i < I; i++) {
            if (visited[i][J]) {
                return false;
            }
        }

        // 判断左斜
        for (int i = I - 1; i >= 0 && (i - I + J) >= 0; i--) {
            if (visited[i][i - I + J]) {
                return false;
            }
        }

        // 判断右斜
        for (int i = I - 1; i >= 0 && (I + J - i) < n; i--) {
            if (visited[i][I + J - i]) {
                return false;
            }
        }

        return true;
    }

}

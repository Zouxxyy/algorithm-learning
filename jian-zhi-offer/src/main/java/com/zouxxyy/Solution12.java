/*
面试题12. 矩阵中的路径

请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]

但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

 

示例 1：

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
示例 2：

输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false
提示：

1 <= board.length <= 200
1 <= board[i].length <= 200

 */

/*
思路：

深搜
 */

package com.zouxxyy;

public class Solution12 {

    private static final int[][] steps = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static boolean exist(char[][] board, String word) {
        if (word.length() == 0) return false;

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j] && dfs(board, word, 1, i, j, visited))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] visited) {

        if (word.length() == index) return true;

        visited[i][j] = true;
        for (int[] step : steps) {
            int I = i + step[0];
            int J = j + step[1];
            if (I >= 0 && I < board.length && J >= 0 && J < board[0].length
                    && !visited[I][J] && board[I][J] == word.charAt(index)
                    && dfs(board, word, index + 1, I, J, visited))
                return true;
        }
        visited[i][j] = false;
        return false;
    }
}

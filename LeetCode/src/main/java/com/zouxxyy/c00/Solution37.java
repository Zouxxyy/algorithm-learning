package com.zouxxyy.c00;

/**
 * @author zxy
 */
public class Solution37 {

    private boolean finish = false;

    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    private void dfs(char[][] board, int i, int j) {


        for (int m = i; m < 9; m++) {
            for (int n = 0; n < 9; n++) {

                if ((m == i && n <= j) || board[i][j] != '.') {
                    continue;
                }

                for (int k = 1; k <= 9; k++) {

                    if (finish || !check(board, m, n, k)) {
                        return;
                    }

                    board[m][n] = (char) (k + '0');
                    dfs(board, m, n);
                    if (finish) {
                        return;
                    }
                    board[m][n] = ',';
                }

                break;


            }

        }

        finish = true;

    }

    private boolean check(char[][] board, int i, int j, int cur) {

        for (int k = 0; k < 9; k++) {
            if (k != j && board[i][k] == cur - '0') {
                return false;
            }
        }

        for (int k = 0; k < 9; k++) {
            if (k != i && board[k][j] == cur - '0') {
                return false;
            }
        }

        for (int m = i / 3 * 3; m < i / 3 * 3 + 3; m++) {
            for (int n = j / 3 * 3; n < j / 3 * 3 + 3; n++) {
                if ((m != i || n != j) && board[m][n] == cur - '0') {
                    return false;
                }
            }
        }

        return true;
    }

}

package nc00;

/*
螺旋矩阵

给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
示例1
输入
复制
[[1,2,3],[4,5,6],[7,8,9]]
返回值
复制
[1,2,3,6,9,8,7,4,5]
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution38 {

    public ArrayList<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> res = new ArrayList<>();

        int m = matrix.length;
        if (m == 0) {
            return res;
        }
        int n = matrix[0].length;

        int state = 0;
        int[] board = new int[]{n - 1, m - 1, 0, 1};
        int i = 0, j = 0, k = 0;

        while (k++ < m * n) {

            res.add(matrix[i][j]);

            if (state == 0) {

                if (j + 1 <= board[0]) {
                    j++;
                } else {
                    i++;
                    state = 1;
                    board[0]--;
                }

            } else if (state == 1) {

                if (i + 1 <= board[1]) {
                    i++;
                } else {
                    j--;
                    state = 2;
                    board[1]--;
                }

            } else if (state == 2) {

                if (j - 1 >= board[2]) {
                    j--;
                } else {
                    i--;
                    state = 3;
                    board[2]++;
                }

            } else {

                if (i - 1 >= board[3]) {
                    i--;
                } else {
                    j++;
                    state = 0;
                    board[3]++;
                }

            }
        }

        return res;
    }

}

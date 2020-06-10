/*
面试题29. 顺时针打印矩阵

输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

 

示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 

限制：

0 <= matrix.length <= 100
0 <= matrix[i].length <= 100

 */

/*
思路：

切物体，上面切一刀，右边一刀，下边一刀，左边一刀
 */

package com.zouxxyy;

public class Solution29 {
    public int[] spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];

        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];

        int left = 0, right = n - 1, up = 0, down = m - 1;
        int k = 0, i;

        while (true) {
            for (i = left; i <= right; i++) res[k++] = matrix[up][i];
            if (++up > down) return res;
            for (i = up; i <= down; i++) res[k++] = matrix[i][right];
            if (--right < left) return res;
            for (i = right; i >= left; i--) res[k++] = matrix[down][i];
            if (--down < up) return res;
            for (i = down; i >= up; i--) res[k++] = matrix[i][left];
            if (++left > right) return res;
        }
    }
}

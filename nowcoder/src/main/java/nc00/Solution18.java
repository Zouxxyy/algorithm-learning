package nc00;

/*
顺时针旋转矩阵

有一个NxN整数矩阵，请编写一个算法，将矩阵顺时针旋转90度。

给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于300。

示例1
输入
[[1,2,3],[4,5,6],[7,8,9]],3

返回值
[[7,4,1],[8,5,2],[9,6,3]]
 */

/**
 * @author zxy
 */
public class Solution18 {

    public int[][] rotateMatrix(int[][] mat, int n) {

        // 原地算法

        /*
        1 2 3                     1 4 7                  7 4 1
        4 5 6  -> 对角线翻转  ->   2 5 8  -> 中线翻转 ->   8 5 2
        7 8 9                     3 6 9                  9 6 3
         */

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(mat, i, j, j, i);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(mat, i, j, i, n - 1 - j);
            }
        }

        return mat;

    }

    private void swap(int[][] mat, int i1, int j1, int i2, int j2) {

        int temp = mat[i1][j1];
        mat[i1][j1] = mat[i2][j2];
        mat[i2][j2] = temp;

    }


}

package com.zouxxyy.c00;

/*
48. 旋转图像
给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:

给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
示例 2:

给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */

/*
思路：

从一个点出发，找出该点替换的位置，再找被替换的位置又替换到哪，找出规律即可
然后选择一圈一圈的遍历
 */

/**
 * @author zxy
 */
public class Solution48 {

    public void rotate(int[][] matrix) {

        // matrix[i][j] -> matrix[j][n - i - 1]

        int n = matrix.length;

        // 按圈数遍历
        for (int k = 0; k <= (n - 1) / 2; k++) {
            // 旋转第k圈的数：遍历该圈的上横行的数
            for (int j = k; j <= n - k - 2; j++) {
                int temp = matrix[k][j];
                matrix[k][j] = matrix[n - 1 - j][k];
                matrix[n - 1 - j][k] = matrix[n - 1 - k][n - 1 - j];
                matrix[n - 1 - k][n - 1 - j] = matrix[j][n - 1 - k];
                matrix[j][n - 1 - k] = temp;
            }
        }

    }
}

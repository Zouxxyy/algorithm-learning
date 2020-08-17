package com.zouxxyy.c02;

/*
240. 搜索二维矩阵 II
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。
 */

/*
思路：

从右上角开始走
 */

/**
 * @author zxy
 */
public class Solution40 {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) {
            return false;
        }

        // 右上角出发
        int i = 0;
        int j = matrix[0].length - 1;

        while (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {

            int cur = matrix[i][j];

            if (cur == target) {
                return true;
            } else if (cur < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}

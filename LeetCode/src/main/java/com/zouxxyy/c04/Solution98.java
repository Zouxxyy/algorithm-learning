package com.zouxxyy.c04;

/*
498. 对角线遍历
给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。



示例:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

输出:  [1,2,4,7,5,3,6,8,9]

解释:



说明:

给定矩阵中的元素总数不会超过 100000 。
 */

/**
 * @author zxy
 */
public class Solution98 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int k = 0;
        boolean rise = true;
        // 核心：i 和 j 交替以 sum 为开始（不能超过边界）添加数，sum 每次加 1
        for (int sum = 0; sum <= m + n - 2; sum++) {
            if (rise) {
                for (int i = Math.min(sum, m - 1); i >= 0 && sum - i < n; i--) {
                    res[k++] = mat[i][sum - i];
                }
            } else {
                for (int j = Math.min(sum, n - 1); j >= 0 && sum - j < m; j--) {
                    res[k++] = mat[sum - j][j];
                }
            }
            rise = !rise;
        }
        return res;
    }
}

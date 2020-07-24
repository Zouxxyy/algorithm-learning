package com.zouxxyy;

import java.util.Scanner;

/*
在行列都排好序的矩阵中找指定的数

题目描述
给定一个N×M的整形矩阵matrix和一个整数K, matrix的每一行和每一列都是排好序的。
实现一个函数，判断K是否在matrix中
[要求]
时间复杂度为O(N+M)，额外空间复杂度为O(1)。
输入描述:
第一行有三个整数N, M, K
接下来N行，每行M个整数为输入的矩阵
输出描述:
若K存在于矩阵中输出"Yes"，否则输出"No"
 */

/*
思路：
从右上角开始寻找
时间复杂度为O(N+M)，额外空间复杂度为O(1)。
 */

/**
 * @author zxy
 */
public class C001 {

    public static boolean kInMatrix(int[][] matrix, int k) {

        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                int a = matrix[i][j];
                if (a == k) {
                    return true;
                } else if (a > k) {
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        boolean res = kInMatrix(matrix, k);
        if (res) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

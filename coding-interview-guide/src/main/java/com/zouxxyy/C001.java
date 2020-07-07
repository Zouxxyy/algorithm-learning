package com.zouxxyy;

import java.util.Scanner;

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

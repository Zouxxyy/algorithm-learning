package com.zouxxyy;

import java.util.Scanner;

/*
题目描述
给定排序数组arr和整数k，不重复打印arr中所有相加和为k的不降序三元组
例如, arr = [-8, -4, -3, 0, 1, 2, 4, 5, 8, 9], k = 10，打印结果为：
-4 5 9
-3 4 9
-3 5 8
0 1 9
0 2 8
1 4 5
[要求]
时间复杂度为O(n^2)，空间复杂度为O(1)

输入描述:
第一行有两个整数n, k
接下来一行有n个整数表示数组内的元素
输出描述:
输出若干行，每行三个整数表示答案
按三元组从小到大的顺序输出(三元组大小比较方式为每个依次比较三元组内每个数)
 */

/*
思路：
一个数加上两数相加（C003）
时间复杂度为O(n^2)，空间复杂度为O(1)
 */

/**
 * @author zxy
 */
public class C004 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        StringBuilder builder = new StringBuilder();

        // 由于要确保有3个数，i 至少为 n - 3
        for (int i = 0; i <= n - 3; i++) {

            // 去重
            if (i != 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int target = k - arr[i];
            int left = i + 1, right = n - 1;
            while (left < right) {

                // 去重
                if (arr[left] == arr[left - 1]) {
                    left++;
                    continue;
                }
                if (right != (n - 1) && arr[right] == arr[right + 1]) {
                    right--;
                    continue;
                }

                int sum = arr[left] + arr[right];
                if (sum == target) {
                    builder.append(arr[i]).append(' ').append(arr[left]).append(arr[right]).append('\n');
                    left++;
                    right--;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(builder.toString());
    }
}

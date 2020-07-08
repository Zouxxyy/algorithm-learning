package com.zouxxyy;

import java.util.Scanner;

/*
题目描述
给定排序数组arr和整数k，不重复打印arr中所有相加和为k的不降序二元组
例如, arr = [-8, -4, -3, 0, 1, 2, 4, 5, 8, 9], k = 10，打印结果为：
1, 9
2, 8
[要求]
时间复杂度为O(n)，空间复杂度为O(1)
输入描述:
第一行有两个整数n, k
接下来一行有n个整数表示数组内的元素
输出描述:
输出若干行，每行两个整数表示答案
按二元组从小到大的顺序输出(二元组大小比较方式为每个依次比较二元组内每个数)
 */

/*
思路：
左右指针 + 去重
时间复杂度为O(n)，空间复杂度为O(1)
 */

/**
 * @author zxy
 */
public class C003 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int left = 0, right = n - 1;

        while (left < right) {

            // 去重
            if (left != 0 && arr[left] == arr[left - 1]) {
                left++;
                continue;
            }
            if (right != (n - 1) && arr[right] == arr[right + 1]) {
                right--;
                continue;
            }

            int sum = arr[left] + arr[right];
            if (sum == k) {
                System.out.println(arr[left] + " " + arr[right]);
                left++;
                right--;
            } else if (sum > k) {
                right--;
            } else {
                left++;
            }
        }
    }
}

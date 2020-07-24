package com.zouxxyy;

import java.util.HashMap;
import java.util.Scanner;

/*
题目描述
给定一个无序数组arr，其中元素可正、可负、可0。求arr所有子数组中正数与负数个数相等的最长子数组的长度。
[要求]
时间复杂度为O(n)，空间复杂度为O(n)
输入描述:
第一行一个整数N，表示数组长度
接下来一行有N个数表示数组中的数
输出描述:
输出一个整数表示答案
 */

/*
思路：

dp[i] 代表前i个数的正负号插值，找到从dp[0]开始第一个等于dp[i]的索引j，i - j 就是长度为 i 时的最大值（dp[i] == 0 时，最大值就是 i + 1）
可用 hashMap 加速
 */

/**
 * @author zxy
 */
public class C010 {

    private static int solution(int[] arr) {

        int maxLength = 0;
        int sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>(arr.length);

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0) {
                sum += arr[i] > 0 ? 1 : -1;
            }

            if (sum == 0) {
                maxLength = i + 1;

            } else {
                if (!hashMap.containsKey(sum)) {
                    hashMap.put(sum, i);
                } else {
                    maxLength = Math.max(maxLength, i - hashMap.get(sum));
                }
            }

        }
        return maxLength;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(arr));

    }

}

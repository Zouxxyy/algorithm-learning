package com.zouxxyy;

import java.util.HashMap;
import java.util.Scanner;

/*
题目描述
给定一个无序数组arr, 其中元素可正、可负、可0。给定一个整数k，求arr所有子数组中累加和为k的最长子数组长度
输入描述:
第一行两个整数N, k。N表示数组长度，k的定义已在题目描述中给出
第二行N个整数表示数组内的数
输出描述:
输出一个整数表示答案
 */


/*
思路：

(m, n]的和为 sum[0, n] - sum[0, m]
 */

/**
 * @author zxy
 */
public class C009 {

    private static int solution(int[] arr, int target) {

        int sum = 0;
        int maxLength = 0;

        // key 是数组上 [0, k] 之和，value 是 k （取最小），
        HashMap<Integer, Integer> hashMap = new HashMap<>(arr.length + 1);

        // 注意此处
        hashMap.put(0, -1);

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (hashMap.containsKey(sum - target)) {
                maxLength = Math.max(maxLength, i - hashMap.get(target - sum));
            }

            if (!hashMap.containsKey(sum)) {
                hashMap.put(sum, i);
            }

        }

        return maxLength;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int target = scanner.nextInt();


        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(arr, target));

    }
}



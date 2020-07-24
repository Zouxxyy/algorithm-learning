package com.zouxxyy;

import java.util.HashMap;
import java.util.Scanner;

/*
题目描述
给定一个无序数组arr，其中元素只能是1或0。求arr所有的子数组中0和1个数相等的最长子数组的长度
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

和C010基本一样
 */

/**
 * @author zxy
 */
public class C011 {

    private static int solution(int[] arr) {

        HashMap<Integer, Integer> hashMap = new HashMap<>(arr.length);

        int maxLength = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] == 0 ? -1 : 1;
            if (sum == 0) {
                maxLength = i + 1;
            } else {
                if (hashMap.containsKey(sum)) {
                    maxLength = Math.max(maxLength, i - hashMap.get(sum));
                } else {
                    hashMap.put(sum, i);
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

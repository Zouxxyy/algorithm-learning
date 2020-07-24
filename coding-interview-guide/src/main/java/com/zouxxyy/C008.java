package com.zouxxyy;

import java.util.Scanner;

/*
题目描述
给定一个数组arr，该数组无序，但每个值均为正数，再给定一个正数k。求arr的所有子数组中所有元素相加和为k的最长子数组的长度
例如，arr = [1, 2, 1, 1, 1], k = 3
累加和为3的最长子数组为[1, 1, 1]，所以结果返回3
[要求]
时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 */

/*
思路：
双指针
 */

/**
 * @author zxy
 */
public class C008 {


    /**
     * 双指针：左开右闭
     */
    private static int solution(int[] arr, int target) {

        int left = 0, right = 0;
        int sum = arr[0];
        int maxLength = 0;

        while (right < arr.length) {

            if (sum == target) {

                maxLength = Math.max(maxLength, right - left + 1);

                sum -= arr[left++];
                if (++right < arr.length) {
                    sum += arr[right];
                }

            } else if (sum > target) {

                sum -= arr[left++];

            } else {

                if (++right < arr.length) {
                    sum += arr[right];
                }
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

package com.zouxxxyy.sort;

import java.util.Arrays;

/*
基数排序

取得数组中的最大数，并取得位数；
arr为原始数组，从最低位开始取每个位组成radix数组；
对radix进行计数排序（利用计数排序适用于小范围数的特点）
循环直到最高位

时间复杂度：平均 O(d * n) 最坏 O(d * n) 最好 O(d * n)
空间复杂度： O(n + k)
稳定排序
 */

/**
 * @author zxy
 */
public class RadixSort {

    public static void radixSort(int[] arr) {

        // 10进制，10个桶
        int[] bucket = new int[10];

        // 获取最大数字的位数
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        int digits = 0;
        while (max != 0) {
            max /= 10;
            digits++;
        }

        // 从最低位开始到最高位，进行计数排序
        int[] temp = new int[arr.length];
        for (int x = 1; x <= digits; x++) {

            // 桶置0
            Arrays.fill(bucket, 0);

            // 计数排序
            for (int num : arr) {
                bucket[getDigit(num, x)]++;
            }

            for (int i = 1; i < bucket.length; i++) {
                bucket[i] += bucket[i - 1];
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                temp[bucket[getDigit(arr[i], x)] - 1] = arr[i];
                bucket[getDigit(arr[i], x)] -= 1;
            }
            System.arraycopy(temp, 0, arr, 0, temp.length);
        }
    }

    /**
     * 获取数字的第 x 位，比如 getDigit(int 456, int 1) 返回 6
     */
    private static int getDigit(int num, int x) {
        while (x > 1) {
            num /= 10;
            x--;
        }
        return num % 10;
    }

}

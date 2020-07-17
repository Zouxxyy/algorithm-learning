package com.zouxxxyy.sort;

/*
计数排序

计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中
作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
适用场景：数据集中，且范围一定

时间复杂度：平均 O(n + k) 最坏 O(n + k) 最好 O(n + k)
空间复杂度：O(n + k)
稳定排序

非稳定版本很好写
稳定版本思路：写完计数桶后，将后一个桶加上前一个桶的值，此时桶里的值对应同名键值的最后一个的位置，将原数组从后往前遍历，找到位置数后，减一
 */

/**
 * @author zxy
 */
public class CountingSort {

    /**
     * 非稳定版简单实现，需要保证最小值 >= 0
     * @param max 数组最大值
     */
    public static void notStableCountingSort(int[] arr, int max) {

        int[] bucket = new int[max + 1];

        for (int i : arr) {
            bucket[i]++;
        }

        for (int i = 0, j = 0; i < bucket.length; i++) {
            int count = bucket[i];
            while (count > 0) {
                arr[j++] = i;
                count--;
            }
        }
    }

    /**
     * 稳定版简单实现，需要保证最小值 >= 0
     * @param max 数组最大值
     */
    public static void stableCountingSort(int[] arr, int max) {

        int[] bucket = new int[max + 1];
        int[] temp = new int[arr.length];

        for (int i : arr) {
            bucket[i]++;
        }

        // 后一个桶加上前一个桶的值
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] += bucket[i - 1];
        }

        // 桶里的值对应同名键值的最后一个的位置
        for (int i = arr.length - 1; i >= 0; i--) {
            temp[bucket[arr[i]] - 1] = arr[i];
            // 减一
            bucket[arr[i]] -= 1;
        }

        System.arraycopy(temp, 0, arr, 0, temp.length);
    }

}

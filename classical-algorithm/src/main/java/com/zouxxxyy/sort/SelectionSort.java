package com.zouxxxyy.sort;

/*
选择排序（简单选择排序）

首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
以此类推，直到所有元素均排序完毕。

时间复杂度：平均 O(n^2) 最坏 O(n^2) 最好 O(n^2)
空间复杂度： O(1)
不稳定排序：5 8 5 2 9，第一个5会和2交换
 */

/**
 * @author zxy
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {

        int length = arr.length;

        for (int i = 0; i < length; i++) {
            // 找到最小索引
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

}

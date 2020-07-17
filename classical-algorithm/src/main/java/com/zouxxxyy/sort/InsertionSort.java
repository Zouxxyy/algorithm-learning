package com.zouxxxyy.sort;

/*
插入排序（简单插入排序）

它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。

时间复杂度：平均 O(n^2) 最坏 O(n^2) 最好 O(n)
空间复杂度：O(1)
稳定排序
 */

/**
 * @author zxy
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {

        int length = arr.length;

        // 从 1 开始
        for (int i = 1; i < length; i++) {
            int insert = arr[i];
            int pre = i - 1;
            while (pre >= 0 && arr[pre] > insert) {
                arr[pre + 1] = arr[pre];
                pre--;
            }
            arr[pre + 1] = insert;
        }
    }

}

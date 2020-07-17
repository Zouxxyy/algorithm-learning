package com.zouxxxyy.sort;

/*
冒泡排序

它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。

时间复杂度：平均 O(n^2) 最坏 O(n^2) 最好 O(n)
空间复杂度：O(1)
稳定排序
 */

/**
 * @author zxy
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {

        int length = arr.length;

        // 注意要减1
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}

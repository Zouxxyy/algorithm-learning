package com.zouxxxyy.sort;

/*
二路归并排序

分治法，将已有序的子序列合并，得到完全有序的序列
若将两个有序表合并成一个有序表，称为二路归并排序

时间复杂度：平均 O(nlogn) 最坏 O(nlogn) 最好 O(nlogn)
空间复杂度：O(n)
稳定排序

记忆：使用辅助数组，归并左，归并右，合并左右
 */

/**
 * @author zxy
 */
public class MergeSort {

    /**
     * 左闭右闭
     * @param temp 辅助数组
     */
    public static void mergeSort(int[] arr, int[] temp, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);

        // 如果 左数组的结尾位置小于等于右数组的开头，不需要 merge
        if (arr[mid] <= arr[mid + 1]) {
            return;
        }

        merge(arr, temp, left, mid, right);
    }

    public static void merge(int[] arr, int[] temp, int left, int mid, int right) {

        // i 是左数组的起始位置；j 是右数组的起始位置
        // mid 是左数组的结尾位置；right 是右数组的结尾位置
        int i = left, j = mid + 1;

        // 填入temp数组中
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                temp[k] = arr[j];
                j++;
            } else if (j == right + 1) {
                temp[k] = arr[i];
                i++;
                // <= 用于保持稳定性
            } else if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
        }

        // copy temp数组到原数组
        System.arraycopy(temp, left, arr, left, right - left + 1);
    }

}

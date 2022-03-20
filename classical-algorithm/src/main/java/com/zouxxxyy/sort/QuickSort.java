package com.zouxxxyy.sort;

/*
快速排序

通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。

时间复杂度：平均 O(nlogn) 最坏 O(n^2) 最好 O(nlogn)
空间复杂度：O(logn) 递归占用
不稳定排序

以填坑的思路记忆 分割算法：取最左边的数为基数，也就是分割点（保存它，并挖坑）
                      从右向左找第一个小于基准的数，填入坑中，该数位置为新坑
                      从左向右找第一个大于等于基准的数，填入坑中，该数位置为新坑
                      直到 l >= r，此时分割点为 l，把基准填入
 */

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author zxy
 */
public class QuickSort {

    /**
     * 左闭右闭
     */
    public static void quickSort(int[] arr, int left, int right) {

        if (left < right) {
            int index = getSplitIndex(arr, left, right);

            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
        }
    }

    /**
     * 把数组按分割点分开，并返回分割点 index
     *
     * @return 分割点 index
     */
    private static int getSplitIndex(int[] arr, int l, int r) {

        // 把最左边的数做分割点
        int split = arr[l];

        while (l < r) {
            // 从右向左找第一个小于x的数
            while (l < r && arr[r] >= split) {
                r--;
            }
            if (l < r) {
                arr[l++] = arr[r];
            }

            // 从左向右找第一个大于等于x的数
            while (l < r && arr[l] < split) {
                l++;
            }
            if (l < r) {
                arr[r--] = arr[l];
            }
        }
        arr[l] = split;
        return l;
    }


    /**
     * 非递归版
     */
    public static void quickSort2(int[] arr, int left, int right) {

        LinkedList<Integer> stack = new LinkedList<>();

        stack.push(right);
        stack.push(left);

        while (!stack.isEmpty()) {

            int l = stack.pop();
            int r = stack.pop();

            int index = getSplitIndex(arr, l, r);

            if (l < index - 1) {
                stack.push(index - 1);
                stack.push(l);
            }

            if (index + 1 < r) {
                stack.push(r);
                stack.push(index + 1);
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 5, 1, 6, 7, 8, 0, -1};
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}

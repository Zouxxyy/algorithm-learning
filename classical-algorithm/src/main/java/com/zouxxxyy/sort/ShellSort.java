package com.zouxxxyy.sort;

/*
希尔排序

在一定间隔内执行插入排序，缩小间隔，直到间隔为1

时间复杂度：平均 O(n^1.3) 最坏 O(n^2) 最好 O(n)
空间复杂度： O(1)
不稳定排序
 */

/**
 * @author zxy
 */
public class ShellSort {

    public static void shellSort(int[] arr) {

        int length = arr.length;

        // 初始间距设为 length / 2
        for (int interval = length / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < length; i++) {
                int insert = arr[i];
                int pre = i - interval;
                while (pre >= 0 && arr[pre] > insert) {
                    arr[pre + interval] = arr[pre];
                    pre -= interval;
                }
                arr[pre + interval] = insert;
            }
        }
    }

}

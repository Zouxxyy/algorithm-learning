package com.zouxxxyy.sort;

/*
堆排序

利用堆这种数据结构所设计的一种排序算法。
堆：近似完全二叉树的结构，父节点的值总是大于（或小于）它的子节点。

时间复杂度：平均 O(nlogn) 最坏 O(nlogn) 最好 O(nlogn)
空间复杂度：O(1)
不稳定排序

从小到大排时记忆：从第一个非叶结点往左，调整该节点
               头节点为最大值，和尾节点交换，调整头。长度减一循环
 */

/**
 * @author zxy
 */
public class HeapSort {

    public static void heapSort(int[] arr) {

        int length = arr.length;

        // 步骤1：建大根堆
        // 重要性质1：第一个非叶结点为 length / 2 - 1
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, length);
        }

        // 步骤2：交换 和 调整
        for (int i = length - 1; i > 0; i--) {
            swap(arr, 0, i);
            // 交换后会破坏头节点结构，调整它（注意 length 要变）
            heapify(arr, 0, i);
        }
    }

    /**
     * 调整某节点，且需保证调整后的堆仍然是大根堆（递归被修改的子树）
     */
    private static void heapify(int[] arr, int parent, int length) {

        // 重要性质2：左子树为 2 * parent + 1，右子树为 2 * parent + 2
        int left = 2 * parent + 1, right = 2 * parent + 2;
        int maxIndex = parent;

        if (left < length && arr[left] > arr[maxIndex]) {
            maxIndex = left;
        }

        if (right < length && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }

        if (maxIndex != parent) {
            swap(arr, parent, maxIndex);
            // 因为交换后可能会破坏子节点结构，递归被交换的子节点
            heapify(arr, maxIndex, length);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

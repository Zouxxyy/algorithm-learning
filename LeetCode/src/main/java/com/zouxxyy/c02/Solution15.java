package com.zouxxyy.c02;

/*
215. 数组中的第K个最大元素
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */

/*
思路：

堆排序
 */

/**
 * @author zxy
 */
public class Solution15 {

    public int findKthLargest(int[] nums, int k) {

        int length = nums.length;

        // 建堆
        for (int i = (length - 2) / 2; i >= 0; i--) {
            heapfy(nums, i, length);
        }

        int res = 0;

        for (int i = length - 1; i >= length - k; i--) {
            res = nums[0];
            nums[0] = nums[i];
            heapfy(nums, 0, i);
        }

        return res;
    }

    private void heapfy(int[] nums, int i, int length) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIndex = i;

        if (left < length && nums[left] > nums[maxIndex]) {
            maxIndex = left;
        }

        if (right < length && nums[right] > nums[maxIndex]) {
            maxIndex = right;
        }

        if (maxIndex != i) {
            swap(maxIndex, i, nums);
            heapfy(nums, maxIndex, length);
        }
    }

    private void swap(int l, int r, int[] nums) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}

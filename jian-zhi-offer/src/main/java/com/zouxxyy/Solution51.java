/*
面试题51. 数组中的逆序对

在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

 

示例 1:

输入: [7,5,6,4]
输出: 5
 

限制：

0 <= 数组长度 <= 50000

 */

/*
笔记：

使用归并排序
 */

package com.zouxxyy;

public class Solution51 {

    public int reversePairs(int[] nums) {

        int len = nums.length;
        if (len <= 1) return 0;

        int[] copy = new int[len];
        System.arraycopy(nums, 0, copy, 0, len);
        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {

        if (left >= right) return 0;

        int mid = left + (right - left) / 2;

        int leftCount = reversePairs(nums, left, mid, temp);
        int rightCount = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftCount + rightCount;
        }

        return leftCount + rightCount + merge(nums, left, mid, right, temp);
    }

    private int merge(int[] nums, int left, int mid, int right, int[] temp) {

        System.arraycopy(nums, left, temp, left, right - left + 1);

        int i = left;
        int j = mid + 1;
        int count = 0;

        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += mid - i + 1;
            }
        }
        return count;
    }
}

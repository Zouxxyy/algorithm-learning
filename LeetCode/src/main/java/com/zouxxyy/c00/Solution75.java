package com.zouxxyy.c00;

/*
75. 颜色分类
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

示例:

输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
进阶：

一个直观的解决方案是使用计数排序的两趟扫描算法。
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
你能想出一个仅使用常数空间的一趟扫描算法吗？
 */

/*
思路：

三指针 + 交换
 */

/**
 * @author zxy
 */
public class Solution75 {

    public void sortColors(int[] nums) {

        // left 的左边全为 0, right 的右边全为 2
        int left = 0, right = nums.length - 1;
        int cur = 0;

        while (cur <= right) {

            switch (nums[cur]) {
                case 0:
                    if (left < cur) {
                        swap(nums, left++, cur++);
                    }
                    left++;
                    // 由于交换的数已知，cur++
                    cur++;
                    break;

                case 1:
                    cur++;
                    break;

                case 2:
                    swap(nums, right, cur);
                    right--;
                    // 由于交换过来的数未知，cur 不变
                    break;

                default:
            }
        }

    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

}

package com.zouxxyy.c00;

/*
34. 在排序数组中查找元素的第一个和最后一个位置

给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
 */

/*
思路：

两个二分查找 + 边界判断
 */

/**
 * @author zxy
 */
public class Solution34 {

    public int[] searchRange(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        int[] res = new int[]{-1, -1};

        if (nums.length == 0) {
            return res;
        }

        // 找左边界点
        while (left < right) {

            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                right = mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        if (nums[left] == target) {
            res[0] = left;
        } else {
            return res;
        }

        // 把范围的左边作为计算右边界的初始左边界
        left = res[0];
        right = nums.length - 1;

        // 找右边界点
        while (left < right) {

            // 注意此处，由于left有可能会被赋值成mid，因此mid的计算需修改为往右靠（例如：3 和 4的中点是 4）
            int mid = left + (right + 1 - left) / 2;

            if (target == nums[mid]) {
                left = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        if (nums[left] == target) {
            res[1] = left;
        }

        return res;
    }

}

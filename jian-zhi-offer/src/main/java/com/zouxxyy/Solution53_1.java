/*
面试题53 - I. 在排序数组中查找数字 I
统计一个数字在排序数组中出现的次数。

 

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: 0
 

限制：

0 <= 数组长度 <= 50000
 */

package com.zouxxyy;

public class Solution53_1 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;

        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) break;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        if (right < left) return 0;

        int l = mid, r = right, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] > target) r = m - 1;
            else if ((m + 1) == nums.length || nums[m + 1] != target) break;
            else l = m + 1;
        }

        int R = m;
        l = left;
        r = mid;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] < target) l = m + 1;
            else if (m == 0 || nums[m - 1] != target) break;
            else r = m - 1;
        }
        return R - m + 1;
    }
}

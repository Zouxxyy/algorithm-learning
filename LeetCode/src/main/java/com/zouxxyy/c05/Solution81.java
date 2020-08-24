package com.zouxxyy.c05;

/*
581. 最短无序连续子数组
给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

你找到的子数组应是最短的，请输出它的长度。

示例 1:

输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
说明 :

输入的数组长度范围在 [1, 10,000]。
输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */

/*
思路：

学习下右往左遍历的技巧
 */

/**
 * @author zxy
 */
public class Solution81 {


    /**
     * 没看答案前想的方法：贪心 + 二分，时间复杂度 最好 O(n) 最差 O(nlogn)
     */
    public int findUnsortedSubarray1(int[] nums) {

        // 左闭右闭
        int left = -1;
        int right = -2;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length ; i++) {

            if (nums[i] < nums[i - 1]) {

                if (left == -1) {
                    left = i - 1;
                }

                right = i;

                if (nums[i] < min) {
                    min = nums[i];
                    // 从左边界前面找到第一个 > nums[i] 的 index 作为新的左边界
                    left = findMaxIndex(nums, left, min);
                }

                max = Math.max(max, nums[i - 1]);

            } else if (nums[i] < max) {

                right = i;

            }

        }

        return right - left + 1;
    }

    /**
     * 找到首个 > val 的 index
     */
    private int findMaxIndex(int[] nums, int right, int val) {

        // 二分 左边界模板
        int l = 0;
        int r = right + 1;

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] > val) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }
        return r;
    }


    /**
     * 学习下 O(n) 的解法
     */
    public int findUnsortedSubarray2(int[] nums) {

        // 左闭右闭
        int left = -1;
        int right = -1;

        // 从左往右遍历，找出左边界，（左边界左边的都是升序）
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                left = i;
                break;
            }
        }

        // 如果 left 没有被赋值（全为升序），直接返回 0
        if (left == -1) {
            return 0;
        }

        // 从右往左遍历，找出右边界，（右边界右边的都是升序）
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                right = i + 1;
                break;
            }
        }

        // 这时仍不能保证答案正确，如 0 1 3 | 5 2 7 4 | 6 7 8
        // 需要找到 [left : right] 里的最大值和最小值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        // 后两步可以使用二分查找，但由于前面的复杂度已经是O(n)了，因此不用二分，直接遍历也可以

        // 找到 左边界前面 首个 > min 的 index
        for (int i = 0; i <= left - 1; i++) {
            if (nums[i] > min) {
                left = i;
                break;
            }
        }

        // 找到 右边界后面 首个 < max 的 index
        for (int i = nums.length - 1; i >= right + 1; i--) {
            if (nums[i] < max) {
                right = i;
                break;
            }
        }

        return right - left + 1;

    }

}

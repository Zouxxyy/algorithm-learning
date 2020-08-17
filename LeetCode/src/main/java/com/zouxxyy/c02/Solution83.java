package com.zouxxyy.c02;

/*
283. 移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
 */

/**
 * @author zxy
 */
public class Solution83 {

    public void moveZeroes(int[] nums) {

        if (nums.length <= 1) {
            return;
        }

        int cur = 0;

        // 非0往前依次写
        for (int num : nums) {
            if (num != 0) {
                nums[cur++] = num;
            }
        }

        // 后面补0
        while(cur <nums.length) {
            nums[cur++] = 0;
        }

    }
}

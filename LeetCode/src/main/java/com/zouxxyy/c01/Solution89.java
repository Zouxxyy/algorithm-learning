package com.zouxxyy.c01;

/*
189. 旋转数组
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。
 */

/**
 * @author zxy
 */
public class Solution89 {

    public void rotate(int[] nums, int k) {

        int curIndex = 0;
        int cur = nums[curIndex];

        int start = curIndex;

        int i = 0;
        while (true) {

            // 移动数字
            int nextIndex = (curIndex + k) % nums.length;

            int temp = cur;
            cur = nums[nextIndex];
            nums[nextIndex] = temp;

            // 移动 k 个数后结束
            if (++i >= nums.length) {
                return;
            }

            // 如果回到初始位置，+1 调整位置
            if (nextIndex == start) {
                curIndex = nextIndex + 1;
                start = curIndex;
                cur = nums[curIndex];
            } else {
                curIndex = nextIndex;
            }

        }

    }

}

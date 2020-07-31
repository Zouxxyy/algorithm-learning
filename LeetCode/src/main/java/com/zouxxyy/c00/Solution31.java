package com.zouxxyy.c00;

/*
31. 下一个排列

实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

 */

/*
思路：

多写几个例子， 把思路理出来就行
 */

/**
 * @author zxy
 */
public class Solution31 {

    public void nextPermutation(int[] nums) {

        if (nums.length <= 1) {
            return;
        }

        // 从后开始，找到第一个比后一个数小的数
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 如果 i 为 -1，代表该数最大，直接转置所有数
        if (i != -1) {

            // 从该数开始，找到第一个比该数小的数
            int j = i + 1;
            while (j < nums.length && nums[j] > nums[i]) {
                j++;
            }

            // 将 i 和 j - 1 所在的数调换
            swap(nums, i, j - 1);
        }

        // 转置 i 后面的所有数
        reverse(nums, i);

    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    /**
     * 转置数组中 index > start 的所有数
     */
    private void reverse(int[] nums, int start) {
        for (int k = 1; k <= (nums.length - start) / 2; k++) {
            swap(nums, start + k, nums.length - k);
        }
    }

}

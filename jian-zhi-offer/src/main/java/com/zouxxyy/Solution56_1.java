/*
面试题56 - I. 数组中数字出现的次数

一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

 

示例 1：

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
示例 2：

输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]
 

限制：

2 <= nums.length <= 10000

 */

/*
笔记

A ^ A = 0
A ^ B = 1  // 通过它，找到那两个唯一数不同的那一位，按它分组
A ^ 0 = A
 */

package com.zouxxyy;

public class Solution56_1 {
    public int[] singleNumbers(int[] nums) {

        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }

        // 找到用于分组的那一位
        int div = 1;
        while ((div & ret) == 0)
            div <<= 1;

        int A = 0, B = 0;
        for (int num : nums) {
            if ((num & div) == 0) A ^= num;
            else B ^= num;
        }
        return new int[]{A, B};
    }
}

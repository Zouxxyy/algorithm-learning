package com.zouxxyy.c04;

/*
485. 最大连续1的个数
给定一个二进制数组， 计算其中最大连续1的个数。

示例 1:

输入: [1,1,0,1,1,1]
输出: 3
解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
注意：

输入的数组只包含 0 和1。
输入数组的长度是正整数，且不超过 10,000
 */

/**
 * @author zxy
 */
public class Solution85 {

    public int findMaxConsecutiveOnes(int[] nums) {

        int res = 0;
        int cur = 0;

        for (int num : nums) {

            if (num == 1) {
                cur++;
            } else {
                res = Math.max(res, cur);
                cur = 0;
            }

        }
        return Math.max(res, cur);
    }

}

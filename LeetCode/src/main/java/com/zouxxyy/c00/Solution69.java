package com.zouxxyy.c00;

/*
69. x 的平方根
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。
 */

/*
思路：

满足 m * m <= x，求 m 的最大值
 */

/**
 * @author zxy
 */
public class Solution69 {

    public int mySqrt(int x) {

        if (x <= 1) {
            return x;
        }

        // 满足 m * m <= x，求 m 的最大值
        // 使用二分的右边界模板
        int l = 1;
        int r = x;

        while (l < r) {

            int mid = l + (r - l + 1) / 2;

            // 不要 mid * mid，会溢出！
            if (mid <= x / mid) {
                l = mid;
            } else {
                r = mid - 1;
            }

        }
        return l;
    }

}

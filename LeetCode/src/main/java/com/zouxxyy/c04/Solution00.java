package com.zouxxyy.c04;

/*
400. 第 N 位数字
在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。



注意：n 是正数且在 32 位整数范围内（n < 231）。



示例 1：

输入：3
输出：3
示例 2：

输入：11
输出：0
解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 */

/**
 * @author zxy
 */
public class Solution00 {

    public int findNthDigit(int n) {

        if (n <= 9) {
            return n;
        }

        int cnt = 1;
        while (n > (cnt * 9 * Math.pow(10, cnt - 1))) {
            n -= cnt * 9 * Math.pow(10, cnt - 1);
            cnt++;
        }

        int num = (n - 1) / cnt + (int) Math.pow(10, cnt - 1);

        int c = n % cnt == 0 ? cnt : n % cnt;

        return num / (int) Math.pow(10, cnt - c) % 10;
    }

}

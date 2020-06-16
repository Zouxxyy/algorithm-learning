/*
面试题44. 数字序列中某一位的数字

数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

请写一个函数，求任意第n位对应的数字。

 

示例 1：

输入：n = 3
输出：3
示例 2：

输入：n = 11
输出：0
 

限制：

0 <= n < 2^31

 */

package com.zouxxyy;

public class Solution44 {
    public int findNthDigit(int n) {

        if (n <= 9) return n;

        int len = 0;
        while (true) {
            len++;
            int temp = (int) (n - 9 * Math.pow(10, len - 1) * len);
            if (temp > 0) n = temp;
            else break;
        }

        int x = n % len;
        int num = (int) (Math.pow(10, len - 1) + (n + 1) / len - 1);

        for (int i = len; i > 0; i--) {
            int dig = num % 10;
            num = num / 10;
            if (i % len == x) return dig;
        }

        return 0;
    }
}

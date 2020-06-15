/*
面试题43. 1～n整数中1出现的次数

输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。

例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。

 

示例 1：

输入：n = 12
输出：5
示例 2：

输入：n = 13
输出：6
 

限制：

1 <= n < 2^31

 */

package com.zouxxyy;

public class Solution43 {

    // 我尝试的解法
    public int countDigitOneOld(int n) {

        if (n <= 0) return 0;

        int temp = n;

        // 计算 n 的位数
        int length = 0;
        while (temp > 0) {
            temp /= 10;
            length++;
        }

        // 所有 n 位数含 1 的 数（含0开头的）
        int[] f = new int[length];
        f[0] = 0;
        int i = 1;
        while (i < f.length) {
            f[i] = (int) (Math.pow(10, i - 1) + 10 * f[i - 1]);
            i++;
        }

        int res = 0;
        temp = n;
        // eg. n = 2341, length = 4
        for (i = length; i >= 1; i--) {
            int divisor = (int) Math.pow(10, i - 1);
            // remain = 341, num = 2
            int remain = temp % divisor;
            int num = temp / divisor;
            // 其它开头叠加
            res += num * f[i - 1];
            // 1 开头的计算：
            if (num == 1) res = res + remain + 1;
            else if (num > 1) res += divisor;
            temp = remain;
        }
        return res;
    }


    // 大佬的解法
    // 解题思路：
    // 将 1 ~ n 的个位、十位、百位、...的 1 出现次数相加，即为 1 出现的总次数。
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}

/*
面试题10- II. 青蛙跳台阶问题

一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：

输入：n = 2
输出：2
示例 2：

输入：n = 7
输出：21
提示：

0 <= n <= 100

 */

/*
思路：

f(0) = 1 f(1) = 1 f(2) = 2

f(n) = 跳一格 * f(n - 1) + 跳两格 * f(n - 2)
     = f(n - 1) + f(n - 2)
 */

package com.zouxxyy;

public class Solution10_2 {

    private static final int MAX = 1000000007;

    public int numWays(int n) {

        if (n <= 1) return 1;

        int a = 1, b = 1, k = 1;
        while (true) {
            a = (a + b) % MAX;
            if (++k == n)
                return a;
            b = (a + b) % MAX;
            if (++k == n)
                return b;
        }
    }
}

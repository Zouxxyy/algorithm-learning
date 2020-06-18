/*
面试题65. 不用加减乘除做加法

写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。

 

示例:

输入: a = 1, b = 1
输出: 2
 

提示：

a, b 均可能是负数或 0
结果不会溢出 32 位整数

 */

/*
笔记：

计算十进制13+19：

1.不进位的和：22；
2.进位：10。

再计算十进制22+10：

1.不进位的和：32；
2.进位：0。

因此结果13+9=22。

循环结束条件：进位为0
 */

package com.zouxxyy;

public class Solution65 {

    // 递归写法
    public int addOld(int a, int b) {
        if (b == 0) return a;
        return add(a ^ b, (a & b) << 1);
    }

    // 非递归
    public int add(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}

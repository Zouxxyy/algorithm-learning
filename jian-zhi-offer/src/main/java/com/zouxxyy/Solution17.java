/*
面试题17. 打印从1到最大的n位数

输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]
 

说明：

用返回一个整数列表来代替打印
n 为正整数

 */

package com.zouxxyy;

public class Solution17 {
    public int[] printNumbers(int n) {

        int max = 0;
        while (n > 0) {
            max = max * 10 + 9;
            n--;
        }

        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }

        return res;
    }
}

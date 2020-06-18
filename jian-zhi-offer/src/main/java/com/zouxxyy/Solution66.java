/*
面试题66. 构建乘积数组

给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。

 

示例:

输入: [1,2,3,4,5]
输出: [120,60,40,30,24]
 

提示：

所有元素乘积之和不会溢出 32 位整数
a.length <= 100000

 */

/*
笔记：

先计算左下三角，再计算右上三角
 */

package com.zouxxyy;

public class Solution66 {
    public int[] constructArr(int[] a) {
        if (a.length <= 1) return a;
        int[] res = new int[a.length];
        int temp = 1;
        res[0] = 1;
        for (int i = 1; i < a.length; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }
        for (int i = a.length - 2; i >= 0; i--) {
            temp = temp * a[i + 1];
            res[i] = res[i] * temp;
        }
        return res;
    }
}

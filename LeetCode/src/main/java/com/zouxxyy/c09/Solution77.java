package com.zouxxyy.c09;

/*
977. 有序数组的平方
给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。



示例 1：

输入：[-4,-1,0,3,10]
输出：[0,1,9,16,100]
示例 2：

输入：[-7,-3,2,3,11]
输出：[4,9,9,49,121]


提示：

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A 已按非递减顺序排序。
 */

/*
思路：

从两头开始算，倒序插入
 */

/**
 * @author zxy
 */
public class Solution77 {

    public int[] sortedSquares(int[] A) {

        int[] res = new int[A.length];

        int l = 0;
        int r = A.length - 1;
        int i = A.length - 1;

        while (l <= r) {

            if (A[l] * -1 > A[r]) {
                res[i] = A[l] * A[l];
                l++;
            } else {
                res[i] = A[r] * A[r];
                r--;
            }

            i--;
        }

        return res;

    }

}

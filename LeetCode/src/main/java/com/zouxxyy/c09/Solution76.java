package com.zouxxyy.c09;

/*
976. 三角形的最大周长
给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。

如果不能形成任何面积不为零的三角形，返回 0。



示例 1：

输入：[2,1,2]
输出：5
示例 2：

输入：[1,2,1]
输出：0
示例 3：

输入：[3,2,3,4]
输出：10
示例 4：

输入：[3,6,2,3]
输出：8


提示：

3 <= A.length <= 10000
1 <= A[i] <= 10^6
 */


import java.util.Arrays;

/**
 * @author zxy
 */
public class Solution76 {

    public int largestPerimeter(int[] A) {

        Arrays.sort(A);

        // 三条边可以构成三角形充要条件：最短的两条边之和大于第三边
        // 思路：排序后，固定最长边，由大到小遍历；另外两条边，取次小和次次小 即可
        // 原因：如果 次小 + 次次小 之和 都小于最长边，那就更不用往后取了

        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }

        return 0;
    }

}

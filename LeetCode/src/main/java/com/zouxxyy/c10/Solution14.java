package com.zouxxyy.c10;

/*
1014. 最佳观光组合
给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。

一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。

返回一对观光景点能取得的最高分。



示例：

输入：[8,1,5,2,6]
输出：11
解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11


提示：

2 <= A.length <= 50000
1 <= A[i] <= 1000
 */

/**
 * @author zxy
 */
public class Solution14 {

    public int maxScoreSightseeingPair(int[] A) {

        int res = Integer.MIN_VALUE;

        // 固定右边界，计算左边界最大值
        int maxL = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            res = Math.max(res, A[i] + maxL - i);
            maxL = Math.max(maxL, A[i] + i);
        }

        return res;
    }

}

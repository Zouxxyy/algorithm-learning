package com.zouxxyy.c09;

/*
992. K 个不同整数的子数组
给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。

（例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）

返回 A 中好子数组的数目。



示例 1：

输入：A = [1,2,1,2,3], K = 2
输出：7
解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
示例 2：

输入：A = [1,2,1,3,4], K = 3
输出：3
解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].


提示：

1 <= A.length <= 20000
1 <= A[i] <= A.length
1 <= K <= A.length
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution92 {

    public int subarraysWithKDistinct(int[] A, int K) {

        return help(A, K) - help(A, K - 1);

    }


    /**
     * 小于等于 K 个不同整数的子数组
     */
    private int help(int[] A, int K) {

        int res = 0;
        int l = 0, r = 0;
        int[] feq = new int[A.length + 1];
        // 不同整数的个数
        int cnt = 0;

        while (r < A.length) {

            if (feq[A[r]] == 0) {
                cnt++;
            }
            feq[A[r]]++;

            while (cnt > K) {
                feq[A[l]]--;
                if (feq[A[l]] == 0) {
                    cnt--;
                }
                l++;
            }

            res += r - l + 1;
            r++;
        }

        return res;
    }

}

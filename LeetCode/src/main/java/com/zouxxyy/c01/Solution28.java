package com.zouxxyy.c01;

/*
128. 最长连续序列
给定一个未排序的整数数组，找出最长连续序列的长度。

要求算法的时间复杂度为 O(n)。

示例:

输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */

/*
思路：

服了
 */

import java.util.HashSet;

/**
 * @author zxy
 */
public class Solution28 {

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int res = 0;

        for (Integer cur : set) {

            // 找到连续序列的开头
            if (set.contains(cur - 1)) {
                continue;
            }

            // 计算连续序列的长度
            int cnt = 1;
            while (set.contains(++cur)) {
                cnt++;
            }

            res = Math.max(cnt, res);
        }

        return res;
    }

}

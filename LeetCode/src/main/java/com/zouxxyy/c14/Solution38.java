package com.zouxxyy.c14;

/*
1438. 绝对差不超过限制的最长连续子数组
给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。

如果不存在满足条件的子数组，则返回 0 。



示例 1：

输入：nums = [8,2,4,7], limit = 4
输出：2
解释：所有子数组如下：
[8] 最大绝对差 |8-8| = 0 <= 4.
[8,2] 最大绝对差 |8-2| = 6 > 4.
[8,2,4] 最大绝对差 |8-2| = 6 > 4.
[8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
[2] 最大绝对差 |2-2| = 0 <= 4.
[2,4] 最大绝对差 |2-4| = 2 <= 4.
[2,4,7] 最大绝对差 |2-7| = 5 > 4.
[4] 最大绝对差 |4-4| = 0 <= 4.
[4,7] 最大绝对差 |4-7| = 3 <= 4.
[7] 最大绝对差 |7-7| = 0 <= 4.
因此，满足题意的最长子数组的长度为 2 。
示例 2：

输入：nums = [10,1,2,4,7,2], limit = 5
输出：4
解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
示例 3：

输入：nums = [4,2,2,2,4,4,2,2], limit = 0
输出：3


提示：

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
0 <= limit <= 10^9
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution38 {

    public int longestSubarray(int[] nums, int limit) {

        int res = 0;

        LinkedList<Integer> min = new LinkedList<>();
        LinkedList<Integer> max = new LinkedList<>();

        int l = 0, r = 0;

        while (r < nums.length) {

            // 最大值，递减队列
            while (max.size() > 0 && nums[r] > max.peekLast()) {
                max.removeLast();
            }
            max.addLast(nums[r]);

            // 最小值，递增队列
            while (min.size() > 0 && nums[r] < min.peekLast()) {
                min.removeLast();
            }
            min.addLast(nums[r]);

            while (Math.abs(nums[r] - max.peekFirst()) > limit || Math.abs(nums[r] - min.peekFirst()) > limit) {
                // l 右移动
                if (nums[l] == max.peekFirst()) {
                    max.removeFirst();
                }
                if (nums[l] == min.peekFirst()) {
                    min.removeFirst();
                }
                l++;
            }

            // 左闭右闭
            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;
    }

}

package com.zouxxyy.c00;

/*
56. 合并区间
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */

/*
思路：

排序后 使用双指针
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zxy
 */
public class Solution56 {

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return intervals;
        }

        // 数组按int[x][0]进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        ArrayList<int[]> list = new ArrayList<>();

        int i = 0;

        while (i < intervals.length) {

            int left = intervals[i][0];
            int right = intervals[i][1];

            // 如果下一个数的左边界，小于等于当前右边界，说明可以合并
            while (++i < intervals.length && intervals[i][0] <= right) {
                // 计算新的右边界
                right = Math.max(right, intervals[i][1]);
            }

            list.add(new int[]{left, right});
        }

        return list.toArray(new int[list.size()][2]);
    }

}

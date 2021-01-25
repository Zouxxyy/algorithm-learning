package com.zouxxyy.c00;

/*
57. 插入区间
给出一个无重叠的 ，按照区间起始端点排序的区间列表。

在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。



示例 1：

输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
输出：[[1,5],[6,9]]
示例 2：

输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出：[[1,2],[3,10],[12,16]]
解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。


注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        // 主要思路：遍历找出新区间的左右端点，同时在遍历的过程中 加入新区间前后的区间 到 res 中

        List<int[]> list = new ArrayList<>();

        int l = newInterval[0], r = newInterval[1];
        int i = 0;

        // 1. 找到新区间的左端点，同时把它前面的区间加入 list
        int newL = l;
        while (i < intervals.length) {
            if (l > intervals[i][1]) {
                list.add(intervals[i]);
            } else {
                newL = Math.min(l, intervals[i][0]);
                break;
            }
            i++;
        }

        // 2. 找到新区间的右端点
        boolean hasAdd = false;
        while (i < intervals.length) {
            if (r < intervals[i][0]) {
                list.add(new int[]{newL, r});
                hasAdd = true;
                break;
            } else if (r <= intervals[i][1]) {
                list.add(new int[]{newL, intervals[i][1]});
                i++;
                hasAdd = true;
                break;
            }
            i++;
        }

        // 3. 把右端点后面的区间加入 list
        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }

        // 4. 超出右边界情况
        if (!hasAdd) {
            list.add(new int[]{newL, r});
        }

        return list.toArray(new int[list.size()][2]);
    }

}

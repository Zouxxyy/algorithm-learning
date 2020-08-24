package com.zouxxyy.c00;

/*
84. 柱状图中最大的矩形
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。





以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。





图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。



示例:

输入: [2,1,5,6,2,3]
输出: 10

 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zxy
 */
public class Solution84 {

    public int largestRectangleArea(int[] heights) {

        int res = 0;

        // 单调栈：栈底到栈顶由小到大
        Deque<Integer> stack = new LinkedList<>();

        // 矩形的左右边界
        int l, r;

        for (r = 0; r < heights.length; r++) {

            // 它的起始位置等于最后一个弹出的 index
            l = r;
            while (!stack.isEmpty() && heights[stack.peek()] > heights[r]) {

                // 弹出的比当前大的数，它不可能再变长了，计算长度
                l = stack.pop();
                res = Math.max((r - l) * heights[l], res);
            }

            heights[l] = heights[r];
            stack.push(l);
        }

        // 处理栈中剩余的元素
        while (!stack.isEmpty()) {
            int index = stack.pop();
            res = Math.max((r - index) * heights[index], res);
        }

        return res;

    }

}

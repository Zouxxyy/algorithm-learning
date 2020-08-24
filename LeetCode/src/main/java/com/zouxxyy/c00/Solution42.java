package com.zouxxyy.c00;

/*
42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
 */

/*
思路：

单调栈
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zxy
 */
public class Solution42 {

    public int trap(int[] height) {

        int res = 0;
        // 单调栈：栈底到栈顶由大到小(存的是索引，对应的值由大到小)
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < height.length; i++) {

            int lastHeight = 0;
            while (!stack.isEmpty()) {

                if (height[i] >= height[stack.peek()]) {

                    // 情况1：前面存在比当前高度小的会形成坑
                    int pop = stack.pop();
                    // 宽 * 高
                    res += (i - pop - 1) * (height[pop] - lastHeight);
                    lastHeight = height[pop];


                } else {

                    // 情况2：前面存在比当前大的（它们中最小的那个）会形成坑
                    res += (i - stack.peek() - 1) * (height[i] - lastHeight);
                    break;

                }

            }
            stack.push(i);

        }

        return res;
    }

}

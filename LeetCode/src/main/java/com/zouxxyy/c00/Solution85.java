package com.zouxxyy.c00;

/*
85. 最大矩形
给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

示例:

输入:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
输出: 6
 */

/*
思路：

对每一层计算矩形最大面积
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution85 {

    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }

        int res = 0;
        int[] nums = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (i > 0 && matrix[i][j] != '0'){
                    matrix[i][j] += matrix[i - 1][j] - '0';
                }
            }

            for (int k = 0; k < matrix[i].length; k++) {
                nums[k] = matrix[i][k] - '0';
            }

            // 由于我们后面会改变数组的值，使用深拷贝
            res = Math.max(res, largestRectangleArea(nums));
        }

        return res;
    }


    /**
     * C84
     */
    private int largestRectangleArea(int[] nums) {

        // 单调栈：栈底到栈顶由小到大 2 3 4
        LinkedList<Integer> stack = new LinkedList<>();
        int res = 0;
        int i;

        for (i = 0; i < nums.length; i++) {

            int begin = i;

            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {

                begin = stack.poll();
                res = Math.max(res, (i - begin) * (nums[begin]));
            }

            nums[begin] = nums[i];
            stack.push(begin);
        }

        while (!stack.isEmpty()) {

            Integer begin = stack.poll();
            res = Math.max(res, (i - begin) * (nums[begin]));
        }

        return res;
    }

}

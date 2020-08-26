package com.zouxxyy.c04;

/*
491. 递增子序列
给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。

示例:

输入: [4, 6, 7, 7]
输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
说明:

给定数组的长度不会超过15。
数组中的整数范围是 [-100,100]。
给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 */

/*
思路：

回溯 + 去重
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution91 {

    public List<List<Integer>> findSubsequences(int[] nums) {

        List<List<Integer>> res = new LinkedList<>();
        recursion(nums, new LinkedList<>(), res, - 1);
        return res;

    }


    /**
     * 回溯
     * @param cur 代表当前添加的数的 index
     */
    private void recursion(int[] nums, LinkedList<Integer> lst, List<List<Integer>> res, int cur) {

        // 递增子序列的长度至少是2
        if (lst.size() > 1) {
            res.add(new ArrayList<>(lst));
        }

        // 添加 cur 后面的数（重复的数不添加，用 visited 去重）
        HashSet<Integer> visited = new HashSet<>();
        for (int i = cur + 1; i < nums.length; i++) {

            // 第一个数不需要比较大小
            if ((cur == -1 || nums[i] >= nums[cur]) && !visited.contains(nums[i])) {

                visited.add(nums[i]);

                lst.add(nums[i]);
                recursion(nums, lst, res, i);
                lst.removeLast();
            }
        }

    }

}

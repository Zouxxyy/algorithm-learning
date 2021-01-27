package com.zouxxyy.c00;

/*
47. 全排列 II
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。



示例 1：

输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
示例 2：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


提示：

1 <= nums.length <= 8
-10 <= nums[i] <= 10
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution47 {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length;

        dfs(nums, 0, n, res);

        return res;
    }

    private void dfs(int[] nums, int cur, int n, List<List<Integer>> res) {

        if (cur == n) {

            ArrayList<Integer> list = new ArrayList<>();

            for (int num : nums) {
                list.add(num);
            }

            res.add(list);
            return;
        }

        HashSet<Integer> used = new HashSet<>(32);

        for (int i = cur; i < n; i++) {

            if (!used.contains(nums[i])) {

                used.add(nums[i]);

                swap(nums, i, cur);
                dfs(nums, cur + 1, n, res);
                swap(nums, i, cur);
            }
        }
    }


    private void swap(int[] nums, int x, int y) {

        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;

    }

}

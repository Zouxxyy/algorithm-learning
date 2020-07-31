package com.zouxxyy.c00;

import java.util.*;


/*
46. 全排列
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

/*
思路：

回溯。题目本身不难，学习下原基础上修改的解法
 */

/**
 * @author zxy
 */
public class Solution46 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new LinkedList<>();

        if (nums.length > 0) {

            ArrayList<Integer> ints = new ArrayList<>(nums.length);

            for (int num : nums) {
                ints.add(num);
            }

            dfs(ints, res, 0);
        }

        return res;

    }

    private void dfs(List<Integer> ints, List<List<Integer>> res, int index) {

        if (index == ints.size()) {
            res.add(new ArrayList<>(ints));
            return;
        }

        for (int i = index; i < ints.size(); i++) {
            Collections.swap(ints, index, i);
            dfs(ints, res, index + 1);
            Collections.swap(ints, index, i);
        }

    }

}

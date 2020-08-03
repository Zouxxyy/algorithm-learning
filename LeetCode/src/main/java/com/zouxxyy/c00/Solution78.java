package com.zouxxyy.c00;

/*
78. 子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */

/*
思路：

从前往后遍历, 遇到一个数, 之前的所有集合添加上这个数组成新的子集
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxy
 */
public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        // 加上空集
        res.add(new ArrayList<>());

        for (int num : nums) {

            int size = res.size();

            for (int i = 0; i < size; i++) {
                ArrayList<Integer> newList = new ArrayList<>(res.get(i));
                newList.add(num);
                res.add(newList);
            }

        }

        return res;
    }

}

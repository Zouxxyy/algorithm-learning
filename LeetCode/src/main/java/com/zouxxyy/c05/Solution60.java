package com.zouxxyy.c05;

/*
560. 和为K的子数组
给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

示例 1 :

输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
说明 :

数组的长度为 [1, 20,000]。
数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */

/*
学习：

范围问题，可尝试 前 j 项和 - 前 i 项和
 */

import java.util.HashMap;

/**
 * @author zxy
 */
public class Solution60 {

    public int subarraySum(int[] nums, int k) {

        // 前 j 项和 - 前 i 项和 = (i : j] 的和
        // 构造数据结构：map (前 i 项和, 个数)

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int res = 0;

        for (int num : nums) {

            sum += num;

            Integer count = map.get(sum - k);
            if (count != null) {
                res += count;
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }

}

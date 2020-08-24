package com.zouxxyy.c03;

/*
347. 前 K 个高频元素
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。



示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]


提示：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
你可以按任意顺序返回答案。
 */

/*
思路：

方法一：堆，时间复杂度：O(n log k)
方法二：由于频率有范围，[1:n]，可以使用桶排序
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author zxy
 */
public class Solution47 {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>(nums.length);

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 用最小堆保存频率最大的前 k 个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (Integer integer : map.keySet()) {
            if (pq.size() < k) {
                pq.add(integer);
            } else if (map.get(pq.peek()) < map.get(integer)) {
                pq.poll();
                pq.add(integer);
            }
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }

}

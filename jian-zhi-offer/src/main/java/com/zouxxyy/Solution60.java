/*
面试题60. n个骰子的点数

把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。

 

你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。

 

示例 1:

输入: 1
输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
示例 2:

输入: 2
输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 

限制：

1 <= n <= 11

 */

package com.zouxxyy;

import java.util.HashMap;

public class Solution60 {
    public double[] twoSum(int n) {
        HashMap<Integer, Double> map1 = new HashMap<>();
        HashMap<Integer, Double> map2 = new HashMap<>();
        map1.put(1, 1. / 6);
        map1.put(2, 1. / 6);
        map1.put(3, 1. / 6);
        map1.put(4, 1. / 6);
        map1.put(5, 1. / 6);
        map1.put(6, 1. / 6);
        while (--n > 0) {
            for (Integer num : map1.keySet())
                for (int i = 1; i <= 6; i++)
                    map2.put(num + i, 1. / 6 * map1.get(num) +
                            (map2.containsKey(num + i) ? map2.get(num + i) : 0));

            HashMap<Integer, Double> temp = map1;
            map1 = map2;
            map2 = temp;
            map2.clear();
        }
        double[] res = new double[map1.size()];
        int i = 0;
        for (Double x : map1.values()) {
            res[i++] = x;
        }
        return res;
    }
}

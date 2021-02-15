package com.zouxxyy.competition.c228;

/*
5679. 一个图中连通三元组的最小度数
给你一个无向图，整数 n 表示图中节点的数目，edges 数组表示图中的边，其中 edges[i] = [ui, vi] ，表示 ui 和 vi 之间有一条无向边。

一个 连通三元组 指的是 三个 节点组成的集合且这三个点之间 两两 有边。

连通三元组的度数 是所有满足此条件的边的数目：一个顶点在三元组内，而另一个顶点不在三元组内。

请你返回所有连通三元组中度数的 最小值 ，如果图中没有连通三元组，那么返回 -1 。



示例 1：


输入：n = 6, edges = [[1,2],[1,3],[3,2],[4,1],[5,2],[3,6]]
输出：3
解释：只有一个三元组 [1,2,3] 。构成度数的边在上图中已被加粗。
示例 2：


输入：n = 7, edges = [[1,3],[4,1],[4,3],[2,5],[5,6],[6,7],[7,5],[2,6]]
输出：0
解释：有 3 个三元组：
1) [1,4,3]，度数为 0 。
2) [2,5,6]，度数为 2 。
3) [5,6,7]，度数为 2 。


提示：

2 <= n <= 400
edges[i].length == 2
1 <= edges.length <= n * (n-1) / 2
1 <= ui, vi <= n
ui != vi
图中没有重复的边。
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution4 {

    public int minTrioDegree(int n, int[][] edges) {

        int res = Integer.MAX_VALUE;

        // 邻接表
        Map<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> visited = new HashSet<>();

        for (Integer integer : map.keySet()) {
            Integer[] values = map.get(integer).toArray(new Integer[0]);
            for (int i = 0; i < values.length; i++) {

                if (visited.contains(values[i])) {
                    continue;
                }

                for (int j = i + 1; j < values.length; j++) {
                    if (map.containsKey(values[i]) && map.get(values[i]).contains(values[j])) {
                        res = Math.min(values.length + map.get(values[i]).size() +
                                (map.containsKey(values[j]) ? map.get(values[j]).size() : 0) - 6, res);
                    }
                }

            }

            visited.add(integer);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

}

package com.zouxxyy.c03;

/*
332. 重新安排行程
给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。

说明:

如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
所有的机场都用三个大写字母表示（机场代码）。
假定所有机票至少存在一种合理的行程。
示例 1:

输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
示例 2:

输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 */

/*
Hierholzer 算法

选择任一顶点为起点，遍历所有相邻边。
深度搜索，访问相邻顶点。将经过的边都删除。
如果当前顶点没有相邻边，则将顶点写入结果。
结果倒序输出，就是从起点出发的欧拉回路。
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution32 {

    public List<String> findItinerary(List<List<String>> tickets) {

        List<String> res = new LinkedList<>();

        if (tickets.size() == 0) {
            return res;
        }

        // 构造临界表
        HashMap<String, PriorityQueue<String>> map = new HashMap<>(tickets.size());
        for (List<String> ticket : tickets) {
            if (!map.containsKey(ticket.get(0))) {
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(ticket.get(1));
                map.put(ticket.get(0), pq);
            } else {
                map.get(ticket.get(0)).add(ticket.get(1));
            }
        }

        dfs(map, "JFK", res);

        return res;
    }


    /**
     * Hierholzer 算法
     *
     * 深度搜索，访问相邻顶点。将经过的边都删除。
     * 如果当前顶点没有相邻边，则将顶点写入结果。
     * 结果倒序输出，就是从起点出发的欧拉回路。(头插法就不用倒序)
     */
    private void dfs(HashMap<String, PriorityQueue<String>> map, String from, List<String> res) {

        // 遍历所有出度
        PriorityQueue<String> tos = map.get(from);

        while (tos != null && !tos.isEmpty()) {
            dfs(map, tos.poll(), res);
        }

        res.add(0, from);
    }

}

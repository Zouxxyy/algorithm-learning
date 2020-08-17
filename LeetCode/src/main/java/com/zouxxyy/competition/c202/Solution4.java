package com.zouxxyy.competition.c202;

import java.util.*;

/*
5490. 吃掉 N 个橘子的最少天数
厨房里总共有 n 个橘子，你决定每一天选择如下方式之一吃这些橘子：

吃掉一个橘子。
如果剩余橘子数 n 能被 2 整除，那么你可以吃掉 n/2 个橘子。
如果剩余橘子数 n 能被 3 整除，那么你可以吃掉 2*(n/3) 个橘子。
每天你只能从以上 3 种方案中选择一种方案。

请你返回吃掉所有 n 个橘子的最少天数。



示例 1：

输入：n = 10
输出：4
解释：你总共有 10 个橘子。
第 1 天：吃 1 个橘子，剩余橘子数 10 - 1 = 9。
第 2 天：吃 6 个橘子，剩余橘子数 9 - 2*(9/3) = 9 - 6 = 3。（9 可以被 3 整除）
第 3 天：吃 2 个橘子，剩余橘子数 3 - 2*(3/3) = 3 - 2 = 1。
第 4 天：吃掉最后 1 个橘子，剩余橘子数 1 - 1 = 0。
你需要至少 4 天吃掉 10 个橘子。
示例 2：

输入：n = 6
输出：3
解释：你总共有 6 个橘子。
第 1 天：吃 3 个橘子，剩余橘子数 6 - 6/2 = 6 - 3 = 3。（6 可以被 2 整除）
第 2 天：吃 2 个橘子，剩余橘子数 3 - 2*(3/3) = 3 - 2 = 1。（3 可以被 3 整除）
第 3 天：吃掉剩余 1 个橘子，剩余橘子数 1 - 1 = 0。
你至少需要 3 天吃掉 6 个橘子。
示例 3：

输入：n = 1
输出：1
示例 4：

输入：n = 56
输出：6


提示：

1 <= n <= 2*10^9
 */

/*
思路：

数字拆分求次数伪命题，bfs 或者 dfs
 */

/**
 * @author zxy
 */
public class Solution4 {

    /**
     * 方法一：BFS + visited + 贪心
     * 执行用时：24 ms 内存消耗：39 MB
     */
    public int minDays1(int n) {

        HashSet<Integer> visited = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(n);
        int level = 0;

        while (!queue.isEmpty()) {

            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();

                if (poll >= 3 && poll % 3 == 0) {
                    helper(queue, poll / 3, visited);
                }

                if (poll >= 2 && poll % 2 == 0) {
                    helper(queue, poll / 2, visited);
                }

                if (poll > 1) {
                    helper(queue, poll - 1, visited);
                } else {
                    return level;
                }
            }
        }
        return -1;
    }

    private void helper(LinkedList<Integer> queue, int remain, HashSet<Integer> visited) {
        if (!visited.contains(remain)) {
            queue.add(remain);
            visited.add(remain);
        }
    }


    /**
     * 方法二：dfs + 缓存 + 空间优化
     * 执行用时：4 ms 内存消耗：38.9 MB
     */
    HashMap<Integer, Integer> cache = new HashMap<>();

    public int minDays2(int n) {
        return dfs(n);
    }


    private int dfs(int n) {

        if (n <= 2) {
            return n;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int min = Math.min(dfs(n / 2) + n % 2, dfs(n / 3) + n % 3) + 1;
        cache.put(n, min);
        return min;
    }

}

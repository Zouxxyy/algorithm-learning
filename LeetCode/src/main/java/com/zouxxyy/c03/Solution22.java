package com.zouxxyy.c03;

/*
322. 零钱兑换
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。



示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1


说明:
你可以认为每种硬币的数量是无限的。
 */

/*
思路：

第一眼就用完全背包解了，结果发现排名很差，原来有更快的贪心方法。

小结：拆分物品的算法：dp、bfs + visited、dfs + cache
 */

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author zxy
 */
public class Solution22 {

    /**
     * 解法一：完全背包
     */
    public int coinChange1(int[] coins, int amount) {

        // dp[i][j]，只看前i个硬币，拼成 j 的最小个数
        // dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i]] + 1)
        // 降维

        int[] dp = new int[amount + 1];

        for (int j = 1; j < amount + 1; j++) {
            dp[j] = Integer.MAX_VALUE;
        }

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + (dp[j - coin] == Integer.MAX_VALUE ? 0 : 1));
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    /**
     * 解法二：bfs + visited
     */
    public int coinChange2(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }

        Arrays.sort(coins);

        boolean[] visited = new boolean[amount];

        int level = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(amount);

        while (!queue.isEmpty()) {
            level++;
            for (int i = queue.size(); i > 0; i--) {
                int poll = queue.poll();
                for (int coin : coins) {

                    int remain = poll - coin;
                    if (remain == 0) {
                        return level;
                    } else if (remain > 0) {
                        if (!visited[remain]) {
                            visited[remain] = true;
                            queue.add(remain);
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        return -1;
    }

}

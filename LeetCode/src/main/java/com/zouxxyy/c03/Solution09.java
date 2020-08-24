package com.zouxxyy.c03;

/*
309. 最佳买卖股票时机含冷冻期
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */

/*
思路：

理清每天有哪几种状态，然后转移即可
 */

/**
 * @author zxy
 */
public class Solution09 {

    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        // 3种状态：有股票、冷冻期结束，之后可买股票（无股票）、明天冷冻期（无股票）
        int withStock = prices[0] * -1;
        int afterCoolDown = 0;
        int toCoolDown = 0;

        for (int i = 1; i < prices.length; i++) {

            int withStockTemp = withStock;

            withStock = Math.max(withStockTemp, afterCoolDown - prices[i]);
            afterCoolDown = Math.max(afterCoolDown, toCoolDown);
            toCoolDown = withStockTemp + prices[i];
        }
        return Math.max(afterCoolDown, toCoolDown);
    }

}

package nc01;


/*
股票交易的最大收益（二）

题目描述
假定你知道某只股票每一天价格的变动。
你最多可以同时持有一只股票。但你最多只能进行两次交易（一次买进和一次卖出记为一次交易。买进和卖出均无手续费）。
请设计一个函数，计算你所能获得的最大收益。
示例1
输入
复制
[8,9,3,5,1,3]
返回值
复制
4
说明
第三天买进，第四天卖出，第五天买进，第六天卖出。总收益为4。
备注:
总天数不大于200000。保证股票每一天的价格在[1,100]范围内。
 */

/**
 * @author zxy
 */
public class Solution35 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 两次交易所能获得的最大收益
     *
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public int maxProfit(int[] prices) {
        // write code here

        int buy1 = -prices[0];
        int buy2 = -prices[0];
        int sell1 = 0;
        int sell2 = 0;

        for (int price : prices) {
            int tempBuy1 = buy1, tempBuy2 = buy2;
            buy1 = Math.max(buy1, -price);
            buy2 = Math.max(buy2, sell1 - price);
            sell1 = Math.max(sell1, tempBuy1 + price);
            sell2 = Math.max(sell2, tempBuy2 + price);
        }

        return Math.max(sell1, sell2);
    }

}

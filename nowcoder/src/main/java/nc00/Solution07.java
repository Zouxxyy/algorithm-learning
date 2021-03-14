package nc00;

/*
买卖股票的最好时机

假设你有一个数组，其中第\ i i 个元素是股票在第\ i i 天的价格。
你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
示例1
输入
复制
[1,4,2]
返回值
复制
3
示例2
输入
复制
[2,4,1]
返回值
复制
2
 */

/**
 * @author zxy
 */
public class Solution07 {

    public int maxProfit(int[] prices) {
        // write code here
        int res = 0;
        int min = Integer.MAX_VALUE;

        for (int price : prices) {

            if (price < min) {
                min = price;
            } else {
                res = Math.max(res, price - min);
            }
        }

        return res;
    }

}

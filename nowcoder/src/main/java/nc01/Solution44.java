package nc01;

/*
不相邻最大子序列和

题目描述
给你一个n（1\leq n\leq10^51≤n≤10
5
 ），和一个长度为n的数组，在不同时选位置相邻的两个数的基础上，求该序列的最大子序列和（挑选出的子序列可以为空）。
示例1
输入
复制
3,[1,2,3]
返回值
复制
4
说明
有[],[1],[2],[3],[1,3] 4种选取方式其中[1,3]选取最优，答案为4
示例2
输入
复制
4,[4,2,3,5]
返回值
复制
9
说明
其中[4,5]的选取方案是在满足不同时选取相邻位置的数的情况下是最优的答案
备注:
输入的值在int范围内
 */

/**
 * @author zxy
 */
public class Solution44 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算
     *
     * @param n     int整型 数组的长度
     * @param array int整型一维数组 长度为n的数组
     * @return long长整型
     */
    public long subsequence(int n, int[] array) {
        // write code here

        long res = 0;
        // choose notChoose

        long[][] dp = new long[n][2];
        int choose = 0, notChoose = 0;

        for (int a : array) {
            int temp = choose;
            choose = Math.max(choose, notChoose + a);
            notChoose = Math.max(temp, notChoose);
        }

        return Math.max(choose, notChoose);
    }

}

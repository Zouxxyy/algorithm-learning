package com.zouxxxyy.knapsack;

/*
2维背包

问题描述：
一个体积为 V 重量为 W 的背包，N 件物品，第i件物品的体积是v[i]，重量是w[i]，价值是w[i]，每件物品只能使用一次
求解物品装入背包（物品的体积总和不超过背包体积且重量总和不超过背包重量）时的最大总价值。

解法：n维背包n维dp即可
 */

/**
 * @author zxy
 */
public class No5_TwoDimensionalKnapsack {

    private static int solution(int N, int V, int M, int[] v, int[] m, int[] w) {

        int[][] dp = new int[V + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= v[i]; j--) {
                for (int k = M; k >= m[i]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - v[i]][k - m[i]] + w[i]);
                }
            }
        }

        return dp[V][M];
    }

    public static void main(String[] args) {

        // 物品种类
        final int N = 4;
        // 背包体积
        final int V = 5;
        // 背包重量
        final int M = 6;

        // v[i] 是第 i 个物品的体积，m[i] 是第 i 个物品的质量，w[i] 是第 i 个物品的价值；v[0]、m[0]、w[0] 仅用于占位
        final int[] v = new int[]{0, 1, 2, 3, 4};
        final int[] m = new int[]{0, 2, 4, 4, 5};
        final int[] w = new int[]{0, 3, 4, 5, 6};

        // 输出8
        System.out.println(solution(N, V, M, v, m, w));
    }

}

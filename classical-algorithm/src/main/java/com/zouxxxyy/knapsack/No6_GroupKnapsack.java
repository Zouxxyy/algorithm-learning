package com.zouxxxyy.knapsack;

/*
分组背包

问题描述：
一个体积为 V 的背包，N 组物品，第i组第j个物品的体积是v[i][j]，价值是w[i][j]，同一组的物品最多只能选一个
求解物品装入背包（物品的体积总和不超过背包体积）时的最大总价值。

解法：遍历组，倒遍历体积，遍历组内，转移
 */

/**
 * @author zxy
 */
public class No6_GroupKnapsack {

    private static int solution(int N, int V, int[][] v, int[][] w) {

        int[] dp = new int[V + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= 1; j--) {
                for (int k = 0; k < v[i].length; k++) {
                    if (j >= v[i][k]) {
                        dp[j] = Math.max(dp[j], dp[j - v[i][k]] + w[i][k]);
                    }
                }
            }
        }

        return dp[V];
    }

    public static void main(String[] args) {

        // 物品组数
        final int N = 3;
        // 背包体积
        final int V = 5;

        // v[i][j] 是第 i 组第 j 个物品的体积，w[i][j] 是第 i 组第 j 个物品的价值；v[0]、w[0] 仅用于占位
        final int[][] v = new int[][]{{}, {1, 2}, {3}, {4}};
        final int[][] w = new int[][]{{}, {2, 4}, {4}, {5}};

        // 输出8
        System.out.println(solution(N, V, v, w));
    }

}

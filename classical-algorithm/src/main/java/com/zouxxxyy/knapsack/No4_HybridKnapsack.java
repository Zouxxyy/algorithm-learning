package com.zouxxxyy.knapsack;

/*
混合背包（前3种背包的混合）

一个体积为 V 的背包，N 件物品，第i件物品的体积是v[i]，价值是w[i]，使用次数是s[i]，0代表无限次，-1代表只能使用一次
求解物品装入背包（物品的体积总和不超过背包体积）时的最大总价值。

解法：把多重背包拆成01背包，然后分01背包和完全背包两种情况讨论即可
 */

/**
 * @author zxy
 */
public class No4_HybridKnapsack {


    /**
     * 把多重背包拆成01背包，然后转移时分01背包和完全背包两种情况讨论即可
     */
    private static int solution(int N, int V, int[] v, int[] w, int[] s) {

        int count = 0;
        // 第二维表示：[v, w, s (0: 完全背包，-1: 01背包)]
        int[][] goods = new int[20002][3];

        for (int i = 1; i < N; i++) {

            int temp = s[i];

            if (temp == 0) {

                goods[count++] = new int[]{v[i], w[i], 0};

            } else if (temp == -1) {

                goods[count++] = new int[]{v[i], w[i], -1};

            } else {

                int k = 1;
                while (temp > k) {
                    goods[count++] = new int[]{k * v[i], k * w[i], -1};
                    temp -= k;
                    k *= 2;
                }

                if (temp > 0) {
                    goods[count++] = new int[]{temp * v[i], temp * w[i], -1};
                }

            }
        }

        int[] dp = new int[V + 1];

        for (int[] good : goods) {

            if (good[2] == 0) {
                // 完全背包
                for (int j = good[0]; j <= V; j++) {
                    dp[j] = Math.max(dp[j], dp[j - good[0]] + good[1]);
                }

            } else {
                // 01背包
                for (int j = V; j >= good[0]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - good[0]] + good[1]);
                }
            }

        }

        return dp[V];
    }


    public static void main(String[] args) {

        // 物品种类
        final int N = 4;
        // 背包体积
        final int V = 5;

        // v[i] 是第 i 个物品的体积，w[i] 是第 i 个物品的价值，s[i] 是第 i 个物品的个数；v[0]、w[0]、s[0] 仅用于占位
        final int[] v = new int[]{0, 1, 2, 3, 4};
        final int[] w = new int[]{0, 2, 4, 4, 5};
        final int[] s = new int[]{0, -1, 1, 0, 2};

        // 输出8
        System.out.println(solution(N, V, v, w, s));
    }

}

package com.zouxxxyy.knapsack;

/*
01背包

问题描述：
一个体积为 V 的背包，N 件物品，第i件物品的体积是v[i]，价值是w[i]，每件物品只能使用一次
求解物品装入背包（物品的体积总和不超过背包体积）时的最大总价值。

记忆：
1维dp解法，物品正序，体积倒序
 */


/**
 * @author zxy
 */
public class No1_ZeroOneKnapsack {

    /**
     * 2维动态规划
     * <p>
     * 求子问题：dp[i][j] 只看前 i 个物品，总体积为 j 的情况下的最大价值
     * 转移方程：dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i])
     * 计算顺序：i 必须从小到大
     * 初始状态：dp[0][x] = 0
     */
    private static int oldSolution(int N, int V, int[] v, int[] w) {

        int[][] dp = new int[N + 1][V + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[N][V];
    }


    /**
     * 1维动态规划（只是省空间，该怎么算还是怎么算）
     * <p>
     * 优化思想：
     * dp[i][j] 值只与 dp[i-1][x] {x:1...j} 有关，dp[i-1][x]是前一次i循环的值,可以将dp缩减成一维数组，从而达到优化空间的目的
     * 注意：dp[i][j]是通过dp[i-1][j-w(i)]来推导的，因此j的扫描顺序应该从大到小，否者前一次循环保存下来的值将会被修改，从而造成错误。
     * <p>
     * 求子问题：dp[j] 总体积为 j 的情况下的最大价值
     * 转移方程：dp[j] = max(dp[j], dp[j - v[i]] + w[i])
     * 计算顺序：i 必须从小到大，j 必须从大到小
     * 初始状态：0 件物品的 dp[x] = 0
     */
    private static int solution(int N, int V, int[] v, int[] w) {

        int[] dp = new int[V + 1];

        for (int i = 1; i <= N; i++) {
            // j 的最小值可进一步优化成一下写法
            for (int j = V; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }

        /*
        进阶思考：dp[V] 是总体积小于等于 V 时的最大值，如果我们想得到恰好等于 V 时的最大值呢？
        分析原因：会出现小于V的情况，是因为它是由 x != 0 时的初始值层层转移的，因此我们可以把 x != 0 时的初始值设为负无穷
                即初始状态变为 dp[0] = 0; dp[x] = 负无穷 (x != 0)
                如果不理解，想成二维情况就好理解，也就是 dp[0][0] = 0; dp[0][x] = 负无穷 (x != 0)
         */

        return dp[V];
    }


    public static void main(String[] args) {

        // 物品种类
        final int N = 4;
        // 背包体积
        final int V = 5;

        // v[i] 是第 i 个物品的体积，w[i] 是第 i 个物品的价值；v[0]、w[0] 仅用于占位
        final int[] v = new int[]{0, 1, 2, 3, 4};
        final int[] w = new int[]{0, 2, 4, 4, 5};

        // 输出8
        System.out.println(oldSolution(N, V, v, w));
        System.out.println(solution(N, V, v, w));

    }
}

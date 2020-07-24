package com.zouxxxyy.knapsack;

/*
完全背包

问题描述：
一个体积为 V 的背包，N 件物品，第i件物品的体积是v[i]，价值是w[i]，每件物品能使用无限次
求解物品装入背包（物品的体积总和不超过背包体积）时的最大总价值。

记忆：
1维dp解法，物品正序，体积正序，输入可优化
 */


/**
 * @author zxy
 */
public class No2_FullKnapsack {

    /**
     * 初始解法，我学完01背包第一时间想的就是这种解法
     * <p>
     * 求子问题：dp[j] 总体积为 j 的情况下的最大价值
     * 转移方程：dp[j] = max(dp[j], dp[j - k * v[i]] + k * w[i]) { k = 1,2... }
     * 计算顺序：i 必须从小到大，j 必须从大到小
     * 初始状态：0 件物品的 dp[x] = 0
     */
    private static int oldSolution(int N, int V, int[] v, int[] w) {

        int[] dp = new int[V + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= v[i]; j--) {
                // 01背包中 k 只能为 0 或 1
                // k从大到小或者从小到大都行。原因：我们只要保证不覆盖就行，而 k * v[i] 必大于等于0
                for (int k = 1; k * v[i] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                }
            }
        }

        return dp[V];
    }

    /**
     * 进阶解法
     * <p>
     * 求子问题：dp[j] 总体积为 j 的情况下的最大价值
     * 转移方程：dp[j] = max(dp[j], dp[j - v[i]] + w[i])
     * 计算顺序：i 必须从小到大，j 必须从小到大
     * 初始状态：0 件物品的 dp[x] = 0
     */
    private static int solution(int N, int V, int[] v, int[] w) {

        int[] dp = new int[V + 1];

        for (int i = 1; i <= N; i++) {
            // 思考 这里为啥把01背包中的j遍历顺序调回来就可以了？？？

            // 从2维转移方程的角度理解：dp[i][j] = max(dp[i - 1][j], dp[i][j - k * v[i]] + k * w[i])
            // dp[i][j] 在计算时用的还是dp[i][j - x]，因此同一维必须替换，且 k 在计算时其实是重复的，直接消掉

            // 另一个角度理解：如果我们想在计算 dp[j] 时含当前第i个物品（即完全背包），就用正序；不含（即 01 背包）就用逆序
            for (int j = v[i]; j <= V; j++) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }

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

        // 注意，输入可以优化，如果一个物品的体积比别人小，而价值反而更大，那么可以直接把那个体积大价值小的删了

        // 输出10
        System.out.println(oldSolution(N, V, v, w));
        System.out.println(solution(N, V, v, w));
    }

}

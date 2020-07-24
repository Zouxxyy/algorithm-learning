package com.zouxxxyy.knapsack;

/*
多重背包

问题描述：
一个体积为 V 的背包，N 件物品，第i件物品的体积是v[i]，价值是w[i]，使用次数是s[i]
求解物品装入背包（物品的体积总和不超过背包体积）时的最大总价值。

一般解法：01背包的思路，再套一个k循环。时间复杂度：O(N)O(K)O(V)
2进制解法：将物品的个数通过2进制拆分，形成新的物品，在新物品上引用01背包即可。时间复杂度：O(N)O(logK)O(V)

 */


/**
 * @author zxy
 */
public class No3_MultipleKnapsack {

    /**
     * 初始解法
     * <p>
     * 求子问题：dp[j] 总体积为 j 的情况下的最大价值
     * 转移方程：dp[j] = max(dp[j], dp[j - k * v[i]] + k * w[i]) { k = 1,2...s[i] }
     * 计算顺序：i 必须从小到大，j 必须从大到小
     * 初始状态：0 件物品的 dp[x] = 0
     * 时间复杂度：O(N)O(K)O(V)
     */
    private static int oldSolution(int N, int V, int[] v, int[] w, int[] s) {

        int[] dp = new int[V + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = V; j >= 1; j--) {
                for (int k = 1; k <= s[i] && k * v[i] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                }
            }
        }

        return dp[V];
    }

    /**
     * 2进制拆分解法
     * <p>
     * 假设某物品的个数为 K 个，寻求一种拆分方式，让拆分结果通过01组合，可以组合成任意小于等于 K 的数，但又不会超过 K。之后在新数组上使用01背包即可
     * 2进制拆分方式：把一个数不断拆成 1, 2, 4, 8...和一个剩下不能拆分的数。eg. 10 拆成 1, 2, 4, 3；21 拆成 1, 2, 4, 8, 6
     * <p>
     * 时间复杂度：O(N)O(logK)O(V)
     */
    private static int solution(int N, int V, int[] v, int[] w, int[] s) {

        int count = 0;

        // 步骤1：创建新数组，第一维大小设定为 N * logK（我这里手动随机设了一个），同样index为0时只用于占位。第二维表示 [v, w]
        int[][] goods = new int[20002][2];

        // 步骤2：将2进制拆分结果填入新数组中
        for (int i = 1; i < s.length; i++) {

            int temp = s[i];
            int k = 1;

            // 2进制部分
            while (temp > k) {
                goods[count++] = new int[]{v[i] * k, w[i] * k};
                temp -= k;
                k *= 2;
            }

            // 剩余部分
            if (temp > 0) {
                goods[count++] = new int[]{v[i] * temp, w[i] * temp};
            }
        }

        // 步骤3：使用01背包求解新数组

        int[] dp = new int[V + 1];

        for (int[] good : goods) {
            for (int j = V; j >= good[0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - good[0]] + good[1]);
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
        final int[] s = new int[]{0, 3, 1, 3, 2};

        // 输出10
        System.out.println(oldSolution(N, V, v, w, s));
        System.out.println(solution(N, V, v, w, s));
    }

}

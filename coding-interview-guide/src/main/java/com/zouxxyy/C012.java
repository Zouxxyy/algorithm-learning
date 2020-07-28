package com.zouxxyy;

import java.util.Scanner;

/*
题目描述
给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个aim，代表要找的钱数，求组成aim的最少货币数。
输入描述:
输入包括两行，第一行两个整数n（0<=n<=1000）代表数组长度和aim（0<=aim<=5000），第二行n个不重复的正整数，代表arr
​

输出描述:
输出一个整数，表示组成aim的最小货币数，无解时输出-1.
 */

/*
思路：

完全背包，每个硬币的价值是1，体积是硬币对应的值，求体积等于指定值时的最小价值
 */

/**
 * @author zxy
 */
public class C012 {
    private static int solution(int[] arr, int target) {

        int[] dp = new int[target + 1];

        // 由于是恰好等于，所以初始值除0以外都设为-1
        for (int i = 1; i < dp.length; i++) {
            dp[i] = -1;
        }

        // 完全背包
        for (int i = 1; i < arr.length; i++) {
            for (int j = arr[i]; j <= target; j++) {
                if (dp[j - arr[i]] != -1) {
                    if (dp[j] != -1) {
                        dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                    } else {
                        dp[j] = dp[j - arr[i]] + 1;
                    }
                }
            }
        }

        return dp[target];
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int target = scanner.nextInt();

        // arr[0] 用于占位
        int[] arr = new int[count + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(arr, target));
    }

}

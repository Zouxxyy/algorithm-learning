/*
面试题49. 丑数

我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。

 

示例:

输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
说明:  

1 是丑数。
n 不超过1690。

 */

/*
思路：

三个有序数组的无重复元素合并！注意无重复
 */

package com.zouxxyy;

public class Solution49 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int a = 1, b = 1, c = 1;
        for (int i = 2; i < n + 1; i++) {
            int dpa = dp[a] * 2, dpb = dp[b] * 3, dpc = dp[c] * 5;
            dp[i] = Math.min(Math.min(dpa, dpb), dpc);
            if (dp[i] == dpa) a++;
            if (dp[i] == dpb) b++;
            if (dp[i] == dpc) c++;
        }
        return dp[n];
    }
}

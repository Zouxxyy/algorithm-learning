package com.zouxxyy.c06;

/*
647. 回文子串
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。



示例 1：

输入："abc"
输出：3
解释：三个回文子串: "a", "b", "c"
示例 2：

输入："aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"


提示：

输入的字符串长度不会超过 1000 。
 */

/*
思路：

dp 或者 中心扩散
 */

/**
 * @author zxy
 */
public class Solution47 {

    public int countSubstrings(String s) {

        // dp[i][j]：s[i : j] 是否为回文子串
        // 转移方程：dp[i][j] = s[i] == s[j] && dp[i + 1][j - 1]
        // 计算顺序：i 从大到小，j 任意

        // i 那维可以消掉，计算顺序：i 从大到小，j 从大到小

        int res = 0;

        boolean[] dp = new boolean[s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = s.length() - 1; j >= i; j--) {

                // aa a  aaa 肯定是回文
                dp[j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[j - 1]);

                if (dp[j]) {
                    res++;
                }
            }

        }

        return res;
    }

}

package com.zouxxyy.c00;

/*
5. 最长回文子串

给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

 */

/*
思路：

方法1：动态规划
子问题：aba 是回文，那么 cabac 是回文，cabad 不是回文
dp[l][r] 表示 s[l : r]　是否是回文（左闭右闭）
转移方程：dp[l][r] = s.charAt(l) == s.charAt(r) && (r - l < 3 || dp[l + 1][r - 1])
初始值：dp[l][r] = true (l == r) 其实用不到
计算顺序：一层循环 r 递增，二层循环 l 递增

降维：
由于 dp[x][r] 仅依赖 dp[x][r - 1]，可以直接把 x 降维；由于 l 依赖与 l + 1
dp[l] = s.charAt(l) == s.charAt(r) && (r - l < 3 || dp[l + 1])

方法2：中心扩散（同一个地址分奇偶两种）
 */

/**
 * @author zxy
 */
public class Solution05 {

    /**
     * 1维动态规划解法
     */
    public String longestPalindrome(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        // 左闭右闭
        int begin = 0, end = 0;

        boolean[] dp = new boolean[s.length()];

        for (int r = 1; r < s.length(); r++) {
            // 由于 dp[l] 依赖于 dp[l + 1]，因此新值不会替换旧值，l 仍然按以前的顺序计算
            for (int l = 0; l < r; l++) {
                dp[l] = s.charAt(l) == s.charAt(r) && (r - l < 3 || dp[l + 1]);
                if (dp[l] && (r - l > end - begin)) {
                    begin = l;
                    end = r;
                }

            }
        }

        return s.substring(begin, end + 1);
    }
}

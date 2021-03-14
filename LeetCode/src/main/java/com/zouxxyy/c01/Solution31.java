package com.zouxxyy.c01;

/*
131. 分割回文串
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

回文串 是正着读和反着读都一样的字符串。



示例 1：

输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
示例 2：

输入：s = "a"
输出：[["a"]]


提示：

1 <= s.length <= 16
s 仅由小写英文字母组成
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution31 {

    public List<List<String>> partition(String s) {

        int n = s.length();

        // 转移方程：dp[i][j] = s[i] == s[j] && (j - i < 3 || dp[i + 1][j - 1])
        boolean[][] dp = new boolean[n][n];
        char[] chars = s.toCharArray();

        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = chars[i] == chars[j] && (j - i < 3 || dp[i + 1][j - 1]);
            }
        }

        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, n, new LinkedList<>(), dp, res);
        return res;

    }

    private void dfs(String s, int start, int n, LinkedList<String> cur, boolean[][] dp, List<List<String>> res) {

        if (start == n) {
            res.add(new ArrayList<>(cur));
        }

        for (int end = start; end < n; end++) {
            if (dp[start][end]) {
                cur.add(s.substring(start, end + 1));
                dfs(s, end + 1, n, cur, dp, res);
                cur.removeLast();
            }
        }
    }

}

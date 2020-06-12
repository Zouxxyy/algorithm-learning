/*
面试题19. 正则表达式匹配

请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。

示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例 3:

输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。

 */

/*
笔记：

学习大佬的递归写法，以后多做点简单的动态规划，再回来想这题的动态规划
 */

package com.zouxxyy;

public class Solution19 {
    public boolean isMatch(String s, String p) {
        return dfs(s, p, 0, 0);
    }

    public boolean dfs(String s, String p, int i, int j) {

        if (i == s.length()) {
            if ((p.length() - j) % 2 != 0) return false;
            j++;
            while (j < p.length()) {
                if (p.charAt(j) != '*') return false;
                j += 2;
            }
            return true;
        }

        if (j == p.length()) return false;

        char s1 = s.charAt(i), p1 = p.charAt(j), p2 = '-';
        if (j + 1 < p.length()) p2 = p.charAt(j + 1);

        if (p2 == '*') {
            if (s1 == p1 || p1 == '.') return dfs(s, p, i + 1, j) || dfs(s, p, i, j + 2);
            else return dfs(s, p, i, j + 2);
        } else {
            if (s1 == p1 || p1 == '.') return dfs(s, p, i + 1, j + 1);
            else return false;
        }
    }
}
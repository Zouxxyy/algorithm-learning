package com.zouxxyy.c00;

/*
32. 最长有效括号
给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。



示例 1：

输入：s = "(()"
输出：2
解释：最长有效括号子串是 "()"
示例 2：

输入：s = ")()())"
输出：4
解释：最长有效括号子串是 "()()"
示例 3：

输入：s = ""
输出：0


提示：

0 <= s.length <= 3 * 104
s[i] 为 '(' 或 ')'
 */

import java.util.LinkedList;

/**
 * @author zxy
 */
public class Solution32 {

    public int longestValidParentheses(String s) {

        LinkedList<Integer> stack = new LinkedList<>();
        char[] cs = s.toCharArray();
        int res = 0;
        int start = -1;

        for (int i = 0; i < cs.length; i++) {

            if (cs[i] == '(') {
                stack.push(i);
            } else if (!stack.isEmpty()) {
                stack.pop();
                res = Math.max(res, i - (stack.isEmpty() ? start : stack.peek()));
            } else {
                start = i;
            }
        }

        return res;
    }
}

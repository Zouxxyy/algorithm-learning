package com.zouxxyy.c11;

/*
1190. 反转每对括号间的子串
给出一个字符串 s（仅含有小写英文字母和括号）。

请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。

注意，您的结果中 不应 包含任何括号。



示例 1：

输入：s = "(abcd)"
输出："dcba"
示例 2：

输入：s = "(u(love)i)"
输出："iloveu"
示例 3：

输入：s = "(ed(et(oc))el)"
输出："leetcode"
示例 4：

输入：s = "a(bcdefghijkl(mno)p)q"
输出："apmnolkjihgfedcbq"


提示：

0 <= s.length <= 2000
s 中只有小写英文字母和括号
我们确保所有括号都是成对出现的
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution90 {

    public String reverseParentheses(String s) {

        LinkedList<String> stack = new LinkedList<>();
        StringBuilder cur = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(cur.toString());
                cur = new StringBuilder();
            } else if (c == ')') {
                cur.reverse();
                if (!stack.isEmpty()) {
                    cur = new StringBuilder(stack.pop()).append(cur);
                }
            } else {
                cur.append(c);
            }
        }

        return cur.toString();
    }

}

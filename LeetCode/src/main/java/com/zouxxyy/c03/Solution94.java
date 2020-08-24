package com.zouxxyy.c03;

/*
394. 字符串解码
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。



示例 1：

输入：s = "3[a]2[bc]"
输出："aaabcbc"
示例 2：

输入：s = "3[a2[c]]"
输出："accaccacc"
示例 3：

输入：s = "2[abc]3[cd]ef"
输出："abcabccdcdcdef"
示例 4：

输入：s = "abc3[cd]xyz"
输出："abccdcdcdxyz"
 */

/*
思路：

递归：写的有点乱
栈：个人偏向它，里栈存的是StringBuilder
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution94 {

    /**
     * 解法1：dfs
     */
    public String decodeString1(String s) {
        return dfs(s, 0, s.length() - 1);
    }

    private String dfs(String s, int start, int end) {

        if (start == s.length()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        int nextStart = start;
        int leftCount = 0;
        boolean tag = true;

        for (int i = start; i <= end; i++) {

            char c = s.charAt(i);
            if (c >= '0' && c <= '9' && tag) {

                count *= 10;
                count += c - '0';

            } else if (c == '[') {

                leftCount++;
                if (tag) {
                    nextStart = i + 1;
                    tag = false;
                }

            } else if (c == ']') {

                leftCount--;
                if (leftCount == 0) {
                    String sub = dfs(s, nextStart, i - 1);
                    for (int k = 0; k < count; k++) {
                        sb.append(sub);
                    }
                    count = 0;
                    tag = true;
                }

            } else if (tag) {
                sb.append(c);
            }
        }

        return sb.toString();
    }


    /**
     * 方法2：栈（双栈）
     */
    public String decodeString2(String s) {

        if (s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        LinkedList<StringBuilder> sbStack = new LinkedList<>();
        LinkedList<Integer> countStack = new LinkedList<>();

        int count = 0;

        for (char c : s.toCharArray()) {

            if (c >= '0' && c <= '9') {

                // [ 前面的次数
                count *= 10;
                count += c - '0';

            } else if (c == '[') {

                // 入栈 和 清0
                sbStack.push(sb);
                countStack.push(count);

                count = 0;
                sb = new StringBuilder();

            } else if (c == ']') {

                // 出栈，按次数添加字符串
                StringBuilder sbPop = sbStack.pop();
                int countPop = countStack.pop();
                String toCycle = sb.toString();

                for (int k = 0; k < countPop; k++) {
                    sbPop.append(toCycle);
                }

                // 这句非常关键
                sb = sbPop;

            } else {

                sb.append(c);

            }
        }

        return sb.toString();

    }

}

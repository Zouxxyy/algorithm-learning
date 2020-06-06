/*
面试题05. 替换空格

请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."
 

限制：

0 <= s 的长度 <= 10000

 */

/*
笔记：

StringBuffer 线程安全；StringBuilder 线程不安全
 */

package com.zouxxyy;

public class Solution05 {
    public String replaceSpace(String s) {
        if (s.length() == 0) return s;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= s.length() - 1; i++) {
            stringBuilder.append(s.charAt(i) != ' ' ? s.charAt(i) : "%20");
        }
        return stringBuilder.toString();
    }
}

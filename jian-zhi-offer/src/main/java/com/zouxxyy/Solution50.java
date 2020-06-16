/*
面试题50. 第一个只出现一次的字符

在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:

s = "abaccdeff"
返回 "b"

s = ""
返回 " "
 

限制：

0 <= s 的长度 <= 50000
 */

package com.zouxxyy;

public class Solution50 {
    public char firstUniqChar(String s) {

        if (s.length() == 0) return ' ';

        char[] chars = new char[26];

        for (int i = 0; i < s.length(); i++)
            chars[s.charAt(i) - 'a']++;

        for (int i = 0; i < s.length(); i++)
            if (chars[s.charAt(i) - 'a'] == 1) return s.charAt(i);

        return ' ';
    }
}

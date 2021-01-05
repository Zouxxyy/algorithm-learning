package com.zouxxyy.c02;

/*
214. 最短回文串
给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。

示例 1:

输入: "aacecaaa"
输出: "aaacecaaa"
示例 2:

输入: "abcd"
输出: "dcbabcd"
 */

/**
 * @author zxy
 */
public class Solution14 {

    public String shortestPalindrome(String s) {

        if (s.length() <= 1) {
            return s;
        }

        char[] chars = s.toCharArray();

        // 找到最大回文前缀
        int r = chars.length - 1;
        while (0 < r && !isPalindrome(chars, r)) {
            r--;
        }

        // 反转后面部分，然后拼接
        return new StringBuilder(s.substring(r + 1)).reverse().append(s).toString();
    }


    /**
     * 判断 chars[0:r] 是否是回文
     */
    private boolean isPalindrome(char[] chars, int r) {

        int l = 0;

        while (l < r) {
            if (chars[l++] != chars[r--]) {
                return false;
            }
        }

        return true;
    }

}

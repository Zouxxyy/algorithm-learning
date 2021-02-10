package com.zouxxyy.c06;

/*
680. 验证回文字符串 Ⅱ
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

示例 1:

输入: "aba"
输出: True
示例 2:

输入: "abca"
输出: True
解释: 你可以删除c字符。
注意:

字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 */

/**
 * @author zxy
 */
public class Solution80 {

    public boolean validPalindrome(String s) {

        int l = 0, r = s.length() - 1;
        char[] chars = s.toCharArray();

        while (l < r) {

            if (chars[l] == chars[r]) {
                l++;
                r--;
            } else {
                return isPalindrome(chars, l + 1, r) || isPalindrome(chars, l, r - 1);
            }
        }

        return true;
    }

    private boolean isPalindrome(char[] chars, int l, int r) {

        while (l < r) {
            if (chars[l] == chars[r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;

    }

}

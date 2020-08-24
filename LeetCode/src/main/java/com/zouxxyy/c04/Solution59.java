package com.zouxxyy.c04;

/*
459. 重复的子字符串
给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

示例 1:

输入: "abab"

输出: True

解释: 可由子字符串 "ab" 重复两次构成。
示例 2:

输入: "aba"

输出: False
示例 3:

输入: "abcabcabcabc"

输出: True

解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */

/*
思路：

不懂KMP，以后学学
 */

/**
 * @author zxy
 */
public class Solution59 {

    public boolean repeatedSubstringPattern(String s) {

        for (int cnt = 1; cnt <= s.length() / 2; cnt++) {

            if (check(s, cnt)) {
                return true;
            }

        }

        return false;
    }


    /**
     * 长度为 cnt 的子串是否符合要求
     */
    private boolean check(String s, int cnt) {

        // 只有整数倍才有可能
        if (s.length() % cnt != 0) {
            return false;
        }

        int i = 0;

        while (i < s.length()) {

            for (int j = 0; j < cnt; j++) {
                if (s.charAt(j) != s.charAt(i++)) {
                    return false;
                }
            }

        }
        return true;
    }

}

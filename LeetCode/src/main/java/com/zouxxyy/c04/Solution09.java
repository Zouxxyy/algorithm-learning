package com.zouxxyy.c04;

/*
409. 最长回文串
给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

示例 1:

输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution09 {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        boolean flag = false;
        for (int i : map.values()) {
            if (i % 2 == 1) {
                flag = true;
            }
            res += i / 2 * 2;
        }
        return flag ? res + 1 : res;
    }
}

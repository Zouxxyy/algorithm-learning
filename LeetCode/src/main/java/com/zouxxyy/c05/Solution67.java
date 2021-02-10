package com.zouxxyy.c05;

/*
567. 字符串的排列
给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，第一个字符串的排列之一是第二个字符串的子串。

示例1:

输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").


示例2:

输入: s1= "ab" s2 = "eidboaoo"
输出: False


注意：

输入的字符串只包含小写字母
两个字符串的长度都在 [1, 10,000] 之间
 */

/**
 * @author zxy
 */
public class Solution67 {

    public boolean checkInclusion(String s1, String s2) {

        int[] feq = new int[26];
        int cnt = 0;
        int n1 = s1.length(), n2 = s2.length();

        for (char c : s1.toCharArray()) {
            if (feq[c - 'a'] == 0) {
                cnt++;
            }
            feq[c - 'a']++;
        }

        char[] chars = s2.toCharArray();
        for (int i = 0; i < n2; i++) {

            if (--feq[chars[i] - 'a'] == 0) {
                cnt--;
            }

            if (i >= n1 && feq[chars[i - n1] - 'a']++ == 0) {
                cnt++;
            }

            if (cnt == 0) {
                return true;
            }
        }

        return false;
    }

}

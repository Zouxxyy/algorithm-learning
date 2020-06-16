/*
面试题48. 最长不含重复字符的子字符串

请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

 

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 

提示：

s.length <= 40000

 */

/*
笔记：

加hashMap
 */

package com.zouxxyy;

import java.util.HashMap;

public class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, res = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>(128);
        while (right < s.length()) {
            char c = s.charAt(right);
            if (hashMap.containsKey(c))
                left = Math.max(hashMap.get(c), left);
            hashMap.put(c, right);
            right++;
            res = Math.max(res, right - left);
        }
        return res;
    }
}

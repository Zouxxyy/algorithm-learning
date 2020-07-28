package com.zouxxyy.c00;

/*
3. 无重复字符的最长子串

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

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

 */

/*
思路：

双指针 + hashMap
 */

import java.util.HashMap;

/**
 * @author zxy
 */
public class Solution03 {

    public int lengthOfLongestSubstring(String s) {

        int left = 0, right = 0, res = 0;

        // key 是 char， value 是该 char 在 s 中最新的 index
        HashMap<Character, Integer> hashMap = new HashMap<>(s.length());

        while (right < s.length()) {

            char c = s.charAt(right);

            if (hashMap.containsKey(c)) {
                int index = hashMap.get(c);

                // 只有当 index 在 left 或者它的右边时，才需要移动 left
                if (index >= left) {
                    left = index + 1;
                }
            }

            hashMap.put(c, right);

            res = Math.max(res, right - left + 1);

            right++;
        }

        return res;
    }
}

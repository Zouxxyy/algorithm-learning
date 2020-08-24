package com.zouxxyy.c04;

/*
438. 找到字符串中所有字母异位词
给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：

字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。
示例 1:

输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 示例 2:

输入:
s: "abab" p: "ab"

输出:
[0, 1, 2]

解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
思路：

效果一般，后面再回顾它
 */

/**
 * @author zxy
 */
public class Solution38 {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new LinkedList<>();

        if (s.length() < p.length()) {
            return res;
        }

        HashMap<Character, Integer> counts = new HashMap<>(26);
        for (char c : p.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }


        int length = p.length();
        for (int i = 0; i < length; i++) {
            char cur = s.charAt(i);
            if (counts.containsKey(cur)) {
                counts.put(cur, counts.get(cur) - 1);
            }
        }
        if (check(counts)) {
            res.add(0);
        }

        for (int i = 1; i <= s.length() - length; i++) {

            char remove = s.charAt(i - 1);
            char add = s.charAt(i + length - 1);

            if (counts.containsKey(remove)) {
                counts.put(remove, counts.get(remove) + 1);
            }

            if (counts.containsKey(add)) {
                counts.put(add, counts.get(add) - 1);
                if (check(counts)) {
                    res.add(i);
                }
            }
        }

        return res;

    }

    private boolean check(HashMap<Character, Integer> counts) {
        for (Integer value : counts.values()) {
            if (value !=  0) {
                return false;
            }
        }
        return true;
    }

}

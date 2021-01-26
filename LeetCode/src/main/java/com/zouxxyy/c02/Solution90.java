package com.zouxxyy.c02;

/*
290. 单词规律
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:

输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例 2:

输入:pattern = "abba", str = "dog cat cat fish"
输出: false
示例 3:

输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
示例 4:

输入: pattern = "abba", str = "dog dog dog dog"
输出: false
说明:
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution90 {

    public boolean wordPattern(String pattern, String s) {

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        String[] splits = s.split(" ");

        char[] chars = pattern.toCharArray();

        if (splits.length != chars.length) {
            return false;
        }

        for (int i = 0; i < chars.length; i++) {

            if (!map.containsKey(chars[i])) {

                map.put(chars[i], splits[i]);

                if (!set.contains(splits[i])) {
                    set.add(splits[i]);
                } else {
                    return false;
                }

            } else if (!map.get(chars[i]).equals(splits[i])) {
                return false;
            }
        }

        return true;
    }

}

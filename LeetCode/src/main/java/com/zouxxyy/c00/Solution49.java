package com.zouxxyy.c00;

/*
49. 字母异位词分组
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。
 */

/*
思路：

hashMap(排序好的，List)
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> hashMap = new HashMap<>(strs.length);

        for (String str : strs) {

            String key = sortString(str);

            if (!hashMap.containsKey(key)) {

                List<String> strings = new ArrayList<>();
                strings.add(str);
                hashMap.put(key, strings);

            } else {
                hashMap.get(key).add(str);
            }
        }

        return new ArrayList<>(hashMap.values());

    }

    /**
     * 将字符串按字母表排好，比如 "bac" 变为 "abc
     */
    private String sortString(String str) {

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }

}

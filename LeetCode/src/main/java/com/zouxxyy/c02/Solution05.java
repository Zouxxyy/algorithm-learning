package com.zouxxyy.c02;

/*
205. 同构字符串
给定两个字符串 s 和 t，判断它们是否是同构的。

如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。

每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。



示例 1:

输入：s = "egg", t = "add"
输出：true
示例 2：

输入：s = "foo", t = "bar"
输出：false
示例 3：

输入：s = "paper", t = "title"
输出：true


提示：

可以假设 s 和 t 长度相同。
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution05 {

    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        for (int i = 0; i < charS.length; i++) {

            if (!map.containsKey(charS[i])) {

                map.put(charS[i], charT[i]);

                if (!set.contains(charT[i])) {
                    set.add(charT[i]);
                } else {
                    return false;
                }

            } else if (map.get(charS[i]) != charT[i]) {

                return false;

            }
        }

        return true;
    }

}

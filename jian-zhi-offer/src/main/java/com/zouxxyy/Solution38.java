/*
面试题38. 字符串的排列

输入一个字符串，打印出该字符串中字符的所有排列。

 

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

 

示例:

输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]
 

限制：

1 <= s 的长度 <= 8

 */

package com.zouxxyy;

import java.util.HashSet;
import java.util.LinkedList;

public class Solution38 {

    private char[] chars;

    public String[] permutation(String s) {
        LinkedList<String> list = new LinkedList<>();
        chars = new char[s.length()];
        dfs(0, s, list);
        return list.toArray(new String[0]);
    }

    public void dfs(int index, String remain, LinkedList<String> list) {
        if (remain.length() == 0) {
            list.addLast(String.valueOf(chars));
            return;
        }
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < remain.length(); i++) {
            if (!hashSet.contains(remain.charAt(i))) {
                hashSet.add(remain.charAt(i));
                chars[index] = remain.charAt(i);
                dfs(index + 1, remain.substring(0, i) + remain.substring(i + 1), list);
            }
        }
    }
}

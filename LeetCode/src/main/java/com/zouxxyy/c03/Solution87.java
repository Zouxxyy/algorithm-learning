package com.zouxxyy.c03;

/*
387. 字符串中的第一个唯一字符
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。



示例：

s = "leetcode"
返回 0

s = "loveleetcode"
返回 2


提示：你可以假定该字符串只包含小写字母。
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution87 {

    public int firstUniqChar(String s) {

        // 三种状态：没出现 -1，第一次出现 >= 0，第二次出现 —2
        int[] states = new int[26];
        Arrays.fill(states, -1);

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            int index = chars[i] - 'a';

            if (states[index] == -1) {
                states[index] = i;
            } else if (states[index] >= 0) {
                states[index] = -2;
            }

        }

        int res = Integer.MAX_VALUE;
        for (int i : states) {
            if (i >= 0) {
                res = Math.min(i, res);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

}

package com.zouxxyy.c04;

/*
424. 替换后的最长重复字符
给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。

注意：字符串长度 和 k 不会超过 104。



示例 1：

输入：s = "ABAB", k = 2
输出：4
解释：用两个'A'替换为两个'B',反之亦然。
示例 2：

输入：s = "AABABBA", k = 1
输出：4
解释：
将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
子串 "BBBB" 有最长重复字母, 答案为 4。
 */


/**
 * @author zxy
 */
public class Solution24 {

    public int characterReplacement(String s, int k) {

        int l = 0, r = 0;
        // 滑动窗口中出现次数最多的字母的个数（历史值）
        int maxN = 0;
        int[] counts = new int[26];

        char[] chars = s.toCharArray();
        while (r < s.length()) {

            counts[chars[r] - 'A']++;
            // 贪心思想：只有 新加的字符 可能成为 maxN
            maxN = Math.max(counts[chars[r] - 'A'], maxN);
            r++;

            // 判断 l 是否需要移动，此时是左闭右开状态
            if (k < (r - l - maxN)) {
                counts[chars[l] - 'A']--;
                l++;
            }

        }

        return r - l;
    }

}

package com.zouxxyy.c00;

/*
76. 最小覆盖子串
给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。



示例：

输入：S = "ADOBECODEBANC", T = "ABC"
输出："BANC"


提示：

如果 S 中不存这样的子串，则返回空字符串 ""。
如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */

/*
核心：

1. 固定左边界，找出以它为左边界的字串的最小值，然后右移左边界（固定变量法，这个技巧dp也经常用，学习下滑动窗口模板）
2. 使用 distance 保证 check 操作是 O(1) 的
 */

/**
 * @author zxy
 */
public class Solution76 {

    public String minWindow(String s, String t) {

        // 单词出现次数数组，'z' = 122
        int[] sFeq = new int[128];
        int[] tFeq = new int[128];
        for (char c : t.toCharArray()) {
            tFeq[c] += 1;
        }

        // 使用 distance 保证 check 操作是 O(1) 的
        int distance = t.length();

        // 最小子串长度 和 起始位置
        int minLen = s.length() + 1;
        int begin = -1;

        // 滑动窗口，左闭右开
        int l = 0, r = 0;
        char[] ss = s.toCharArray();

        // 循环终止条件：r （出边界）
        while (r < s.length()) {

            // 如果窗口不符合条件，增加 r 所在的点，修改距离，r 右移
            if (tFeq[ss[r]] > 0 && sFeq[ss[r]]++ < tFeq[ss[r]]) {
                distance--;
            }
            r++;

            // 如果窗口符合条件
            while (distance == 0) {

                // 1. 更新 minLen
                if (r - l < minLen) {
                    minLen = r - l;
                    begin = l;
                    // minLen 是 t 的长度时，提前返回
                    if (minLen == t.length()) {
                        break;
                    }
                }

                // 2. 移除 l 所在的点，修改距离，l 右移
                if (tFeq[ss[l]] > 0 && --sFeq[ss[l]] < tFeq[ss[l]]) {
                    distance++;
                }
                l++;
            }

        }

        return begin != -1 ? s.substring(begin, begin + minLen) : "";
    }

}

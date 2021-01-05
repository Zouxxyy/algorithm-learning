package com.zouxxyy.c05;

/*
557. 反转字符串中的单词 III
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。



示例：

输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"


提示：

在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */

/**
 * @author zxy
 */
public class Solution57 {

    public String reverseWords(String s) {

        char[] chars = s.toCharArray();

        int l = 0;
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == ' ') {
                reverse(chars, l, i - 1);
                l = i + 1;
            }
        }

        reverse(chars, l, s.length() - 1);
        return new String(chars);
    }


    /**
     * reverse chars[l:r]
     */
    private void reverse(char[] chars, int l, int r) {

        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }

    }

}

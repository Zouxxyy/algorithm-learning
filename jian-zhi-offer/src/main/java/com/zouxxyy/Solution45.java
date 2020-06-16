/*
面试题45. 把数组排成最小的数

输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

 

示例 1:

输入: [10,2]
输出: "102"
示例 2:

输入: [3,30,34,5,9]
输出: "3033459"
 

提示:

0 < nums.length <= 100
说明:

输出结果可能非常大，所以你需要返回一个字符串而不是整数
拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 */

package com.zouxxyy;

import java.util.Arrays;

public class Solution45 {

    // 看答案前想的办法，可替代为 s1 + s2 比 s2 + s1
    public int recursive(String s1, String s2) {
        int i;
        for (i = 0; i < s1.length() && i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);
            }
        }
        if (s1.length() == s2.length()) return 0;
        if (s2.length() == i) return recursive(s1.substring(i) + s2, s2 + s1.substring(i));
        return recursive(s1 + s2.substring(i), s2.substring(i) + s1);
    }

    public String minNumber(int[] nums) {

        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(strings, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        StringBuilder builder = new StringBuilder();
        for (String string : strings)
            builder.append(string);
        return builder.toString();
    }
}

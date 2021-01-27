package com.zouxxyy.c04;

/*
415. 字符串相加
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。



提示：

num1 和num2 的长度都小于 5100
num1 和num2 都只包含数字 0-9
num1 和num2 都不包含任何前导零
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 */

/**
 * @author zxy
 */
public class Solution15 {

    public String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();

        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();

        int i = nums1.length - 1;
        int j = nums2.length - 1;

        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {

            int sum = 0;

            if (i >= 0) {
                sum += nums1[i] - '0';
                i--;
            }

            if (j >= 0) {
                sum += nums2[j] - '0';
                j--;
            }

            sum += carry;

            sb.append((char) (sum % 10 + '0'));
            carry = sum / 10;

        }

        return sb.reverse().toString();

    }

}

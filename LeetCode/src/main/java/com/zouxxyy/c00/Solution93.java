package com.zouxxyy.c00;

/*
93. 复原IP地址
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。



示例 1：

输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
示例 2：

输入：s = "0000"
输出：["0.0.0.0"]
示例 3：

输入：s = "1111"
输出：["1.1.1.1"]
示例 4：

输入：s = "010010"
输出：["0.10.0.10","0.100.1.0"]
示例 5：

输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]


提示：

0 <= s.length <= 3000
s 仅由数字组成
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution93 {

    private List<String> res;

    public List<String> restoreIpAddresses(String s) {

        res = new ArrayList<>();

        if (s.length() < 4 || s.length() > 12) {
            return res;
        }

        dfs(s.toCharArray(), 0, 0, new StringBuilder(), s.length());

        return res;
    }


    private void dfs(char[] chars, int index, int cnt, StringBuilder sb, int n) {

        if (cnt == 4) {

            if (index == n) {
                res.add(sb.deleteCharAt(sb.length() - 1).toString());
            }

            return;
        }


        if (index < n) {
            dfs(chars, index + 1, cnt + 1, new StringBuilder(sb).append(chars, index, 1).append('.'), n);
        }

        if (index + 1 < n && chars[index] != '0') {
            dfs(chars, index + 2, cnt + 1, new StringBuilder(sb).append(chars, index, 2).append('.'), n);
        }

        if (index + 2 < n && (chars[index] == '1' || (chars[index] == '2' && (chars[index + 1] < '5' || (chars[index + 1] == '5' && chars[index + 2] <= '5'))))) {
            dfs(chars, index + 3, cnt + 1, new StringBuilder(sb).append(chars, index, 3).append('.'), n);
        }

    }

}

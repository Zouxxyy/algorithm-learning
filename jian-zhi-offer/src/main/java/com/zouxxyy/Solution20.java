/*
面试题20. 表示数值的字符串

请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。

例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。

 */

/*
笔记：

状态机
 */

package com.zouxxyy;

import java.util.HashMap;
import java.util.Map;

public class Solution20 {

    // 个人愚法，提交了9次，已经麻木
    public boolean isNumberOld(String s) {
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') i++;
            else break;
        }
        if (i == s.length()) return false;

        if ((s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.length() == i + 1) return false;
            else i += 1;
        }
        boolean hasNum = false;
        for (boolean hasPoint = false; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                if (hasPoint) return false;
                boolean hadNum = false;
                if (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') hadNum = true;
                if (i - 1 >= 0 && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9') hadNum = true;
                if (!hadNum) return false;
                hasPoint = true;
            } else if (s.charAt(i) == 'e') {
                if (i == 0) return false;
                i += 1;
                if (i == s.length()) return false;
                if ((s.charAt(i) == '-' || s.charAt(i) == '+')) {
                    if (s.length() == i + 1) return false;
                    else i += 1;
                }
                boolean hasNum2 = false;
                while (i < s.length()) {
                    if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        hasNum2 = true;
                        i++;
                    } else if (s.charAt(i) == ' ') {
                        i++;
                        while (i < s.length()) {
                            if (s.charAt(i) == ' ') i++;
                            else return false;
                        }
                    } else return false;
                }
                return hasNum && hasNum2;
            } else if (s.charAt(i) == ' ') {
                break;
            } else if (s.charAt(i) < '0' || s.charAt(i) > '9')
                return false;
            else hasNum = true;
        }
        while (i < s.length()) {
            if (s.charAt(i) == ' ') i++;
            else return false;
        }
        return true;
    }

    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap<Character, Integer>() {{
                    put(' ', 0);
                    put('s', 1);
                    put('d', 2);
                    put('.', 4);
                }}, // 0.
                new HashMap<Character, Integer>() {{
                    put('d', 2);
                    put('.', 4);
                }},                           // 1.
                new HashMap<Character, Integer>() {{
                    put('d', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }}, // 2.
                new HashMap<Character, Integer>() {{
                    put('d', 3);
                    put('e', 5);
                    put(' ', 8);
                }},              // 3.
                new HashMap<Character, Integer>() {{
                    put('d', 3);
                }},                                        // 4.
                new HashMap<Character, Integer>() {{
                    put('s', 6);
                    put('d', 7);
                }},                           // 5.
                new HashMap<Character, Integer>() {{
                    put('d', 7);
                }},                                        // 6.
                new HashMap<Character, Integer>() {{
                    put('d', 7);
                    put(' ', 8);
                }},                           // 7.
                new HashMap<Character, Integer>() {{
                    put(' ', 8);
                }}                                         // 8.
        };
        int p = 0;
        char t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') t = 'd';
            else if (c == '+' || c == '-') t = 's';
            else t = c;
            if (!states[p].containsKey(t)) return false;
            p = (int) states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}

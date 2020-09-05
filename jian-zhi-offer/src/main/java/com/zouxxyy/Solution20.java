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

        HashMap<Integer, HashMap<Character, Integer>> map = new HashMap<>(9);

        HashMap<Character, Integer> map0 = new HashMap<>(4);
        map0.put(' ', 0);
        map0.put('+', 1);
        map0.put('d', 2);
        map0.put('.', 3);
        map.put(0, map0);

        HashMap<Character, Integer> map1= new HashMap<>(2);
        map1.put('d', 2);
        map1.put('.', 3);
        map.put(1, map1);

        HashMap<Character, Integer> map2= new HashMap<>(4);
        map2.put('d', 2);
        map2.put(' ', 8);
        map2.put('.', 4);
        map2.put('e', 5);
        map.put(2, map2);

        HashMap<Character, Integer> map3 = new HashMap<>(1);
        map3.put('d', 4);
        map.put(3, map3);

        HashMap<Character, Integer> map4 = new HashMap<>(3);
        map4.put('d', 4);
        map4.put(' ', 8);
        map4.put('e', 5);
        map.put(4, map4);

        HashMap<Character, Integer> map5 = new HashMap<>(2);
        map5.put('d', 7);
        map5.put('+', 6);
        map.put(5, map5);

        HashMap<Character, Integer> map6 = new HashMap<>(1);
        map6.put('d', 7);
        map.put(6, map6);

        HashMap<Character, Integer> map7 = new HashMap<>(2);
        map7.put('d', 7);
        map7.put(' ', 8);
        map.put(7, map7);

        HashMap<Character, Integer> map8 = new HashMap<>(1);
        map8.put(' ', 8);
        map.put(8, map8);

        Integer state = 0;

        for (char c : s.toCharArray()) {

            if (!map.containsKey(state)) {
                return false;
            }

            HashMap<Character, Integer> cur = map.get(state);

            if (c == ' ') {
                state = cur.get(' ');
            } else if (c >= '0' && c <= '9') {
                state = cur.get('d');
            } else if (c == '.') {
                state = cur.get('.');
            } else if (c == 'e' || c == 'E') {
                state = cur.get('e');
            } else if (c == '+' || c == '-') {
                state = cur.get('+');
            } else {
                return false;
            }
        }

        return state != null  && (state == 2 || state == 4  || state == 7 || state == 8);
    }
}

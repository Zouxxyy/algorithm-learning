package com.zouxxyy.c00;

import java.util.LinkedList;
import java.util.List;

/*
22. 括号生成

数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。


示例：

输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]
 */

/*
思路：

回溯
 */

/**
 * @author zxy
 */
public class Solution22 {

    public List<String> generateParenthesis(int n) {

        List<String> res = new LinkedList<>();

        if (n != 0) {
            dfs(res, n, 0, 0, new StringBuilder());
        }

        return res;
    }

    /**
     * @param countL 左括号个数
     * @param countR 右括号个数
     */
    private void dfs(List<String> res, int n, int countL, int countR, StringBuilder sb) {

        if (countR == n) {
            res.add(sb.toString());
            return;
        }

        if (countL < n) {
            sb.append('(');
            dfs(res, n, countL + 1, countR, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        // 只有当左括号数大于右括号数时，才能添加右括号
        if (countR < countL) {
            sb.append(')');
            dfs(res, n, countL, countR + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}

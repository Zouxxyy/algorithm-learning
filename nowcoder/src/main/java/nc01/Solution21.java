package nc01;

/*
字符串的排列

输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
示例1
输入
复制
"ab"
返回值
复制
["ab","ba"]
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution21 {

    private ArrayList<String> res;

    public ArrayList<String> Permutation(String str) {
        res = new ArrayList<>();
        if (str.length() > 0) {
            dfs(str.toCharArray(), 0);
        }
        Collections.sort(res);
        return res;
    }

    private void dfs(char[] chars, int start) {

        if (start == chars.length) {
            res.add(new String(chars));
        }

        HashSet<Character> visited = new HashSet<>();
        for (int i = start; i < chars.length; i++) {
            if (!visited.contains(chars[i])) {
                visited.add(chars[i]);
                swap(chars, start, i);
                dfs(chars, start + 1);
                swap(chars, start, i);
            }
        }

    }

    private void swap(char[] chars, int l, int r) {
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
    }

}

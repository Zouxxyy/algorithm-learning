package com.zouxxyy.c09;

/*
990. 等式方程的可满足性
给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。

只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。



示例 1：

输入：["a==b","b!=a"]
输出：false
解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
示例 2：

输入：["b==a","a==b"]
输出：true
解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
示例 3：

输入：["a==b","b==c","a==c"]
输出：true
示例 4：

输入：["a==b","b!=c","c==a"]
输出：false
示例 5：

输入：["c==c","b==d","x!=z"]
输出：true


提示：

1 <= equations.length <= 500
equations[i].length == 4
equations[i][0] 和 equations[i][3] 是小写字母
equations[i][1] 要么是 '='，要么是 '!'
equations[i][2] 是 '='
 */

/**
 * @author zxy
 */
public class Solution90 {

    public boolean equationsPossible(String[] equations) {

        int n = equations.length;
        char[][] s = new char[n][4];

        for (int i = 0; i < n; i++) {
            s[i] = equations[i].toCharArray();
        }

        FindUnion findUnion = new FindUnion(26);

        // 先满足 == 的边
        for (char[] equation : s) {
            if (equation[1] == '=') {
                findUnion.union(equation[0] - 'a', equation[3] - 'a');
            }
        }

        // 再判断 != 的边
        for (char[] equation : s) {
            if (equation[1] == '!' && findUnion.isUnion(equation[0] - 'a', equation[3] - 'a')) {
                return false;
            }
        }

        return true;
    }


    public static class FindUnion {

        private final int[] parent;
        private final int[] rank;

        public FindUnion(int n) {

            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int n) {

            if (parent[n] != n) {
                parent[n] = find(parent[n]);
            }

            return parent[n];
        }

        private void union(int x, int y) {

            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {

                if (rank[rootX] == rank[rootY]) {
                    rank[rootX]++;
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                }

            }

        }

        private boolean isUnion(int x, int y) {
            return find(x) == find(y);
        }

    }

}

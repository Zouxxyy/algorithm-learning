package com.zouxxyy.c12;

/*
1202. 交换字符串中的元素
给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。

你可以 任意多次交换 在 pairs 中任意一对索引处的字符。

返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。



示例 1:

输入：s = "dcab", pairs = [[0,3],[1,2]]
输出："bacd"
解释：
交换 s[0] 和 s[3], s = "bcad"
交换 s[1] 和 s[2], s = "bacd"
示例 2：

输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
输出："abcd"
解释：
交换 s[0] 和 s[3], s = "bcad"
交换 s[0] 和 s[2], s = "acbd"
交换 s[1] 和 s[2], s = "abcd"
示例 3：

输入：s = "cba", pairs = [[0,1],[1,2]]
输出："abc"
解释：
交换 s[0] 和 s[1], s = "bca"
交换 s[1] 和 s[2], s = "bac"
交换 s[0] 和 s[1], s = "abc"


提示：

1 <= s.length <= 10^5
0 <= pairs.length <= 10^5
0 <= pairs[i][0], pairs[i][1] < s.length
s 中只含有小写英文字母
 */

/*
思路：

把问题转化为，不同子集合（对 pair 求并集） 分别排序
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution02 {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        if (pairs.size() == 0) {
            return s;
        }

        UnionFind unionFind = new UnionFind(s.length());

        // 1、导入并查集中
        for (List<Integer> pair : pairs) {
            unionFind.union(pair.get(0), pair.get(1));
        }

        // 2、构建 map
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            int rootI = unionFind.find(i);
            map.computeIfAbsent(rootI, key -> new PriorityQueue<>()).offer(chars[i]);

        }

        // 3、重新构成字符串
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < chars.length; i++) {
            int rootI = unionFind.find(i);
            sb.append(map.get(rootI).poll());
        }

        return sb.toString();
    }

    static class UnionFind {

        private final int[] parent;
        private final int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {

            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];

        }

        public boolean union(int x, int y) {

            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return true;
            } else {
                if (rank[rootX] == rank[rootY]) {
                    parent[rootX] = parent[rootY];
                    rank[rootY]++;

                } else if (rank[rootX] > rank[rootY]){
                    parent[rootY] = parent[rootX];

                } else {
                    parent[rootX] = parent[rootY];

                }
                return false;
            }

        }

    }

}

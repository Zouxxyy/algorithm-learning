package com.zouxxyy.c09;

/*
959. 由斜杠划分区域
在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。

（请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。

返回区域的数目。



示例 1：

输入：
[
  " /",
  "/ "
]
输出：2
解释：2x2 网格如下：

示例 2：

输入：
[
  " /",
  "  "
]
输出：1
解释：2x2 网格如下：

示例 3：

输入：
[
  "\\/",
  "/\\"
]
输出：4
解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
2x2 网格如下：

示例 4：

输入：
[
  "/\\",
  "\\/"
]
输出：5
解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
2x2 网格如下：

示例 5：

输入：
[
  "//",
  "/ "
]
输出：3
解释：2x2 网格如下：



提示：

1 <= grid.length == grid[0].length <= 30
grid[i][j] 是 '/'、'\'、或 ' '。
 */

/**
 * @author zxy
 */
public class Solution59 {

    public int regionsBySlashes(String[] grid) {

        int n = grid.length;

        UnionFind unionFind = new UnionFind(4 * n * n);

        for (int i = 0; i < n; i++) {

            char[] row = grid[i].toCharArray();

            for (int j = 0; j < n; j++) {

                int index = 4 * (i * n + j);
                char c = row[j];

                // 单元格内合并
                if (c == '/') {
                    unionFind.union(index, index + 3);
                    unionFind.union(index + 1, index + 2);
                } else if (c == '\\') {
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 2, index + 3);
                } else {
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 1, index + 2);
                    unionFind.union(index + 2, index + 3);
                }

                // 单元格外合并，合并 1 号右边的格子
                if (j + 1 < n) {
                    unionFind.union(index + 1, index + 7);
                }
                // 单元格外合并，合并 2 号下边的格子
                if (i + 1 < n) {
                    unionFind.union(index + 2, index + 4 * n);
                }
            }
        }

        return unionFind.getCount();
    }

    static class UnionFind {

        private final int[] parent;
        private final int[] rank;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            count = n;
        }

        private int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {

            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] == rank[rootY]) {
                parent[rootX] = rootY;
                rank[rootY]++;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
            }

            count--;
        }

        public int getCount() {
            return count;
        }
    }

}

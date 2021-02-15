package com.zouxxyy.c07;

/*
765. 情侣牵手
N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。

人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。

这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。

示例 1:

输入: row = [0, 2, 1, 3]
输出: 1
解释: 我们只需要交换row[1]和row[2]的位置即可。
示例 2:

输入: row = [3, 2, 0, 1]
输出: 0
解释: 无需交换座位，所有的情侣都已经可以手牵手了。
说明:

len(row) 是偶数且数值在 [4, 60]范围内。
可以保证row 是序列 0...len(row)-1 的一个全排列。
 */

/*
至少交换的次数 = 所有情侣的对数 - 并查集里连通分量的个数
 */

/**
 * @author zxy
 */
public class Solution65 {

    public int minSwapsCouples(int[] row) {

        // 情侣对数
        int n = row.length / 2;
        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < row.length; i += 2) {
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }

        return n - unionFind.getCnt();
    }


    public static class UnionFind {

        private final int[] parent;
        private final int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        private int find(int x) {

            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        public boolean union(int x1, int x2) {

            int root1 = find(x1);
            int root2 = find(x2);

            if (root1 == root2) {
                return true;
            } else {

                if (rank[root1] > rank[root2]) {
                    parent[root2] = root1;
                } else if (rank[root1] < rank[root2]) {
                    parent[root1] = root2;
                } else {
                    parent[root2] = root1;
                    rank[root1]++;
                }
                return false;
            }
        }

        public int getCnt() {

            int cnt = 0;

            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i) {
                    cnt++;
                }
            }
            return cnt;
        }

    }

}

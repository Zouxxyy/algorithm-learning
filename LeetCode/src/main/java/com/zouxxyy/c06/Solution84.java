package com.zouxxyy.c06;

/*
684. 冗余连接
在本问题中, 树指的是一个连通且无环的无向图。

输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。

结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。

返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。

示例 1：

输入: [[1,2], [1,3], [2,3]]
输出: [2,3]
解释: 给定的无向图为:
  1
 / \
2 - 3
示例 2：

输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
输出: [1,4]
解释: 给定的无向图为:
5 - 1 - 2
    |   |
    4 - 3
注意:

输入的二维数组大小在 3 到 1000。
二维数组中的整数在1到N之间，其中N是输入数组的大小。
 */

import java.util.Arrays;

/**
 * @author zxy
 */
public class Solution84 {

    public int[] findRedundantConnection(int[][] edges) {

        FindUnion findUnion = new FindUnion(edges.length);

        int index = 0;

        for (int i = 0; i < edges.length; i++) {
            if (findUnion.union(edges[i][0], edges[i][1])) {
                index = i;
            }
        }

        return edges[index];
    }

    static class FindUnion {

        private final int[] parent;
        private final int[] rank;

        public FindUnion(int n) {
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(parent, -1);
        }

        private int findRoot(int x) {
            while (parent[x] != -1) {
                x = parent[x];
            }
            return x;
        }

        public boolean union(int x1, int x2) {

            int root1 = findRoot(x1);
            int root2 = findRoot(x2);

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
    }

}

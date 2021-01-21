package com.zouxxyy.c15;

/*
1584. 连接所有点的最小费用
给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。

连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。

请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。



示例 1：



输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
输出：20
解释：

我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
注意到任意两个点之间只有唯一一条路径互相到达。
示例 2：

输入：points = [[3,12],[-2,5],[-4,1]]
输出：18
示例 3：

输入：points = [[0,0],[1,1],[1,0],[-1,1]]
输出：4
示例 4：

输入：points = [[-1000000,-1000000],[1000000,1000000]]
输出：4000000
示例 5：

输入：points = [[0,0]]
输出：0


提示：

1 <= points.length <= 1000
-106 <= xi, yi <= 106
所有点 (xi, yi) 两两不同。
 */

/*
思路：

Kruskal 算法是一种常见并且好写的最小生成树算法
1、求出所有边 2、由小到大排序 3、贪心选择最小边，使用并查集判断连通性
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution84 {

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        List<Edge> edges = new ArrayList<>(n);

        // 1、求出所有边
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }

        // 2、按边长排序
        edges.sort(Comparator.comparingInt(edge -> edge.len));

        // 3、贪心 + 并查集
        DisjointSets disjointSets = new DisjointSets(n);
        int i = 1;
        int res = 0;
        for (Edge edge : edges) {

            if (disjointSets.unionSet(edge.x, edge.y)) {
                i++;
                res += edge.len;
                if (i == n) {
                    break;
                }
            }

        }

        return res;
    }


    /**
     * 并查集
     */
    static class DisjointSets {

        private final int[] f;
        private final int[] rank;

        public DisjointSets(int n) {
            f = new int[n];
            rank = new int[n];
            Arrays.fill(f, -1);
        }

        private int find(int n) {
            while (f[n] != -1) {
                n = f[n];
            }
            return n;
        }

        public boolean unionSet(int x, int y) {

            int fx = find(x);
            int fy = find(y);

            if (fx == fy) {
                return false;
            }

            if (rank[fx] > rank[fy]) {
                f[fy] = fx;
            } else if (rank[fx] < rank[fy]) {
                f[fx] = fy;
            } else {
                f[fy] = fx;
                rank[fx]++;
            }

            return true;
        }

    }


    /**
     * 边
     * x 和 y 是边的 index
     */
    static class Edge {

        public int x;
        public int y;
        public int len;

        public Edge(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }

    }

}

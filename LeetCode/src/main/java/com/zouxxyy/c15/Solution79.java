package com.zouxxyy.c15;

/*
1579. 保证图可完全遍历
Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3  种类型的边：

类型 1：只能由 Alice 遍历。
类型 2：只能由 Bob 遍历。
类型 3：Alice 和 Bob 都可以遍历。
给你一个数组 edges ，其中 edges[i] = [typei, ui, vi] 表示节点 ui 和 vi 之间存在类型为 typei 的双向边。请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图是可以完全遍历的。

返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。



示例 1：



输入：n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
输出：2
解释：如果删除 [1,1,2] 和 [1,1,3] 这两条边，Alice 和 Bob 仍然可以完全遍历这个图。再删除任何其他的边都无法保证图可以完全遍历。所以可以删除的最大边数是 2 。
示例 2：



输入：n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
输出：0
解释：注意，删除任何一条边都会使 Alice 和 Bob 无法完全遍历这个图。
示例 3：



输入：n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
输出：-1
解释：在当前图中，Alice 无法从其他节点到达节点 4 。类似地，Bob 也不能达到节点 1 。因此，图无法完全遍历。


提示：

1 <= n <= 10^5
1 <= edges.length <= min(10^5, 3 * n * (n-1) / 2)
edges[i].length == 3
1 <= edges[i][0] <= 3
1 <= edges[i][1] < edges[i][2] <= n
所有元组 (typei, ui, vi) 互不相同
 */

/**
 * @author zxy
 */
public class Solution79 {

    public int maxNumEdgesToRemove(int n, int[][] edges) {

        int toRemove = 0;

        // 先处理公共边
        UnionFind unionFind1 = new UnionFind(n);
        for (int[] edge : edges) {
            if (edge[0] == 3 && unionFind1.union(edge[1] - 1, edge[2] - 1)) {
                toRemove++;
            }
        }

        // 再处理各自的
        UnionFind unionFind2 = new UnionFind(unionFind1.parent, unionFind1.rank, unionFind1.cnt);
        for (int[] edge : edges) {
            if (edge[0] == 1 && unionFind1.union(edge[1] - 1, edge[2] - 1)) {
                toRemove++;
            }
            if (edge[0] == 2 && unionFind2.union(edge[1] - 1, edge[2] - 1)) {
                toRemove++;
            }
        }

        return unionFind1.cnt != n || unionFind2.cnt != n ? -1 : toRemove;
    }

    public static class UnionFind {

        public final int[] parent;
        public final int[] rank;
        public int cnt = 1;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public UnionFind(int[] parent, int[] rank, int cnt) {
            this.parent = parent.clone();
            this.rank = rank.clone();
            this.cnt = cnt;
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
                cnt++;
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
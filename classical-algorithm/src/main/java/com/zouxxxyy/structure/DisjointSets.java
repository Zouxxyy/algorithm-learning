package com.zouxxxyy.structure;

/*
并查集

树型的数据结构，用于处理一些不交集（Disjoint Sets）的合并及查询问题。

有一个联合-查找算法（Union-find Algorithm）定义了两个用于此数据结构的操作：
Find：确定元素属于哪一个子集。它可以被用来确定两个元素是否属于同一子集。
Union：将两个子集合并成同一个集合。
由于支持这两种操作，一个不相交集也常被称为联合-查找数据结构（Union-find Data Structure）或合并-查找集合（Merge-find Set）。

功能：
判断两个对象 是否在一个组里
对 对象 进行分组（同一个组并集），并且同一个组内拥有一样的组号

经典例题：
947. 移除最多的同行或同列石头
1584. 连接所有点的最小费用
1202. 交换字符串中的元素
 */

/**
 * @author zxy
 */
public class DisjointSets {

    private final int[] parent;
    private final int[] rank;

    public DisjointSets(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    /**
     * 返回 root，如果没有，返回本身
     */
    private int find(int x) {

        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }


    /**
     * 把两个数放到一个集合，如果两个数之前不在一个集合，返回 false；否则返回 true
     */
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


    public static void main(String[] args) {

        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 4}};

        DisjointSets set = new DisjointSets(6);

        for (int[] edge : edges) {
            boolean isUnion = set.union(edge[0], edge[1]);
            if (isUnion) {
                System.out.println("存在环");
            }
        }

    }

}

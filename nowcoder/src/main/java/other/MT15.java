package other;

/*
美团面试真题：MT15 病毒传播

题目描述
给出一个图G(V,E)，图上有n个点，m条边，所有的边都是无向边。

最开始，也就是第0天的时候，这n个点中有一个点v感染了病毒，之后的每一天，凡是感染病毒的点都会向它的邻居点传播病毒。
经过了t天之后，得到了感染病毒的点集S。要求找出第0天感染病毒的点v。如果v有很多不同的答案，把它们都找出来。

输入描述:
第一行两个数n，m，接下来有m行，每行两个数u，v，表示点u，v之间有一条无向边。接下来一行两个数k，t，其中k表示集合S的大小。最后一行k个数，集合S中的元素。
输入的图可能有自环和重边，输入保证S中的数互不相同。（1≤n≤103,0≤m≤103,1≤t≤109,1≤u,v,k≤n,S中所有元素在区间[1,n]）

输出描述:
输出一行，如果不存在这样的v，输出-1。
否则输出所有可能的v，按照从小到大的顺序输出，数字之间用空格隔开，不要在行末输出多余的空格。
示例1
输入
复制
4 3
3 2
1 2
1 4
3 2
4 2 1
输出
复制
4
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author zxy
 *
 * 图 bfs 模拟
 */
public class MT15 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();

        // 构建图，点的范围在 [1:n]
        HashSet<Integer>[] edges = new HashSet[n + 1];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new HashSet<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            // 去自环
            if (a != b) {
                edges[a].add(b);
                edges[b].add(a);
            }
        }

        // 填充 infection 集合
        int k = sc.nextInt(), t = sc.nextInt();
        HashSet<Integer> infection = new HashSet<>();
        for (int i = 0; i < k; i++) {
            infection.add(sc.nextInt());
        }

        // bfs 找起点
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (bfs(edges, t, infection, i)) {
                res.add(i);
            }
        }

        // 输出
        if (res.size() == 0) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < res.size() - 1; i++) {
                System.out.print(res.get(i));
                System.out.print(' ');
            }
            System.out.print(res.get(res.size() - 1));
        }

    }

    /**
     * 层序遍历
     */
    private static boolean bfs(HashSet<Integer>[] edges, int t, HashSet<Integer> infection, int start) {

        HashSet<Integer> visited = new HashSet<>();

        LinkedList<Integer> queue = new LinkedList<>();
        if (infection.contains(start)) {
            queue.offer(start);
            visited.add(start);
        }

        int days = 0;
        while (!queue.isEmpty()) {

            for (int i = queue.size(); i > 0; i--) {
                Integer poll = queue.poll();
                for (Integer next : edges[poll]) {
                    if (!infection.contains(next)) {
                        return false;
                    } else if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            if (++days == t) {
                break;
            }
        }

        return visited.size() == infection.size();
    }

}

package nc00;

/*
出现次数的TopK问题

题目描述
给定String类型的数组strArr，再给定整数k，请严格按照排名顺序打印 出次数前k名的字符串。
[要求]
如果strArr长度为N，时间复杂度请达到O(N \log K)O(NlogK)

输出K行，每行有一个字符串和一个整数（字符串表示）。
你需要按照出现出现次数由大到小输出，若出现次数相同时字符串字典序较小的优先输出

示例1
输入
复制
["1","2","3","4"],2
返回值
复制
[["1","1"],["2","1"]]
示例2
输入
复制
["1","1","2","3"],2
返回值
复制
[["1","2"],["2","1"]]
备注:
1 \leq N \leq 10^51≤N≤10
5
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution97 {

    /**
     * return topK string
     *
     * @param strings string字符串一维数组 strings
     * @param k       int整型 the k
     * @return string字符串二维数组
     */
    public String[][] topKstrings(String[] strings, int k) {
        // write code here
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : strings) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        Comparator<String> comparator = (o1, o2) -> {
            int c1 = map.get(o1), c2 = map.get(o2);
            if (c1 != c2) {
                return c1 - c2;
            } else {
                return o2.compareTo(o1);
            }
        };

        // 小根堆
        PriorityQueue<String> pq = new PriorityQueue<>(comparator);

        for (String s : map.keySet()) {
            pq.offer(s);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        String[][] res = new String[k][2];

        int i = k - 1;
        while (!pq.isEmpty()) {
            res[i][0] = pq.poll();
            res[i][1] = String.valueOf(map.get(res[i][0]));
            i--;
        }

        return res;
    }

}

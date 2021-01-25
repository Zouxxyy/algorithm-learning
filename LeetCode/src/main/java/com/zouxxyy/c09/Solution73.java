package com.zouxxyy.c09;

import java.util.*;

/**
 * @author zxy
 */
public class Solution73 {

    public int[][] kClosest(int[][] points, int K) {

        // pq 里的 元素，[平方和，原数组坐标]，注意是大根堆
        PriorityQueue<int[]> pq = new PriorityQueue<>(K, (o1, o2) -> o2[0] - o1[0]);

        for (int i = 0; i < points.length; i++) {

            int sum = points[i][0] * points[i][0] + points[i][1] * points[i][1];

            if (i < K) {
                pq.offer(new int[]{sum, i});
            } else if (pq.peek()[0] > sum) {
                pq.poll();
                pq.offer(new int[]{sum, i});
            }
        }

        int[][] res = new int[K][2];

        for (int i = 0; i < K; i++) {
            res[i] = points[pq.poll()[1]];
        }

        return res;
    }

}

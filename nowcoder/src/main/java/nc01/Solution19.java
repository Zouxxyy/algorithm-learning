package nc01;

/*
题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
示例1
输入
复制
[4,5,1,6,2,7,3,8],4
返回值
复制
[1,2,3,4]
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution19 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> res = new ArrayList<>();
        if (input.length < k || k == 0) {
            return res;
        }

        // 大根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int num : input) {
            if (pq.size() < k) {
                pq.offer(num);
            } else {
                if (pq.peek() > num) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }

        res.addAll(pq);
        return res;
    }

}

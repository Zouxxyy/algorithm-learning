package com.zouxxyy.c00;

import java.util.*;

/*
思路：

寻找 k 个数的极值，使用优先队列
 */

/**
 * @author zxy
 */
public class Solution23 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {

        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        // 优先队列，输出最小元素
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        // 添加元素
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        while (!pq.isEmpty()) {

            ListNode poll = pq.poll();
            cur.next = poll;
            cur = cur.next;

            // 保证添加的节点非空

            if (poll.next != null) {
                pq.add(poll.next);
            }

        }

        return pre.next;

    }

}

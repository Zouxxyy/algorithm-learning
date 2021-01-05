package com.zouxxyy.c01;

/*
143. 重排链表
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:

给定链表 1->2->3->4, 重新排列为 1->4->2->3.
示例 2:

给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution43 {

    private static class ListNode {
        int val;
        ListNode next;
    }

    public void reorderList(ListNode head) {

        if (head == null) {
            return;
        }

        // 快慢指针找中点
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

        }

        ListNode mid = slow;

        Deque<ListNode> stack = new LinkedList<>();

        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        ListNode cur = head;

        while (cur != mid) {
            ListNode pop = stack.pop();
            pop.next = cur.next;
            cur.next = pop;
            cur = pop.next;
        }

        if (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur.next.next = null;
        } else {
            cur.next = null;
        }

    }

}

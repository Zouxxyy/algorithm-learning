package com.zouxxyy.algorithm.cig.chap2.example04;

import com.zouxxyy.algorithm.cig.chap2.example01.DoubleNode;
import com.zouxxyy.algorithm.cig.chap2.example01.Node;

/**
 * 反转单向和双向链表（难度1）
 * @version 1.00 2019-04-09
 * @author zouxxyy
 */
public class Solution {
    public static Node reverseList(Node head) {
        Node cur = head;
        Node newHead = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }

    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode cur = head;
        DoubleNode newHead = null;
        while (cur != null) {
            DoubleNode next = cur.next;
            cur.next = newHead;
            cur.last = next;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }
}

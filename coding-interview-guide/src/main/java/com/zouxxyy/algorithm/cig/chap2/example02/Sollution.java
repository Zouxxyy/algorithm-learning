package com.zouxxyy.algorithm.cig.chap2.example02;

import com.zouxxyy.algorithm.cig.chap2.example01.DoubleNode;
import com.zouxxyy.algorithm.cig.chap2.example01.Node;

/**
 * 在单链表和双链表中删除倒数第k个节点（难度1）
 * @version 1.00 2019-04-04
 * @author zouxxyy
 */
public class Sollution {
    public static Node removeNthFromEnd(Node head, int n) {
        int nn = 0;
        Node cur = head;
        if(head.next == null && n == 1) return null;
        while (cur.next != null){
            nn++;
            cur = cur.next;
        }
        cur = head;
        nn = nn - n;
        while (nn > 0){
            nn--;
            cur = cur.next;
        }

        if(nn == -1)
            head = cur.next;
        else
            cur.next = cur.next.next;
        return head;
    }

    public static DoubleNode removeNthFromEnd(DoubleNode head, int n) {
        int nn = 0;
        DoubleNode cur = head;
        if(head.next == null && n == 1) return null;
        while (cur.next != null){
            nn++;
            cur = cur.next;
        }
        cur = head;
        nn = nn - n;
        while (nn > 0){
            nn--;
            cur = cur.next;
        }
        // nn = -1时，删除第一个节点
        if(nn == -1) {
            head = cur.next;
            head.last = null;
        }
        else{
            cur.next = cur.next.next;
            if(cur.next != null)
                cur.next.last = cur;
        }
        return head;
    }
}
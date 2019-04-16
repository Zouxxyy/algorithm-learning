package com.zouxxyy.algorithm.cig.chap2.example04;

import com.zouxxyy.algorithm.cig.chap2.example01.DoubleNode;
import com.zouxxyy.algorithm.cig.chap2.example01.Node;

public class Test {
    public static void main(String[] args) {
        DoubleNode head = new DoubleNode(1);
        DoubleNode cur = head;
        DoubleNode temp;
        cur.next = new DoubleNode(2); temp = cur; cur = cur.next; cur.last = temp;
        cur.next = new DoubleNode(3); temp = cur; cur = cur.next; cur.last = temp;
        cur.next = new DoubleNode(4); temp = cur; cur = cur.next; cur.last = temp;
        cur.next = new DoubleNode(5); temp = cur; cur = cur.next; cur.last = temp;
        cur.next = new DoubleNode(6); temp = cur; cur = cur.next; cur.last = temp;

        cur = head;
        System.out.println("原链表");
        while (cur != null) {
            System.out.print(cur.value + "->");
            cur = cur.next;
        }

        System.out.println();
        System.out.println("反转链表");
        cur = Solution.reverseList(head);
        while (cur != null) {
            System.out.print(cur.value + "->");
            cur = cur.next;
        }
    }
}

/*
原链表
1->2->3->4->5->6->
反转链表
6->5->4->3->2->1->
 */
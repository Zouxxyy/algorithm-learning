package com.zouxxyy.algorithm.cig.chap2.example03;

import com.zouxxyy.algorithm.cig.chap2.example01.Node;

public class Test {
    public static void main(String[] args) {
        Node head = new Node(5);
        Node cur = head;
        cur.next = new Node(12); cur = cur.next;
        cur.next = new Node(61); cur = cur.next;
        cur.next = new Node(32); cur = cur.next;
        cur.next = new Node(16); cur = cur.next;
        cur.next = new Node(92); //cur = cur.next;
        //cur.next = new Node(11);

        cur = head;
        System.out.println("原链表");
        while (cur != null) {
            System.out.print(cur.value + "->");
            cur = cur.next;
        }

        System.out.println();
        System.out.println("删除中间的元素");
        cur = Solution.removeMidNode(head);
        while (cur != null) {
            System.out.print(cur.value + "->");
            cur = cur.next;
        }

        System.out.println();
        System.out.println("删除位于2/7的元素");
        cur = Solution.removeByRatio(head, 2, 7);
        while (cur != null) {
            System.out.print(cur.value + "->");
            cur = cur.next;
        }
    }
}

/*
原链表
5->12->61->32->16->92->
删除中间的元素
5->12->32->16->92->
删除位于2/7的元素
5->32->16->92->
 */
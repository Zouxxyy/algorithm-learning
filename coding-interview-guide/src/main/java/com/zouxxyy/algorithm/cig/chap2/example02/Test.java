package com.zouxxyy.algorithm.cig.chap2.example02;

import com.zouxxyy.algorithm.cig.chap2.example01.Node;

public class Test {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node cur = head;
        cur.next = new Node(2); cur = cur.next;
        cur.next = new Node(5); cur = cur.next;
        cur.next = new Node(6); cur = cur.next;
        cur.next = new Node(12); cur = cur.next;
        cur.next = new Node(9); cur = cur.next;
        cur.next = new Node(11);

        cur = head;
        while (cur != null) {
            System.out.print(cur.value + "->");
            cur = cur.next;
        }

        int n = 7;
        System.out.println();
        System.out.println("删除倒数第 " + n + " 节点");
        cur = Sollution.removeNthFromEnd(head, n);
        while (cur != null) {
            System.out.print(cur.value + "->");
            cur = cur.next;
        }
    }
}

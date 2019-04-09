package com.zouxxyy.algorithm.cig.chap2.example01;

public class Test {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node cur = head1;
        cur.next = new Node(3); cur = cur.next;
        cur.next = new Node(5); cur = cur.next;
        cur.next = new Node(5); cur = cur.next;
        cur.next = new Node(6); cur = cur.next;
        cur.next = new Node(9); cur = cur.next;
        cur.next = new Node(11);

        Node head2 = new Node(3);
        cur = head2;
        cur.next = new Node(1); cur = cur.next;
        cur.next = new Node(5); cur = cur.next;
        cur.next = new Node(5); cur = cur.next;
        cur.next = new Node(5); cur = cur.next;
        cur.next = new Node(9); cur = cur.next;
        cur.next = new Node(12);

        PrintCommon.printCommon(head1, head2);
    }
}

/*
common: 3
common: 5
common: 5
common: 9
 */
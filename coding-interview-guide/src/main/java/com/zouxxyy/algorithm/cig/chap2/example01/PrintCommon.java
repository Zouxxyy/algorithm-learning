package com.zouxxyy.algorithm.cig.chap2.example01;

/**
 * 打印两个有序链表的公共部分（难度1）
 * @version 1.00 2019-04-04
 * @author zouxxyy
 */
public class PrintCommon {
    public static void printCommon(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if(head1.value < head2.value)
                head1 = head1.next;
            else if(head1.value > head2.value)
                head2 = head2.next;
            else {
                System.out.println("common: " + head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}

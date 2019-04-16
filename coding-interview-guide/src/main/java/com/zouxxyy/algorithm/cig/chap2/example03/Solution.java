package com.zouxxyy.algorithm.cig.chap2.example03;

import com.zouxxyy.algorithm.cig.chap2.example01.Node;

/**
 * 删除链表的中间节点和a/b处的节点（难度1）
 * @version 1.00 2019-04-09
 * @author zouxxyy
 */
public class Solution {
    public static Node removeMidNode(Node head) {
        if(head == null || head.next == null) return null;
        Node cur = head;
        int n = 0;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        n = n % 2 == 0 ? n / 2 : (n + 1) / 2;
        cur = head;
        if(n == 1) head = cur.next;
        else {
            while (n > 2) {
                cur = cur.next;
                n--;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static Node removeByRatio(Node head, int a, int b) {
        if(a < 1 || a > b) return head;
        Node cur = head;
        int n = 0;
        while (cur != null) {
            cur = cur.next;
            n++;
        }

        // 计算要删除的位置
        n = (int) Math.ceil((double)(a * n) / (double) b);
        cur = head;
        if (n == 1) head = cur.next;
        else {
            while (n > 2) {
                cur = cur.next;
                n--;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}

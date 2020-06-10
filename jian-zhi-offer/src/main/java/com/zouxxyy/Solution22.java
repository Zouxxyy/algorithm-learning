/*
面试题22. 链表中倒数第k个节点

输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

 

示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.

 */

/*
笔记：

快慢指针
 */

package com.zouxxyy;

public class Solution22 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 普通解法
//    public ListNode getKthFromEnd(ListNode head, int k) {
//
//        int n = 0;
//        ListNode cur = head;
//        while (cur != null) {
//            n++;
//            cur = cur.next;
//        }
//
//        n = n - k;
//        while (n > 0) {
//            n--;
//            head = head.next;
//        }
//        return head;
//    }

    // 使用快慢双指针
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode fast = head, slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

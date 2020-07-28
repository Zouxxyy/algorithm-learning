package com.zouxxyy.c00;

/*
2. 两数相加

给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

 */

/*
思路：

直接按加再考虑进位。切莫计算原来的数(会爆int)
 */

/**
 * @author zxy
 */
public class Solution02 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // head 的前一个，用于取 head
        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        // 是否需要进位
        boolean carry = false;

        while (l1 != null || l2 != null || carry) {

            int i1 = 0, i2 = 0;

            if (l1 != null) {
                i1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                i2 = l2.val;
                l2 = l2.next;
            }

            int sum = i1 + i2 + (carry ? 1 : 0);

            carry = sum > 9;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }

        return pre.next;
    }
}

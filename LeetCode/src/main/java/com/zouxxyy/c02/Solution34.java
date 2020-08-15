package com.zouxxyy.c02;

/*
234. 回文链表
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */

/*
思路：

双指针 + 反转前半部分
 */


/**
 * @author zxy
 */
public class Solution34 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public boolean isPalindrome(ListNode head) {

        // 1. 找到中点，并转置前半部分
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }

        // 2. 奇偶会对中点产生差异，进行微调
        if (fast != null) {
            slow = slow.next;
        }

        // 3. pre 是左半的起点，slow 是右半的起点，一直比较即可
        while (pre != null) {

            if (slow.val != pre.val) {
                return false;
            }

            slow = slow.next;
            pre = pre.next;
        }

        return true;
    }

}

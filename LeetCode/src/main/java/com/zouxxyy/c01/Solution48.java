package com.zouxxyy.c01;

/*
148. 排序链表
在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4
示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5
 */

/*
思路：

从题目要求 O(n log n) 时间复杂度分析，满足的排序方法有归并、快排、堆。
快排要频繁使用arr[r--]，堆排序需要各种找节点。这俩在链表用起来都比较麻烦。
归并排序只需要计算出中点，相对较简单，因此选用归并
 */

/**
 * @author zxy
 */
public class Solution48 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // 用快慢指针找到链表的中点
        // 让fast先走2格（1格也可以），这样计算后的 slow 是往左靠的：
        // 假如一共3个数，计算后slow指向第1个数（fast先走1格时指向第2个数）；如果一共4个数，slow指向第2个数
        ListNode fast = head.next.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 左靠的好处在这里体现，可以用slow.next作mid，并置空（此时保证了一共4个数时，mid指向第3个数）
        ListNode mid = slow.next;
        slow.next = null;

        // 归并排序
        return merge(sortList(head), sortList(mid));
    }


    /**
     * 合并两个有序链表
     */
    private ListNode merge(ListNode left, ListNode right) {

        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        cur.next = left == null ? right : left;

        return pre.next;
    }


}

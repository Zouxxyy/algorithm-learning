/*
面试题52. 两个链表的第一个公共节点

输入两个链表，找出它们的第一个公共节点。
 */

/*
笔记：

你变成我，走过我走过的路。
我变成你，走过你走过的路。
然后我们便相遇了..

A -> B
B -> A 相遇 null

A -> C -> B
B -> C -> A 相遇 C
 */

package com.zouxxyy;

import java.util.HashSet;

public class Solution52 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 看答案前的解法
    public ListNode getIntersectionNodeOld(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            set.add(curA);
            curA = curA.next;
        }
        while (curB != null) {
            if (set.contains(curB)) return curB;
            curB = curB.next;
        }
        return null;
    }

    // 浪漫相遇，爱了爱了
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            if (curA == null) curA = headB;
            else curA = curA.next;
            if (curB == null) curB = headA;
            else curB = curB.next;
        }
        return curA;
    }
}

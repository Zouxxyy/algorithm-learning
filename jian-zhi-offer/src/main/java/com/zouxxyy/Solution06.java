/*
面试题06. 从尾到头打印链表

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

 

示例 1：

输入：head = [1,3,2]
输出：[2,3,1]
 

限制：

0 <= 链表长度 <= 10000

 */

package com.zouxxyy;

import java.util.ArrayList;

public class Solution06 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {

        if (head == null) return new int[0];

        ArrayList<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int n = list.size();
        int[] ints = new int[n];

        for (int i = 0; i < n; i++) {
            ints[i] = list.get(n - i - 1);
        }
        return ints;
    }
}

package com.zouxxyy.c01;

/*
142. 环形链表 II
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

说明：不允许修改给定的链表。



示例 1：

输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。


示例 2：

输入：head = [1,2], pos = 0
输出：tail connects to node index 0
解释：链表中有一个环，其尾部连接到第一个节点。


示例 3：

输入：head = [1], pos = -1
输出：no cycle
解释：链表中没有环。



进阶：
你是否可以不用额外空间解决此题？
 */

/*
思路：

先用双指针找到相遇节点，再让其中一个节点变成头节点，一起移动，相遇时就是环的起点

假设 起点 到 环起点 的距离是 L，环起点 到 第一次相遇位置 的距离是 C，环长度为 R
相遇时慢指针走了 L + C + nR，快指针走了 L + C + kR
快指针速度是慢指针的两倍，所以2L + 2C + 2nR = L + C + kR
即 L + C = mR，因此从第一次相遇位置出发，再走 L 距离一定会到环起点。

这个距离L，可以通过把其中一个指针指向头，另一个还是在相遇位置，然后俩指针一起走，直到相遇即可
 */

/**
 * @author zxy
 */
public class Solution42 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }

        return null;
    }
}

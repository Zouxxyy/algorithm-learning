package nc00;

/*
判断一个链表是否为回文结构

给定一个链表，请判断该链表是否为回文结构。
示例1
输入
复制
[1,2,2,1]
返回值
复制
true
备注:
1 \leq n \leq 10^61≤n≤10
6
 */

/**
 * @author zxy
 */
public class Solution96 {

    public class ListNode {
        int val;
        ListNode next = null;
    }

    /**
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail(ListNode head) {
        // write code here

        // 寻找中点
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 反转链表
        ListNode pre = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }

        // 比较
        while (pre != null) {
            if (pre.val == head.val) {
                pre = pre.next;
                head = head.next;
            } else {
                return false;
            }
        }

        return true;

    }

}

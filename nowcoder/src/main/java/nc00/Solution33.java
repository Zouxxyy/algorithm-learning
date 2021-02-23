package nc00;

/*
将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的，且合并后新链表依然有序。

示例1
输入
复制
{1},{2}
返回值
复制
{1,2}
示例2
输入
复制
{2},{1}
返回值
复制
{1,2}
 */

/**
 * @author zxy
 */
public class Solution33 {

    public static class ListNode {
        int val;
        ListNode next = null;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        ListNode pre = new ListNode();
        ListNode cur = pre;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return pre.next;
    }

}

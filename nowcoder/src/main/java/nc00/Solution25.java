package nc00;

/*
删除有序链表中重复的元素

题目描述
删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
例如：
给出的链表为1\to1\to21→1→2,返回1 \to 21→2.
给出的链表为1\to1\to 2 \to 3 \to 31→1→2→3→3,返回1\to 2 \to 31→2→3.

示例1
输入
复制
{1,1,2}
返回值
复制
{1,2}
 */

/**
 * @author zxy
 */
public class Solution25 {

    public static class ListNode {

        int val;
        ListNode next = null;

    }

    public ListNode deleteDuplicates(ListNode head) {
        // write code here

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}

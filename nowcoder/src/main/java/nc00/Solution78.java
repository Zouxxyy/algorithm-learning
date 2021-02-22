package nc00;

/*
题目描述
输入一个链表，反转链表后，输出新链表的表头。
示例1
输入
复制
{1,2,3}
返回值
复制
{3,2,1}
 */

/**
 * @author zxy
 */
public class Solution78 {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode ReverseList(ListNode head) {

        ListNode last = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = last;
            last = cur;
            cur = temp;
        }

        return last;
    }

}

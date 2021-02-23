package nc00;

/*
两个链表的第一个公共结点

输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */

/**
 * @author zxy
 */
public class Solution66 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        // 浪漫相遇
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;

        while (cur1 != cur2) {

            cur1 = cur1 == null ? pHead2 : cur1.next;
            cur2 = cur2 == null ? pHead1 : cur2.next;

        }

        return cur1;
    }

}

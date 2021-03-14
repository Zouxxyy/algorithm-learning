package nc00;

/*
链表内指定区间反转

将一个链表\ m m 位置到\ n n 位置之间的区间反转，要求时间复杂度 ，空间复杂度 。
例如：
给出的链表为 1\to 2 \to 3 \to 4 \to 5 \to NULL1→2→3→4→5→NULL, ，,
返回 1\to 4\to 3\to 2\to 5\to NULL1→4→3→2→5→NULL.
注意：
给出的 满足以下条件：
1 \leq m \leq n \leq 链表长度1≤m≤n≤链表长度
示例1
输入
复制
{1,2,3,4,5},2,4
返回值
复制
{1,4,3,2,5}
 */

/**
 * @author zxy
 */
public class Solution21 {


    public class ListNode {
        int val;
        ListNode next = null;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;

        for (int i = 0; i < m - 1; i++) {
            cur = cur.next;
        }
        ListNode pre = cur;
        ListNode l = cur.next;

        for (int i = m - 1; i < n - 1; i++) {
            cur = cur.next;
        }
        ListNode r = cur.next;
        ListNode end = r.next;

        ListNode[] reverse = reverse(l, r);
        pre.next = reverse[0];
        reverse[1].next = end;
        return dummyHead.next;
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {

        ListNode pre = null;
        ListNode oldHead = head;
        while (pre != tail) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return new ListNode[]{tail, oldHead};
    }

}

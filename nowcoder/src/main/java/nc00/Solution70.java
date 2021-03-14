package nc00;

/*
单链表的排序

给定一个无序单链表，实现单链表的排序(按升序排序)。
示例1
输入
复制
[1,3,2,4,5]
返回值
复制
{1,2,3,4,5}
 */

/**
 * @author zxy
 */
public class Solution70 {

    public class ListNode {
        int val;
        ListNode next = null;
    }

    /**
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList(ListNode head) {

        // write code here
        if (head == null || head.next == null) {
            return head;
        }

        // 使用快慢指针找中点
        ListNode fast = head.next.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        return merge(sortInList(head), sortInList(mid));
    }

    /**
     * 合并有序链表
     */
    private ListNode merge(ListNode l, ListNode r) {

        ListNode pre = new ListNode();
        ListNode cur = pre;

        while (l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }

        cur.next = l == null ? r : l;
        return pre.next;
    }

}

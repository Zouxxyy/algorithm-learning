package nc00;

/*
重排链表

题目描述
将给定的单链表\ L L： L_0→L_1→…→L_{n-1}→L_ nL
0
​
 →L
1
​
 →…→L
n−1
​
 →L
n
​

重新排序为：L_0→L_n →L_1→L_{n-1}→L_2→L_{n-2}→…L
0
​
 →L
n
​
 →L
1
​
 →L
n−1
​
 →L
2
​
 →L
n−2
​
 →…
要求使用原地算法，不能只改变节点内部的值，需要对实际的节点进行交换。
例如：
对于给定的单链表{10,20,30,40}，将其重新排序为{10,40,20,30}.
 */


/**
 * @author zxy
 */
public class Solution02 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // 1. 找到中点
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 翻转链表
        ListNode cur = slow;
        ListNode last = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = last;
            last = cur;
            cur = temp;
        }

        // 3. 合并链表
        cur = new ListNode(0);
        while (head != slow || last != null) {
            if (head != slow) {
                cur.next = head;
                head = head.next;
                cur = cur.next;
            }
            if (last != null) {
                cur.next = last;
                last = last.next;
                cur = cur.next;
            }
        }

    }

}

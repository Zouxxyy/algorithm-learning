package nc00;

/*
合并\ k k 个已排序的链表并将其作为一个已排序的链表返回。分析并描述其复杂度。
示例1
输入
复制
[{1,2,3},{4,5,6,7}]
返回值
复制
{1,2,3,4,5,6,7}
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution51 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            if (poll.next != null) {
                pq.offer(poll.next);
            }
            cur.next = poll;
            cur = cur.next;
        }

        return pre.next;
    }

}

package nc00;

/*
将给出的链表中的节点每\ k k 个一组翻转，返回翻转后的链表
如果链表中的节点数不是\ k k 的倍数，将最后剩下的节点保持原样
你不能更改节点中的值，只能更改节点本身。
要求空间复杂度 \ O(1) O(1)
例如：
给定的链表是1\to2\to3\to4\to51→2→3→4→5
对于 \ k = 2 k=2, 你应该返回 2\to 1\to 4\to 3\to 52→1→4→3→5
对于 \ k = 3 k=3, 你应该返回 3\to2 \to1 \to 4\to 53→2→1→4→5

示例1
输入
复制
{1,2,3,4,5},2
返回值
复制
{2,1,4,3,5}
 */

/**
 * @author zxy
 */
public class Solution50 {


    public class ListNode {
        int val;
        ListNode next = null;
    }

    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        // pre -> head -> x -> tail -> end
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;

        while (head != null) {

            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummyHead.next;
                }
            }
            ListNode end = tail.next;
            ListNode[] reverse = reverser(head, tail);
            pre.next = reverse[0];
            reverse[1].next = end;
            pre = reverse[1];
            head = end;
        }

        return dummyHead.next;
    }

    private ListNode[] reverser(ListNode head, ListNode tail) {

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

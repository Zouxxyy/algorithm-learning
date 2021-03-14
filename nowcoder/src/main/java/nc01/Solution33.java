package nc01;

/*
题目描述
给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
注意是节点的编号而非节点的数值。

示例1
输入
复制
{1,2,3,4,5,6}
返回值
复制
{1,3,5,2,4,6}
示例2
输入
复制
{1,4,6,3,7}
返回值
复制
{1,6,7,4,3}
说明
奇数节点有1,6,7，偶数节点有4,3。重排后为1,6,7,4,3
备注:
链表长度不大于200000。每个数范围均在int内。
 */

/**
 * @author zxy
 */
public class Solution33 {

    public class ListNode {
        int val;
        ListNode next = null;
    }

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head, evenStart = head.next, even = evenStart;

        // 1 -> 2   1 -> 2 -> 3
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenStart;
        return head;
    }

}

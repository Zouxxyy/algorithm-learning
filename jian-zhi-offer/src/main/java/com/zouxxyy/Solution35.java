/*
面试题35. 复杂链表的复制

请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。

 

示例 1：



输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
示例 2：



输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
示例 3：



输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
示例 4：

输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。
 

提示：

-10000 <= Node.val <= 10000
Node.random 为空（null）或指向链表中的节点。
节点数目不超过 1000 。

 */

/*
笔记：

我觉得这题还是很有意思的，两种解法都很神奇

解法一：
使用 dfs 遍历图，将 copy 放入 hashMap，用于检验是否 visit 和 copy

解法二：
1. A -> B -> C 变成 A -> A1 -> B -> B1 -> C -> C1
2. 连接random
2. 分开，由于答案会检测是否改动原链表，所以分开不要忘记同时修复原链表
 */

package com.zouxxyy;

import java.util.HashMap;

public class Solution35 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // 解法一：dfs
    public Node copyRandomListOld(Node head) {
        HashMap<Node, Node> hashMap = new HashMap<>();
        return dfs(head, hashMap);
    }

    public Node dfs(Node node, HashMap<Node, Node> hashMap) {
        if (node == null) return null;
        if (hashMap.containsKey(node)) {
            return hashMap.get(node);
        } else {
            Node copy = new Node(node.val);
            hashMap.put(node, copy);
            copy.next = dfs(node.next, hashMap);
            copy.random = dfs(node.random, hashMap);
            return copy;
        }
    }

    // 解法二：A -> B -> C 变成 A -> A1 -> B -> B1 -> C -> C1
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node temp = cur.next;
            Node node = new Node(cur.val);
            cur.next = node;
            node.next = temp;
            cur = temp;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node res = head.next;
        while (cur != null) {
            Node temp = cur.next.next;
            if (cur.next.next != null) cur.next.next = cur.next.next.next;
            cur.next = temp;
            cur = cur.next;
        }
        return res;
    }
}

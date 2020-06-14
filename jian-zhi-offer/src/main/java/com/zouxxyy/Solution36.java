/*
面试题36. 二叉搜索树与双向链表

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
要求不能创建任何新的节点，只能调整树中节点指针的指向。

特别地，我们希望可以就地完成转换操作。
当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 */

package com.zouxxyy;

public class Solution36 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node[] res = dfs(root);
        res[0].left = res[1];
        res[1].right = res[0];
        return res[0];
    }

    public Node[] dfs(Node root) {
        Node[] res = new Node[2];
        if (root.left != null) {
            Node[] leftRes = dfs(root.left);
            leftRes[1].right = root;
            root.left = leftRes[1];
            res[0] = leftRes[0];
        } else res[0] = root;
        if (root.right != null) {
            Node[] rightRes = dfs(root.right);
            rightRes[0].left = root;
            root.right = rightRes[0];
            res[1] = rightRes[1];
        } else res[1] = root;
        return res;
    }
}

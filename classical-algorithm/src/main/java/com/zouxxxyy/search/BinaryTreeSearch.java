package com.zouxxxyy.search;

/*
二叉查找树，也称为二叉搜索树：

若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
任意节点的左、右子树也分别为二叉查找树；
没有键值相等的节点。

本例实现了二叉查找树的：插入、查找、删除、遍历

时间复杂度：O(logn) - O(n)
空间复杂度：O(1)
 */

/**
 * @author zxy
 */
public class BinaryTreeSearch<T extends Comparable<T>> {

    /**
     * 节点数据结构
     * <p>
     * 我这里增加难度，没有加 parent 属性，因此计算时麻烦点，需要保存 pre 节点（这其实也是单链表较之与双向链表的缺点之一）
     *
     * @param <T>
     */
    private static class Node<T> {

        T data;

        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this(data, null, null);
        }

        public Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 根节点
     */
    private Node<T> root;


    /**
     * 添加节点
     */
    public void add(T data) {

        Node<T> cur = root;
        Node<T> pre = null;

        int cmp = 0;

        while (cur != null) {

            pre = cur;

            cmp = data.compareTo(cur.data);
            if (cmp < 0) {
                cur = cur.left;
            } else if (cmp > 0) {
                cur = cur.right;
            } else {
                // 相同则替换
                cur.data = data;
                return;
            }
        }

        if (pre == null) {
            // pre 为 null，表明 cur 为根节点
            root = new Node<>(data);

        } else {
            if (cmp < 0) {
                pre.left = new Node<>(data);
            } else {
                pre.right = new Node<>(data);
            }
        }
    }


    /**
     * 查找节点是否存在
     */
    public boolean search(T data) {
        Node<T> cur = root;

        while (cur != null) {
            int cmp = data.compareTo(cur.data);
            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return false;
    }


    /**
     * 删除节点
     *
     * @return true: 删除成功， false: 删除失败（不含）
     */
    public boolean remove(T data) {

        boolean hasData = false;

        Node<T> cur = root;
        Node<T> pre = null;
        // 找到要删除的节点 cur，同时保存它的父节点 pre
        while (cur != null) {
            int cmp = data.compareTo(cur.data);
            if (cmp == 0) {
                hasData = true;
                break;
            } else {
                pre = cur;
                if (cmp < 0) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
        }

        if (!hasData) {
            return false;
        }

        Node<T> replace;
        if (cur.left == null && cur.right == null) {
            // 要删除的节点 左右子树都为空，直接删除
            replace = null;

        } else if (cur.right == null) {
            // 要删除的节点 左右子树其中一个为空，用非空的取代
            replace = cur.left;

        } else if (cur.left == null) {
            replace = cur.right;

        } else {
            /*
             * 要删除的节点 左右子树都不为空，把左子树最右边的节点替换要删除的节点（或右子树最左边的节点）
             * eg. 假设删除 7, 需要把 6（左子树的最右子树） 替换 7 ，把 4的右子树 替换 6的左子树
             *
             *     3(pre)
             *    / \
             *   2   7(cur)
             *      / \
             *     4   9
             *      \
             *       6(curL)
             *      /
             *     5
             */
            Node<T> curL = cur.left;
            if (curL.right != null) {
                Node<T> preL = cur;
                while (curL.right != null) {
                    preL = curL;
                    curL = curL.right;
                }
                preL.right = curL.left;
                curL.left = cur.left;
            }
            replace = curL;
            curL.right = cur.right;
        }

        // 替换
        if (pre == null) {
            // pre 为 null，表明 cur 为根节点
            root = replace;
        } else {
            if (pre.left == cur) {
                pre.left = replace;
            } else {
                pre.right = replace;
            }
        }

        return true;
    }


    /**
     * 中序遍历
     */
    public void LDR() {
        LDR(root);
        System.out.println();
    }

    private void LDR(Node<T> node) {
        if (node == null) {
            return;
        }

        LDR(node.left);
        System.out.print(node.data + " ");
        LDR(node.right);
    }


    public static void main(String[] args) {
        BinaryTreeSearch<Integer> binaryTree = new BinaryTreeSearch<>();
        binaryTree.add(3);
        binaryTree.add(2);
        binaryTree.add(7);
        binaryTree.add(4);
        binaryTree.add(9);
        binaryTree.add(6);
        binaryTree.add(5);

        binaryTree.LDR();
        System.out.println(binaryTree.remove(7));
        binaryTree.LDR();

    }

}

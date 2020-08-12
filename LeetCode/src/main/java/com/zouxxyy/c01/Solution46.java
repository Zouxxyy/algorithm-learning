package com.zouxxyy.c01;

/*
146. LRU缓存机制
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。



进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？



示例:

LRUCache cache = new LRUCache( 2 );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
 */

/*
思路：

使用 hashMap<key, LinkedNode> + LinkedNode
LinkedNode 是 双向链表，含key，value
 */

import java.util.HashMap;

/**
 * @author zxy
 */
public class Solution46 {

    static class LRUCache {

        private static class Node {
            // key用来删除尾节点时，找到对应hashMap中的节点并删除
            int key;
            int value;
            Node pre;
            Node next;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size;
        private final int capacity;
        private final HashMap<Integer, Node> hashMap;
        private final Node head = new Node();
        private final Node tail = new Node();

        public LRUCache(int capacity) {
            hashMap = new HashMap<>(capacity);

            this.capacity = capacity;
            size = 0;

            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {

            if (hashMap.containsKey(key)) {

                Node node = hashMap.get(key);
                // 删除原来位置，并插入双向链表头部
                removeNode(node);
                addNodeToHead(node);
                return node.value;
            } else {
                return -1;
            }

        }

        public void put(int key, int value) {

            if (!hashMap.containsKey(key)) {
                Node node = new Node(key, value);
                hashMap.put(key, node);

                // 插入双向链表头部
                addNodeToHead(node);

                // 缓存满了，删除尾部（不要忘了还要删除hashMap里对应的键值对！）
                if (++size > capacity) {
                    hashMap.remove(tail.pre.key);
                    removeNode(tail.pre);
                    size--;
                }

            } else {

                Node node = hashMap.get(key);
                node.value = value;

                // 删除原来位置，并插入双向链表头部
                removeNode(node);
                addNodeToHead(node);
            }

        }


        /**
         * 插入节点到头部
         */
        private void addNodeToHead(Node toAdd) {
            Node temp = head.next;

            head.next = toAdd;
            toAdd.pre = head;

            toAdd.next = temp;
            temp.pre = toAdd;
        }


        /**
         * 删除双向链表中的指定节点
         */
        private void removeNode(Node toRemove) {
            Node pre = toRemove.pre;
            toRemove.pre.next = toRemove.next;
            pre.next.pre = pre;
        }

    }

}

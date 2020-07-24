package com.zouxxxyy.structure;

/*
LRUCache

使用 hashMap + 双向链表实现

使用双向链表的原因：需要移除指定位置的 Node
 */

import java.util.HashMap;

/**
 * @author zxy
 */
public class LRUCache<K, V> {

    private static class Node<K, V> {

        // key 的作用是删除最后一个节点时，通过它删除对应 hashMap 里的KV
        Node<K, V> pre;
        Node<K, V> next;
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node() {

        }
    }

    private final HashMap<K, Node<K, V>> hashMap;
    private final int capacity;
    private int size;

    private final Node<K, V> head = new Node<>();
    private final Node<K, V> tail = new Node<>();

    public LRUCache(int capacity) {

        hashMap = new HashMap<>(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }


    /**
     * 加
     */
    public void put(K key, V value) {

        if (!hashMap.containsKey(key)) {

            Node<K, V> node = new Node<>(key, value);
            hashMap.put(key, node);
            moveNodeToHead(node, true);

            // 如果超过最大容量，删除最后一个节点
            if (++size > capacity) {
                hashMap.remove(tail.pre.key);
                removeNode(tail.pre);
                size--;
            }

        } else {

            Node<K, V> node = hashMap.get(key);
            node.value = value;
            moveNodeToHead(node, false);
        }

    }


    /**
     * 取
     * @return 不含时为 null
     */
    public V get(K key) {

        if (!hashMap.containsKey(key)) {
            return null;
        } else {
            Node<K, V> node = hashMap.get(key);
            moveNodeToHead(node, false);
            return node.value;
        }
    }


    /**
     * 把节点移到头部
     *
     * @param isNew 该节点是否为新节点
     */
    private void moveNodeToHead(Node<K, V> node, Boolean isNew) {

        if (!isNew) {
            if (head.next == node) {
                return;
            } else {
                removeNode(node);
            }
        }

        // 加到头部
        node.next = head.next;
        node.next.pre = node;

        head.next = node;
        node.pre = head;
    }


    /**
     * 双向链表中移除某节点
     */
    private void removeNode(Node<K, V> node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


    public static void main(String[] args) {

        LRUCache<Integer, Integer> lruCache = new LRUCache<>(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        // 输出 1
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        // 输出 null
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        // 输出 null
        System.out.println(lruCache.get(1));
        // 输出 3
        System.out.println(lruCache.get(3));
        // 输出 4
        System.out.println(lruCache.get(4));
        // 输出 4
        System.out.println(lruCache.get(4));

    }

}



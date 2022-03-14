package com.zouxxyy.c04;

/*
460. LFU 缓存
请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。

实现 LFUCache 类：

LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。
void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。

为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。

当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。



示例：

输入：
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
输出：
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]

解释：
// cnt(x) = 键 x 的使用计数
// cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
LFUCache lFUCache = new LFUCache(2);
lFUCache.put(1, 1);   // cache=[1,_], cnt(1)=1
lFUCache.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
lFUCache.get(1);      // 返回 1
                      // cache=[1,2], cnt(2)=1, cnt(1)=2
lFUCache.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
                      // cache=[3,1], cnt(3)=1, cnt(1)=2
lFUCache.get(2);      // 返回 -1（未找到）
lFUCache.get(3);      // 返回 3
                      // cache=[3,1], cnt(3)=2, cnt(1)=2
lFUCache.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
                      // cache=[4,3], cnt(4)=1, cnt(3)=2
lFUCache.get(1);      // 返回 -1（未找到）
lFUCache.get(3);      // 返回 3
                      // cache=[3,4], cnt(4)=1, cnt(3)=3
lFUCache.get(4);      // 返回 4
                      // cache=[3,4], cnt(4)=2, cnt(3)=3


提示：

0 <= capacity, key, value <= 104
最多调用 105 次 get 和 put 方法


进阶：你可以为这两种操作设计时间复杂度为 O(1) 的实现吗？
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author zxy
 */
public class Solution60 {

    static class Node {
        int key;
        int value;
        int freq;

        public Node(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }

    class LFUCache {

        private final Map<Integer, Node> nodeMap = new HashMap<>();
        private final Map<Integer, LinkedList<Node>> freqMap = new HashMap<>();
        private int minFreq = 0;
        private final int capacity;

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (capacity != 0 && nodeMap.containsKey(key)) {
                Node node = nodeMap.get(key);
                updateNodeInFreqMap(node, false);
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (nodeMap.containsKey(key)) {
                Node node = nodeMap.get(key);
                node.value = value;
                updateNodeInFreqMap(node, false);
            } else {
                if (nodeMap.size() == capacity) {
                    nodeMap.remove(freqMap.get(minFreq).getLast().key);
                    freqMap.get(minFreq).removeLast();
                    if (freqMap.get(minFreq).size() == 0) {
                        freqMap.remove(minFreq);
                    }
                }
                Node node = new Node(key, value, 1);
                nodeMap.put(key, node);
                updateNodeInFreqMap(node, true);
                minFreq = 1;
            }
        }

        private void updateNodeInFreqMap(Node node, boolean isNew) {
            if (!isNew) {
                LinkedList<Node> list = freqMap.get(node.freq);
                list.remove(node);
                if (list.size() == 0) {
                    freqMap.remove(node.freq);
                    if (minFreq == node.freq) {
                        minFreq++;
                    }
                }
                node.freq++;
            }
            if (freqMap.containsKey(node.freq)) {
                freqMap.get(node.freq).addFirst(node);
            } else {
                LinkedList<Node> nodes = new LinkedList<>();
                nodes.addFirst(node);
                freqMap.put(node.freq, nodes);
            }
        }
    }
}

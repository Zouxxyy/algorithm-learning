package nc00;

/*
题目描述
设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
set(key, value)：将记录(key, value)插入该结构
get(key)：返回key对应的value值
[要求]
set和get方法的时间复杂度为O(1)
某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
若opt=1，接下来两个整数x, y，表示set(x, y)
若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
对于每个操作2，输出一个答案
示例1
输入
复制
[[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3
返回值
复制
[1,-1]
说明
第一次操作后：最常使用的记录为("1", 1)
第二次操作后：最常使用的记录为("2", 2)，("1", 1)变为最不常用的
第三次操作后：最常使用的记录为("3", 2)，("1", 1)还是最不常用的
第四次操作后：最常用的记录为("1", 1)，("2", 2)变为最不常用的
第五次操作后：大小超过了3，所以移除此时最不常使用的记录("2", 2)，加入记录("4", 4)，并且为最常使用的记录，然后("3", 2)变为最不常使用的记录
备注:
1 \leq K \leq N \leq 10^51≤K≤N≤10
5

-2 \times 10^9 \leq x,y \leq 2 \times 10^9−2×10
9
 ≤x,y≤2×10
9
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution93 {

    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        // write code here
        LRUcache lruCache = new LRUcache(k);
        List<Integer> list = new ArrayList<>();

        for (int[] operator : operators) {
            if (operator[0] == 1) {
                lruCache.set(operator[1], operator[2]);
            } else {
                list.add(lruCache.get(operator[1]));
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    static class Node {

        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public class LRUcache {

        private final int capacity;
        private int size;
        private final Node head;
        private final Node tail;
        private final HashMap<Integer, Node> map;

        public LRUcache(int capacity) {
            this.capacity = capacity;
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            map = new HashMap<>();
        }

        public void set(int key, int value) {
            if (!map.containsKey(key)) {
                Node node = new Node(key, value);
                moveNodeToHead(node, true);
                map.put(key, node);
                if (++size > capacity) {
                    map.remove(tail.pre.key);
                    removeNode(tail.pre);
                    size--;
                }
            } else {
                Node node = map.get(key);
                node.value = value;
                moveNodeToHead(node, false);
            }
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            } else {
                Node node = map.get(key);
                moveNodeToHead(node, false);
                return node.value;
            }
        }

        private void moveNodeToHead(Node node, boolean isNew) {

            if (!isNew) {
                if (head.next == node) {
                    return;
                } else {
                    removeNode(node);
                }
            }

            // 加到头部
            Node next = head.next;
            head.next = node;
            node.pre = head;
            node.next = next;
            next.pre = node;
        }

        private void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

    }

}

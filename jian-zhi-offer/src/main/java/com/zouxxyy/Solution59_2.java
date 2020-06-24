/*
面试题59 - II. 队列的最大值

请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

若队列为空，pop_front 和 max_value 需要返回 -1

示例 1：

输入:
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]
示例 2：

输入:
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]
 

限制：

1 <= push_back,pop_front,max_value的总操作数 <= 10000
1 <= value <= 10^5

 */

/*
笔记：

如果是直接peek两个队列的数比较，请注意这样就是在比较两个Integer对象而不是基本类型int，
要用equals不要用==，否则对于非缓存数字（-128 - 127）可能会出现明明值一样 == 却返回false的情况！
 */

package com.zouxxyy;

import java.util.LinkedList;

public class Solution59_2 {

    class MaxQueue {
        LinkedList<Integer> deque1;
        LinkedList<Integer> deque2;

        public MaxQueue() {
            deque1 = new LinkedList<>();
            deque2 = new LinkedList<>();
        }

        public int max_value() {
            return deque2.isEmpty() ? -1 : deque2.peekFirst();
        }

        public void push_back(int value) {
            deque1.addLast(value);
            while (!deque2.isEmpty() && deque2.peekLast() < value)
                deque2.removeLast();
            deque2.addLast(value);
        }

        public int pop_front() {
            if (deque1.isEmpty()) return -1;
            int poll = deque1.pollFirst();
            if (poll == deque2.peekFirst())
                deque2.pollFirst();
            return poll;
        }
    }
}

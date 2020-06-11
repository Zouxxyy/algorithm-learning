/*
面试题30. 包含min函数的栈

定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

 

示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.
 

提示：

各函数的调用总次数不超过 20000 次

 */

package com.zouxxyy;

import java.util.Stack;

public class Solution30 {
    class MinStack {

        private Stack<int[]> stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(new int[]{x, stack.empty() ? x : Math.min(x, stack.peek()[1])});
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0];
        }

        public int min() {
            return stack.peek()[1];
        }
    }
}

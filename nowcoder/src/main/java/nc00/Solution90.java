package nc00;

/*
设计getMin功能的栈

实现一个特殊功能的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
示例1
输入
复制
[[1,3],[1,2],[1,1],[3],[2],[3]]
返回值
复制
[1,2]
备注:
有三种操作种类，op1表示push，op2表示pop，op3表示getMin。你需要返回和op3出现次数一样多的数组，表示每次getMin的答案

1<=操作总数<=1000000
-1000000<=每个操作数<=1000000
数据保证没有不合法的操作
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution90 {

    public int[] getMinStack(int[][] op) {
        // write code here
        List<Integer> list = new ArrayList<>();
        MinStack minStack = new MinStack();

        for (int[] o : op) {
            if (o[0] == 1) {
                minStack.push(o[1]);
            } else if (o[0] == 2) {
                minStack.pop();
            } else {
                list.add(minStack.getMin());
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public static class MinStack {


        private final LinkedList<Integer> stack1;
        private final LinkedList<Integer> stack2;

        public MinStack() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void push(int i) {
            stack1.push(i);

            int min = i;
            if (!stack2.isEmpty()) {
                min = Math.min(min, stack2.peek());
            }
            stack2.push(min);
        }

        public int pop() {
            stack2.pop();
            return stack1.pop();
        }

        public int getMin() {
            return stack2.peek();
        }

    }

}

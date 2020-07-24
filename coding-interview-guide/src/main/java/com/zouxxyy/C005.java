package com.zouxxyy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/*
题目描述
实现一个特殊功能的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
输入描述:
第一行输入一个整数N，表示对栈进行的操作总数。

下面N行每行输入一个字符串S，表示操作的种类。

如果S为"push"，则后面还有一个整数X表示向栈里压入整数X。

如果S为"pop"，则表示弹出栈顶操作。

如果S为"getMin"，则表示询问当前栈中的最小元素是多少。
输出描述:
对于每个getMin操作，输出一行表示当前栈中的最小元素是多少。
 */

/**
 * @author zxy
 */
public class C005 {

    private static class MyStack {

        private final Deque<Integer> stack;
        private final Deque<Integer> minStack;

        public MyStack() {
            this.stack = new LinkedList<>();
            this.minStack = new LinkedList<>();
        }

        public void push(int i) {
            stack.push(i);
            Integer peek = minStack.peek();
            minStack.push(null == peek ? i : Math.min(peek, i));
        }

        public int pop() throws Exception {
            Integer peek = stack.peek();
            if (null == peek) {
                throw new Exception("stack is empty, can't pop!");
            } else {
                stack.pop();
                minStack.pop();
                return peek;
            }
        }

        public int getMin() throws Exception {
            Integer peek = minStack.peek();
            if (null == peek) {
                throw new Exception("stack is empty, can't getMin!");
            } else {
                return peek;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        MyStack myStack = new MyStack();

        Scanner scanner = new Scanner(System.in);

        int k = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < k; i++) {
            String[] codes = scanner.nextLine().split(" ");
            switch (codes[0]) {
                case "getMin":
                    System.out.println(myStack.getMin());
                    break;
                case "pop":
                    myStack.pop();
                    break;
                case "push":
                    myStack.push(Integer.parseInt(codes[1]));
                    break;
                default:
            }
        }
    }
}


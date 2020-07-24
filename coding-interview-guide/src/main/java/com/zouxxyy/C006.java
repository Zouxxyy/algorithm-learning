/*
题目描述
用两个栈实现队列，支持队列的基本操作。
输入描述:
第一行输入一个整数N，表示对队列进行的操作总数。

下面N行每行输入一个字符串S，表示操作的种类。

如果S为"add"，则后面还有一个整数X表示向队列尾部加入整数X。

如果S为"poll"，则表示弹出队列头部操作。

如果S为"peek"，则表示询问当前队列中头部元素是多少。
输出描述:
对于每一个为"peek"的操作，输出一行表示当前队列中头部元素是多少。
 */


package com.zouxxyy;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author zxy
 */
public class C006 {

    private static class MyQueue {

        private final LinkedList<Integer> stack1;
        private final LinkedList<Integer> stack2;

        public MyQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void add(int i) {
            stack1.push(i);
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.poll());
                }
            }
            return stack2.peek();
        }

        public void poll() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.poll());
                }
            }
            stack2.poll();
        }
    }

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();

        Scanner scanner = new Scanner(System.in);

        int k = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < k; i++) {
            String[] codes = scanner.nextLine().split(" ");
            switch (codes[0]) {
                case "add":
                    myQueue.add(Integer.parseInt(codes[1]));
                    break;
                case "poll":
                    myQueue.poll();
                    break;
                case "peek":
                    System.out.println(myQueue.peek());
                    break;
                default:
            }
        }
    }
}


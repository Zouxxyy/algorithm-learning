package com.zouxxyy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/*
题目描述
一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。
除此之外，可以申请新的变量，但不能申请额外的数据结构。如何完成排序？

输入描述:
第一行输入一个N，表示栈中元素的个数
第二行输入N个整数表示栈顶到栈底的各个元素

输出描述:
输出一行表示排序后的栈中栈顶到栈底的各个元素。
 */

/**
 * @author zxy
 */
public class C013 {

    private static Deque<Integer> sortStack(Deque<Integer> stack) {

        Deque<Integer> tempStack = new LinkedList<>();

        while (!stack.isEmpty()) {
            int pop = stack.pop();

            while (!tempStack.isEmpty() && pop < tempStack.peek()) {
                stack.push(tempStack.pop());
            }

            tempStack.push(pop);
        }

        return tempStack;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            stack.push(scanner.nextInt());
        }

        stack = sortStack(stack);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
            System.out.print(' ');
        }
    }

}

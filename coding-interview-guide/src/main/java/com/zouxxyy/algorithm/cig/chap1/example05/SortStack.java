package com.zouxxyy.algorithm.cig.chap1.example05;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序（难度1）
 * @version 1.00 2019-04-04
 * @author zouxxyy
 */
public class SortStack {
    public static void mySort(Stack<Integer> stack) {

        Stack<Integer> sortStack = new Stack<>();

        while (!stack.isEmpty()) {
            int i = stack.pop();
            while (!sortStack.isEmpty() && sortStack.peek() < i)
                stack.push(sortStack.pop());
            sortStack.push(i);
        }
        while (!sortStack.isEmpty())
            stack.push(sortStack.pop());
    }
}

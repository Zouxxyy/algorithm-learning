package com.zouxxyy.algorithm.cig.chap1.example03;

import java.util.Stack;

/**
 * 仅用递归和栈操作逆序一个栈（难度2）
 * @version 1.00 2019-04-01
 * @author zouxxyy
 */
public class ReverseStack {
    public static void reverseStack(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
            int num = getAndRemoveLast(stack);
            reverseStack(stack);
            stack.push(num);
        }
    }

    // 获得并删除栈底元素，采用递归
    private static int getAndRemoveLast(Stack<Integer> stack) {
        int num = stack.pop();
        if(stack.isEmpty())
            return num;
        else {
            int last = getAndRemoveLast(stack);
            stack.push(num);
            return last;
        }
    }
}
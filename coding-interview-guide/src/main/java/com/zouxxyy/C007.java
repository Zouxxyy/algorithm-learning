package com.zouxxyy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/*
用递归函数和栈逆序一个栈

题目描述
一个栈依次压入1,2,3,4,5，那么从栈顶到栈底分别为5,4,3,2,1。
将这个栈转置后，从栈顶到栈底为1,2,3,4,5，也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构。

输入描述:
输入数据第一行一个整数N为栈中元素的个数。
接下来一行N个整数。表示从栈顶依次到栈底的每个元素。

输出描述:
输出一行表示栈中元素逆序后的每个元素
 */

/*
思路：
两个递归
这题写的出就见鬼了
 */

/**
 * @author zxy
 */
public class C007 {

    /**
     * 转置栈
     * @param stack 目标栈
     */
    public static void reverseStack(Deque<Integer> stack) {
        if (!stack.isEmpty()) {
            int num = getAndRemoveLast(stack);
            reverseStack(stack);
            stack.push(num);
        }
    }

    /**
     * 获得并删除栈底元素，采用递归
     *
     * @param stack 目标栈
     * @return 栈底元素
     */
    private static int getAndRemoveLast(Deque<Integer> stack) {
        int num = stack.pop();
        if (stack.isEmpty()) {
            return num;
        } else {
            int last = getAndRemoveLast(stack);
            stack.push(num);
            return last;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }

        reverseStack(stack);
        reverseStack(stack);

        for (int i = 0; i < n; i++) {
            System.out.print(stack.pop());
            System.out.print(" ");
        }
    }

}

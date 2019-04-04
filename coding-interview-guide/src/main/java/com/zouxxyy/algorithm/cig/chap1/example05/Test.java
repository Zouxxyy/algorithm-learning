package com.zouxxyy.algorithm.cig.chap1.example05;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(7);
        stack.push(4);
        stack.push(9);
        stack.push(3);
        stack.push(9);
        stack.push(1);
        stack.push(5);


        System.out.println(stack);
        SortStack.mySort(stack);
        System.out.println(stack);

    }
}

/*
[2, 7, 4, 9, 3, 9, 1, 5]
[1, 2, 3, 4, 5, 7, 9, 9]
*/
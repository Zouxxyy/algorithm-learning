package com.zouxxyy.algorithm.cig.chap1.example01;

public class Test {
    public static void main(String[] args) {
        GetMinStack getMinStack = new GetMinStack();
        getMinStack.push(3);
        getMinStack.push(9);
        getMinStack.push(4);
        getMinStack.push(2);
        getMinStack.push(2);
        getMinStack.push(6);
        System.out.println("Min: " + getMinStack.getMin());
        System.out.println(getMinStack.pop());
        System.out.println("Min: " + getMinStack.getMin());
        System.out.println(getMinStack.pop());
        System.out.println("Min: " + getMinStack.getMin());
        System.out.println(getMinStack.pop());
        System.out.println("Min: " + getMinStack.getMin());
    }
}

/*
Min: 2
6
Min: 2
2
Min: 2
2
Min: 3
 */



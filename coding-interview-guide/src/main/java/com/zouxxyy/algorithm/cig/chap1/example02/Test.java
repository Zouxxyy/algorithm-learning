package com.zouxxyy.algorithm.cig.chap1.example02;

public class Test {
    public static void main(String[] args) {
        TwoStackQueue myqueue = new TwoStackQueue();
        myqueue.add(1);
        myqueue.add(2);
        myqueue.add(3);
        myqueue.add(4);
        myqueue.add(5);
        myqueue.add(6);
        System.out.println("peek: " + myqueue.peek());
        System.out.println(myqueue.poll());
        System.out.println("peek: " + myqueue.peek());
        myqueue.add(7);
        System.out.println(myqueue.poll());
        System.out.println(myqueue.poll());
        myqueue.add(8);

        System.out.println(myqueue.poll());
        System.out.println(myqueue.poll());
        System.out.println(myqueue.poll());
        System.out.println("peek: " + myqueue.peek());
        System.out.println(myqueue.poll());
        System.out.println(myqueue.poll());
        System.out.println("peek: " + myqueue.peek());
        System.out.println(myqueue.poll());


    }
}

/*
peek: 1
1
peek: 2
2
3
4
5
6
peek: 7
7
8
peek: null
null
 */
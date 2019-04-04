package com.zouxxyy.algorithm.cig.chap1.example02;

import java.util.Stack;

/**
 * 由两个栈组成的队列（难度2）
 * @version 1.00 2019-04-01
 * @author zouxxyy
 */
public class TwoStackQueue {
    private Stack<Integer> stackAdd;
    private Stack<Integer> stackPoll;

    public TwoStackQueue() {
        this.stackAdd = new Stack<>();
        this.stackPoll = new Stack<>();
    }

    public void add(int num) {
        stackAdd.push(num);
    }

    public Integer poll() {
        Integer value = peek();
        if(value != null)
            stackPoll.pop();
        return value;
    }

    public Integer peek() {
        if(stackPoll.isEmpty()) { // 只有在stackPoll为空时加入stackAdd的全部元素
            while (!stackAdd.isEmpty())
                stackPoll.add(stackAdd.pop());
        }
        if(stackPoll.isEmpty())
            return null;
        else return stackPoll.peek();
    }
}

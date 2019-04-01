package com.zouxxyy.algorithm.cig.chap1.example01;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈（难度1）
 * @version 1.00 2019-04-01
 * @author zouxxyy
 */
public class GetMinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public GetMinStack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public int getMin() {
        return this.stackMin.peek();
    }

    public void push(int num) {
        this.stackData.push(num);
        if(this.stackMin.isEmpty() || num <= this.stackMin.peek())
            this.stackMin.push(num);
    }

    public int pop() {
        int value = this.stackData.pop();
        if(value == this.getMin())
            this.stackMin.pop();
        return value;
    }
}


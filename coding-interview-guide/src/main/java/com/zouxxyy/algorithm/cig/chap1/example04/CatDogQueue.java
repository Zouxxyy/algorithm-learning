package com.zouxxyy.algorithm.cig.chap1.example04;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 猫狗队列（难度2）
 * @version 1.00 2019-04-01
 * @author zouxxyy
 */
public class CatDogQueue {
    private Queue<MyPet> catQueue;
    private Queue<MyPet> dogQueue;
    private long num;

    public CatDogQueue() {
        catQueue = new ArrayDeque<>();
        dogQueue = new ArrayDeque<>();
        num = 0;
    }

    public void add(Pet pet) {
        if(pet instanceof Dog)
            dogQueue.add(new MyPet(pet, num++));
        else
            catQueue.add(new MyPet(pet, num++));
    }

    public Pet pollAll() {
        if (!isCatEmpty() && !isCatEmpty()) {
            if (dogQueue.peek().getNum() < catQueue.peek().getNum())
                return dogQueue.poll().getPet();
            else
                return catQueue.poll().getPet();
        }
        else if(!isDogEmpty())
            return pollDog();
        else
            return pollCat();
    }

    public Pet pollDog() {
        if(!isDogEmpty())
            return dogQueue.poll().getPet();
        else
            throw new RuntimeException("queue is empty");
    }

    public Pet pollCat() {
        if(!isCatEmpty()) {
            return catQueue.poll().getPet();
        }
        else
            throw new RuntimeException("queue is empty");
    }

    public boolean isEmpty() {
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }
}

class MyPet{
    private Pet pet;
    private long num;

    public MyPet(Pet pet, long num) {
        this.pet = pet;
        this.num = num;
    }

    public Pet getPet() {
        return pet;
    }

    public long getNum() {
        return num;
    }

    public String getType() {
        return pet.getType();
    }
}
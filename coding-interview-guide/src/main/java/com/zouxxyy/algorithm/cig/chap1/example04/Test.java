package com.zouxxyy.algorithm.cig.chap1.example04;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();


        CatDogQueue catDogQueue = new CatDogQueue();
        catDogQueue.add(dog);
        catDogQueue.add(dog);
        catDogQueue.add(cat);
        catDogQueue.add(dog);
        catDogQueue.add(cat);
        catDogQueue.add(dog);
        catDogQueue.add(dog);

        System.out.println(catDogQueue.pollAll().getType());
        System.out.println(catDogQueue.pollCat().getType());
        System.out.println(catDogQueue.isCatEmpty());
        System.out.println(catDogQueue.pollDog().getType());
        System.out.println(catDogQueue.pollAll().getType());
        System.out.println(catDogQueue.pollAll().getType());
        System.out.println(catDogQueue.pollAll().getType());
        System.out.println(catDogQueue.pollAll().getType());
        System.out.println(catDogQueue.isEmpty());
    }
}

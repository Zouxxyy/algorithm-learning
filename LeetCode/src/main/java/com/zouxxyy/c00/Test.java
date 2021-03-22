package com.zouxxyy.c00;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zxy
 */
public class Test {
    private static boolean flag;
    private static int num;

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(() -> {
            System.out.println("ssss");
            LockSupport.park();
            System.out.println("ss");
        });

        t1.start();
        Thread.sleep(222);
        t1.interrupt();
        Thread.sleep(222);

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

    }
}

package com.zouxxxyy.structure;

/*
生产者消费者示例

核心记忆点：

在 while 里使用 object.wait 和 object.notify
 */

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zxy
 */
public class ProducerAndConsumer {

    public static void main(String[] args) {

        Solution2();

    }


    /**
     * 3线程交替打印
     */
    public static void Solution1() throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();
        Condition A = lock.newCondition();
        Condition B = lock.newCondition();
        Condition C = lock.newCondition();

        new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    A.await();
                    System.out.print("A");
                    B.signal();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    B.await();
                    System.out.print("B");
                    C.signal();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    C.await();
                    System.out.print("C");
                    A.signal();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        Thread.sleep(100);
        try {
            lock.lock();
            A.signal();
        } finally {
            lock.unlock();
        }

    }


    /**
     * 生产者 和 消费者
     */
    public static void Solution2()  {

        LinkedList<Integer> list = new LinkedList<>();
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (list.isEmpty()) {
                        condition.await();
                    }
                    list.removeLast();
                    System.out.println("消费");
                    condition.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (list.isEmpty()) {
                        condition.await();
                    }
                    list.removeLast();
                    System.out.println("消费");
                    condition.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();

                    while (list.size() >= 5) {
                        condition.await();
                    }
                    list.add(1);
                    System.out.println("生产");
                    condition.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();

                    while (list.size() >= 5) {
                        condition.await();
                    }
                    list.add(1);
                    System.out.println("生产");
                    condition.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }).start();
    }

}

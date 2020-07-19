package com.zouxxxyy.structor;

/*
双锁机制的ArrayBlockingQueue

JDK里的ArrayBlockingQueue是单锁，LinkedBlockingQueue是双锁

 */


import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zxy
 */
public class BlockingQueue<T> {

    private final Object[] table;
    private final int capacity;
    private final AtomicInteger count = new AtomicInteger(0);

    private final ReentrantLock putLock = new ReentrantLock();
    private final ReentrantLock takeLock = new ReentrantLock();

    private final Condition notFull = putLock.newCondition();
    private final Condition notEmpty = takeLock.newCondition();

    private int takeIndex;
    private int putIndex;


    public BlockingQueue(int capacity) {

        this.capacity = capacity;
        table = new Object[capacity];
    }


    /**
     * 添加
     */
    public void put(T obj) throws InterruptedException {

        int c;

        if (obj == null) {
            throw new NullPointerException();
        }

        putLock.lockInterruptibly();
        try {
            while (count.get() == capacity) {
                notFull.await();
            }
            table[putIndex] = obj;

            if (++putIndex == capacity) {
                putIndex = 0;
            }

            c = count.getAndIncrement();
            if (c + 1 < capacity) {
                notFull.signal();
            }
        } finally {
            putLock.unlock();
        }

        // 如果 put 前个数为 0，通知 take
        if (c == 0) {
            takeLock.lock();
            try {
                notEmpty.signal();
            } finally {
                takeLock.unlock();
            }
        }
    }


    /**
     * 取出
     */
    public T take() throws InterruptedException {

        int c;
        T take;

        takeLock.lockInterruptibly();
        try {
            while (count.get() == 0) {
                notEmpty.await();
            }
            take = (T) table[takeIndex];
            // 手动置空，gc
            table[takeIndex] = null;

            if (++takeIndex == capacity) {
                takeIndex = 0;
            }

            c = count.getAndDecrement();
            if (c > 1) {
                notEmpty.signal();
            }

        } finally {
            takeLock.unlock();
        }

        // 如果 take 前个数为 capacity，通知 put
        if (c == capacity) {
            putLock.lock();
            try {
                notFull.signal();
            } finally {
                putLock.unlock();
            }
        }

        return take;
    }


    /**
     * 目前个数
     */
    public int size() {
        return count.get();
    }


    /**
     * 测试
     */
    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new BlockingQueue<>(5);

        final int producerNum = 8;
        final int consumerNum = 8;

        final int times = 10;

        ThreadPoolExecutor producers = new ThreadPoolExecutor(producerNum, producerNum,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        ThreadPoolExecutor consumers = new ThreadPoolExecutor(consumerNum, consumerNum,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


        for (int i = 0; i < producerNum; i++) {
            final int finalI = i;
            producers.execute(() -> {
                try {
                    for (int j = 1; j <= times; j++) {
                        blockingQueue.put("产品");
                        System.out.println("生成者 " + finalI + " 生产第 " + j + " 条任务，当前队列长度为 " + blockingQueue.size());
                        Thread.sleep(new Random().nextInt(1000));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for (int i = 0; i < consumerNum; i++) {
            final int finalI = i;
            consumers.execute(() -> {
                try {
                    for (int j = 1; j <= times; j++) {
                        String take = blockingQueue.take();
                        System.out.println("消费者 " + finalI + " 消费第 " + j + " 条任务，当前队列长度为 " + blockingQueue.size());
                        Thread.sleep(new Random().nextInt(1000));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        producers.shutdown();
        consumers.shutdown();
    }
}

package com.zouxxxyy.structure;

/*
优先队列

使用大根堆实现
 */

/**
 * @author zxy
 */
public class PriorityQueue<T extends Comparable<T>> {

    private Object[] queue;
    private int capacity;
    private int size;


    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        queue = new Object[capacity];
    }


    /**
     * 添加，不能添加 null
     */
    public void add(T data) {

        if (data == null) {
            throw new NullPointerException();
        }

        if (size == capacity) {
            Object[] newObject = new Object[2 * capacity];
            System.arraycopy(queue, 0, newObject, 0, capacity);
            queue = newObject;
            capacity *= 2;
        }

        // 新元素加到结尾，然后向上移
        queue[size] = data;
        int index = size;

        while (index > 0 && get(index).compareTo(get(parentIndex(index))) > 0) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }

        size++;
    }


    /**
     * 取出，size 为 0 时返回 null
     */
    public T poll() {

        if (size == 0) {
            return null;
        }

        T toReturn = get(0);

        if (size > 1) {
            queue[0] = queue[size - 1];
            queue[size - 1] = null;
        }
        size--;
        siftDown(0);
        return toReturn;
    }


    public T peek() {
        return (size == 0) ? null : get(0);
    }


    /**
     * 元素个数
     */
    public int size() {
        return size;
    }


    private void siftDown(int index) {

        int maxIndex = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < size && get(leftIndex).compareTo(get(maxIndex)) > 0) {
            maxIndex = leftIndex;
        }

        if (rightIndex < size && get(rightIndex).compareTo(get(maxIndex)) > 0) {
            maxIndex = rightIndex;
        }

        if (maxIndex != index) {
            swap(maxIndex, index);
            siftDown(maxIndex);
        }
    }

    @SuppressWarnings("unchecked")
    private T get(int index) {
        return (T) queue[index];
    }

    private int parentIndex(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index 0 没有parent");
        } else {
            return (index - 1) / 2;
        }
    }

    private void swap(int l, int r) {
        Object temp = queue[l];
        queue[l] = queue[r];
        queue[r] = temp;
    }


    /**
     * 测试
     */
    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(10);

        priorityQueue.add(4);
        priorityQueue.add(8);
        priorityQueue.add(2);
        priorityQueue.add(9);
        priorityQueue.add(3);
        priorityQueue.add(3);
        priorityQueue.add(7);
        priorityQueue.add(1);

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }

}

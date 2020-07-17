package com.zouxxxyy.search;

/*
hash查找

通过构建hash表，进行查找

时间复杂度：O(1) - O(n)
空间复杂度：O(n)
 */

/**
 * @author zxy
 */
public class HashSearch<T> {

    private final T[] table;

    private final int capacity;

    public HashSearch(int capacity) {
        this.capacity = capacity;
        table = (T[]) new Object[capacity];
    }

    /**
     * 添加
     * @param data 不能为 null
     */
    public void add(T data) {

        int hashAddr = hash(data);

        // 使用开放寻址处理hash冲突
        while (table[hashAddr] != null && table[hashAddr].equals(data)) {
            hashAddr = (++hashAddr) % capacity;
        }

        table[hashAddr] = data;
    }


    /**
     * 查找是否存在
     */
    public boolean search(T data) {

        if (data == null) {
            return false;
        }

        int preHashAddr = hash(data);
        int hashAddr = preHashAddr;

        while (table[hashAddr] == null || !table[hashAddr].equals(data)) {
            hashAddr = (++hashAddr) % capacity;
            // 回到原来的位置代表没找到
            if (hashAddr == preHashAddr) {
                return false;
            }
        }

        return true;
    }


    /**
     * 简单取余hash函数
     */
    private int hash(T data) {
        return data.hashCode() % capacity;
    }


    public static void main(String[] args) {

        HashSearch<Integer> hashSearch = new HashSearch<>(20);
        hashSearch.add(5);
        hashSearch.add(81);
        hashSearch.add(25);
        hashSearch.add(11);
        hashSearch.add(9);
        hashSearch.add(0);
        hashSearch.add(44);
        hashSearch.add(16);
        hashSearch.add(45);
        hashSearch.add(6);

        System.out.println(hashSearch.search(6));
        System.out.println(hashSearch.search(7));
        System.out.println(hashSearch.search(45));
    }

}

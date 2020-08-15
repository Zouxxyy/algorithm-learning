package com.zouxxxyy.structure;

/*
前缀树（字典树）

核心数据结构 Node：links的map(ch, Node)，isEnd，data

实现了：插入单词、删除单词、查询是否含有单词、查询是否含有前缀
 */

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author zxy
 */
public class Trie {

    /**
     * 节点数据结构
     */
    private static class Node {

        private boolean isEnd;
        private final HashMap<Character, Node> links;
        // 节点数据，用于找到它的父位置
        private final char data;

        Node(char ch) {
            links = new HashMap<>(26);
            data = ch;
        }
    }


    private final Node root;

    Trie() {
        root = new Node(' ');
    }


    /**
     * 插入单词
     */
    public void insert(String word) {
        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!cur.links.containsKey(ch)) {
                cur.links.put(ch, new Node(ch));
            }

            cur = cur.links.get(ch);
        }

        // 添加单词结尾标志
        cur.isEnd = true;
    }


    /**
     * 删除单词
     */
    public void remove(String word) {

        Node cur = root;
        Deque<Node> stack = new LinkedList<>();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!cur.links.containsKey(ch)) {
                return;
            }

            stack.push(cur);
            cur = cur.links.get(ch);
        }

        // 检测是否是单词结尾，如果是则改回false
        if (!cur.isEnd) {
            return;
        } else {
            cur.isEnd = false;
        }

        // 从后往前删除字符（通过栈实现）
        char toRemove;
        if (!cur.links.isEmpty()) {
            return;
        } else {
            toRemove = cur.data;
        }

        while (!stack.isEmpty()) {

            Node pop = stack.pop();
            pop.links.remove(toRemove);

            // 不要忘记 pop.isEnd 这个条件！
            if (!cur.links.isEmpty() || pop.isEnd) {
                return;
            } else {
                toRemove = pop.data;
            }
        }

    }


    /**
     * 查找Trie中是否含有某单词
     */
    public boolean search(String word) {
        Node node = getLastNode(word);
        return node != null && node.isEnd;
    }


    /**
     * 查找Trie中是否含有某单词的某个前缀
     */
    public boolean startsWith(String prefix) {
        return getLastNode(prefix) != null;
    }


    /**
     * 获取单词中最后一个字符所在的节点，不存在则返回 null（辅助函数）
     */
    private Node getLastNode(String word) {

        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cur.links.containsKey(ch)) {
                return null;
            }
            cur = cur.links.get(ch);
        }

        return cur;
    }


    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("he");
        // true
        System.out.println(trie.startsWith("he"));
        trie.remove("hello");
        // true
        System.out.println(trie.startsWith("he"));
        // false
        System.out.println(trie.startsWith("hel"));

    }

}

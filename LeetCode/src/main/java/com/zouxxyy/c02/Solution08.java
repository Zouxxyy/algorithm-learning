package com.zouxxyy.c02;

/*
208. 实现 Trie (前缀树)
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");
trie.search("app");     // 返回 true
说明:

你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。
 */

/*
好好学，好好记，重点记住节点的数据结构即可
 */

/**
 * @author zxy
 */
public class Solution08 {

    static class Trie {

        private static class Node {

            private final Node[] links;
            boolean isEnd;

            Node() {
                links = new Node[26];
            }

            /**
             * 添加子节点
             */
            private void add(char ch, Node node) {
                links[ch - 'a'] = node;
            }

            /**
             * 获取子节点
             */
            private Node get(char ch) {
                return links[ch - 'a'];
            }

            private boolean containsLink(char ch) {
                return links[ch - 'a'] != null;
            }

            public boolean isEnd() {
                return isEnd;
            }

            public void setEnd(boolean end) {
                isEnd = end;
            }
        }

        private final Node root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node cur = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!cur.containsLink(ch)) {
                    cur.add(ch, new Node());
                }

                cur = cur.get(ch);
            }

            cur.setEnd(true);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {

            Node node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {

            return searchPrefix(prefix) != null;

        }

        /**
         * 辅助函数，返回结尾Node，如果不含则返回null
         */
        private Node searchPrefix(String word) {
            Node cur = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!cur.containsLink(ch)) {
                    return null;
                }

                cur = cur.get(ch);
            }

            return cur;
        }
    }

}

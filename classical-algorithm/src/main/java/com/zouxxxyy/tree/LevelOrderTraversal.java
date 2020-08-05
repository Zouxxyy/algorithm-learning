package com.zouxxxyy.tree;

import com.zouxxxyy.structure.BinaryTree;

import java.util.*;

/*
二叉树的层序遍历

使用队列
 */

/**
 * @author zxy
 */
public class LevelOrderTraversal<T> {

    public List<List<T>> levelOrder(BinaryTree<T> root) {

        List<List<T>> res = new ArrayList<>();
        LinkedList<BinaryTree<T>> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {

            List<T> list = new ArrayList<>();

            int count = queue.size();
            for (int i = 0; i < count; i++) {

                BinaryTree<T> get = queue.removeFirst();

                list.add(get.val);

                if (get.left != null) {
                    queue.add(get.left);
                }

                if (get.right != null) {
                    queue.add(get.right);
                }

            }

            res.add(list);
        }

        return res;
    }

}

package com.zouxxxyy.tree;

import com.zouxxxyy.structure.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
二叉树的中序遍历

方法一：递归
方式二：栈
 */

/**
 * @author zxy
 */
public class InorderTraversal<T> {

    /**
     * 方式一：使用递归实现中序遍历
     */
    public List<T> inorderTraversalRe(BinaryTree<T> root) {

        ArrayList<T> res = new ArrayList<>();
        recursive(root, res);
        return res;

    }

    private void recursive(BinaryTree<T> node, List<T> res) {
        if (node != null) {
            recursive(node.left, res);
            res.add(node.val);
            recursive(node.right, res);
        }
    }


    /*
    一统天下写法思路：

             1
            / \
           2   3
          / \
         4   5

     递归思路：r(1) -> r(2)       ->      r(4)     ->    使用4
                       |                 |
                     使用1              使用2
                       |                 |
                     r(3) -> 使用3      r(5) -> 使用5


     栈思路：r(n) = r(左) -> 使用n -> r(右)，根据栈先进后出的规则，按照r(右)、使用n、r(左) 的顺序入栈
            但是你会发现有两种需求，一种是r(n)表示递归函数，一种是使用n。因此为了区分两种需求，引入 null 标志（图中用x表示）
            如果栈中取出的是 null，表明要使用下一个弹出的n。如果取出的不是 null，就是递归函数，按照r(右)、使用n、r(左) 的顺序入栈


                                       | x |
                              | 4 |    | 4 |
                              | x |    | x |   | x |
                              | 2 |    | 2 |   | 2 |           | x |
                     | 2 |    | 5 |    | 5 |   | 5 |   | 5 |   | 5 |
                     | x |    | x |    | x |   | x |   | x |   | x |   | x |
                     | 1 |    | 1 |    | 1 |   | 1 |   | 1 |   | 1 |   | 1 |            | x |
            | 1 |    | 3 |    | 3 |    | 3 |   | 3 |   | 3 |   | 3 |   | 3 |   | 3 |    | 3 |
            |___|    |___|    |___|    |___|   |___|   |___|   |___|   |___|   |___|    |___|   |___|
     */


    /**
     * 方式二：不使用递归实现中序遍历
     */
    public List<T> inorderTraversal(BinaryTree<T> root) {

        ArrayList<T> res = new ArrayList<>();
        Deque<BinaryTree<T>> stack = new LinkedList<>();

        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {

            BinaryTree<T> pop = stack.pop();

            res.add(pop.val);

            if (pop.right != null) {
                stack.push(pop.right);
            }

            if (pop.left != null) {
                stack.push(pop.left);
            }

        }

        return res;
    }

}

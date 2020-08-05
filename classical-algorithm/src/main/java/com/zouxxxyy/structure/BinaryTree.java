package com.zouxxxyy.structure;


/**
 * @author zxy
 */
public class BinaryTree<T> {

    public T val;

    public BinaryTree<T> left;
    public BinaryTree<T> right;

    public BinaryTree(T val) {
        this(val, null, null);
    }

    public BinaryTree(T val, BinaryTree<T> left, BinaryTree<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

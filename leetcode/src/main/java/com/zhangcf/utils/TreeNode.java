package com.zhangcf.utils;


public class TreeNode<T> {
    T val;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(){}

    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}

package com.zhangcf.utils;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSearch {

    // 初始化二叉树
    public TreeNode<String> init() {
        TreeNode<String> D = new TreeNode<>("D", null, null);
        TreeNode<String> H = new TreeNode<>("H", null, null);
        TreeNode<String> I = new TreeNode<>("I", null, null);
        TreeNode<String> J = new TreeNode<>("J", null, null);
        TreeNode<String> P = new TreeNode<>("P", null, null);
        TreeNode<String> G = new TreeNode<>("G", P, null);
        TreeNode<String> F = new TreeNode<>("F", null, J);
        TreeNode<String> E = new TreeNode<>("E", H, I);
        TreeNode<String> B = new TreeNode<>("B", D, E);
        TreeNode<String> C = new TreeNode<>("C", F, G);
        TreeNode<String> A = new TreeNode<>("A", B, C);
        return A;
    }

    public void print(TreeNode treeNode){
        System.out.print(treeNode.getVal() + " ");
    }

    public void preSearch(TreeNode root){
        print(root);
        if (root.left != null){
            preSearch(root.left);
        }
        if (root.right != null){
            preSearch(root.right);
        }
    }

    public void midSearch(TreeNode root){

        if (root.left != null){
            preSearch(root.left);
        }
        print(root);
        if (root.right != null){
            preSearch(root.right);
        }
    }

    public void postSearch(TreeNode root){

        if (root.left != null){
            preSearch(root.left);
        }
        if (root.right != null){
            preSearch(root.right);
        }
        print(root);
    }

    public void levelSearch(TreeNode root){
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode head = queue.poll();
            print(head);
            if (head.getLeft() != null){
                queue.offer(head.getLeft());
            }
            if (head.getRight() != null){
                queue.offer(head.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeSearch treeSearch = new TreeSearch();
        TreeNode<String> root = treeSearch.init();
        treeSearch.preSearch(root);
        System.out.println();
        treeSearch.midSearch(root);
        System.out.println();
        treeSearch.postSearch(root);
        System.out.println();
        treeSearch.levelSearch(root);
    }
}

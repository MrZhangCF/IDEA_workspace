package com.zhangcf.code;

import com.zhangcf.utils.TreeNode;
import com.zhangcf.utils.TreeSearch;

public class N1 {
    public int run(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null){
            return 1;
        }
        if (root.getLeft() == null){
            return run(root.getRight()) + 1;
        }
        if (root.getRight() == null){
            return run(root.getLeft()) + 1;
        }
        return Math.min(run(root.getLeft()), run(root.getRight())) + 1;
    }

    public int f(int a){
        if (a == 0)
            return 0;
        if (a == 1)
            return 1;
        return a * f(a - 1);
    }

    public static void main(String[] args) {
        System.out.println(new N1().run(new TreeSearch().init()));
        System.out.println(new N1().f(3));

    }
}

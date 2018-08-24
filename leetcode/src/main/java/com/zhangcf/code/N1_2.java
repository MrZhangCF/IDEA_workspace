package com.zhangcf.code;

import com.zhangcf.utils.TreeNode;
import com.zhangcf.utils.TreeSearch;

public class N1_2 {
    public int run(TreeNode root){

        if (root == null)
            return 0;
        if(root.getLeft() == null && root.getRight() == null)
            return 1;
        if (root.getLeft() == null)
            return run(root.getRight()) + 1;
        if (root.getRight() == null){
            return run(root.getLeft()) + 1;
        }

        return Math.max(run(root.getLeft()) + 1, run(root.getRight()) + 1);
    }

    public static void main(String[] args) {
        System.out.println(new N1_2().run(new TreeSearch().init()));
    }
}

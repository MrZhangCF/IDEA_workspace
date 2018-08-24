package com.zhangcf.ObjectPart;

public class JavaStackOverflow {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaStackOverflow oom = new JavaStackOverflow();
        try{
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length: " + oom.stackLength);
            throw e;
        }

    }
}

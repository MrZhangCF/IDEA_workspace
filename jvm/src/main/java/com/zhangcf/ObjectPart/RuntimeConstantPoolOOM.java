package com.zhangcf.ObjectPart;

import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        //使用list保持着常量池引用，避免GC回收常量池行为。
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}

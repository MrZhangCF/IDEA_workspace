package com.zhangcf.ObjectPart;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args:-Xms 20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObejct{}

    public static void main(String[] args) {
        List<OOMObejct> list = new ArrayList<>();
        while (true){
            list.add(new OOMObejct());
        }
    }
}

package com.zhangcf.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class N4 {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            arrayList.add(numbers[i]);
        }
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1 + "" + o2;
                String str2 = o2 + "" + o1;
                return str1.compareTo(str2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Integer in :
                arrayList) {
            sb.append(in);
        }
        return sb.toString();
    }
}

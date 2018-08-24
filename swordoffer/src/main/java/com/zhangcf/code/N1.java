package com.zhangcf.code;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class N1 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        final int j ;

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            arrayList.add(input[i]);
        }
        Collections.sort(arrayList);
//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.println(arrayList.get(i));
//        }
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (int i = 0 ; i < 4; i++) {
            arrayList1.add(arrayList.get(i));
        }
        return arrayList1;
    }

    public static void main(String[] args) {
        int [] input = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> arrayList = new N1().GetLeastNumbers_Solution(input,4);
        for (int i = 0; i < 4; i++) {
            arrayList.get(i);
        }
    }
}

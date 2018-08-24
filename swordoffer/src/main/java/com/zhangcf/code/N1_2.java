package com.zhangcf.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class N1_2 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int length = input.length;
        if (k > length || k == 0)
            return result;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                 return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k){
                maxHeap.offer(input[i]);
            }else if (input[i] < maxHeap.peek()){
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }

        for (Integer node :
                maxHeap) {
            result.add(node);
        }
        return result;
    }
    public static void main(String[] args) {
        int [] input = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> arrayList = new N1_2().GetLeastNumbers_Solution(input,4);
        for (Integer node:arrayList
             ) {
            System.out.println(node);
        }
    }
}

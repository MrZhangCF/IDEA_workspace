package com.zhangcf.code;

public class N7 {
    public int InversePairs(int [] array) {
        int length = array.length;
        int count = 0;
        for (int i = length-1; i > 0; i--) {
            for (int j = i - 1; j >=0 ; j--) {
                if (array[i] < array[j])
                    count++;
            }
        }

        return count;
    }
}

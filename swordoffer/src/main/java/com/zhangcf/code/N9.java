package com.zhangcf.code;

public class N9 {
    public int GetNumberOfK(int [] array , int k) {
        return binaSearch(array,k+0.5) - binaSearch(array,k-0.5) - 1;
    }

    private int binaSearch(int[] array, double v) {
        int start = 0;
        int end = array.length-1;
        while (start <= end){
            int mid = (end - start) / 2 + start;
            if (array[mid] > v)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) {
        int [] array = {1,2,2,2,2,1};
        System.out.println(new N9().GetNumberOfK(array,2));
    }
}

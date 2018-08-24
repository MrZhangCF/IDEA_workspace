package com.zhangcf.code;

public class N9_2 {
    public int GetNumberOfK(int [] array , int k) {

        int first = getFirst(array, 0 ,array.length-1, k);
        int last = getLast(array, 0 ,array.length-1, k);
        if (first != -1 && last != -1)
            return last - first + 1;
        return 0;
    }

    private int getLast(int[] array, int s, int e, int k) {
        if (s > e)
            return -1;
        int mid = (s + e) >> 1;
        if (array[mid] > k)
            return getLast(array, s, mid - 1, k);

        else if (array[mid] < k)
            return getLast(array, mid + 1, e, k);
        else if (mid + 1 <= array.length-1 && array[mid + 1] == k)
            return getLast(array, mid + 1, e, k);
        else{
            return mid;
        }
    }

    private int getFirst(int[] array, int s, int e, int k) {
        if (s > e)
            return -1;
        int mid = (s + e) >> 1;
        if (array[mid] > k)
            return getFirst(array, s, mid -1, k);
        else if (array[mid] < k)
            return getFirst(array, mid + 1, e,k);
        else if (mid - 1 >= 0 && array[mid - 1] == k)
            return getFirst(array, s, mid - 1, k);
        else{
            return mid;
        }
    }

    public static void main(String[] args) {
        int [] array = {1,2,3,3,3,3,4,5};
        System.out.println(new N9_2().GetNumberOfK(array,3));
    }
}

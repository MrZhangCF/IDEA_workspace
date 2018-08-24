package com.zhangcf.code;

public class N2 {
    /**
     * 解题思路见注释；
     * 时间复杂度：o（n）
     * 空间复杂度：o（1）
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null){
            return 0;
        }
        int result = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) { //从第2个开始遍历
            max = Math.max(max + array[i], array[i]);   //如果前者小，说明max是负数，则应该将array[i]作为最大值，因为无论array[i]正负，最大值都会变小。
            result = Math.max(max, result);
        }
        return result;
    }
}

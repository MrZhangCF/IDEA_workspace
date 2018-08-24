package com.zhangcf.code;

public class N3 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        String temp = null;
        for (Integer i = 1; i <= n; i++) {
            temp = i.toString();
            if (temp.contains("1")){
                for (int j = 0; j < temp.length(); j++) {
                    if (temp.charAt(j) == '1')
                        count++;
                }
            }
//            String[] strings = temp.split("");
//            for (String string:strings) {
//                if (string.equals("1"))
//                    count++;
//            }
        }
        return count;
    }

    /**
     * 解题思路：统计每一位上从0到n中k出现的次数
     * 其中，num分别表示每一位数，weight表示该数的权重，round表示该数出现了多少轮，一轮为0~9
     * 最终结果为，每一位出现的轮数 * 权重 + 边际情况
     * @param n 最大数
     * @param k 目标数 0 ~ 9
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n,int k) {

        if (n < 1)
            return 0;
        int count = 0;
        int base = 1;
        int round = n;
        while (round > 0){
            int num = n % 10;
            round /= 10;
            count += round * base;
            if (num > k)
                count += base;
            else if (num == k)
                count += (n % base + 1);
            base *= 10;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new N3().NumberOf1Between1AndN_Solution(534,1));
    }
}

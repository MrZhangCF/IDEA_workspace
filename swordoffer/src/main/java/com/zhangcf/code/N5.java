package com.zhangcf.code;

import java.util.LinkedList;
import java.util.Queue;

public class N5 {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0)
            return 0;
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        Queue<Integer> queue3 = new LinkedList<>();

        queue1.add(2);
        queue2.add(3);
        queue3.add(5);

        int min = 1;

        for (int i = 1; i < index; i++) {
            min = Math.min(queue1.peek(), Math.min(queue2.peek(), queue3.peek()));
            if (min == queue1.peek()) {

                queue1.offer(min * 2);
                queue2.offer(min * 3);
                queue3.offer(min * 5);
                queue1.poll();

            } else if (min == queue2.peek()) {

                queue2.offer(min * 3);
                queue3.offer(min * 5);
                queue2.poll();
            } else {
                queue3.offer(min * 5);
                queue3.poll();
            }

        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new N5().GetUglyNumber_Solution(2));
    }
}

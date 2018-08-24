package com.zhangcf.code;

import java.util.HashMap;
import java.util.Map;

public class N8_2 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);
        if (length1 >= length2){
            int temp = length1 - length2;
            for (int i = 0; i < temp; i++) {
                pHead1 = pHead1.next;
            }
        }else {
            int temp = length2 - length1;
            for (int i = 0; i < temp; i++) {
                pHead2 = pHead2.next;
            }
        }
        while (pHead1 != pHead2){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    public int getLength(ListNode node){
        int length = 0;
        while(node != null){
            length++;
            node = node.next;
        }
        return length;
    }
}

package com.zhangcf.code;


import java.util.HashMap;
import java.util.Map;

public class N8 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Map<ListNode,Integer> map = new HashMap<>();
        while(pHead1 != null){
            map.put(pHead1,null);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null){
            if (map.containsKey(pHead2)){
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }

}

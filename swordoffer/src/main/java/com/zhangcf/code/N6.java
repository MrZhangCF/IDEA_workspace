package com.zhangcf.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 两次遍历字符串，第一次存入哈希表，第二次查询出现的次数。
 * 时间复杂度：o（n）
 * 空间复杂度：o（n）
 */
public class N6 {
    public int FirstNotRepeatingChar(String str) {
        int length = str.length();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char temp = str.charAt(i);
            if (map.containsKey(temp)){
                int value = map.get(temp);
                map.put(temp,++value);
            }else{
                map.put(temp, 1);
            }
        }

        for (int i = 0; i < length; i++) {
            if (map.get(str.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}

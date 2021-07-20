package com.streamlet.lrucache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Linxz
 * 创建日期：2021年04月03日 12:56 PM
 * version：
 * 描述：
 */
class LruCacheTestMain {

    public static void main(String[] args) {
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap(0,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry entry) {
                return size()>3;
            }
        };
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.get(3);
        map.get(0);
      //  map.get(4);

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }
}

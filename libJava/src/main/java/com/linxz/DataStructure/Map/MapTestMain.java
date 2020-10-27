package com.linxz.DataStructure.Map;


import java.util.HashMap;

/**
 * @author Linxz
 * 创建日期：2020年07月13日 10:13
 * version：v4.5.4
 * 描述：
 */
public class MapTestMain {

    public static void main(String[] args) {
        BSTMap<String,String> linkeMap=new BSTMap<>();
        linkeMap.add("l123","刘备");
        linkeMap.add(2+"","关羽");
        linkeMap.add("fadsf","张飞");
       // linkeMap.add("1","玄德");
        System.out.println(linkeMap);
        System.out.println(linkeMap.get(2+""));
        System.out.println(linkeMap.contains(2+""));
        System.out.println(linkeMap.getSize());
        System.out.println("-----删除-----");
        System.out.println(linkeMap.remove(2+""));
        System.out.println(linkeMap);
        System.out.println("-----设置-----");
        linkeMap.set(1+"","曹操");
        System.out.println(linkeMap);

        HashMap a=new HashMap();
    }
}

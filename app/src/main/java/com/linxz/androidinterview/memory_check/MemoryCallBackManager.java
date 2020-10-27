package com.linxz.androidinterview.memory_check;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Linxz
 * 创建日期：2020年10月23日 10:22
 * version：
 * 描述：
 */
public class MemoryCallBackManager {


    public static List<MemoryCallBack> list=new ArrayList<>();



    public static void addCallBack(MemoryCallBack callBack){
        list.add(callBack);
    }

    public static void removeCallBack(MemoryCallBack callBack){
        list.remove(callBack);
    }
}

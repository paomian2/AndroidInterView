package com.linxz.DataStructure.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Linxz
 * 创建日期：2020年07月10日 07:57
 * version：v4.5.4
 * 描述：
 */
public class ObUserTest {


    public String name;


    public static void main(String[] args) {
//        ObUserTest obUserA=new ObUserTest();
//        obUserA.name="fdaf";
//        ObUserTest obUserB=obUserA;
//
//        System.out.println(obUserA);
//        System.out.println(obUserB);
//
//       // obUserA=null;
//        obUserA.name="张飞";
//        System.out.println("-----------");
//        System.out.println(obUserA.name);
//        System.out.println(obUserB.name);

        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("0");
        arrayList.add("1");
        arrayList.add("0");
        arrayList.remove("0");
        System.out.println(arrayList.size());


    }
}

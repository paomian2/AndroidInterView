package com.streamlet.proxy;

/**
 * @author Linxz
 * 创建日期：2021年03月04日 8:52 AM
 * version：
 * 描述：
 */
class CoderMain {


    public static void main(String[] args) {
        Bingbing bye=new Bingbing();

        DoSomeThingDynamic doSomeThingDynamic=new DoSomeThingDynamic(new Object());
        BingbingInterface bingbingInterface=doSomeThingDynamic.create(BingbingInterface.class);
        bingbingInterface.sayBye();


    }
}

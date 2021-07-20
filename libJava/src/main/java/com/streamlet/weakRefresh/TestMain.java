package com.streamlet.weakRefresh;

import java.lang.ref.WeakReference;

/**
 * @author Linxz
 * 创建日期：2021年04月06日 12:30 AM
 * version：
 * 描述：
 */
class TestMain {

    public  void main(String[] args) {
//        String str=new String("linxz");
//        WeakReference<String> weakReference=new WeakReference<>(str);
//        str=null;
//        System.gc();
//        try {
//            Thread.sleep(2000);
//            System.out.println(weakReference.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        TestMain testMain=new TestMain();
        testMain.setStr(new String("linxz"));

        MyHandler myHandler=new MyHandler();
        myHandler.handlerMessage();

        testMain=null;

        myHandler.handlerMessage();
    }


    private String str;
    public void setStr(String s){
        this.str=s;
    }

    public class MyHandler{

        public void handlerMessage(){
            System.out.println(str);
        }

    }
}

package com.linxz.androidinterview.mvvm;


/**
 * @author Linxz
 * 创建日期：2021年07月19日 11:38 AM
 * version：
 * 描述：
 */
public class MyLiveData {


    private Object mData;
    private Observerble observerble;

    public void setValue(Object data){
        this.mData = data;
        if (observerble!=null){
            observerble.change(mData);
        }
    }


    public void observer(Observerble observerble){
        this.observerble = observerble;
    }




    public interface Observerble{
        void change(Object data);
    }





}

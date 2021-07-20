package com.linxz.androidinterview.mvvm;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author Linxz
 * 创建日期：2021年04月14日 12:36 AM
 * version：
 * 描述：
 */
public class ShareViewModel extends ViewModel {



    private MutableLiveData<String> userList=new MutableLiveData<>();

    private MyLiveData myLiveData = new MyLiveData();

    public LiveData<String> getUserList(){
        return userList;
    }

    public MyLiveData getMyLiveData(){
        return myLiveData;
    }

    public ShareViewModel(){
        Log.d("viewModel","init...");
    }

    public void doAction(){
        userList.setValue("张三");
        myLiveData.setValue("风满楼");
    }

}

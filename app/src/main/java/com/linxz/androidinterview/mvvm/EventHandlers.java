package com.linxz.androidinterview.mvvm;

import android.util.Log;
import android.view.View;

/**
 * @author Linxz
 * 创建日期：2021年07月20日 10:23 AM
 * version：
 * 描述：
 */
public class EventHandlers {

    private UpdateObserverble  updateObserverble;

    public EventHandlers(UpdateObserverble updateObserverble){
        this.updateObserverble = updateObserverble;
    }

    public void onUpdate(View view){
        Log.d("TAG","点击事件");
        if (updateObserverble!=null){
            updateObserverble.onUpdate();
        }
    }

    public void onUpdate2(String userName){
        Log.d("TAG",userName);
    }

    interface UpdateObserverble{
        void onUpdate();
    }
} 
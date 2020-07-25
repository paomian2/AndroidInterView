package com.linxz.androidinterview;

import android.app.Application;
import android.util.Log;

/**
 * @author Linxz
 * 创建日期：2020年06月12日 13:47
 * version：v4.5.4
 * 描述：
 */
public class App extends Application {

    public static App instance=null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        Log.d("TAG1","fdasfasf");
    }
}

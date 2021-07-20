package com.linxz.androidinterview.source_code.evenbus;

import org.greenrobot.eventbus.EventBus;

/**
 * @author Linxz
 * 创建日期：2021年04月04日 1:12 PM
 * version：
 * 描述：
 */
class EvenBusActivity {


    public void init(){
        EventBus.getDefault().register(this);
    }
}

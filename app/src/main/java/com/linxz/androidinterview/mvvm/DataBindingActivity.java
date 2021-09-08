package com.linxz.androidinterview.mvvm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.linxz.androidinterview.BR;
import com.linxz.androidinterview.R;
import com.linxz.androidinterview.databinding.ActDatabindingTestBindingImpl;

/**
 * @author Linxz
 * 创建日期：2021年07月20日 9:20 AM
 * version：
 * 描述：
 */
public class DataBindingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActDatabindingTestBindingImpl dataBinding = DataBindingUtil.setContentView(this,R.layout.act_databinding_test);
        final DataBindingBean dataBindingBean = new DataBindingBean();
        dataBindingBean.setUserName("风满楼");
        dataBindingBean.setAvatar("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201804%2F28%2F20180428114906_ulvqd.jpg&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1629337325&t=660ef0873c1ca5518d5f8bb03a1a9775");
        dataBinding.setUser(dataBindingBean);
        EventHandlers eventHandlers = new EventHandlers(new EventHandlers.UpdateObserverble() {
            @Override
            public void onUpdate() {
                dataBindingBean.setUserName("璀、");
               // dataBindingBean.notifyChange();
            }
        });
        dataBinding.setEvenHandlers(eventHandlers);
    }
}

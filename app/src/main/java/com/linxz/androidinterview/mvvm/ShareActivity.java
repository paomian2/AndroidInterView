package com.linxz.androidinterview.mvvm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.linxz.androidinterview.R;
import com.linxz.libapp.LibAppHomeActivity;
import com.linxz.libapp2.LibApp2HomeActivity;
import com.linxz.libappbase.router.LinxzRouter;

/**
 * @author Linxz
 * 创建日期：2021年04月14日 9:47 AM
 * version：
 * 描述：
 */
public class ShareActivity extends AppCompatActivity {

    private TextView tvContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_mvvm);
        tvContent=findViewById(R.id.tvContent);
        final ShareViewModel shareViewMode =  ViewModelProviders.of(this).get(ShareViewModel.class);
        shareViewMode.getUserList().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
               // tvContent.setText(s);
            }
        });
        findViewById(R.id.tvTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareViewMode.doAction();
            }
        });

        shareViewMode.getMyLiveData().observer(new MyLiveData.Observerble() {
            @Override
            public void change(Object data) {
                tvContent.setText(data.toString());
            }
        });


//        shareViewModel.getUserList().observe(this, (Observer) o -> {
//            tvContent.setText(new Gson().toJson(o));
//        });
//
//        Glide.with(this).load("").into(new ImageView(this));

//        LinxzRouter.getInstance().bindActivity("LibAppHomeActivity", LibAppHomeActivity.class);
//        LinxzRouter.getInstance().bindActivity("LibApp2HomeActivity", LibApp2HomeActivity.class);
//        LinxzRouter.getInstance().init(this);
//        startActivity(new Intent(this, LibAppHomeActivity.class));



    }
}

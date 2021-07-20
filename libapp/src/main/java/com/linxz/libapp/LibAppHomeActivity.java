package com.linxz.libapp;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.linxz.libappbase.router.LinxzRouter;

/**
 * @author Linxz
 * 创建日期：2021年04月19日 11:47 AM
 * version：
 * 描述：
 */

public class LibAppHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_libapp_home);

    }

    public void onLibAppHomeClick(View view){
        LinxzRouter.getInstance().navigation(this,"LibApp2HomeActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}

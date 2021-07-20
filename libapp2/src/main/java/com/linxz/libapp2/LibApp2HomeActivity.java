package com.linxz.libapp2;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.linxz.libappbase.router.LinxzRouter;

/**
 * @author Linxz
 * 创建日期：2021年04月19日 11:50 AM
 * version：
 * 描述：
 */
public class LibApp2HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_libapp2_home);
    }

    public void onApp2HomeClick(View view){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

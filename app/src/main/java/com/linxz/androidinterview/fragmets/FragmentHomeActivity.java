package com.linxz.androidinterview.fragmets;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.linxz.androidinterview.R;

/**
 * @author Linxz
 * 创建日期：2021年05月27日 1:35 PM
 * version：
 * 描述：
 * https://blog.csdn.net/shw372029857/article/details/48949093?locationNum=5
 */
public class FragmentHomeActivity extends AppCompatActivity {

    private AddFragment addFragment;
    private ReplaceFragment replaceFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_fragmets_home);

        findViewById(R.id.btn1).setOnClickListener(v -> {
            LayoutFragment fragment = (LayoutFragment) getSupportFragmentManager().findFragmentById(R.id.fragment1);
            fragment.setTest("修改了值啦");
        });

        findViewById(R.id.btn2).setOnClickListener(v -> {
             addFragment = new AddFragment();
             getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer,addFragment).commit();
        });

        findViewById(R.id.btn3).setOnClickListener(v -> {
             replaceFragment = new ReplaceFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer2,replaceFragment).commit();
        });

        findViewById(R.id.btn4).setOnClickListener(v -> {
            if (addFragment == null || replaceFragment == null) return;
            getSupportFragmentManager().beginTransaction().remove(addFragment).remove(replaceFragment).commit();
        });

        findViewById(R.id.btn5).setOnClickListener(v -> {
            if (addFragment == null || replaceFragment == null) return;
            getSupportFragmentManager().beginTransaction().hide(addFragment).hide(replaceFragment).commit();
        });
        findViewById(R.id.btn6).setOnClickListener(v -> {
            if (addFragment == null || replaceFragment == null) return;
            getSupportFragmentManager().beginTransaction().show(addFragment).show(replaceFragment).commit();
            Toast.makeText(FragmentHomeActivity.this,"首页Tab切换使用这种方式",Toast.LENGTH_LONG).show();
        });

        findViewById(R.id.btn7).setOnClickListener(v -> {
            //使用remove方法进行推栈操作
            //布局引入的方式没办法推栈
            FragmentHelperManager.getInstance().pop(this);
        });
    }


}

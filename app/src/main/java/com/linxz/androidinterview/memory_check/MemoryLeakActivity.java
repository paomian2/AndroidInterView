package com.linxz.androidinterview.memory_check;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.linxz.androidinterview.R;
//内存泄露检测,反复进入该页面
public class MemoryLeakActivity extends AppCompatActivity implements MemoryCallBack{

    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_leak);
        iv=findViewById(R.id.iv);
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.memory_leak3);
        iv.setImageBitmap(bitmap);
        //把这行代码去除一只，不会阶梯形增大。页面返回之后内存会变小，50->106->50->106
        MemoryCallBackManager.addCallBack(this);
    }

    @Override
    public void onPre() {
        //pre do sth
    }
}

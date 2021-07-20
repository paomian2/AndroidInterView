package com.linxz.androidinterview.layout_optimize;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.linxz.androidinterview.R;

import java.util.ArrayList;

/**
 * @author Linxz
 * 创建日期：2021年01月04日 23:33
 * version：
 * 描述：
 */
public class LayoutOptimizeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.act_optimize);
//
//        String sex="女";
//        if (sex.equals("男")){
//            ViewStub sub= findViewById(R.id.layoutSexMan);
//            sub.inflate();
//        }else{
//            ViewStub sub= findViewById(R.id.layoutSexWoman);
//            sub.inflate();
//        }


        setContentView(R.layout.merge_shell);
        LinearLayout layoutMain = findViewById(R.id.layoutMain);
        ArrayList<View> list = getAllChildren(layoutMain);
        for (View view : list) {
            Log.d("optimize", view.getClass().getSimpleName());
        }
    }


    private ArrayList<View> getAllChildren(View v) {

        if (!(v instanceof ViewGroup)) {
            ArrayList<View> viewArrayList = new ArrayList<>();
            viewArrayList.add(v);
            return viewArrayList;
        }

        ArrayList<View> result = new ArrayList<>();

        ViewGroup viewGroup = (ViewGroup) v;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);

            ArrayList<View> viewArrayList = new ArrayList<>();
            viewArrayList.add(child);//v
            viewArrayList.addAll(getAllChildren(child));

            result.addAll(viewArrayList);
        }
        return result;
    }
}

package com.linxz.androidinterview.fragmets;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.linxz.androidinterview.R;

/**
 * @author Linxz
 * 创建日期：2021年05月27日 2:02 PM
 * version：
 * 描述：
 */
public class ReplaceFragment extends BaseFragment{

    private View contentView;

    @SuppressLint("InflateParams")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.frag_layout,container,false);
        ((TextView)contentView.findViewById(R.id.tvTip)).setText("我是Replace Fragment");
        return contentView;
    }

    public void setTest(String s){
        TextView tv = contentView.findViewById(R.id.tvTip);
        tv.setText(s);
    }

}

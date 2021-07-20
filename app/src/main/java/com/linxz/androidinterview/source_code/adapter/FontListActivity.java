package com.linxz.androidinterview.source_code.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.linxz.androidinterview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Linxz
 * 创建日期：2021年04月04日 11:28 PM
 * version：
 * 描述：
 */
class FontListActivity extends Activity {


    private ListView listView;
    private List<OrderInterface> fontListData=new ArrayList<>();
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_fontlist);
        listView=findViewById(R.id.list);
        layoutInflater=LayoutInflater.from(this);
        FontListAdapter adapter=new FontListAdapter();
        listView.setAdapter(adapter);

        //接口返回数据列表
        String isServiceOrder="";
        if ("服务订单".equals(isServiceOrder)){
            //生成服务订单
            //ServiceOrderFactory.create(); OrderInterface
        }else{
            //生成预约订单
            //appoinntmentOrderFractory.create(); OrderInterface
        }
    }



    public interface OrderInterface{
        void onBtn1Click();
    }

    private class FontListAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        //fontListData.get(0);
                    }
                }
            });
            return fontListData.size();
        }

        @Override
        public OrderInterface getItem(int position) {
            return fontListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint("InflateParams")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if (convertView==null){
                view=layoutInflater.inflate(R.layout.item_font,null);
                convertView.setTag(view);
            }else{
                view= (View) convertView.getTag();
            }
            OrderInterface orderInterface=getItem(position);
            TextView listItem=view.findViewById(R.id.list_item);
            listItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    orderInterface.onBtn1Click();
                }
            });
            return view;
        }
    }
}

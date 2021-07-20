package com.linxz.androidinterview.annotations.runtime;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.linxz.androidinterview.R;

/**
 * @author Linxz
 * 创建日期：2020年07月30日 14:07
 * version：v4.5.4
 * 描述：
 */
@ContentView(R.layout.act_annotation_test)
public class AnnotationTestActivity extends Activity {

    @BindView(R.id.tvAnnotation)
    TextView textView;

    @Autowired
    private Studet studet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InjectUtils.inject(this);

        textView.setText("我是注解生成的对象");
    }


    @ViewOnClick({R.id.tvAnnotation})
    public void onClickDef(View view){
        Toast.makeText(AnnotationTestActivity.this,"注解生成点击事件",Toast.LENGTH_LONG).show();
    }

}

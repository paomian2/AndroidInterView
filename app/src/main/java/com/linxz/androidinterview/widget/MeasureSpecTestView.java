package com.linxz.androidinterview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author Linxz
 * 创建日期：2020年10月19日 11:32
 * version：
 * 描述：
 */
public class MeasureSpecTestView extends View {

    private String mMeasureSpec;

    public MeasureSpecTestView(Context context) {
        super(context);
    }

    public MeasureSpecTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureSpecTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode=MeasureSpec.getMode(widthMeasureSpec);
        switch (mode) {
            case MeasureSpec.AT_MOST:
                Log.d("MeasureSpecTestView","AT_MOST");
                mMeasureSpec="AT_MOST";
                break;
            case MeasureSpec.EXACTLY:
                Log.d("MeasureSpecTestView","EXACTLY");
                mMeasureSpec="EXACTLY";
                break;
            case MeasureSpec.UNSPECIFIED:
                Log.d("MeasureSpecTestView","UNSPECIFIED");
                mMeasureSpec="UNSPECIFIED";
                break;
            default:
                mMeasureSpec="未知";
                break;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //View 绘制红色
        canvas.drawColor(Color.RED);
    }

    public String getMeasureSpec(){
        return mMeasureSpec;
    }
}

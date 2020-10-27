package com.linxz.androidinterview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author Linxz
 * 创建日期：2020年10月19日 15:22
 * version：
 * 描述：
 */
public class HelloWordView extends View {

    private Paint mPaint;

    public HelloWordView(Context context) {
        super(context);
    }

    public HelloWordView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HelloWordView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){
        mPaint=new Paint();
        mPaint.setTextSize(50);
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width= (getWidth() >> 1) -mPaint.measureText("Hello word")/2;
        canvas.drawText("Hello word",width,getHeight()/2,mPaint);
    }
}

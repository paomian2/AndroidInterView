package com.linxz.androidinterview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Linxz
 * 创建日期：2021年04月11日 1:01 AM
 * version：
 * 描述：
 */
class MeasureSpecViewGroup extends ViewGroup {
    public MeasureSpecViewGroup(Context context) {
        super(context);
    }

    public MeasureSpecViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureSpecViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count=getChildCount();
        for (int i=0;i<count;i++){
            View view=getChildAt(i);
            LayoutParams lp=view.getLayoutParams();
            int spec=getChildMeasureSpec(widthMeasureSpec,getPaddingLeft()+getPaddingRight(),lp.width);

        }
    }
}

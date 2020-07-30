package com.linxz.androidinterview.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.linxz.androidinterview.R;

/**
 * @author Linxz
 * 创建日期：2020年07月29日 09:40
 * version：v4.5.4
 * 描述：
 */
public class StudyView extends View {
    public StudyView(Context context) {
        super(context);
    }

    public StudyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StudyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public StudyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width=MeasureSpec.getSize(widthMeasureSpec);
        int height=MeasureSpec.getSize(heightMeasureSpec);
        if (height>width){
            width=height;
        }else{
            height=width;
        }
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
       // super.onDraw(canvas);一定要注释,不然下面的代码无效

        //画点
        Paint paintPoint=new Paint();
        paintPoint.setStrokeWidth(4F);
        paintPoint.setColor(Color.WHITE);
        paintPoint.setStyle(Paint.Style.FILL);
        canvas.drawPoint(100, 10, paintPoint);
        //画多个点
        Paint paintPoints = new Paint();
        paintPoints.setColor(Color.WHITE);
        paintPoints.setStyle(Paint.Style.FILL);
        paintPoints.setStrokeWidth(4F);
        canvas.drawText("画点：", 10, 10, paintPoints);
        //{60,10,65,10,70,10},三个点(60,10),(65,10),(70,10)
        canvas.drawPoints(new float[]{60,10,65,10,70,10}, paintPoints);//画多个点

        //画线
        Paint paintLine=new Paint();
        paintLine.setStrokeWidth(2F);
        paintLine.setStyle(Paint.Style.STROKE);  //STROKE(描边) FILL(描内容) .FILL_AND_STROKE(既绘制轮廓也绘制内容)
        paintLine.setColor(Color.BLACK);
        paintLine.setStrokeJoin(Paint.Join.ROUND);

        Path pathLine = new Path();
        pathLine.lineTo(100, 100);//(0,0)-->(100,100)两点间画线
        canvas.drawPath(pathLine, paintLine);

        //画线框
        Paint paintMultiLine=new Paint();
        paintMultiLine.setStrokeWidth(2F);
        paintMultiLine.setStyle(Paint.Style.STROKE);
        paintMultiLine.setColor(Color.BLACK);
        paintMultiLine.setStrokeJoin(Paint.Join.ROUND);

        Path pathMutil = new Path();
        pathMutil.moveTo(110,110);//将启动由(0,0)转到(110,110)
        pathMutil.lineTo(150, 110);//(110,110)-->(150,110)两点间画线(水平的线)
        pathMutil.lineTo(150,150);//起点为上一步的终点，所以(150,110)-->(150,150)两点间画线(垂线)
        pathMutil.close();//封闭,比如画两条线，则会自动将多出一条将围城一个三角形
        canvas.drawPath(pathMutil, paintMultiLine);

        //画圆
        Paint paintCircle=new Paint();
        paintCircle.setColor(Color.RED);
        //cx,cy,radius->水平位置，垂直位置，半径
        canvas.drawCircle(150, 20, 20, paintCircle);

        //画矩形
        Paint paintRect=new Paint();
        paintRect.setStyle(Paint.Style.FILL);
        paintRect.setColor(Color.LTGRAY);
        paintRect.setAntiAlias(true);// 设置画笔的锯齿效果
        //left,top,right,bottom，(left,top)-->(right,bottom)，左上角点的位置，右下角点的位置
        RectF oval3 = new RectF(10, 260, 200, 300);
        //rx,ry矩形圆角角度
        canvas.drawRoundRect(oval3, 50, 50, paintRect);

        //写字
        Paint paintText=new Paint();
        paintText.setTextSize(24);
        paintText.setColor(Color.WHITE);
        canvas.drawText("你好呀",  200,  200, paintText);


        //画图片，就是贴图
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Paint paintBitmap=new Paint();
        canvas.drawBitmap(bitmap, 10,320,paintBitmap);

        //画圆弧度
        Paint p = new Paint();//这个是画矩形的画笔，方便大家理解这个圆弧
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.RED);

        Paint paintRadian = new Paint();//这个是画矩形的画笔，方便大家理解这个圆弧
        paintRadian.setAntiAlias(true);//取消锯齿
        paintRadian.setStyle(Paint.Style.FILL);
        paintRadian.setStrokeWidth(4F);
        paintRadian.setColor(Color.CYAN);
        float x = (getWidth() - getHeight() / 2) / 2;
        float y = getHeight() / 4;
        RectF oval = new RectF( x, y,
                getWidth() - x, getHeight() - y);
        canvas.drawArc(oval,360,140,true,paintRadian);//画圆弧，这个时候，绘制没有经过圆心
        canvas.drawRect(oval, p);//画矩形
    }
}

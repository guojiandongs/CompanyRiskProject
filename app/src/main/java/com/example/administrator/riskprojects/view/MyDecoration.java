package com.example.administrator.riskprojects.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.ColorRes;
import android.support.annotation.Px;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by Administrator on 3/8/17.
 */

public class MyDecoration extends RecyclerView.ItemDecoration {

    private Context mContext;
    private Paint paint;
    private int mColor;
    private int size;
    private int padding = 0;
    private boolean isDash = false;
    private float[] dashWidth = new float[]{4, 5};
    private int mOrientation;
    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;


    public MyDecoration(Context context, int orientation, @ColorRes int colorid, @Px int size) {
        this.mContext = context;
        this.size = size;
        this.mColor = colorid;
        this.paint = new Paint();
        paint.setAntiAlias(true);
        setOrientation(orientation);
    }

    public MyDecoration(Context mContext, int mOrientation, int mColor, int size, boolean isDash) {
        this(mContext, mOrientation, mColor, size);
        this.isDash = isDash;
    }

    public MyDecoration(Context mContext, int mOrientation, int mColor, int size, int padding, boolean isDash) {
        this(mContext, mOrientation, mColor, size);
        this.isDash = isDash;
        this.padding = padding;
    }

    public MyDecoration(Context mContext, int mOrientation, int mColor, int size, boolean isDash, float[] dashWidth) {
        this(mContext, mOrientation, mColor, size, isDash);
        this.dashWidth = dashWidth;
    }


    //设置屏幕的方向
    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {

        if (mOrientation == HORIZONTAL_LIST) {
            drawVerticalLine(c, parent, state);
        } else {
            drawHorizontalLine(c, parent, state);
        }
    }

    //画横线, 这里的parent其实是显示在屏幕显示的这部分
    public void drawHorizontalLine(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft() + padding;
        int right = parent.getWidth() - parent.getPaddingRight() - padding;
        final int childCount = parent.getChildCount() - 1;
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            //获得child的布局信息
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + size;
            paint.setColor(mContext.getResources().getColor(mColor));
            if (isDash) {
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(size);
                paint.setPathEffect(new DashPathEffect(dashWidth, 0));
                Path path = new Path();
                path.moveTo(left, top);//起始坐标
                path.lineTo(right, bottom);//终点坐标
                c.drawPath(path, paint);
            } else {
                c.drawRect(left, top, right, bottom, paint);
            }


            //Log.d("wnw", left + " " + top + " "+right+"   "+bottom+" "+i);
        }
    }

    //画竖线
    public void drawVerticalLine(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            //获得child的布局信息
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + size;
            paint.setColor(mContext.getResources().getColor(mColor));
            c.drawRect(left, top, right, bottom, paint);
        }
    }

    //由于Divider也有长宽高，每一个Item需要向下或者向右偏移
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == HORIZONTAL_LIST) {
            //画竖线，就是往右偏移一个分割线的宽度
            outRect.set(0, 0, size, 0);
        } else {
            //画横线，就是往下偏移一个分割线的高度
            outRect.set(0, 0, 0, size);

        }
    }

}

package com.celebritysupermarket.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by tt on 2016/6/20.
 */

public class NoScrollViewPager extends LazyViewPager
{

    public NoScrollViewPager(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        return false;
        // return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev)
    {

        return false;
        // // TODO Auto-generated method stub
        // return super.onTouchEvent(ev);
    }

}
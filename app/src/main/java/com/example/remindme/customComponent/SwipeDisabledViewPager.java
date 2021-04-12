/*
* Original code by umarhussain15
* https://gist.github.com/umarhussain15/b661ee44d196b1b6216fa6495b125343
*
* Melakukan extends ke komponen ViewPager
* Bertujuan agar tidak dapat melakukan swipe slide pada ViewPager
* */

package com.example.remindme.customComponent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class SwipeDisabledViewPager extends ViewPager {
    public SwipeDisabledViewPager(Context context) {
        super(context);
    }

    public SwipeDisabledViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // returning false will not propagate the swipe event
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
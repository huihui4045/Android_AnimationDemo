package android_playerdemo.android_animationdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by gavin on 2017/2/24.
 */

public class XRelativeLayout extends RelativeLayout {
    private static String TAG = "XRelativeLayout";

    public XRelativeLayout(Context context) {
        super(context);
    }

    public XRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG, "dispatchTouchEvent" );
        return super.dispatchTouchEvent(event);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent");
        return super.onTouchEvent(event);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG, "onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }


}

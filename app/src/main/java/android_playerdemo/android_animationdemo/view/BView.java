package android_playerdemo.android_animationdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by gavin on 2017/2/24.
 */

public class BView extends View {

    private static String TAG="BView";

    public BView(Context context) {
        super(context);
    }

    public BView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG,"dispatchTouchEvent  ");
        return super.dispatchTouchEvent(event);
    }




    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"onTouchEvent  ");
        return super.onTouchEvent(event);
    }


}

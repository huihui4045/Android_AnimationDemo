package android_playerdemo.android_animationdemo;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

import android_playerdemo.android_animationdemo.type.CharEvluator;
import android_playerdemo.android_animationdemo.type.MyEvaluator;

public class PropertyActivity extends AppCompatActivity implements View.OnClickListener {

    private View mView;

    private ValueAnimator animator;

    private ValueAnimator mValueAnimator;
    private String TAG = this.getClass().getSimpleName();
    private View mViewBig;


    private ValueAnimator mObjectAnimator;
    private Button mBtnChar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);

        mView = findViewById(R.id.view_anim);

        mViewBig = findViewById(R.id.view_anim1);


        animator = ValueAnimator.ofInt(0, 1000);

        mBtnChar = ((Button) findViewById(R.id.btn_char));


        mObjectAnimator = ValueAnimator.ofObject(new CharEvluator(), new Character('A'), new Character('Z'));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            mValueAnimator = ValueAnimator.ofArgb(0xff00ff00, 0xffff0000);

            mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {

                    int curValue = (int) animation.getAnimatedValue();

                    Log.e(TAG, "curValue::" + String.valueOf(curValue));

                    mViewBig.setBackgroundColor(curValue);
                }
            });

        }

        mObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                char value = (char) animation.getAnimatedValue();

                mBtnChar.setText(String.valueOf(value));
            }
        });


        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                int value = ((Integer) animation.getAnimatedValue()).intValue();

                Log.e(TAG, "value:" + String.valueOf(value));

                mView.layout(mView.getLeft(), value, mView.getRight(), value + mView.getHeight());
            }
        });


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.start_anim:
                animator.setDuration(2000);
                animator.setInterpolator(new BounceInterpolator());
                animator.setEvaluator(new MyEvaluator());
                animator.start();

                if (mValueAnimator != null) {

                    mValueAnimator.setDuration(4000);
                    mValueAnimator.setEvaluator(new ArgbEvaluator());
                    mValueAnimator.start();
                }

                if (mObjectAnimator != null) {

                    mObjectAnimator.setDuration(4000);

                    mObjectAnimator.setInterpolator(new AccelerateInterpolator());

                    mObjectAnimator.start();
                }

                break;
            case R.id.end_anim:
                animator.cancel();
                break;
        }
    }
}

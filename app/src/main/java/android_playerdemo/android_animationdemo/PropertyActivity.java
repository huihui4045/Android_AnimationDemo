package android_playerdemo.android_animationdemo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class PropertyActivity extends AppCompatActivity implements View.OnClickListener {

    private View mView;

    private ValueAnimator animator;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);

        mView = findViewById(R.id.view_anim);


        animator = ValueAnimator.ofInt(0, 500,20,400);

        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(null, "", 2);


        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                int value = ((Integer) animation.getAnimatedValue()).intValue();

                Log.e(TAG, "value:" + String.valueOf(value));

                mView.layout(value, value, value + mView.getWidth(), value + mView.getHeight());
            }
        });
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.start_anim:
                animator.setDuration(4000);
                animator.start();

                break;
            case R.id.end_anim:
                animator.cancel();
                break;
        }
    }
}

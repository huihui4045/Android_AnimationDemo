package android_playerdemo.android_animationdemo;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private View mView;
    private Button mBtnStart;

    private TranslateAnimation mTranslateAnimation;

    private AlphaAnimation mAlphaAnimation;

    private ScaleAnimation mScaleAnimation;

    private RotateAnimation mRotateAnimation;

    AnimationSet mAnimationSet;

    private AnimationDrawable mFrameAnimation;
    private ImageView mImageAnim;

    LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mView = findViewById(R.id.view);
        mBtnStart = ((Button) findViewById(R.id.start));
        mImageAnim = ((ImageView) findViewById(R.id.image_anim));

        mTranslateAnimation = new TranslateAnimation(0, -200, 0, -300);
      /*  mTranslateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -1f, Animation.RELATIVE_TO_SELF,
                -1f, Animation.ABSOLUTE, 0, Animation.RELATIVE_TO_SELF, 1f);*/
        //  mTranslateAnimation.setDuration(1000);
        //   mTranslateAnimation.setFillAfter(true);


        mAlphaAnimation = new AlphaAnimation(1.0f, 0.5f);
        //mScaleAnimation = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        mScaleAnimation = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f);

        mRotateAnimation = new RotateAnimation(0, 360);

        mAnimationSet = new AnimationSet(true);

        mAnimationSet.setDuration(2000);
        mAnimationSet.setFillAfter(true);

        mAnimationSet.addAnimation(mTranslateAnimation);
        //mAnimationSet.addAnimation(mAlphaAnimation);
        //mAnimationSet.addAnimation(mScaleAnimation);
        //mAnimationSet.addAnimation(mRotateAnimation);

        // mFrameAnimation.addFrame();

        final AnimationDrawable ad = (AnimationDrawable) getResources().getDrawable(
                R.drawable.anim);


        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mView.startAnimation(mAnimationSet);

                mImageAnim.setBackgroundDrawable(ad);

                ad.start();
            }
        });

        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_property).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, PropertyActivity.class));
            }
        });


        LayoutInflater inflater = LayoutInflater.from(this);

        inflater.inflate(R.layout.activity_main, null);


        AnimationUtils utils;


    }
}

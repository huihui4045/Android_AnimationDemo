package android_playerdemo.android_animationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private View mView;
    private Button mBtnStart;

    private TranslateAnimation mTranslateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        mView = findViewById(R.id.view);
        mBtnStart = ((Button) findViewById(R.id.start));

        mTranslateAnimation=new TranslateAnimation(-200,200,-200,200);
        mTranslateAnimation=new TranslateAnimation(Animation.RELATIVE_TO_SELF,-1f,Animation.RELATIVE_TO_SELF,-1f,Animation.ABSOLUTE,0,Animation.RELATIVE_TO_PARENT,1f);
        mTranslateAnimation.setDuration(1000);


        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mView.startAnimation(mTranslateAnimation);
            }
        });


    }
}

package android_playerdemo.android_animationdemo.type;

import android.animation.TypeEvaluator;

/**
 * Created by gavin on 2017/3/1.
 */

public class MyEvaluator implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {


        return (int) (200 + startValue + (endValue - startValue) * fraction);
    }
}

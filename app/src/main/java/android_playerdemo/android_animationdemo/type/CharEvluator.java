package android_playerdemo.android_animationdemo.type;

import android.animation.TypeEvaluator;

/**
 * Created by gavin on 2017/3/1.
 */

public class CharEvluator implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {

        int startInt = (int) startValue;
        int endInt = (int) endValue;
        int curInt = (int) (startInt + fraction * (endInt - startInt));

        return (char) curInt;
    }
}

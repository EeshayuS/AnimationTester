package com.noobilator7.animationtester;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView animation;
    private ImageView picture;
    private AnimatedVectorDrawable plusToMinus;
    private AnimatedVectorDrawable minusToMultiply;
    private AnimatedVectorDrawable multiplyToDivide;
    private AnimatedVectorDrawable divideToPlus;
    private int typeOfAnimation = 0;
    private AnimatedVectorDrawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animation = (ImageView) findViewById(R.id.animation);
        picture = (ImageView) findViewById(R.id.picture);
        plusToMinus = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_plus_to_minus);
        minusToMultiply = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_minus_to_multiply);
        multiplyToDivide = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_multiply_to_divide);
        divideToPlus = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_divide_to_plus);
        animate();
    }


    public void animate() {
        new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                switch (typeOfAnimation) {
                    case 0:
                        drawable = plusToMinus;
                        typeOfAnimation++;
                        break;
                    case 1:
                        drawable = minusToMultiply;
                        typeOfAnimation++;
                        break;
                    case 2:
                        drawable = multiplyToDivide;
                        typeOfAnimation++;
                        break;
                    case 3:
                        drawable = divideToPlus;
                        typeOfAnimation = 0;
                        break;
                }
                animation.setImageDrawable(drawable);
                picture.setVisibility(View.GONE);
                drawable.start();
                animate();
            }
        }.start();

    }
}



package com.noobilator7.animationtester;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView animation;
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
        plusToMinus = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_plus_to_minus);
        minusToMultiply = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_minus_to_multiply);
        multiplyToDivide = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_multiply_to_divide);
        divideToPlus = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_divide_to_plus);
        // animate(); This does nothing. It should do the animation every one second but does not.
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
                drawable.start();
                animate();
            }
        };

    }

    public void onClick (View view) {
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
        drawable.start();
    }
}


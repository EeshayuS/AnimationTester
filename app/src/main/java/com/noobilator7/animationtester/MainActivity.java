package com.noobilator7.animationtester;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView plusMinus;
    private AnimatedVectorDrawable plusToMinus;
    private AnimatedVectorDrawable minusToPlus;
    private boolean plus = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plusMinus = (ImageView) findViewById(R.id.plus_minus);
        plusToMinus = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_plus_to_minus);
        minusToPlus = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_minus_to_plus);
        animate();
    }

    public void animate() {
        AnimatedVectorDrawable drawable = plus ? plusToMinus : minusToPlus;
        plusMinus.setImageDrawable(drawable);
        drawable.start();
        plus = !plus;
        new CountDownTimer(1, 1){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                animate();
            }
        };

    }
}

package com.example.dell.quizzy;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashQuizzy extends AppCompatActivity {
    TextView textViewsplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_quizzy);
        TextView image = findViewById(R.id.textviewsplashid);
        Animation animation1 = AnimationUtils.loadAnimation(SplashQuizzy.this,
                R.anim.zoomsplash);
        image.startAnimation(animation1);
        textViewsplash = findViewById(R.id.textviewsplashid);


        new Handler().postDelayed(new Runnable() {
            @Override

            public void run() {

                Intent intent = new Intent(SplashQuizzy.this, Register.class);
                startActivity(intent);
                finish();

            }

        }, 5 * 1000);

    }






        }//end of onCreate()....
    //end of class......
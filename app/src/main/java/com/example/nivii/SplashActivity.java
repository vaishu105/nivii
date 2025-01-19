package com.example.nivii;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    ImageView ivLogo;
    TextView tvTitle, tvTitlee , tvSubTitle;
    Animation fadeInAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ivLogo= findViewById(R.id.ivMainLogo);
        tvTitle= findViewById(R.id.tvMainTitle);
        tvTitlee= findViewById(R.id.tvMainTitlee);
        tvSubTitle= findViewById(R.id.tvMainSubTitle);

        fadeInAnim= AnimationUtils.loadAnimation(SplashActivity.this,R.anim.fadein);
        ivLogo.setAnimation(fadeInAnim);
        tvTitle.setAnimation(fadeInAnim);
        tvTitlee.setAnimation(fadeInAnim);
        tvSubTitle.setAnimation(fadeInAnim);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(i);

            }
        },3000);
        }
    }

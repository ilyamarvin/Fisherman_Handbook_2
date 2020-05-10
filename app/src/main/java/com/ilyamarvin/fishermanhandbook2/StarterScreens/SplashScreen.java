package com.ilyamarvin.fishermanhandbook2.StarterScreens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.ilyamarvin.fishermanhandbook2.R;
import com.ilyamarvin.fishermanhandbook2.StarterScreens.OnBoarding;
import com.ilyamarvin.fishermanhandbook2.UserDashboard;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 4000;

    ImageView splashScreenImage;
    TextView textView_splash, powered_by;
    Animation sideAnim, bottomAnim;
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        splashScreenImage = findViewById(R.id.splashScreenImage);
        textView_splash = findViewById(R.id.textView_splash);
        powered_by = findViewById(R.id.powered_by);

        //Анимация
        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        //Установка анимации на элементы
        splashScreenImage.setAnimation(sideAnim);
        textView_splash.setAnimation(bottomAnim);
        powered_by.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);

                if (isFirstTime) {

                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), OnBoarding.class);
                    startActivity(intent);
                    finish();
                    }
                else {
                    Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                    startActivity(intent);
                    finish();
                }
            }
        },SPLASH_TIMER);
    }
}

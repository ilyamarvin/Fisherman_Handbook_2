package com.ilyamarvin.fishermanhandbook2.LoginScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ilyamarvin.fishermanhandbook2.R;
import com.ilyamarvin.fishermanhandbook2.UserDashboard;

public class LoginActivity extends AppCompatActivity {
    RelativeLayout backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        backBtn = findViewById(R.id.login_back_btn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.super.onBackPressed();
            }
        });
    }

        public void callSignUpScreen(View view) {
            Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);

            Pair[] pairs = new Pair[7];
            pairs[0] = new Pair<View,String>(findViewById(R.id.logo_image), "logo_image");
            pairs[1] = new Pair<View,String>(findViewById(R.id.logo_text), "logo_text");
            pairs[2] = new Pair<View,String>(findViewById(R.id.logo_text_desc), "logo_text_desc");
            pairs[3] = new Pair<View,String>(findViewById(R.id.username_login), "username_tran");
            pairs[4] = new Pair<View,String>(findViewById(R.id.password_login), "password_tran");
            pairs[5] = new Pair<View,String>(findViewById(R.id.login_btn), "button_go");
            pairs[6] = new Pair<View,String>(findViewById(R.id.signup_btn), "new_user_tran");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
                startActivity(intent, options.toBundle());
            } else startActivity(intent);
        }
}

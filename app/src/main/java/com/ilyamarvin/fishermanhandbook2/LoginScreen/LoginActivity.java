package com.ilyamarvin.fishermanhandbook2.LoginScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.ilyamarvin.fishermanhandbook2.MenuCategories.UserProfile;
import com.ilyamarvin.fishermanhandbook2.R;
import com.ilyamarvin.fishermanhandbook2.UserDashboard;

public class LoginActivity extends AppCompatActivity {
    RelativeLayout backBtn;
    TextInputLayout username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username_login);
        password = findViewById(R.id.password_login);

        backBtn = findViewById(R.id.login_back_btn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.super.onBackPressed();
            }
        });
    }

    private Boolean validateUsername() {
        String val = username.getEditText().getText().toString();

        if (val.isEmpty()) {
            username.setError("Это поле не может быть пустым");
            return false;
        }
        else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = password.getEditText().getText().toString();

        if (val.isEmpty()) {
            password.setError("Это поле не может быть пустым");
            return false;
        }
        else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    public void loginUser(View view) {
        if (!validateUsername() | !validatePassword()) {
            return;
        }
        else {
            isUser();
        }
    }

    private void isUser() {
        final String userEnteredUsername = username.getEditText().getText().toString().trim();
        final String userEnteredPassword = password.getEditText().getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){

                    username.setError(null);
                    username.setErrorEnabled(false);

                    String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);

                    if(passwordFromDB.equals(userEnteredPassword)) {

                        username.setError(null);
                        username.setErrorEnabled(false);

                        String firstnameFromDB = dataSnapshot.child(userEnteredUsername).child("firstname").getValue(String.class);
                        String secondnameFromDB = dataSnapshot.child(userEnteredUsername).child("secondname").getValue(String.class);
                        String usernameFromDB = dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
                        String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                        /*intent.putExtra("firstname",firstnameFromDB);
                        intent.putExtra("secondname",secondnameFromDB);
                        intent.putExtra("username",usernameFromDB);
                        intent.putExtra("email",emailFromDB);*/

                        startActivity(intent);
                    }
                    else {
                        password.setError("Неверный пароль");
                        password.requestFocus();
                    }
                }
                else {
                    username.setError("Такого пользователя не существует");
                    username.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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

package com.ilyamarvin.fishermanhandbook2.MenuCategories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ilyamarvin.fishermanhandbook2.R;

public class UserProfile extends AppCompatActivity {
    TextInputLayout firstName_user, secondName_user, username_user, email_user, password_user;
    TextView usernameLabel_user;

    String _FIRSTNAME, _SECONDNAME, _USERNAME, _EMAIL, _PASSWORD;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        firstName_user = findViewById(R.id.profile_first_name);
        secondName_user = findViewById(R.id.profile_second_name);
        username_user = findViewById(R.id.profile_username);
        usernameLabel_user = findViewById(R.id.username_profile_label);
        email_user = findViewById(R.id.profile_email);
        password_user = findViewById(R.id.profile_password);
        reference = FirebaseDatabase.getInstance().getReference("users");

        showAllUserData();

    }

    private void showAllUserData() {

        Intent intent = getIntent();
        String user_firstname = intent.getStringExtra("firstname");
        String user_secondname = intent.getStringExtra("secondname");
        String user_username = intent.getStringExtra("username");
        String user_email = intent.getStringExtra("email");
        String user_password = intent.getStringExtra("password");

        usernameLabel_user.setText(user_username);
        firstName_user.getEditText().setText(user_firstname);
        secondName_user.getEditText().setText(user_secondname);
        username_user.getEditText().setText(user_username);
        email_user.getEditText().setText(user_email);
        password_user.getEditText().setText(user_password);
    }

    public void update(View view) {

        if(isFirstNameChanged() || isSecondNameChanged() || isUsernameChanged() || isEmailChanged() || isPasswordChanged()) {
            Toast.makeText(this, "Данные обновлены", Toast.LENGTH_LONG).show();
        }
        else Toast.makeText(this, "Данные не были изменены", Toast.LENGTH_LONG).show();

    }

    private boolean isFirstNameChanged() {
        if(!_FIRSTNAME.equals(firstName_user.getEditText().getText().toString())) {
            reference.child(_FIRSTNAME).child("firstname").setValue(firstName_user.getEditText().getText().toString());
            _FIRSTNAME = firstName_user.getEditText().getText().toString();
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isSecondNameChanged() {
        if(!_SECONDNAME.equals(secondName_user.getEditText().getText().toString())) {
            reference.child(_SECONDNAME).child("secondname").setValue(secondName_user.getEditText().getText().toString());
            _SECONDNAME = secondName_user.getEditText().getText().toString();
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isUsernameChanged() {
        if(!_USERNAME.equals(username_user.getEditText().getText().toString())) {
            reference.child(_USERNAME).child("username").setValue(username_user.getEditText().getText().toString());
            _USERNAME = username_user.getEditText().getText().toString();
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isEmailChanged() {
        if(!_EMAIL.equals(email_user.getEditText().getText().toString())) {
            reference.child(_EMAIL).child("email").setValue(email_user.getEditText().getText().toString());
            _EMAIL = email_user.getEditText().getText().toString();
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isPasswordChanged() {
        if(!_PASSWORD.equals(password_user.getEditText().getText().toString())) {
            reference.child(_PASSWORD).child("password").setValue(password_user.getEditText().getText().toString());
            _PASSWORD = password_user.getEditText().getText().toString();
            return true;
        }
        else {
            return false;
        }
    }
}

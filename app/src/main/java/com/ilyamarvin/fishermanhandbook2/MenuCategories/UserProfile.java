package com.ilyamarvin.fishermanhandbook2.MenuCategories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ilyamarvin.fishermanhandbook2.LoginScreen.LoginActivity;
import com.ilyamarvin.fishermanhandbook2.R;
import com.ilyamarvin.fishermanhandbook2.UserDashboard;

public class UserProfile extends AppCompatActivity {
    TextInputLayout firstName_user, secondName_user, username_user, email_user, password_user;
    TextView usernameLabel_user;
    ImageView backBtn;

    String _FIRSTNAME, _SECONDNAME, _USERNAME, _EMAIL, _PASSWORD;

    DatabaseReference reference;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        backBtn = findViewById(R.id.back_btn_profile);

        firstName_user = findViewById(R.id.profile_first_name);
        secondName_user = findViewById(R.id.profile_second_name);
        username_user = findViewById(R.id.profile_username);
        usernameLabel_user = findViewById(R.id.username_profile_label);
        email_user = findViewById(R.id.profile_email);
        password_user = findViewById(R.id.profile_password);

        reference = FirebaseDatabase.getInstance().getReference("users");
        user = firebaseAuth.getCurrentUser();

        showAllUserData();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }

    private void showAllUserData() {

        Intent intent = getIntent();
        _FIRSTNAME = intent.getStringExtra("firstname");
        _SECONDNAME = intent.getStringExtra("secondname");
        _USERNAME = intent.getStringExtra("username");
        _EMAIL = intent.getStringExtra("email");
        _PASSWORD = intent.getStringExtra("password");

        usernameLabel_user.setText(_USERNAME);
        firstName_user.getEditText().setText(_FIRSTNAME);
        secondName_user.getEditText().setText(_SECONDNAME);
        username_user.getEditText().setText(_USERNAME);
        email_user.getEditText().setText(_EMAIL);
        password_user.getEditText().setText(_PASSWORD);
    }

    public void update(View view) {

        if (isFirstNameChanged() || isSecondNameChanged() || isUsernameChanged() || isEmailChanged() || isPasswordChanged()) {
            Toast.makeText(this, "Данные обновлены", Toast.LENGTH_LONG).show();
        } else Toast.makeText(this, "Данные не были изменены", Toast.LENGTH_LONG).show();

    }

    private boolean isFirstNameChanged() {
        if (!_FIRSTNAME.equals(firstName_user.getEditText().getText().toString())) {
            reference.child(_USERNAME).child("firstname").setValue(firstName_user.getEditText().getText().toString());
            _FIRSTNAME = firstName_user.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isSecondNameChanged() {
        if (!_SECONDNAME.equals(secondName_user.getEditText().getText().toString())) {
            reference.child(_USERNAME).child("secondname").setValue(secondName_user.getEditText().getText().toString());
            _SECONDNAME = secondName_user.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isUsernameChanged() {
        if (!_USERNAME.equals(username_user.getEditText().getText().toString())) {
            reference.child(_USERNAME).child("username").setValue(username_user.getEditText().getText().toString());
            _USERNAME = username_user.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmailChanged() {
        if (!_EMAIL.equals(email_user.getEditText().getText().toString())) {
            reference.child(_USERNAME).child("email").setValue(email_user.getEditText().getText().toString());
            _EMAIL = email_user.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isPasswordChanged() {
        if (!_PASSWORD.equals(password_user.getEditText().getText().toString())) {
            reference.child(_USERNAME).child("password").setValue(password_user.getEditText().getText().toString());
            _PASSWORD = password_user.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }
}

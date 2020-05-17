package com.ilyamarvin.fishermanhandbook2.MenuCategories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ilyamarvin.fishermanhandbook2.R;

public class UserProfile extends AppCompatActivity {
    TextInputLayout firstName_user, secondName_user, username_user, email_user, password_user;
    TextView usernameLabel_user;
    ImageView backBtn;

    String _FIRSTNAME, _SECONDNAME, _USERNAME, _EMAIL, _PASSWORD, currentUserId;

    DatabaseReference reference, referenceForId;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        backBtn = findViewById(R.id.back_btn_profile);

        firstName_user = findViewById(R.id.profile_first_name);
        secondName_user = findViewById(R.id.profile_second_name);
        username_user = findViewById(R.id.profile_username);
        usernameLabel_user = findViewById(R.id.username_profile_label);
        email_user = findViewById(R.id.profile_email);
        password_user = findViewById(R.id.profile_password);

        mAuth = FirebaseAuth.getInstance();
        currentUserId = mAuth.getCurrentUser().getUid();
        reference = FirebaseDatabase.getInstance().getReference("users");
        referenceForId = FirebaseDatabase.getInstance().getReference("users").child(currentUserId);

        showAllUserData();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserProfile.super.onBackPressed();
            }
        });

    }

    private void showAllUserData() {

        referenceForId.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    _FIRSTNAME = dataSnapshot.child("firstname").getValue().toString();
                    _SECONDNAME = dataSnapshot.child("secondname").getValue().toString();
                    _USERNAME = dataSnapshot.child("username").getValue().toString();
                    _EMAIL = dataSnapshot.child("email").getValue().toString();
                    _PASSWORD = dataSnapshot.child("password").getValue().toString();

                    usernameLabel_user.setText(_USERNAME);
                    firstName_user.getEditText().setText(_FIRSTNAME);
                    secondName_user.getEditText().setText(_SECONDNAME);
                    username_user.getEditText().setText(_USERNAME);
                    email_user.getEditText().setText(_EMAIL);
                    password_user.getEditText().setText(_PASSWORD);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void update(View view) {

        if (isFirstNameChanged() || isSecondNameChanged() || isUsernameChanged() || isEmailChanged() || isPasswordChanged()) {
            Toast.makeText(this, "Данные обновлены", Toast.LENGTH_LONG).show();
        } else Toast.makeText(this, "Данные не были изменены", Toast.LENGTH_LONG).show();

    }

    private boolean isFirstNameChanged() {
        if (!_FIRSTNAME.equals(firstName_user.getEditText().getText().toString())) {
            reference.child(_USERNAME).child("firstname").setValue(firstName_user.getEditText().getText().toString());
            reference.child(currentUserId).child("firstname").setValue(firstName_user.getEditText().getText().toString());
            _FIRSTNAME = firstName_user.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isSecondNameChanged() {
        if (!_SECONDNAME.equals(secondName_user.getEditText().getText().toString())) {
            reference.child(_USERNAME).child("secondname").setValue(secondName_user.getEditText().getText().toString());
            reference.child(currentUserId).child("secondname").setValue(secondName_user.getEditText().getText().toString());
            _SECONDNAME = secondName_user.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isUsernameChanged() {
        if (!_USERNAME.equals(username_user.getEditText().getText().toString())) {
            reference.child(_USERNAME).child("username").setValue(username_user.getEditText().getText().toString());
            reference.child(currentUserId).child("username").setValue(username_user.getEditText().getText().toString());
            _USERNAME = username_user.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmailChanged() {
        if (!_EMAIL.equals(email_user.getEditText().getText().toString())) {
            reference.child(_USERNAME).child("email").setValue(email_user.getEditText().getText().toString());
            reference.child(currentUserId).child("email").setValue(email_user.getEditText().getText().toString());
            _EMAIL = email_user.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isPasswordChanged() {
        if (!_PASSWORD.equals(password_user.getEditText().getText().toString())) {
            reference.child(_USERNAME).child("password").setValue(password_user.getEditText().getText().toString());
            reference.child(currentUserId).child("password").setValue(password_user.getEditText().getText().toString());
            _PASSWORD = password_user.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }
}

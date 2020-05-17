package com.ilyamarvin.fishermanhandbook2.LoginScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.ilyamarvin.fishermanhandbook2.HelperClasses.UserRegistration;
import com.ilyamarvin.fishermanhandbook2.R;
import com.ilyamarvin.fishermanhandbook2.UserDashboard;

public class SignUpActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    TextInputLayout regFirstName, regSecondName, regUsername, regEmail, regPassword;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String currentUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        regFirstName = findViewById(R.id.first_name_signup);
        regSecondName = findViewById(R.id.second_name_signup);
        regUsername = findViewById(R.id.username_signup);
        regEmail = findViewById(R.id.email_signup);
        regPassword = findViewById(R.id.password_signup);

        reference = FirebaseDatabase.getInstance().getReference("users");
        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
    }

    private Boolean validateFirstName() {
        String val = regFirstName.getEditText().getText().toString();
        if (val.isEmpty()) {
            regFirstName.setError("Это поле не может быть пустым");
            return false;
        } else {
            regFirstName.setError(null);
            regFirstName.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateSecondName() {
        String val = regSecondName.getEditText().getText().toString();
        if (val.isEmpty()) {
            regSecondName.setError("Это поле не может быть пустым");
            return false;
        } else {
            regSecondName.setError(null);
            regSecondName.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateUsername() {
        String val = regUsername.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if (val.isEmpty()) {
            regUsername.setError("Это поле не может быть пустым");
            return false;
        } else if (val.length() > 15) {
            regUsername.setError("Имя пользователя слишком длинное");
            return false;
        } else if (!val.matches(noWhiteSpace)) {
            regUsername.setError("Пробелы не допустимы");
            return false;
        } else {
            regUsername.setError(null);
            regUsername.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateEmail() {
        String val = regEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            regEmail.setError("Это поле не может быть пустым");
            return false;
        } else if (!val.matches(emailPattern)) {
            regEmail.setError("Неправильная электронная почта");
            return false;
        } else {
            regEmail.setError(null);
            regEmail.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = regPassword.getEditText().getText().toString();
        String passwordVal = "^" +
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=\\S+$)" +           //no white spaces
                ".{6,}" +               //at least 6 characters
                "$";

        if (val.isEmpty()) {
            regPassword.setError("Это поле не может быть пустым");
            return false;
        } else if (!val.matches(passwordVal)) {
            regPassword.setError("Пароль слишком короткий (минимум 6 знаков)");
            return false;
        } else {
            regPassword.setError(null);
            regPassword.setErrorEnabled(false);
            return true;
        }
    }

    //Сохраняем информацию в Firebase на клик кнопки
    public void registerUser(View view) {

        if (!validateFirstName() | !validateSecondName() | !validateUsername() | !validateEmail() | !validatePassword()) {
            return;
        } else {

            final String enteredUsername = regUsername.getEditText().getText().toString().trim();
            Query checkUsername = reference.orderByChild("username").equalTo(enteredUsername);

            checkUsername.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.exists()) {

                        regUsername.setError("Имя пользователя занято!");
                        Toast.makeText(SignUpActivity.this, "Не удалось зарегистрироваться, попробуйте снова", Toast.LENGTH_SHORT).show();
                    } else {

                        String enteredEmail = regEmail.getEditText().getText().toString().trim();
                        Query checkEmail = reference.orderByChild("email").equalTo(enteredEmail);

                        checkEmail.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                if (dataSnapshot.exists()) {

                                    regEmail.setError("Электронная почта занята!");
                                    Toast.makeText(SignUpActivity.this, "Не удалось зарегистрироваться, попробуйте снова", Toast.LENGTH_SHORT).show();

                                } else {

                                    rootNode = FirebaseDatabase.getInstance();
                                    reference = rootNode.getReference("users");

                                    progressDialog.setMessage("Выполняется регистрация");
                                    progressDialog.show();

                                    final String firstname = regFirstName.getEditText().getText().toString().trim();
                                    final String secondname = regSecondName.getEditText().getText().toString().trim();
                                    final String username = regUsername.getEditText().getText().toString().trim();
                                    final String email = regEmail.getEditText().getText().toString().trim();
                                    final String password = regPassword.getEditText().getText().toString().trim();

                                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                                            .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                                @Override
                                                public void onComplete(@NonNull Task<AuthResult> task) {
                                                    if (task.isSuccessful()) {
                                                        UserRegistration registrationClass = new UserRegistration(firstname, secondname, username, email, password);
                                                        UserRegistration databaseForID = new UserRegistration(firstname, secondname, username, email, password);
                                                        reference.child(username).setValue(registrationClass);
                                                        reference.child(firebaseAuth.getCurrentUser().getUid()).setValue(registrationClass);

                                                        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                        startActivity(intent);

                                                        Toast.makeText(SignUpActivity.this, "Регистрация прошла успешно", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        Toast.makeText(SignUpActivity.this, "Не удалось зарегистрироваться, попробуйте снова", Toast.LENGTH_SHORT).show();
                                                    }
                                                    progressDialog.dismiss();
                                                }
                                            });
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }

    public void callLoginScreen(View view) {
        onBackPressed();
    }
}
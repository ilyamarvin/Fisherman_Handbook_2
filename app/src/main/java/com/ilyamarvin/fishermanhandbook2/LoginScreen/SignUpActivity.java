package com.ilyamarvin.fishermanhandbook2.LoginScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ilyamarvin.fishermanhandbook2.HelperClasses.UserRegistration;
import com.ilyamarvin.fishermanhandbook2.R;
import com.ilyamarvin.fishermanhandbook2.UserDashboard;

public class SignUpActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    TextInputLayout regFirstName, regSecondName, regUsername, regEmail, regPassword;
    FirebaseDatabase rootNode;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        regFirstName = findViewById(R.id.first_name_signup);
        regSecondName = findViewById(R.id.second_name_signup);
        regUsername = findViewById(R.id.username_signup);
        regEmail = findViewById(R.id.email_signup);
        regPassword = findViewById(R.id.password_signup);

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
        }
        else if(val.length()>15) {
            regUsername.setError("Имя пользователя слишком длинное");
            return false;
        }
        else if (!val.matches(noWhiteSpace)) {
            regUsername.setError("Пробелы не допустимы");
            return false;
        }
            else {
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
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (val.isEmpty()) {
            regPassword.setError("Это поле не может быть пустым");
            return false;
        } else if (!val.matches(passwordVal)) {
            regPassword.setError("Пароль слишком слабый (aA-zZ, 0-9)");
            return false;
        } else {
            regPassword.setError(null);
            regPassword.setErrorEnabled(false);
            return true;
        }
    }

    //Сохраняем информацию в Firebase на клик кнопки
    public void registerUser(View view) {

        if(!validateFirstName() | !validateSecondName() | !validateUsername() | !validateEmail()| !validatePassword()) {
            return;
        } else {

            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("users");

            progressDialog.setMessage("Выполняется регистрация");
            progressDialog.show();

            String firstname = regFirstName.getEditText().getText().toString();
            String secondname = regSecondName.getEditText().getText().toString();
            String username = regUsername.getEditText().getText().toString();
            String email = regEmail.getEditText().getText().toString();
            String password = regPassword.getEditText().getText().toString();

            UserRegistration registrationClass = new UserRegistration(firstname, secondname, username, email, password);
            reference.child(username).setValue(registrationClass);

            Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            Toast.makeText(this, "Регистрация прошла успешно", Toast.LENGTH_SHORT).show();
        }

    }

    public void callLoginScreen(View view) {
        onBackPressed();
    }
}

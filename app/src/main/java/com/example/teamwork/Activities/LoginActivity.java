package com.example.teamwork.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.teamwork.R;
import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsername,edtPassword;
    private Button btnLogin;
    private ConstraintLayout layout;

    private AppCompatEditText email,password;
    private    TextInputLayout UserLayout,PasswordLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        setTitle("Login");



        //Initializing of member Variables

        edtUsername = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        layout = findViewById(R.id.layout);

        layout.setOnClickListener(null);

        //Initializing of member Variables EditText

        email = findViewById(R.id.edtEmail);
        password = findViewById(R.id.edtPassword);

        //userlayout initialization of member Variables
        UserLayout = findViewById(R.id.Email_TextInputLayout);
        PasswordLayout = findViewById(R.id.password_TextInputLayout);

        UserLayout.setCounterEnabled(true);
        UserLayout.setCounterMaxLength(20);


        PasswordLayout.setCounterEnabled(true);
        PasswordLayout.setCounterMaxLength(15);

        //Method to add Text changer
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (email.getText().toString().isEmpty()){

                    UserLayout.setErrorEnabled(true);
                    UserLayout.setError("Please Enter Your Username");

                }else{
                    UserLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        //onClick event for focusChangeListener
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (email.getText().toString().isEmpty()){

                    UserLayout.setErrorEnabled(true);
                    UserLayout.setError("Please Enter Your Username");

                }else{
                    UserLayout.setErrorEnabled(false);
                }
            }
        });


        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

             if (password.getText().toString().isEmpty()){

                 PasswordLayout.setErrorEnabled(true);
                 PasswordLayout.setError("Please Enter Password");
             }else{
                 PasswordLayout.setErrorEnabled(false);
             }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



//

        //Onclick method for Login Button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    //Logic for EditTextfields Login and Password
                if (edtUsername.getText().toString().equals("")||edtPassword.getText().toString().equals("")){

                     Toast.makeText(LoginActivity.this,"Enter Username and Password",Toast.LENGTH_SHORT).show();

                }else if(edtPassword.getText().toString().length()<6){
                    Toast.makeText(LoginActivity.this, "Password should be six characters Long", Toast.LENGTH_SHORT).show();

                }else{
                    Intent intent = new Intent(LoginActivity.this,Home.class);
                    startActivity(intent);
                    finish();
                }




            }
        });

    }
}

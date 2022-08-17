package com.example.takshak;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class signup extends AppCompatActivity {
    Button signup;
    TextInputLayout etName, etPhno, etEmail, etPassword;
    RadioGroup etGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup = findViewById(R.id.btnSignup);
        etName = findViewById(R.id.name);
        etPhno=findViewById(R.id.phno);
        etEmail=findViewById(R.id.email);
        etPassword=findViewById(R.id.password);
        etGender=findViewById(R.id.etGender);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!validateFullName() | !validatePhonenumber() | !validateEmail() | !validatePassword() | !validateGender()){
                    return;
                }

                Intent i = new Intent(signup.this,Eventname.class);
                startActivity(i);
            }
        });


    }

    private boolean validateFullName(){
        String val = etName.getEditText().getText().toString().trim();
        String checkName = "^[a-zA-Z ]*$";

        if(val.isEmpty()){
            etName.setError("Field cannot be empty");
            return false;
        }else if (!val.matches(checkName)){
            etName.setError("Name should only contain characters!");
            return false;
        } else{
            etName.setError(null);
            etName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePhonenumber(){
        String val = etPhno.getEditText().getText().toString().trim();
        String checkNumber = "^[0-9]{10}$";


        if(val.isEmpty()){
            etPhno.setError("Field cannot be empty");
            return false;
        }else if (!val.matches(checkNumber)){
            etPhno.setError("Phone Number should have 10-digits!");
            return false;
        }else {
            etPhno.setError(null);
            etPhno.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail(){
        String val = etEmail.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty()){
            etEmail.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(checkEmail)){
            etEmail.setError("Invalid Email!");
            return false;
        } else{
            etEmail.setError(null);
            etEmail.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword(){
        String val = etPassword.getEditText().getText().toString().trim();
        String checkPassword = "^" +
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{6,}" +               //at least 6 characters
                "$";


        if(val.isEmpty()){
            etPassword.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(checkPassword)){
            etPassword.setError("Password should contain atleast 6 characters and a special character!");
            return false;
        } else{
            etPassword.setError(null);
            etPassword.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateGender(){
        if(etGender.getCheckedRadioButtonId()==-1) {
            Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }

    }

}
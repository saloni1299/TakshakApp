package com.example.takshak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class Login extends AppCompatActivity {

    EditText email,pwd;
    Button login, signup;
    TextView textView12;
    FloatingActionButton fb,google,twitter;
    float v=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email =findViewById(R.id.email);
        pwd = findViewById(R.id.pwd);
        login = findViewById(R.id.btnLogin);
        signup = findViewById(R.id.btnRegister);
        textView12 = findViewById(R.id.textView12);
        fb = findViewById(R.id.fab_fb);
        google = findViewById(R.id.fab_google);
        twitter = findViewById(R.id.fb_twitter);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateEmail() | !validatePassword()){
                    return;
                }
                Intent i = new Intent(Login.this,Eventname.class);
                startActivity(i);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this,signup.class);
                startActivity(i);
            }
        });


        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://www.facebook.com/"));
                    startActivity(i);
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://accounts.google.com/ServiceLogin/signinchooser?flowName=GlifWebSignIn&flowEntry=ServiceLogin"));
                startActivity(i);
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://twitter.com/login?lang=en"));
                startActivity(i);
            }
        });

        email.setTranslationX(800);
        pwd.setTranslationX(800);
        login.setTranslationX(800);
        signup.setTranslationX(800);
        textView12.setTranslationX(800);

        fb.setTranslationY(300);
        google.setTranslationY(300);
        twitter.setTranslationY(300);

        email.setAlpha(v);
        pwd.setAlpha(v);
        login.setAlpha(v);
        signup.setAlpha(v);
        textView12.setAlpha(v);
        fb.setAlpha(v);
        google.setAlpha(v);
        twitter.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pwd.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        textView12.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(900).start();
        signup.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(1000).start();


        fb.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        twitter.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();


    }

    private boolean validateEmail(){
        String val = email.getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty()){
            email.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(checkEmail)){
            email.setError("Invalid Email!");
            return false;
        } else{
            email.setError(null);
            return true;
        }
    }
    private boolean validatePassword(){
        String val = pwd.getText().toString().trim();
        String checkPassword = "^" +
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{6,}" +               //at least 6 characters
                "$";


        if(val.isEmpty()){
            pwd.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(checkPassword)){
            pwd.setError("Password should contain atleast 6 characters and a special character!");
            return false;
        } else{
            pwd.setError(null);
            return true;
        }

    }
}
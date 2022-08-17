package com.example.takshak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Range extends AppCompatActivity {

    RadioGroup radioGroup;
    public FloatingActionButton floatingActionButton, floatingActionButton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range);

        floatingActionButton=findViewById(R.id.next2);
        floatingActionButton2=findViewById(R.id.back2);
        radioGroup=findViewById(R.id.radioGroup);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateRange()){
                    return;
                }

                Intent i = new Intent(Range.this, Confirmation.class);
                startActivity(i);
            }
        });

        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Range.this, Eventname.class);
                startActivity(i);
            }
        });

    }

    private boolean validateRange(){
        if(radioGroup.getCheckedRadioButtonId()==-1) {
            Toast.makeText(this, "Please Select Range", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }

    }
}
package com.example.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class second extends AppCompatActivity {
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        et1=(EditText) findViewById(R.id.et1);
        Intent intent=getIntent();
        String y=intent.getStringExtra("Num1");
        et1.setText(y);
    }
}
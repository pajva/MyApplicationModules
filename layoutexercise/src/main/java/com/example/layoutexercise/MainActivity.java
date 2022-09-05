package com.example.layoutexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup=findViewById(R.id.bu2);
        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.bu2:
                Intent intent = new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
                break;
            case R.id.bu1:
                Toast.makeText(getApplicationContext(),
                        "Login Successfull",
                        Toast.LENGTH_LONG)
                        .show();
        }
    }
}
package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv11;
    Button btn1,btn2;
    public static final String DEFAULT = "N/A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        tv1=findViewById(R.id.ttv1);
        tv11=findViewById(R.id.ttv11);
        tv2=findViewById(R.id.ttv2);
        tv3=findViewById(R.id.ttv3);
        tv4=findViewById(R.id.ttv4);
        tv5=findViewById(R.id.ttv5);
        tv6=findViewById(R.id.ttv6);
        tv7=findViewById(R.id.ttv7);
        btn1=findViewById(R.id.bt1);
        btn2=findViewById(R.id.bt2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.bt1:
                load(view);
                break;
            case R.id.bt2:
                previous(view);
                break;
            default:
                break;
        }
    }

    private void load(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyUser", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("Data","");
        User user = gson.fromJson(json,User.class);
        if(user.equals(DEFAULT))
        {
            Toast.makeText(this, "Data not found", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Data Loaded Successfully", Toast.LENGTH_SHORT).show();
            tv1.setText(user.getName());
            tv11.setText(user.getGender());
            tv2.setText(user.getAddress());
            tv3.setText(user.getEmail());
            tv4.setText(user.getCity());
            tv5.setText(user.getPhone());
            tv6.setText(user.getUsername());
            tv7.setText(user.getPassword());
        }
    }

    private void previous(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
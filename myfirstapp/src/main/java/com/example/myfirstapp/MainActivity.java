package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  Button linear,relative,frame,layout,boxes,relayout,secondlinear,image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linear=findViewById(R.id.btn1);
        relative=findViewById(R.id.btn2);
        frame=findViewById(R.id.btn3);
        layout=findViewById(R.id.btn4);
        boxes=findViewById(R.id.btn5);
        relayout=findViewById(R.id.btn6);
        secondlinear=findViewById(R.id.btn7);
        image=findViewById(R.id.btn8);
        linear.setOnClickListener(this);
        relative.setOnClickListener(this);
        frame.setOnClickListener(this);
        layout.setOnClickListener(this);
        boxes.setOnClickListener(this);
        relayout.setOnClickListener(this);
        secondlinear.setOnClickListener(this);
        image.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btn1:
                Intent intent=new Intent(MainActivity.this,LinearLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                startActivity(new Intent(MainActivity.this,RelativeLayoutActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(MainActivity.this,Li_Layout.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(MainActivity.this,FrameLayout.class));
                break;
            case R.id.btn5:
                startActivity(new Intent(MainActivity.this,Boxes.class));
                break;
            case R.id.btn6:
                startActivity(new Intent(MainActivity.this,Rel_Layout.class));
                break;
            case R.id.btn7:
                startActivity(new Intent(MainActivity.this,SecondActivityLinear.class));
                break;
            case R.id.btn8:
                startActivity(new Intent(MainActivity.this,Image.class));
                break;
            default:
                break;
        }
    }
}
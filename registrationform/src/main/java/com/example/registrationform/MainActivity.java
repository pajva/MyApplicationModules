package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt1,edt2,edt3,edt4,edt5,edt6,edt7;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button btn1,btn2;
    String name,gender,address,email,city,phone,username,password;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=findViewById(R.id.radio_button);
        edt1=findViewById(R.id.et1);
        edt2=findViewById(R.id.et2);
        edt3=findViewById(R.id.et3);
        edt4=findViewById(R.id.et4);
        edt5=findViewById(R.id.et5);
        edt6=findViewById(R.id.et6);
        edt7=findViewById(R.id.et7);
        btn1=findViewById(R.id.bt1);
        btn2=findViewById(R.id.bt2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.bt1:save(view);
            break;
            case R.id.bt2:next(view);
            break;
            default:
                break;
        }

    }

    private void save(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        gender=radioButton.getText().toString();
        name=edt1.getText().toString();
        address=edt2.getText().toString();
        email=edt3.getText().toString();
        city=edt4.getText().toString();
        phone=edt5.getText().toString();
        username=edt6.getText().toString();
        password=edt7.getText().toString();
        if(name.length()==0){
            edt1.requestFocus();
            edt1.setError("Field cannot be empty");
        }
        else if(!name.matches("[a-z A-Z]+")){
            edt1.requestFocus();
            edt1.setError("ENTER ONLY ALPHABETICAL CHARACTER");
        }
        else if(address.length()==0){
            edt2.requestFocus();
            edt2.setError("Field cannot be empty");
        }
        else if(email.length()==0){
            edt3.requestFocus();
            edt3.setError("Field cannot be empty");
        }
        else if(!email.matches("[a-zA-Z0-9]+@+.+")){
            edt3.requestFocus();
            edt3.setError("Must include @ & .");
        }
        else if(city.length()==0){
            edt4.requestFocus();
            edt4.setError("Field cannot be empty");
        }
        else if(phone.length()==0){
            edt5.requestFocus();
            edt5.setError("Field cannot be empty");
        }
        else if(!phone.matches("[0-9]+")){
            edt5.requestFocus();
            edt5.setError("ENTER ONLY NUMBERS");
        }
        else if(username.length()==0){
            edt6.requestFocus();
            edt6.setError("Field cannot be empty");
        }
        else if(password.length()==0){
            edt7.requestFocus();
            edt7.setError("Field cannot be empty");
        }
        else{
            User user = new User();
            user.setName(name);
            user.setGender(gender);
            user.setAddress(address);
            user.setCity(city);
            user.setEmail(email);
            user.setPhone(phone);
            user.setUsername(username);
            user.setPassword(password);
            SharedPreferences sharedPreferences = getSharedPreferences("MyUser",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(user);
            editor.putString("Data",json);
            editor.commit();
            Toast.makeText(this,"Save Successfull", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "save: "+ json );
        }

    }

    private void next(View view) {

        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
    }
}
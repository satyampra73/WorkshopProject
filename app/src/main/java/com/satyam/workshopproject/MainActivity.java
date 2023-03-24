package com.satyam.workshopproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etPassword,etMobile;
    AppCompatButton btnLogin;
    boolean isLogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPassword=findViewById(R.id.etPassword);
        etMobile=findViewById(R.id.etMobile);
        btnLogin=findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etMobile.getText().toString().trim().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please Enter Mobile No.",Toast.LENGTH_SHORT).show();
                }
                else if(etPassword.getText().toString().trim().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please Enter Mobile No.",Toast.LENGTH_SHORT).show();
                } else  {
                    DatabaseHelper databaseHelper=new DatabaseHelper(MainActivity.this);
                   isLogin = databaseHelper.matchData(etMobile.getText().toString(),etPassword.getText().toString().trim());
                   if (isLogin){
                       Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();

                   }
                   else {
                       Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                   }

                }
            }
        });

    }

    public void GoToRegister(View view) {
        Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
        startActivity(intent);
    }
}
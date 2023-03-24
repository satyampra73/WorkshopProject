package com.satyam.workshopproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class SignUpActivity extends AppCompatActivity {
    EditText etName,etMobile,etPassword;
    Button btnRegister;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etName=findViewById(R.id.etName);
        etMobile=findViewById(R.id.etMobile);
        etPassword=findViewById(R.id.etPassword);
        btnRegister=findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etName.getText().toString().trim().isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
                }
                else if(etPassword.getText().toString().trim().isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Please Enter Your Password", Toast.LENGTH_SHORT).show();
                }
                else if (etMobile.getText().toString().trim().isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Please Enter Yor Mobile No also", Toast.LENGTH_SHORT).show();
                }
                else {
                    DatabaseHelper databaseHelper=new DatabaseHelper(SignUpActivity.this);
                    databaseHelper.SignUp(etMobile.getText().toString().trim(),etPassword.getText().toString().trim());
                }
            }
        });

    }
}
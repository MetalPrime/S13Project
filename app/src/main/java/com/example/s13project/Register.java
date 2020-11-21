package com.example.s13project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.FillEventHistory;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private EditText registerName,registerPhone,registerEmail,registerPassword,registerConfirmedPassword;
    private Button btnRegister;
    private TextView anchorLogin;

    private FirebaseAuth auth;
    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        anchorLogin = findViewById(R.id.anchorLogIn);
        btnRegister = findViewById(R.id.btnRegister);

        registerName = findViewById(R.id.registerName);
        registerPhone = findViewById(R.id.registerPhone);
        registerEmail = findViewById(R.id.registerEmail);
        registerPassword = findViewById(R.id.registerPassword);
        registerConfirmedPassword = findViewById(R.id.registerConfirmedPassword);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.anchorLogIn:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btnRegister:

                break;
        }
    }
}
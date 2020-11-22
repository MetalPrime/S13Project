package com.example.s13project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.FillEventHistory;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        anchorLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
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
                if(!registerName.getText().toString().equals("") || !registerEmail.getText().equals("") || !registerPhone.getText().equals("") || !registerPassword.getText().equals("") || !registerConfirmedPassword.getText().equals("") ){
                    if(registerPassword.getText().toString().equals(registerConfirmedPassword.getText().toString())){
                        auth.createUserWithEmailAndPassword(registerEmail.getText().toString(),registerPassword.getText().toString())
                                .addOnCompleteListener(
                                        task -> {
                                            if(task.isSuccessful()){
                                                String id = auth.getCurrentUser().getUid();
                                                User user = new User(
                                                        registerEmail.getText().toString(),
                                                        id,
                                                        registerName.getText().toString(),
                                                        registerPhone.getText().toString(),
                                                        registerPassword.getText().toString()
                                                );
                                                db.getReference().child("semana14").child("users").child(id).setValue(user)
                                                        .addOnCompleteListener(
                                                                task1 -> {
                                                                    if(task1.isSuccessful()){
                                                                        Intent intent1 = new Intent(this,Contacts.class);
                                                                        startActivity(intent1);
                                                                        finish();
                                                                    }else {
                                                                        Toast.makeText(this,task1.getException().getMessage(),Toast.LENGTH_LONG).show();
                                                                    }
                                                                }
                                                        );
                                            }else{
                                                Toast.makeText(this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                            }
                                        }
                                );
                    } else {
                        Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_LONG).show();
                    }

                } else{
                    Toast.makeText(this,"Por favor, rellene todo los campos",Toast.LENGTH_LONG).show();
                }

                break;
        }
    }
}
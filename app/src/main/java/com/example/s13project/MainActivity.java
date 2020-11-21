package com.example.s13project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button btnLogIn;
    private EditText userEmail;
    private EditText userPassword;
    private TextView anchorRegister;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogIn = findViewById(R.id.btnLogIn);
        userEmail = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPassword);

        btnLogIn.setOnClickListener(
                (view) ->{

                    Intent i = new Intent(this,Contacts.class);
                    i.putExtra("userName",userEmail.getText().toString());

                    startActivity(i);
                }
        );


    }
}
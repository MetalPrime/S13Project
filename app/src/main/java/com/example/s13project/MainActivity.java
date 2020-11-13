package com.example.s13project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button btnRegister;
    private EditText userName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegister = findViewById(R.id.btnRegister);
        userName = findViewById(R.id.userName);

        btnRegister.setOnClickListener(
                (view) ->{

                    Intent i = new Intent(this,Contacts.class);
                    i.putExtra("userName",userName.getText().toString());

                    startActivity(i);
                }
        );


    }
}
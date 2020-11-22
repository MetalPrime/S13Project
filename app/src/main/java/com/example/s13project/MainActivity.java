package com.example.s13project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogIn;
    private EditText userEmail;
    private EditText userPassword;
    private TextView anchorRegister;
    private FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogIn = findViewById(R.id.btnLogIn);
        userEmail = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPassword);
        anchorRegister = findViewById(R.id.anchorRegister);

        btnLogIn.setOnClickListener(this);
        anchorRegister.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogIn:

                auth.signInWithEmailAndPassword(userEmail.getText().toString(),userPassword.getText().toString()).addOnCompleteListener(
                        task -> {
                            if(task.isSuccessful()){
                                Intent i = new Intent(this,Contacts.class);
                                startActivity(i);
                                finish();
                            }else {
                                Toast.makeText(this,task.getException().toString(),Toast.LENGTH_LONG).show();
                            }
                        }
                );


                break;
            case R.id.anchorRegister:

                Intent intent = new Intent(this,Register.class);
                startActivity(intent);
                finish();

                break;
        }
    }
}
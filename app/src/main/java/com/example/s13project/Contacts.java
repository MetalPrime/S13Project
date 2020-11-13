package com.example.s13project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;

public class Contacts extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    private ListView listContact;
    private EditText contactName;
    private EditText contactNumber;
    private Button btnAddContact;
    private ContactAdapter adapter;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        listContact = findViewById(R.id.listContact);
        contactName = findViewById(R.id.contactName);
        contactNumber = findViewById(R.id.contactNumber);
        btnAddContact = findViewById(R.id.btnAddContact);

        username = getIntent().getStringExtra("userName");

        adapter = new ContactAdapter();
        listContact.setAdapter(adapter);

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.CALL_PHONE,
        }, 1);

        loadDatabase();

        btnAddContact.setOnClickListener(
                (view) ->{
                    String id = UUID.randomUUID().toString();
                    newContact contact = new newContact(
                            id,
                            username,
                            contactName.getText().toString(),
                            contactNumber.getText().toString()
                    );
                    Log.e("fdsxcdv", contact + "");
                    database.getReference("contacts").child(id).setValue(contact);
                }
        );


    }

    private void loadDatabase() {
        DatabaseReference ref = database.getReference().child("contacts");
        ref.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        adapter.clear();
                        for (DataSnapshot child : snapshot.getChildren()) {
                            newContact contact = child.getValue(newContact.class);
                            if(contact.getUserName().equals(username)){
                                adapter.addContact(contact);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );
    }


}


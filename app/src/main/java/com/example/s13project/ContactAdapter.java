package com.example.s13project;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.UUID;

public class ContactAdapter extends BaseAdapter {

    private ArrayList<newContact> contacts;

    public ContactAdapter(){
        contacts = new ArrayList<>();

    }

    public void addContact(newContact addContact){
        contacts.add(addContact);
        this.notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int pos, View renglon, ViewGroup lista) {
        LayoutInflater inflater = LayoutInflater.from(lista.getContext());
        View renglonView = inflater.inflate(R.layout.row,null);

        newContact contact = contacts.get(pos);

        ImageButton btnCall = renglonView.findViewById(R.id.btnCall);
        ImageButton btnDelete = renglonView.findViewById(R.id.btnDelete);
        TextView setNameContact = renglonView.findViewById(R.id.setNameContact);
        TextView setContactNumber = renglonView.findViewById(R.id.setContactNumber);

        setNameContact.setText(contact.getContactName());
        setContactNumber.setText((""+contact.getContactNumber()));

        btnCall.setOnClickListener(
                (v)->{
                    Intent i = new Intent(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel:"+contact.getContactNumber()));
                    lista.getContext().startActivity(i);
                }
        );

        btnDelete.setOnClickListener(
                view -> {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    database.getReference().child("contacts").child(contact.getId()).removeValue();
                }
        );

        return renglonView;
    }

    public void clear() {
        contacts.clear();
        notifyDataSetChanged();
    }
}

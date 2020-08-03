package com.example.My_Dietist_Android_App.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.My_Dietist_Android_App.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ContactActivity extends AppCompatActivity {
    EditText txtName, txtSurname, txtEmail, txtPh;
    Button saveButton;
    //db reference
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        txtName = (EditText) findViewById(R.id.nameEditText);
        txtSurname = (EditText) findViewById(R.id.surnameEditText);
        txtEmail = (EditText) findViewById(R.id.emailEditText);
        txtPh = (EditText) findViewById(R.id.phoneNumEditText);
        saveButton = (Button) findViewById(R.id.saveButton);
        //initializing instance of DatabaseReference
        mDatabase = FirebaseDatabase.getInstance().getReference();

        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Long phn =Long.parseLong(txtPh.getText().toString().trim());
//                user object inserted in the db under users, each child of users in named after the inserted user name
                User user = new User(txtName.getText().toString(), txtEmail.getText().toString(), txtSurname.getText().toString(), phn);
                mDatabase.child("users").child(txtName.getText().toString()).setValue(user);
                Toast.makeText(ContactActivity.this,"conn successful", Toast.LENGTH_LONG).show();
            }
        });

    }

}

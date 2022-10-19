package com.example.dell.quizzy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class ViewProfile extends AppCompatActivity {
    TextView nametext,emailtext,numbertext,passtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        Intent intent=getIntent();
        String name=intent.getStringExtra("Name");
        String email=intent.getStringExtra("Email");
        String number=intent.getStringExtra("Number");
        String password=intent.getStringExtra("Password");
        // Toast.makeText(Main4Activity.this,"LOL...1"+name, Toast.LENGTH_SHORT).show();

        nametext=findViewById(R.id.viewname);
        emailtext=findViewById(R.id.viewemail);
        numbertext=findViewById(R.id.viewnumber);
        passtext=findViewById(R.id.viewpassword);

        nametext.setText(name);
        emailtext.setText(email);
        numbertext.setText(number);
        passtext.setText(password);




    }
}

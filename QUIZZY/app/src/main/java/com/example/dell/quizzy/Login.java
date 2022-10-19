package com.example.dell.quizzy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    EditText loginnumber, loginpass,editpassword,editnumber;
    Button loginbutton;
    int flag=0;
    FirebaseDatabase firebase;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginnumber = findViewById(R.id.loginnumber);
        loginpass = findViewById(R.id.loginpassword);
        loginbutton = findViewById(R.id.buttonlogin);

        editnumber=findViewById(R.id.registernumber);
        editpassword=findViewById(R.id.registerpassword);

        firebase= FirebaseDatabase.getInstance();
        reference=firebase.getReference();

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(Main2Activity.this,"..................",Toast.LENGTH_SHORT).show();
//        Toast.makeText(Main2Activity.this,"LOL",Toast.LENGTH_SHORT).show();
                flag=0;
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for(DataSnapshot dat:dataSnapshot.getChildren())
                        {
                            UserPojo pojo= dat.getValue(UserPojo.class);

                            // Toast.makeText(Main2Activity.this,"data..." + "  "+loginnumber.getText().toString() +"  "+loginpass.getText().toString(),Toast.LENGTH_SHORT).show();

                            if(pojo.getNumber().equals(loginnumber.getText().toString()) && pojo.getPassword().equals(loginpass.getText().toString()))
                            {

                                flag=1;
                                Toast.makeText(Login.this,"Login successfull",Toast.LENGTH_SHORT).show();

                                finish();
                                Intent intent1=new Intent(Login.this,HomeActivity.class);
                                intent1.putExtra("Name", pojo.getName());
                                intent1.putExtra("Email", pojo.getEmail());
                                intent1.putExtra("Number", pojo.getNumber());
                                intent1.putExtra("Password", pojo.getPassword());
                                startActivity(intent1);
                                break;
                            }//end of pojo....

                            //Toast.makeText(Main2Activity.this,"LOL...1",Toast.LENGTH_SHORT).show();
                        }//end of for loop....

                        if(flag==0)
                        {
                            Toast.makeText(Login.this,"Incorrect Details",Toast.LENGTH_SHORT).show();
                            // Toast.makeText(Main2Activity.this,"LOL...2",Toast.LENGTH_SHORT).show();
                        }


                    }//end of onDarachange().....

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(Login.this,"Error",Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });




    }
}







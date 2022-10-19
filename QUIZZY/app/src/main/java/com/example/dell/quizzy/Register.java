package com.example.dell.quizzy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    EditText editname,editemail,editnumber,editpass,editpasscon;
    TextView textView2;
    Button regbutton;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        database=FirebaseDatabase.getInstance();
        reference=database.getReference();
        editname=findViewById(R.id.registername);
        editemail=findViewById(R.id.registeremail);
        editnumber=findViewById(R.id.registernumber);
        editpass=findViewById(R.id.registerpassword);
        editpasscon=findViewById(R.id.registerconfpass);
        regbutton=findViewById(R.id.buttonregister);
        textView2=findViewById(R.id.textlogin);

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Register.this,"Loginnn",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
                finish();
            }
        });



        regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editname.getText().toString().trim();
                String email = editemail.getText().toString().trim();
                String number = editnumber.getText().toString().trim();
                String pass = editpass.getText().toString().trim();
                String confpass = editpasscon.getText().toString().trim();

                String emailpattren = "[a-zA-Z0-9._-]+@[a-z]+\\.com";
                if (!name.matches("[a-zA-Z\\.\\ a-zA-Z]+") || name.length() > 25 || name.length() < 3 || name.isEmpty())
                {
                    Toast.makeText(Register.this, "Incorrect Name", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (!email.matches(emailpattren) || email.length() < 15 || email.length() > 64)
                    {
                        Toast.makeText(Register.this, "Incorrect Email", Toast.LENGTH_SHORT).show();
                    }


                    else
                    {
                        if (!number.matches("[0-9]+") || number.length() != 10 || number.isEmpty())
                        {
                            Toast.makeText(Register.this, "Incorrect Number", Toast.LENGTH_SHORT).show();
                        }


                        else
                        {
                            if (pass.length()<8||pass.length()>15||!pass.matches("(.*[A-Z].*)")||!pass.matches("(.*[a-z].*)")||!pass.matches("(.*[0-9" +
                                    "].*)"))

                            {
                                Toast.makeText(Register.this, "Password must have contains one lowwercase letter,one uppercase letter,one digit,password length must between 8 to 15 characters", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                if (!confpass.equals(pass)) {
                                    Toast.makeText(Register.this, "Password does not match", Toast.LENGTH_SHORT).show();
                                }

                                UserPojo pojo=new UserPojo();
                                pojo.setName(name);
                                pojo.setEmail(email);
                                pojo.setNumber(number);
                                pojo.setPassword(pass);
                                pojo.setConfirmpassword(confpass);
                                reference.push().setValue(pojo);
                                editname.setText("");
                                editemail.setText("");
                                editnumber.setText("");
                                editpass.setText("");
                                editpasscon.setText("");
                                finish();
                                Intent intent = new Intent(Register.this, Login.class);
                                startActivity(intent);
                            }

                        }//end of confirm password....
                    }//end of password.....


                }//end of email...


            }//end of else of name....


        } );//end of onClick...


    }//end of onCreate...
}//end of class....







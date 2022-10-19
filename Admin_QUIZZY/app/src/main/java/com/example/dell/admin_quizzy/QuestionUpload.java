package com.example.dell.admin_quizzy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class QuestionUpload extends AppCompatActivity {

    EditText answer,subject,question,option1,option2,option3,option4;
    Button submit;
    FirebaseDatabase database;
    DatabaseReference myRef;
    UploadPojo pojo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_upload);
        answer=findViewById(R.id.answer);
        question=findViewById(R.id.question);
        subject=findViewById(R.id.subject);
        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);
        option4=findViewById(R.id.option4);
        submit=findViewById(R.id.submit);
        pojo=new UploadPojo();
                submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sub=subject.getText().toString().trim();
                String que=question.getText().toString().trim();
                String op1=option1.getText().toString().trim();
                String op2=option2.getText().toString().trim();
                String op3=option3.getText().toString().trim();
                String op4=option4.getText().toString().trim();
                String ans=answer.getText().toString().trim();
                database=FirebaseDatabase.getInstance();
                myRef=database.getReference(""+sub);
                pojo.setSujbect(sub);
                pojo.setQuestion(que);
                pojo.setOption1(op1);
                pojo.setOption2(op2);
                pojo.setOption3(op3);
                pojo.setOption4(op4);
                pojo.setAnswer(ans);
                myRef.push().setValue(pojo);
                subject.setText("");
                question.setText("");
                option1.setText("");
                option2.setText("");
                option3.setText("");
                option4.setText("");
                answer.setText("");
                Toast.makeText(QuestionUpload.this,"Successfully uploaded...",Toast.LENGTH_SHORT).show();
            }//end of onClick()....
        });
    }//end of onCreate().....
}//end of class....

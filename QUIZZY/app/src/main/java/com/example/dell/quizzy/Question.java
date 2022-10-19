package com.example.dell.quizzy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArraySet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class Question extends AppCompatActivity {
TextView textViewtimer;
Button questionbuttontext,option1buttontext,option2buttontext,option3buttontext,option4buttontext;

ArrayList<QuestionPojo> questionlist=new ArrayList();
/*
Random r = new Random();
int Low = 0;
int High = 20;
int Result = r.nextInt(High-Low) + Low;
*/
QuestionPojo list;
String subject="";
Set number;
FirebaseDatabase database;
DatabaseReference reference;


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Intent i=getIntent();
        //questionlist=new ArrayList();

        subject=i.getStringExtra("subject");

        database=FirebaseDatabase.getInstance();

/*
        while(number.size()!=15)
        {
            int temp;

        }//end of while loop.....
*/

        reference=database.getReference(subject);
        textViewtimer=findViewById(R.id.timer);
        option1buttontext=findViewById(R.id.option1buttontext);
        option2buttontext=findViewById(R.id.option2buttontext);
        option3buttontext=findViewById(R.id.option3buttontext);
        option4buttontext=findViewById(R.id.option4buttontext);
        questionbuttontext=findViewById(R.id.questionbuttontext);

    reference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for(DataSnapshot d:dataSnapshot.getChildren())
            {
                Toast.makeText(Question.this,"DataSnapShot",Toast.LENGTH_SHORT).show();
                HashMap p=new HashMap();
                p= (HashMap) d.getValue();
                QuestionPojo te=new QuestionPojo();
                te.setQuestion(p.get("question")+"");
                te.setOption1(p.get("option1")+"");
                te.setOption2(p.get("option2")+"");
                te.setOption3(p.get("option3")+"");
                te.setOption4(p.get("option4")+"");
                te.setAnswer(p.get("answer")+"");
                questionlist.add(te);
                Log.e("1234", "onDataChange: "+questionlist.size(), null);
                Log.e("1234", "onDataChange: "+questionlist.get(0), null);
            }

            mainLogic();
            //end of for loop....
            //   Log.e("345678", "onDataChange: "+questionlist.size(), null);
        }//end of onDataChange().....
        @Override
        public void onCancelled(DatabaseError databaseError) {

        }//end of ().....
    });

    numberAdd();

    textViewtimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Question.this,Result.class);
                startActivity(intent);
                finish();

            }//end of onClick().....
        });

    Log.e("1234", "onDataChange: "+questionlist.size(), null);
}//end of onCreate()....

public void numberAdd()
{
    number = new HashSet() {{
        add(0);
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        add(6);
        add(7);
        add(8);
        add(9);
        add(10);
        add(11);
        add(12);
        add(13);
        add(14);
        add(15);
        add(16);
        add(17);
        add(18);
        add(19);
    }};

}//end of numberAdd()...

    @Override
    protected void onStart() {
        super.onStart();


    }

    public void mainLogic()
    {

        Log.e("1234", "mainLogic: " );
        //Toast.makeText(Question.this,""+questionlist,Toast.LENGTH_SHORT).show();
      try {
                    for (int i = 0; i < 15; i++) {

                        Log.e("1234", "mainLogic: 1234");
                         list =new QuestionPojo();
                        Toast.makeText(Question.this,"11111..."+i,Toast.LENGTH_SHORT).show();
                             list=  questionlist.get(i);
                        Log.d("1234", "mainLogic: "+questionlist.size());
                        questionbuttontext.setText(list.getQuestion());
                        option1buttontext.setText(list.getOption1());
                        option2buttontext.setText(list.getOption2());
                        option3buttontext.setText(list.getOption3());
                        option4buttontext.setText(list.getOption4());
                        //   String temp=questionlist.get(i).getAnswer();
                        Toast.makeText(Question.this,"11111..."+list.getQuestion(),Toast.LENGTH_SHORT).show();
                        for (int j = 1; j <= 10; j++) {
                           Toast.makeText(Question.this,"3333..."+j,Toast.LENGTH_SHORT).show();

                            /*  Toast.makeText(Question.this,"44444...",Toast.LENGTH_SHORT).show();
                        */  // Thread.sleep(1000);
                        }//end of for loop....


                    }//end of for loop....

        }//end of try....
        catch(Exception e)
        {
            Toast.makeText(Question.this,"Something went wrong..."+e.getMessage(),Toast.LENGTH_SHORT).show();
        }//end of catch().....
    }//end of ()....

}//end of class....

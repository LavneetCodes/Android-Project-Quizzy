package com.example.dell.quizzy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Subjects extends AppCompatActivity {
    CardView ccardView,c2cardview,javacardview,androidcardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);

        ccardView=findViewById(R.id.cardviewC);
        c2cardview=findViewById(R.id.cardviewC2);
        javacardview=findViewById(R.id.cardviewjava);
        androidcardview=findViewById(R.id.cardviewandroid);


        ccardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Subjects.this,Question.class);
                intent.putExtra("subject","c");
                startActivity(intent);
                finish();

            }
        });

        c2cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Subjects.this,Question.class);
                intent.putExtra("subject","c++");
                startActivity(intent);
                finish();


            }
        });

        javacardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Subjects.this,Question.class);
                intent.putExtra("subject","java");
                startActivity(intent);
                finish();


            }
        });

        androidcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Subjects.this,Question.class);
                intent.putExtra("subject","android");
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    }//end of onBackPressed().....
}//end of class.....

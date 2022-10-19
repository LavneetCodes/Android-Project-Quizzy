package com.example.dell.quizzy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView viewprofile,forgotpassword,logout,settings,aboutus,share;
    Button  playquizbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button image = findViewById(R.id.buttonplay);
        Animation animation1 = AnimationUtils.loadAnimation(HomeActivity.this,
                R.anim.zoomhome);
        animation1.setRepeatCount(Animation.INFINITE);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        playquizbutton=findViewById(R.id.buttonplay);
        playquizbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,Subjects.class);
                startActivity(intent);
                finish();


            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

            image.startAnimation(animation1);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        viewprofile=findViewById(R.id.viewprofile);
        forgotpassword=findViewById(R.id.forgotpassword);
        logout=findViewById(R.id.logout);
        settings=findViewById(R.id.settings);
        aboutus=findViewById(R.id.aboutus);
        share=findViewById(R.id.nav_share);

        if (id == R.id.viewprofile) {
            Intent intent = new Intent(HomeActivity.this, ViewProfile.class);

           /* intent.putExtra("Name", name);
            intent.putExtra("Email", email);
            intent.putExtra("Number", number);
            intent.putExtra("Password", password);
            startActivity(intent);
*/
            startActivity(intent);



        } else if (id == R.id.forgotpassword) {
            Intent intent = new Intent(HomeActivity.this,ForgotPassword.class);
            startActivity(intent);


        } else if (id == R.id.logout) {


        } else if (id == R.id.settings) {
            Intent intent = new Intent(HomeActivity.this,Settings.class);
            startActivity(intent);


        } else if (id == R.id.aboutus) {
            Intent intent = new Intent(HomeActivity.this,AboutUs.class);
            startActivity(intent);


        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }


}

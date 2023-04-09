package com.example.hackathon;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Splash_Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        getSupportActionBar().hide();

        Thread thread = new Thread(){
          public void run(){
              try {
                sleep(4000);
              }
              catch (Exception e){
                  e.printStackTrace();
              }
              finally {
                  Intent intent = new Intent(Splash_Activity.this , MainActivity.class);
                  startActivity(intent);
              }
          }
        };thread.start();
    }

}

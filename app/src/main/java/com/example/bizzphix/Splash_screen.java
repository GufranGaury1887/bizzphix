package com.example.bizzphix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class Splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Thread td = new Thread(){

            public void run(){

                try {
                    sleep(4000);
                }catch (Exception ex){

                    ex.printStackTrace();
                }finally {
                    Intent intent = new Intent(com.example.bizzphix.Splash_screen.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

        };td.start();



    }

}
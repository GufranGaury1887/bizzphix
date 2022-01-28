package com.example.bizzphix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants;
import com.example.bizzphix.Fragment.custom_frg;
import com.example.bizzphix.Fragment.Calender_frg;
import com.example.bizzphix.Fragment.business_frg;
import com.example.bizzphix.Fragment.general_frg;
import com.example.bizzphix.Fragment.soon_frg;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
{

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new Calender_frg()).commit();


        bottomNavigationView = findViewById(R.id.bottom_navigaion);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

    }

    private  BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment temp = null;

            switch (item.getItemId())
            {
                case R.id.bn_calender: temp = new Calender_frg();
                    break;

                case R.id.bn_birthday: temp = new business_frg();
                    break;

                case R.id.bn_marriage: temp = new general_frg();
                    break;

                case R.id.bn_custom: temp = new custom_frg();
                    break;

                case R.id.bn_soon: temp = new soon_frg();
                    break;


            }

            // inflating fragment in the container
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout,temp)
                    .addToBackStack("bacstack")
                    .commit();

            return true;
        }
    };
}
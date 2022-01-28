package com.example.bizzphix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class ResultActivity extends AppCompatActivity {


    ImageView homeBtn,image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        image = findViewById(R.id.image);
        image.setImageURI(getIntent().getData());

        homeBtn = findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeActivity();
            }
        });
    }
        private void homeActivity() {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
}

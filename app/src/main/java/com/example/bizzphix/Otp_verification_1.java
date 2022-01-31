package com.example.bizzphix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hbb20.CountryCodePicker;

public class Otp_verification_1 extends AppCompatActivity {


    CountryCodePicker ccp;
    EditText text1;
    Button buttongetotp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverfication1);

        text1 = (EditText) findViewById(R.id.text1);
        ccp = (CountryCodePicker) findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(text1);
        buttongetotp = (Button)findViewById(R.id.buttongetotp);

        buttongetotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Otp_verification_1.this,Otp_verification_2.class);
                intent.putExtra("mobil",ccp.getFullNumberWithPlus().replace(" ",""));
                startActivity(intent);
            }
        });
    }
}
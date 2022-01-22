//package com.example.bizzphix;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.FirebaseException;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.PhoneAuthCredential;
//import com.google.firebase.auth.PhoneAuthOptions;
//import com.google.firebase.auth.PhoneAuthProvider;
//
//import java.util.concurrent.TimeUnit;
//
//public class Otp_verification_2 extends AppCompatActivity
//{
//
//    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
//    private FirebaseAuth firebaseAuth;
//
////    EditText inputotp1, inputotp2, inputotp3, inputotp4, inputotp5, inputotp6;
//
//    EditText text2;
//    Button buttongetotp2;
//    String phonenumber;
//    String otpid;
//    FirebaseAuth mAuth;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_otp_verifition2);
//
//        phonenumber = getIntent().getStringExtra("mobil").toString();
//        text2 = (EditText)findViewById(R.id.text2);
//        buttongetotp2 = (Button)findViewById(R.id.buttongetotp2);
//        mAuth = FirebaseAuth.getInstance();
////        inputotp1 = findViewById(R.id.inputotp1);
////        inputotp2 = findViewById(R.id.inputotp2);
////        inputotp3 = findViewById(R.id.inputotp3);
////        inputotp4 = findViewById(R.id.inputotp4);
////        inputotp5 = findViewById(R.id.inputotp5);
////        inputotp6 = findViewById(R.id.inputotp6);
//
//
//        initiateotp();
//
//        buttongetotp2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//        if(text2.getText().toString().isEmpty())
//            Toast.makeText(getApplicationContext(), "Blank Field can not be processed", Toast.LENGTH_LONG).show();
//        else if(text2.getText().toString().length()!=6)
//            Toast.makeText(getApplicationContext(), "Invalid OTP ", Toast.LENGTH_LONG).show();
//        else
//        {
//            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(otpid,text2.getText().toString());
//            signInWithPhoneAuthCredential(credential);
//        }
//
//            }
//        });
//
//
//    }
//
//    private void initiateotp()
//
//    {
//        Log.d("gufran",mAuth + " " + phonenumber  );
//
//        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks()
//        {
//
//            @Override
//            public void onCodeSent(String s,PhoneAuthProvider.ForceResendingToken forceResendingToken)
//            {
//                otpid=s;
//            }
//
//            @Override
//            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential)
//            {
//                signInWithPhoneAuthCredential(phoneAuthCredential);
//            }
//
//            @Override
//            public void onVerificationFailed( FirebaseException e) {
//                Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG).show();
//
//
//            }
//        };
//        PhoneAuthOptions options =
//                PhoneAuthOptions.newBuilder(mAuth)
//                        .setPhoneNumber(phonenumber)       // Phone number to verify
//                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
//                        .setActivity(this)                 // Activity (for callback binding)
//                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
//                        .build();
//        PhoneAuthProvider.verifyPhoneNumber(options);
//    }
//
//    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
//        mAuth.signInWithCredential(credential)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful())
//                        {
//                            startActivity(new Intent(Otp_verification_2.this,MainActivity.class));
//                            finish();
//
//                        } else {
//                            Toast.makeText(getApplicationContext(), "Signin Code Error", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//    }
//
//
//}
//

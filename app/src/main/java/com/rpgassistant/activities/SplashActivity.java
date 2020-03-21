package com.rpgassistant.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rpgassistant.R;

public class SplashActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        mFirebaseAuth = FirebaseAuth.getInstance();

//        FirebaseUser currentUser = mFirebaseAuth.getCurrentUser();
//        if (currentUser == null){
//            intent = new Intent(this, NotLoggedActivity.class);
//            startActivity(intent);
//            finish();
//        }
//        else {
                intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

//        }
    }
}

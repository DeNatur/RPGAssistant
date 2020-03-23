package com.rpgassistant.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rpgassistant.R;
import com.rpgassistant.models.User;
import com.rpgassistant.viewmodels.SplashViewModel;

public class SplashActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    Intent intent;
    private SplashViewModel splashViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initSplashViewModel();
        checkIfUserIsAuthenticated();
        }
    private void initSplashViewModel() {
        splashViewModel = new ViewModelProvider(this).get(SplashViewModel.class);
    }

    private void checkIfUserIsAuthenticated() {
        splashViewModel.checkIfUserIsAuthenticated();
        splashViewModel.getIsUserAuthenticatedLiveData().observe(this, user -> {
            if (!user.isAuthenticated()) {
                goToAuthInActivity();
                finish();
            } else {
                getUserFromDatabase(user.getUid());
            }
        });
    }
    private void goToAuthInActivity() {
        Intent intent = new Intent(SplashActivity.this, AuthActivity.class);
        startActivity(intent);
        finish();
    }
    private void getUserFromDatabase(String uid) {
        splashViewModel.setUid(uid);
        splashViewModel.getUserLiveData().observe(this, user -> {
            goToMainActivity(user);
            finish();
        });
    }
    private void goToMainActivity(User user) {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
        finish();
    }
}

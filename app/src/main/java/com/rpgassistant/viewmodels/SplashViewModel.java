package com.rpgassistant.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rpgassistant.models.User;
import com.rpgassistant.repositories.SplashRepository;

public class SplashViewModel extends AndroidViewModel {

    private SplashRepository splashRepository;
    LiveData<User> isUserAuthenticatedLiveData;
    LiveData<User> userLiveData;

    public SplashViewModel(Application application) {
        super(application);
        splashRepository = new SplashRepository();
    }

    public void checkIfUserIsAuthenticated() {
        isUserAuthenticatedLiveData = splashRepository.checkIfUserIsAuthenticatedInFirebase();
    }

     public void setUid(String uid) {
        userLiveData = splashRepository.addUserToLiveData(uid);
    }

    public LiveData<User> getIsUserAuthenticatedLiveData() {
        return isUserAuthenticatedLiveData;
    }

    public LiveData<User> getUserLiveData() {
        return userLiveData;
    }
}

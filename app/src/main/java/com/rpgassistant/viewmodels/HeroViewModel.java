package com.rpgassistant.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.google.firebase.auth.FirebaseUser;
import com.rpgassistant.models.Hero;
import com.rpgassistant.repositories.FirestoreRepository;

import java.util.List;

public class HeroViewModel extends AndroidViewModel {
    private FirestoreRepository repository;
    private LiveData<List<Hero>> allHeroes;

    public HeroViewModel(@NonNull Application application) {
        super(application);
        repository = new FirestoreRepository();
        allHeroes = repository.getAllHeroes();
    }

    public void insert(Hero hero) {
        repository.addHero(hero);
    }

    public void update(Hero hero){
        repository.updateHero(hero);
    }

    public void delete(Hero hero){
        repository.deleteHero(hero);
    }

    public LiveData<List<Hero>> getAllHeroes(){
        return repository.getAllHeroes();
    }
}

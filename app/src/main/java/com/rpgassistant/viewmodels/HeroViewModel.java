package com.rpgassistant.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rpgassistant.models.Hero;
import com.rpgassistant.repositories.HeroRepository;

import java.util.List;

public class HeroViewModel extends AndroidViewModel {
    private HeroRepository repository;
    private LiveData<List<Hero>> allNotes;

    public HeroViewModel(@NonNull Application application) {
        super(application);
        repository = new HeroRepository(application);
        allNotes = repository.getAllHeroes();
    }

    public void insert(Hero hero) {
        repository.insert(hero);
    }

    public void update(Hero hero){
        repository.update(hero);
    }

    public void delete(Hero hero){
        repository.delete(hero);
    }

    public void deleteAllNotes(){
        repository.deleteAllNotes();
    }

    public LiveData<List<Hero>> getAllHeroes(){
        return repository.getAllHeroes();
    }
}

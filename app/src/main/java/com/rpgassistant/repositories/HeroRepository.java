package com.rpgassistant.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.rpgassistant.databases.HeroDao;
import com.rpgassistant.databases.HeroDatabase;
import com.rpgassistant.models.Hero;

import java.util.List;

public class HeroRepository {
    private HeroDao heroDao;
    private LiveData<List<Hero>> allHeroes;

    public HeroRepository(Application application){
        HeroDatabase database = HeroDatabase.getInstance(application);
        heroDao = database.heroDao();
        allHeroes = heroDao.getAllNotes();
    }

    public void insert(Hero hero){
        new InsertHeroAsyncTask(heroDao).execute(hero);
    }
    public void update(Hero hero){
        new UpdateHeroAsyncTask(heroDao).execute(hero);
    }
    public void delete(Hero hero){
        new DeleteHeroAsyncTask(heroDao).execute(hero);
    }

    public void deleteAllNotes(){
        new DeleteAllHeroesInsertNoteAsyncTask(heroDao).execute();
    }

    public LiveData<List<Hero>> getAllHeroes(){
        return  allHeroes;
    }

    private static class InsertHeroAsyncTask extends AsyncTask<Hero, Void, Void> {
        private HeroDao heroDao;

        private InsertHeroAsyncTask(HeroDao heroDao){
            this.heroDao = heroDao;
        }

        @Override
        protected Void doInBackground(Hero... heroes) {
            heroDao.insert(heroes[0]);
            return null;
        }
    }

    private static class UpdateHeroAsyncTask extends AsyncTask<Hero, Void, Void> {
        private HeroDao heroDao;

        private UpdateHeroAsyncTask(HeroDao heroDao){
            this.heroDao = heroDao;
        }

        @Override
        protected Void doInBackground(Hero... heroes) {
            heroDao.update(heroes[0]);
            return null;
        }
    }

    private static class DeleteHeroAsyncTask extends AsyncTask<Hero, Void, Void> {
        private HeroDao heroDao;

        private DeleteHeroAsyncTask(HeroDao heroDao){
            this.heroDao = heroDao;
        }

        @Override
        protected Void doInBackground(Hero... heroes) {
            heroDao.delete(heroes[0]);
            return null;
        }
    }
    private static class DeleteAllHeroesInsertNoteAsyncTask extends AsyncTask<Void, Void, Void> {
        private HeroDao heroDao;

        private DeleteAllHeroesInsertNoteAsyncTask(HeroDao heroDao){
            this.heroDao = heroDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            heroDao.deleteAllHeroes();
            return null;
        }
    }
}

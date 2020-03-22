package com.rpgassistant.databases;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.rpgassistant.models.Hero;

import java.util.ArrayList;
import java.util.List;

@Database(entities = Hero.class, version = 1)
public abstract class HeroDatabase extends RoomDatabase {

    private static HeroDatabase instance;

    public abstract HeroDao heroDao();

    public static synchronized  HeroDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    HeroDatabase.class, "hero_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private HeroDao heroDao;

        private PopulateDbAsyncTask(HeroDatabase db){
            heroDao = db.heroDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            int[] class1 = {10};
            int[] class2 = {0};
            int[] class3 = {4};
            int[] class4 = {1};

            heroDao.insert(new Hero("Layce", class1,0, "", class1));
            heroDao.insert(new Hero("Grog", class2,0, "", class2));
            heroDao.insert(new Hero("Venek", class3,0, "",class3));
            heroDao.insert(new Hero("Scanlen", class4,0, "", class4));
            return null;
        }
    }
}

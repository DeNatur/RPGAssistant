package com.rpgassistant.databases;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.rpgassistant.models.Hero;

import java.util.List;
@Dao
public interface HeroDao {
    @Insert
    void insert(Hero hero);

    @Update
    void update(Hero hero);

    @Delete
    void delete(Hero hero);

    @Query("DELETE FROM hero_table")
    void deleteAllHeroes();

    @Query("SELECT * FROM hero_table")
    LiveData<List<Hero>> getAllNotes();
}

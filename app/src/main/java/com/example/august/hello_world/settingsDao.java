package com.example.august.hello_world;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;

@Dao
public interface settingsDao {
    @Insert
    public void insertId(settingsTable... id);
}

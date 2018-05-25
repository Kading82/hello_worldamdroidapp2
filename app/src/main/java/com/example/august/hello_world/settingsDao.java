package com.example.august.hello_world;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface settingsDao {
    @Insert
    public void insertId(settingsTable... id);

    @Query("SELECT * FROM settingsTable WHERE id IN (:ids)")
    List<settingsTable> loadAllByIds(String[] ids);
}

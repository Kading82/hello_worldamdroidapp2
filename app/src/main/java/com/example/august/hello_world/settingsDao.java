package com.example.august.hello_world;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;

@Dao
public interface settingsDao {


    @Insert
    public void insertId(settingsTable... id);

    @Insert
    public void insertdMrt(settingsTable... dMrT);

    @Insert
    public void insertMaxdistance(settingsTable... maxDistance);

    @Insert
    public void insertGender(settingsTable... gender);

    @Insert
    public void insertAgeRange(settingsTable... ageRange);

    @Insert
    public void insertAccountsettings(settingsTable... accountSettings);


}

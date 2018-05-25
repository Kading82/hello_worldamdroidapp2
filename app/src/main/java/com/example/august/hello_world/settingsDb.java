package com.example.august.hello_world;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {settingsTable.class}, version = 1, exportSchema = false)
public abstract class settingsDb extends RoomDatabase {
    public abstract settingsDao settingsDao();
}

